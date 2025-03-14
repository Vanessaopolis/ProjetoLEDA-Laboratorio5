package main;

import entities.Usuario;
import interfaces.UsuarioRepository;
import repositories.UsuarioRepositoryArrayList;
import repositories.UsuarioRepositoryHashMap;
import repositories.UsuarioRepositoryHashSet;
import repositories.UsuarioRepositoryLinkedHashMap;
import repositories.UsuarioRepositoryTreeMap;
import repositories.UsuarioRepositoryTreeSet;
import java.io.*;

public class MainUsuarioBusca {
	public static void main(String[] args) {

		UsuarioRepository repoArrayList;
		UsuarioRepository repoHashMap;
		UsuarioRepository repoHashSet;
		UsuarioRepository repoLinkedHashMap;
		UsuarioRepository repoTreeMap;
		UsuarioRepository repoTreeSet;

		String caminhoArquivo = Main.FILE_PATH;

		// lendo da entrada padrão
		try {
			PrintStream fileOut = new PrintStream("data/resultadoUsuarioBusca.txt");
			System.setOut(fileOut);
			// Cabeçalho
			System.out.println(Main.HEADER);

			for (int carga = Main.CARGA_USUARIO_INICIAL; carga <= Main.CARGA_USUARIO_FINAL; carga *= Main.RAZAO) {
				long tempoTotalAL = 0;
				long tempoTotalHM = 0;
				long tempoTotalHS = 0;
				long tempoTotalLHM = 0;
				long tempoTotalTM = 0;
				long tempoTotalTS = 0;

				for (int i = 0; i < Main.REPETICOES; i++) {
					BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));

					String cpfASerBuscado = null; // , cpfASerBuscadoUltimo, cpfASerBuscadoPrimeiro;

					repoArrayList = new UsuarioRepositoryArrayList();
					repoHashMap = new UsuarioRepositoryHashMap();
					repoHashSet = new UsuarioRepositoryHashSet();
					repoLinkedHashMap = new UsuarioRepositoryLinkedHashMap();
					repoTreeMap = new UsuarioRepositoryTreeMap();
					repoTreeSet = new UsuarioRepositoryTreeSet();

					int linhaAtual = 0;

					while (linhaAtual++ < carga) {
						String line = reader.readLine();
						String[] sequencia = line.split(" ");

						String nome = sequencia[0];
						String cpf = sequencia[1];
						String senha = sequencia[2];
						String matricula = sequencia[3];

						Usuario user = new Usuario(nome, cpf, senha, matricula);

						repoArrayList.adicionaEstudante(user);
						repoHashMap.adicionaEstudante(user);
						repoHashSet.adicionaEstudante(user);
						repoLinkedHashMap.adicionaEstudante(user);
						repoTreeMap.adicionaEstudante(user);
						repoTreeSet.adicionaEstudante(user);

						// Buscar cpf no meio
						if (linhaAtual == carga / 2)
							cpfASerBuscado = cpf;
					}
					reader.close();

					String senha = "senha123";
					tempoTotalAL += executaBusca(repoArrayList, cpfASerBuscado, senha);
					tempoTotalHM += executaBusca(repoHashMap, cpfASerBuscado, senha);
					tempoTotalLHM += executaBusca(repoLinkedHashMap, cpfASerBuscado, senha);
					tempoTotalHS += executaBusca(repoHashSet, cpfASerBuscado, senha);
					tempoTotalTM += executaBusca(repoTreeMap, cpfASerBuscado, senha);
					tempoTotalTS += executaBusca(repoTreeSet, cpfASerBuscado, senha);
				}

				long mediaAL = tempoTotalAL / Main.REPETICOES;
				long mediaHM = tempoTotalHM / Main.REPETICOES;
				long mediaHS = tempoTotalHS / Main.REPETICOES;
				long mediaLHM = tempoTotalLHM / Main.REPETICOES;
				long mediaTM = tempoTotalTM / Main.REPETICOES;
				long mediaTS = tempoTotalTS / Main.REPETICOES;

				// adiciona o resultado no arquivo de resultado
				System.out.println("ArrayList " + mediaAL + " " + carga);
				System.out.println("HashMap " + mediaHM + " " + carga);
				System.out.println("HashSet " + mediaHS + " " + carga);
				System.out.println("LinkedHashMap " + mediaLHM + " " + carga);
				System.out.println("TreeMap " + mediaTM + " " + carga);
				System.out.println("TreeSet " + mediaTS + " " + carga);
			}
			fileOut.close();
			System.out.println("Terminou");

		} catch (IOException ioe) {
			System.out.println(ioe);

		}

	}

	private static long executaBusca(UsuarioRepository usuarioRepository, String cpf, String senha) {
		long start = System.nanoTime();
		usuarioRepository.buscaEstudante(cpf, senha);
		long end = System.nanoTime();
		return end - start;
	}

}