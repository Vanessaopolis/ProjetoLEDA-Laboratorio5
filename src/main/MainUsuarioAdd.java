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

public class MainUsuarioAdd {
	public static void main(String[] args) {
		UsuarioRepository repoArrayList;
		UsuarioRepository repoHashMap;
		UsuarioRepository repoHashSet;
		UsuarioRepository repoLinkedHashMap;
		UsuarioRepository repoTreeMap;
		UsuarioRepository repoTreeSet;

		String caminhoArquivo = Main.FILE_PATH;

		try {
			PrintStream fileOut = new PrintStream("/home/ubuntu/ProjetoLEDA-Laboratorio5/data/resultadoUsuarioAdd.txt");
			System.setOut(fileOut);
			System.out.println(Main.HEADER);

			for (int carga : Main.CARGAS) {
				long tempoTotalAL = 0;
				long tempoTotalHM = 0;
				long tempoTotalHS = 0;
				long tempoTotalLHM = 0;
				long tempoTotalTM = 0;
				long tempoTotalTS = 0;

				for (int i = 0; i < Main.REPETICOES; i++) {
					BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));

					repoArrayList = new UsuarioRepositoryArrayList();
					repoHashMap = new UsuarioRepositoryHashMap();
					repoHashSet = new UsuarioRepositoryHashSet();
					repoLinkedHashMap = new UsuarioRepositoryLinkedHashMap();
					repoTreeMap = new UsuarioRepositoryTreeMap();
					repoTreeSet = new UsuarioRepositoryTreeSet();

					int linhaAtual = 0;
					while (linhaAtual++ < carga) {
						String line = reader.readLine();
						String[] dados = line.split(" ");

						String nome = dados[0];
						String cpf = dados[1];
						String senha = dados[2];
						String matricula = dados[3];
						Usuario user = new Usuario(nome, cpf, senha, matricula);

						tempoTotalAL += executaAdicao(repoArrayList, user);
						tempoTotalHM += executaAdicao(repoHashMap, user);
						tempoTotalHS += executaAdicao(repoHashSet, user);
						tempoTotalLHM += executaAdicao(repoLinkedHashMap, user);
						tempoTotalTM += executaAdicao(repoTreeMap, user);
						tempoTotalTS += executaAdicao(repoTreeSet, user);

					}

					reader.close();
				}

				long mediaAL = tempoTotalAL / Main.REPETICOES;
				long mediaHM = tempoTotalHM / Main.REPETICOES;
				long mediaHS = tempoTotalHS / Main.REPETICOES;
				long mediaLHM = tempoTotalLHM / Main.REPETICOES;
				long mediaTM = tempoTotalTM / Main.REPETICOES;
				long mediaTS = tempoTotalTS / Main.REPETICOES;

				System.out.println("ArrayList " + mediaAL + " " + carga);
				System.out.println("HashMap " + mediaHM + " " + carga);
				System.out.println("HashSet " + mediaHS + " " + carga);
				System.out.println("LinkedHashMap " + mediaLHM + " " + carga);
				System.out.println("TreeMap " + mediaTM + " " + carga);
				System.out.println("TreeSet " + mediaTS + " " + carga);
			}

			fileOut.close();
			System.setOut(Main.CONSOLE_OUT);
			System.out.println("Terminou");

		} catch (IOException ioe) {
			System.setOut(Main.CONSOLE_OUT);
			System.out.println(ioe);
		}
	}

	private static long executaAdicao(UsuarioRepository usuarioRepository, Usuario estudante) {
		long start = System.nanoTime();
		usuarioRepository.adicionaEstudante(estudante);
		long end = System.nanoTime();
		return end - start;
	}
}
