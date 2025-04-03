package main;

import entities.Usuario;
import interfaces.DicaRepository;
import entities.Dica;
import repositories.DicaRepositoryArrayList;
import repositories.DicaRepositoryDeque;
import repositories.DicaRepositoryHashMap;
import repositories.DicaRepositoryLinkedHashMap;
import repositories.DicaRepositoryLinkedList;
import repositories.DicaRepositoryTreeSet;
import java.io.*;

public class MainDicaBuscaMeio {
	public static void main(String[] args) {
		String main = "MainDicaBuscaMeio";

		DicaRepository repoArrayList;
		DicaRepository repoDeque;
		DicaRepository repoHashMap;
		DicaRepository repoLinkedHashMap;
		DicaRepository repoLinkedList;
		DicaRepository repoTreeSet;

		String caminhoArquivo = Main.CAMINHO_ARQUIVO_DE_ENTRADA;

		try {
			String outputFinal = "";

			for (int carga : Main.CARGAS) {
				System.out.println("main: " + main + ", começo da carga: " + carga);

				int cargaDica = carga / 2;

				long tempoTotalAL = 0;
				long tempoTotalDQ = 0;
				long tempoTotalHM = 0;
				long tempoTotalLHM = 0;
				long tempoTotalLL = 0;
				long tempoTotalTS = 0;

				for (int i = 0; i < Main.REPETICOES; i++) {
					System.out.println("main: " + main + ", carga: " + carga + ", repetição: " + (i + 1));

					BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));

					repoArrayList = new DicaRepositoryArrayList();
					repoDeque = new DicaRepositoryDeque();
					repoHashMap = new DicaRepositoryHashMap();
					repoLinkedHashMap = new DicaRepositoryLinkedHashMap();
					repoLinkedList = new DicaRepositoryLinkedList();
					repoTreeSet = new DicaRepositoryTreeSet();

					int linhaAtual = 0;
					while (linhaAtual++ < cargaDica) {
						String line = reader.readLine();
						String[] sequencia = line.split(" ");

						String nome = sequencia[0];
						String cpf = sequencia[1];
						Usuario user = new Usuario(nome, cpf, Main.SENHA, Main.MATRICULA);
						Dica d1 = new Dica(user, "PesquisaExtensao");
						Dica d2 = new Dica(user, "Monitoria");

						repoArrayList.adicionaDica(d1);
						repoArrayList.adicionaDica(d2);

						repoHashMap.adicionaDica(d1);
						repoHashMap.adicionaDica(d2);

						repoDeque.adicionaDica(d1);
						repoDeque.adicionaDica(d2);

						repoLinkedHashMap.adicionaDica(d1);
						repoLinkedHashMap.adicionaDica(d2);

						repoLinkedList.adicionaDica(d1);
						repoLinkedList.adicionaDica(d2);

						repoTreeSet.adicionaDica(d1);
						repoTreeSet.adicionaDica(d2);
					}

					reader.close();

					int posicao = cargaDica;
					tempoTotalAL += executaBusca(repoArrayList, posicao);
					tempoTotalDQ += executaBusca(repoDeque, posicao);
					tempoTotalHM += executaBusca(repoHashMap, posicao);
					tempoTotalLHM += executaBusca(repoLinkedHashMap, posicao);
					tempoTotalLL += executaBusca(repoLinkedList, posicao);
					tempoTotalTS += executaBusca(repoTreeSet, posicao);
				}

				long mediaAL = tempoTotalAL / Main.REPETICOES;
				long mediaDQ = tempoTotalDQ / Main.REPETICOES;
				long mediaHM = tempoTotalHM / Main.REPETICOES;
				long mediaLHM = tempoTotalLHM / Main.REPETICOES;
				long mediaLL = tempoTotalLL / Main.REPETICOES;
				long mediaTS = tempoTotalTS / Main.REPETICOES;

				String outputDaCarga = "";
				outputDaCarga += "ArrayList " + mediaAL + " " + carga + "\n";
				outputDaCarga += "Deque " + mediaDQ + " " + carga + "\n";
				outputDaCarga += "HashMap " + mediaHM + " " + carga + "\n";
				outputDaCarga += "LinkedHashMap " + mediaLHM + " " + carga + "\n";
				outputDaCarga += "LinkedList " + mediaLL + " " + carga + "\n";
				outputDaCarga += "TreeSet " + mediaTS + " " + carga + "\n";

				outputFinal += outputDaCarga;

				System.out.println("carga concluída: " + carga);
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ubuntu/ProjetoLEDA-Laboratorio5/data/resultadoDicaBuscaMeio.txt"));			
			writer.write(outputFinal = Main.CABECALHO + outputFinal);
			writer.close();

			System.out.println("Terminou");


		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

	private static long executaBusca(DicaRepository dicaRepository, int posicao) {
		long start = System.nanoTime();
		dicaRepository.buscaDica(posicao);
		long end = System.nanoTime();
		return end - start;
	}
}
