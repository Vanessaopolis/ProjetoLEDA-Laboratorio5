package main;

import entities.Dica;
import entities.Usuario;
import interfaces.DicaRepository;
import repositories.DicaRepositoryArrayList;
import repositories.DicaRepositoryDeque;
import repositories.DicaRepositoryHashMap;
import repositories.DicaRepositoryLinkedHashMap;
import repositories.DicaRepositoryLinkedList;
import repositories.DicaRepositoryTreeSet;
import java.io.*;

public class MainDicaAdd {
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
			PrintStream fileOut = new PrintStream("data/resultadoDicaAdd.txt");
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

						tempoTotalAL += executaAdicao(repoArrayList, d1, d2);
						tempoTotalDQ += executaAdicao(repoDeque, d1, d2);
						tempoTotalHM += executaAdicao(repoHashMap, d1, d2);
						tempoTotalLHM += executaAdicao(repoLinkedHashMap, d1, d2);
						tempoTotalLL += executaAdicao(repoLinkedList, d1, d2);
						tempoTotalTS += executaAdicao(repoTreeSet, d1, d2);
					}
					reader.close();
				}

				long mediaAL = tempoTotalAL / Main.REPETICOES;
				long mediaDQ = tempoTotalDQ / Main.REPETICOES;
				long mediaHM = tempoTotalHM / Main.REPETICOES;
				long mediaLHM = tempoTotalLHM / Main.REPETICOES;
				long mediaLL = tempoTotalLL / Main.REPETICOES;
				long mediaTS = tempoTotalTS / Main.REPETICOES;

				// adiciona o resultado no arquivo de resultado
				System.out.println("ArrayList " + mediaAL + " " + carga * 2);
				System.out.println("Deque " + mediaDQ + " " + carga * 2);
				System.out.println("HashSet " + mediaHM + " " + carga * 2);
				System.out.println("LinkedHashMap " + mediaLHM + " " + carga * 2);
				System.out.println("TreeMap " + mediaLL + " " + carga * 2);
				System.out.println("TreeSet " + mediaTS + " " + carga * 2);
			}
			fileOut.close();
			System.out.println("Terminou");

		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

	private static long executaAdicao(DicaRepository dicaRepository, Dica dica1, Dica dica2) {
		long start = System.nanoTime();
		dicaRepository.adicionaDica(dica1);
		dicaRepository.adicionaDica(dica2);
		long end = System.nanoTime();
		return end - start;
	}

}