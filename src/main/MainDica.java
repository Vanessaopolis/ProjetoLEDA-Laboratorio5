package main;

import entities.Usuario;
import interfaces.DicaRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repositories.repositoriesDica.*;


public class MainDica {
    public static void main(String[] args) {
        String main = "MainLDica";

        DicaRepository repoArrayList;
		DicaRepository repoDeque;
		DicaRepository repoHashMap;
		DicaRepository repoLinkedHashMap;
		DicaRepository repoLinkedList;
		DicaRepository repoTreeSet;

		String caminhoArquivo = Main.CAMINHO_ARQUIVO_DE_ENTRADA;

		try {
			String outputFinal = "";

            //le arquivo de entrada 1x
			List<Usuario> todosUsuarios = leUsuarios(caminhoArquivo);

			for (int carga : Main.CARGAS) {
				System.out.println("main: " + main + ", começo da carga: " + carga);

				int cargaDica = carga / 2;

				long addTempoTotalAL = 0, buscaPTempoTotalAL = 0, buscaMTempoTotalAL = 0, buscaUTempoTotalAL = 0;
				long addTempoTotalDQ = 0, buscaPTempoTotalDQ = 0, buscaMTempoTotalDQ = 0, buscaUTempoTotalDQ = 0;
				long addTempoTotalHM = 0, buscaPTempoTotalHM = 0, buscaMTempoTotalHM = 0, buscaUTempoTotalHM = 0;
				long addTempoTotalLHM = 0, buscaPTempoTotalLHM = 0, buscaMTempoTotalLHM = 0, buscaUTempoTotalLHM = 0;;
				long addTempoTotalLL = 0, buscaPTempoTotalLL = 0, buscaMTempoTotalLL = 0, buscaUTempoTotalLL = 0;
				long addTempoTotalTS = 0, buscaPTempoTotalTS = 0, buscaMTempoTotalTS = 0, buscaUTempoTotalTS = 0;

				for (int i = 0; i < Main.REPETICOES; i++) {
					System.out.println(new Date().toString() + "main: " + main + ", carga: " + carga + ", repetição: " + (i + 1));

					List<Usuario> listaDeUsuarios = new ArrayList<>(todosUsuarios.subList(0, carga));

					repoArrayList = new DicaRepositoryArrayList();
					repoDeque = new DicaRepositoryDeque();
					repoHashMap = new DicaRepositoryHashMap();
					repoLinkedHashMap = new DicaRepositoryLinkedHashMap();
					repoLinkedList = new DicaRepositoryLinkedList();
					repoTreeSet = new DicaRepositoryTreeSet();

					// int linhaAtual = 0;
					// while (linhaAtual++ < cargaDica) {
						
					//tempo total em adicao de cada ED
					System.out.println(new Date().toString() + "Processando ArrayList - Adição");
					addTempoTotalAL += AnalisadorDica.executaAdd(repoArrayList, listaDeUsuarios);
					System.out.println(new Date().toString() + "Processando Deque - Adição");
					addTempoTotalDQ += AnalisadorDica.executaAdd(repoDeque, listaDeUsuarios);
					System.out.println(new Date().toString() + "Processando HashMap - Adição");
					addTempoTotalHM += AnalisadorDica.executaAdd(repoHashMap, listaDeUsuarios);
					System.out.println(new Date().toString() + "Processando LinkedHashMap - Adição");
					addTempoTotalLHM += AnalisadorDica.executaAdd(repoLinkedHashMap, listaDeUsuarios);
					System.out.println(new Date().toString() + "Processando LinkedList - Adição");
					addTempoTotalLL += AnalisadorDica.executaAdd(repoLinkedList, listaDeUsuarios);
					System.out.println(new Date().toString() + "Processando TreeSet - Adição");
					addTempoTotalTS += AnalisadorDica.executaAdd(repoTreeSet, listaDeUsuarios);
						

					//tempo total de busca em cada ED
					System.out.println(new Date().toString() + "Processando ArrayList - Busca");
                    buscaPTempoTotalAL += AnalisadorDica.executaBusca(repoArrayList, 1); 
                    buscaMTempoTotalAL += AnalisadorDica.executaBusca(repoArrayList, carga/2);
                    buscaPTempoTotalAL += AnalisadorDica.executaBusca(repoArrayList, carga);
					
                    System.out.println(new Date().toString() + "Processando HashMap - Busca");
                    buscaPTempoTotalHM += AnalisadorDica.executaBusca(repoHashMap, 1);
                    buscaMTempoTotalHM += AnalisadorDica.executaBusca(repoHashMap, carga/2);
                    buscaUTempoTotalHM += AnalisadorDica.executaBusca(repoHashMap, carga);
					
                    System.out.println(new Date().toString() + "Processando LinkedHashMap - Busca");
                    buscaPTempoTotalLHM += AnalisadorDica.executaBusca(repoLinkedHashMap, 1);
                    buscaMTempoTotalLHM += AnalisadorDica.executaBusca(repoLinkedHashMap, carga/2);
                    buscaUTempoTotalLHM += AnalisadorDica.executaBusca(repoLinkedHashMap, carga);
					
                    System.out.println(new Date().toString() + "Processando Deque - Busca");
                    buscaPTempoTotalDQ += AnalisadorDica.executaBusca(repoDeque, 1);
                    buscaMTempoTotalDQ += AnalisadorDica.executaBusca(repoDeque, carga/2);
                    buscaUTempoTotalDQ += AnalisadorDica.executaBusca(repoDeque, carga);
					
                    System.out.println(new Date().toString() + "Processando LinkedList - Busca");
                    buscaPTempoTotalLL += AnalisadorDica.executaBusca(repoLinkedList, 1);
                    buscaMTempoTotalLL += AnalisadorDica.executaBusca(repoLinkedList, carga/2);
                    buscaUTempoTotalLL += AnalisadorDica.executaBusca(repoLinkedList, carga);
					
                    System.out.println(new Date().toString() + "Processando TreeSet - Busca");
                    buscaPTempoTotalTS += AnalisadorDica.executaBusca(repoTreeSet, 1);
                    buscaMTempoTotalTS += AnalisadorDica.executaBusca(repoTreeSet, carga/2);
                    buscaUTempoTotalTS += AnalisadorDica.executaBusca(repoTreeSet, carga);
				}

				long mediaALadd = addTempoTotalAL / Main.REPETICOES, mediaALbp = buscaPTempoTotalAL / Main.REPETICOES, mediaALbm = buscaMTempoTotalAL / Main.REPETICOES, mediaALbu = buscaUTempoTotalAL;
				long mediaDQadd = addTempoTotalDQ / Main.REPETICOES,  mediaDQbp = buscaPTempoTotalDQ / Main.REPETICOES, mediaDQbm = buscaMTempoTotalDQ / Main.REPETICOES, mediaDQbu = buscaUTempoTotalDQ;
				long mediaHMadd = addTempoTotalHM / Main.REPETICOES,  mediaHMbp = buscaPTempoTotalHM / Main.REPETICOES, mediaHMbm = buscaMTempoTotalHM / Main.REPETICOES, mediaHMbu = buscaUTempoTotalHM;
				long mediaLHMadd = addTempoTotalLHM / Main.REPETICOES,  mediaLHMbp = buscaPTempoTotalLHM / Main.REPETICOES, mediaLHMbm = buscaMTempoTotalLHM / Main.REPETICOES, mediaLHMbu = buscaUTempoTotalLHM;
				long mediaLLadd = addTempoTotalLL / Main.REPETICOES,  mediaLLbp = buscaPTempoTotalLL / Main.REPETICOES, mediaLLbm = buscaMTempoTotalLL / Main.REPETICOES, mediaLLbu = buscaUTempoTotalLL;
				long mediaTSadd = addTempoTotalTS / Main.REPETICOES,  mediaTSbp = buscaPTempoTotalTS / Main.REPETICOES, mediaTSbm = buscaMTempoTotalTS / Main.REPETICOES, mediaTSbu = buscaUTempoTotalTS;

			
				String outputDaCarga = "";
				outputDaCarga += geraOutput("ArrayList ", carga, mediaALadd, mediaALbp, mediaALbm, mediaALbu);
				outputDaCarga += geraOutput("Deque ", carga, mediaDQadd, mediaDQbp, mediaDQbm, mediaDQbu);
				outputDaCarga += geraOutput("HashMap ", carga, mediaHMadd, mediaHMbp, mediaHMbm, mediaHMbu);
				outputDaCarga += geraOutput("LinkedHashMap ", carga, mediaLHMadd, mediaLHMbp, mediaLHMbm, mediaLHMbu);
				outputDaCarga += geraOutput("LinkedList ", carga, mediaLLadd, mediaLLbp, mediaLLbm, mediaLLbu);
				outputDaCarga += geraOutput("TreeSet ", carga, mediaTSadd, mediaTSbp, mediaTSbm, mediaTSbu);

				outputFinal += outputDaCarga;

				System.out.println("carga concluída: " + carga);
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ubuntu/ProjetoLEDA-Laboratorio5/data/resultadosDica.txt"));			
			writer.write(outputFinal = Main.CABECALHO + outputFinal);
			writer.close();

			System.out.println("Terminou");


		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

    private static List<Usuario> leUsuarios(String caminhoDoArquivo){
		List<Usuario> todosUsuarios = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(caminhoDoArquivo))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] dados = line.split(" ");
				String nome = dados[0];
				String cpf = dados[1];
				Usuario user = new Usuario(nome, cpf, Main.SENHA, Main.MATRICULA);
				todosUsuarios.add(user);
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}
		return todosUsuarios;
    }

	private static String geraOutput(String nome, int carga, long add, long buscaP, long buscaM, long buscaU) {
		return nome + " - carga(" + carga + ")\n" +
			   "\tmedia de Adicao = " + add + "\n" +
			   "\tmedia de Busca em Primeiro = " + buscaP + "\n" +
			   "\tmedia de Busca no Meio = " + buscaM + "\n" +
			   "\tmedia de Busca em Ultimo = " + buscaU + "\n";
	}
	
	private static String geraOutput2(String nome, int carga, long add, long busca, long ordAlf, long ordBonus) {
		String output = "(" + carga + ") - " + nome + " " + add + " " + busca + " " + ordAlf + " " + ordBonus + "\n" ;
		return output;
	}

	
}