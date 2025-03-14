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

public class MainDicaBuscaUltima {
	public static void main(String[] args) {

		DicaRepository repoArrayList;
		DicaRepository repoDeque;
		DicaRepository repoHashMap;
		DicaRepository repoLinkedHashMap;
		DicaRepository repoLinkedList;
		DicaRepository repoTreeSet;

		String caminhoArquivo = Main.FILE_PATH;

		// lendo da entrada padrão
		try {
			PrintStream fileOut = new PrintStream("data/resultadoDicaBuscaUltima.txt");
			System.setOut(fileOut);
			// Cabeçalho
			System.out.println(Main.HEADER);

			for (int carga = Main.CARGA_DICA_INICIAL; carga <= Main.CARGA_DICA_FINAL; carga *= Main.RAZAO) {
				long tempoTotalAL = 0;
				long tempoTotalDQ = 0;
				long tempoTotalHM = 0;
				long tempoTotalLHM = 0;
				long tempoTotalLL = 0;
				long tempoTotalTS = 0;

				for (int i = 0; i < Main.REPETICOES; i++) {
					BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));

					repoArrayList = new DicaRepositoryArrayList();
					repoDeque = new DicaRepositoryDeque();
					repoHashMap = new DicaRepositoryHashMap();
					repoLinkedHashMap = new DicaRepositoryLinkedHashMap();
					repoLinkedList = new DicaRepositoryLinkedList();
					repoTreeSet = new DicaRepositoryTreeSet();

					int linhaAtual = 0;

					while (linhaAtual++ < carga) {
						String line = reader.readLine();
						String[] sequencia = line.split(" ");

						String nome = sequencia[0];
						String cpf = sequencia[1];
						String senha = sequencia[2];
						String matricula = sequencia[3];

						Usuario user = new Usuario(nome, cpf, senha, matricula);
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

					int posicao = carga * 2;
					tempoTotalAL += executaBusca(repoArrayList, posicao);
					tempoTotalHM += executaBusca(repoHashMap, posicao);
					tempoTotalLHM += executaBusca(repoLinkedHashMap, posicao);
					tempoTotalDQ += executaBusca(repoDeque, posicao);
					tempoTotalLL += executaBusca(repoLinkedList, posicao);
					tempoTotalTS += executaBusca(repoTreeSet, posicao);
				}

				long mediaAL = tempoTotalAL / Main.REPETICOES;
				long mediaHM = tempoTotalHM / Main.REPETICOES;
				long mediaDQ = tempoTotalDQ / Main.REPETICOES;
				long mediaLHM = tempoTotalLHM / Main.REPETICOES;
				long mediaLL = tempoTotalLL / Main.REPETICOES;
				long mediaTS = tempoTotalTS / Main.REPETICOES;

				// adiciona o resultado no arquivo de resultado
				System.out.println("ArrayList " + mediaAL + " " + carga * 2);
				System.out.println("HashMap " + mediaHM + " " + carga * 2);
				System.out.println("LinkedList " + mediaLL + " " + carga * 2);
				System.out.println("LinkedHashMap " + mediaLHM + " " + carga * 2);
				System.out.println("Deque " + mediaDQ + " " + carga * 2);
				System.out.println("TreeSet " + mediaTS + " " + carga * 2);
			}
			fileOut.close();
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