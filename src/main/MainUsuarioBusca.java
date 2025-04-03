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
		String main = "MainUsuarioBusca";

		UsuarioRepository repoArrayList;
		UsuarioRepository repoHashMap;
		UsuarioRepository repoHashSet;
		UsuarioRepository repoLinkedHashMap;
		UsuarioRepository repoTreeMap;
		UsuarioRepository repoTreeSet;

		String caminhoArquivo = Main.CAMINHO_ARQUIVO_DE_ENTRADA;

		try {
			String outputFinal = "";

			for (int carga : Main.CARGAS) {
				System.out.println("main: " + main + ", começo da carga: " + carga);

				long tempoTotalAL = 0;
				long tempoTotalHM = 0;
				long tempoTotalHS = 0;
				long tempoTotalLHM = 0;
				long tempoTotalTM = 0;
				long tempoTotalTS = 0;

				for (int i = 0; i < Main.REPETICOES; i++) {
					System.out.println("main: " + main + ", carga: " + carga + ", repetição: " + (i + 1));

					BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
					String cpfASerBuscado = null;

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
						Usuario user = new Usuario(nome, cpf, Main.SENHA, Main.MATRICULA);

						repoArrayList.adicionaEstudante(user);
						repoHashMap.adicionaEstudante(user);
						repoHashSet.adicionaEstudante(user);
						repoLinkedHashMap.adicionaEstudante(user);
						repoTreeMap.adicionaEstudante(user);
						repoTreeSet.adicionaEstudante(user);

						if (linhaAtual == carga / 2)
							cpfASerBuscado = cpf;
					}

					reader.close();

					tempoTotalAL += executaBusca(repoArrayList, cpfASerBuscado);
					tempoTotalHM += executaBusca(repoHashMap, cpfASerBuscado);
					tempoTotalLHM += executaBusca(repoLinkedHashMap, cpfASerBuscado);
					tempoTotalHS += executaBusca(repoHashSet, cpfASerBuscado);
					tempoTotalTM += executaBusca(repoTreeMap, cpfASerBuscado);
					tempoTotalTS += executaBusca(repoTreeSet, cpfASerBuscado);
				}

				long mediaAL = tempoTotalAL / Main.REPETICOES;
				long mediaHM = tempoTotalHM / Main.REPETICOES;
				long mediaHS = tempoTotalHS / Main.REPETICOES;
				long mediaLHM = tempoTotalLHM / Main.REPETICOES;
				long mediaTM = tempoTotalTM / Main.REPETICOES;
				long mediaTS = tempoTotalTS / Main.REPETICOES;

				String outputDaCarga = "";
				outputDaCarga += "ArrayList " + mediaAL + " " + carga + "\n";
				outputDaCarga += "HashMap " + mediaHM + " " + carga + "\n";
				outputDaCarga += "HashSet " + mediaHS + " " + carga + "\n";
				outputDaCarga += "LinkedHashMap " + mediaLHM + " " + carga + "\n";
				outputDaCarga += "TreeMap " + mediaTM + " " + carga + "\n";
				outputDaCarga += "TreeSet " + mediaTS + " " + carga + "\n";

				outputFinal += outputDaCarga;
				System.out.println("carga concluída: " + carga);
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ubuntu/ProjetoLEDA-Laboratorio5/data/resultadoUsuarioBusca.txt"));			
			writer.write(outputFinal = Main.CABECALHO + outputFinal);
			writer.close();

			System.out.println("Terminou");

		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

	private static long executaBusca(UsuarioRepository usuarioRepository, String cpf) {
		long start = System.nanoTime();
		usuarioRepository.buscaEstudante(cpf, Main.SENHA);
		long end = System.nanoTime();
		return end - start;
	}
}
