package main.mainsParalelos;

import entities.Usuario;
import interfaces.UsuarioRepository;
import java.io.*;
import main.Main;
import repositories.repositoriesUsuario.*;

public class MainUsuarioAdd {
	public static void main(String[] args) {
		String main = "MainUsuarioAdd";

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
						Usuario user = new Usuario(nome, cpf, Main.SENHA, Main.MATRICULA);

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

			BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ubuntu/ProjetoLEDA-Laboratorio5/data/resultadoUsuarioAdd.txt"));			
			writer.write(outputFinal = Main.CABECALHO + outputFinal);
			writer.close();

			System.out.println("Terminou");
		} catch (IOException ioe) {
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
