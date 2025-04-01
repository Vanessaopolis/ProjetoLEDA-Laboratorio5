package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import entities.Dica;
import entities.Usuario;
import interfaces.DicaRepository;
import repositories.DicaRepositoryLinkedList;

public class MainTestesDeAlana {
	public static void main(String[] args) {

		DicaRepository repoLinkedList;

		String caminhoArquivo = Main.FILE_PATH;
		// lendo da entrada padrão
		try {
			PrintStream fileOut = new PrintStream("data/testes_de_alana/testeDeAlanaDicaBuscaUltimaWithGetLast.txt");
			System.setOut(fileOut);
			// Cabeçalho
			System.out.println(Main.HEADER);

			for (int carga = 25; carga <= 18225; carga *= 3) {
				long tempoTotalLL = 0;

				for (int i = 0; i < Main.REPETICOES; i++) {
					BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));

					repoLinkedList = new DicaRepositoryLinkedList();

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
						repoLinkedList.adicionaDica(d1);
						repoLinkedList.adicionaDica(d2);
					}

					tempoTotalLL += executaBusca(repoLinkedList, carga);
					reader.close();
				}

				long mediaLL = tempoTotalLL / Main.REPETICOES;

				// adiciona o resultado no arquivo de resultado
				System.out.println("LinkedList " + mediaLL + " " + carga * 2);
			}
			fileOut.close();

			System.setOut(Main.CONSOLE_OUT);
			System.out.println("Terminou");

		} catch (IOException ioe) {
			System.setOut(Main.CONSOLE_OUT);
			System.out.println(ioe);

		}
	}

	private static long executaBusca(DicaRepository dicaRepository, int carga) {
		long start = System.nanoTime();
		Dica dica = dicaRepository.buscaDica(carga * 2);
		long end = System.nanoTime();
		return end - start;
	}
}