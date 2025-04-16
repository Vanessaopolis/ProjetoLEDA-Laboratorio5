package main;

import entities.Usuario;
import interfaces.UsuarioRepository;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repositories.repositoriesUsuario.*;

public class MainUsuario {
	public static void main(String[] args) {
		String main = "MainUsuario";

		UsuarioRepository repoArrayList;
		UsuarioRepository repoHashMap;
		UsuarioRepository repoHashSet;
		UsuarioRepository repoLinkedHashMap;
		UsuarioRepository repoTreeMap;
		UsuarioRepository repoTreeSet;

		String caminhoArquivo = Main.CAMINHO_ARQUIVO_DE_ENTRADA;

		try {
			String outputFinal = "";

			//le arquivo de entrada 1x
			List<Usuario> todosUsuarios = leUsuarios(caminhoArquivo);

			for (int carga : Main.CARGAS) {
				System.out.println("main: " + main + ", começo da carga: " + carga);

				long addTempoTotalAL = 0, buscaTempoTotalAL = 0, ordAlfTempoTotalAL = 0, ordBonusTempoTotalAL = 0; //arraylist
				long addTempoTotalHM = 0, buscaTempoTotalHM = 0, ordAlfTempoTotalHM = 0, ordBonusTempoTotalHM = 0; //hashmap
				long addTempoTotalHS = 0, buscaTempoTotalHS = 0, ordAlfTempoTotalHS = 0, ordBonusTempoTotalHS = 0; //hashset
				long addTempoTotalLHM = 0, buscaTempoTotalLHM = 0, ordAlfTempoTotalLHM = 0, ordBonusTempoTotalLHM = 0; //linkedhashmap
				long addTempoTotalTM = 0, buscaTempoTotalTM = 0, ordAlfTempoTotalTM = 0, ordBonusTempoTotalTM  = 0; //linkedtreemap
				long addTempoTotalTS = 0, buscaTempoTotalTS = 0, ordAlfTempoTotalTS = 0, ordBonusTempoTotalTS = 0; //treeset

				for (int i = 0; i < Main.REPETICOES; i++) {
					System.out.println(new Date().toString() + "main: " + main + ", carga: " + carga + ", repetição: " + (i + 1));
					
					List<Usuario> listaDeUsuarios = new ArrayList<>(todosUsuarios.subList(0, carga));
					String cpfASerBuscado = listaDeUsuarios.get(carga / 2).getCpf();
					
					repoArrayList = new UsuarioRepositoryArrayList();
					repoHashMap = new UsuarioRepositoryHashMap();
					repoHashSet = new UsuarioRepositoryHashSet();
					repoLinkedHashMap = new UsuarioRepositoryLinkedHashMap();
					repoTreeMap = new UsuarioRepositoryTreeMap();
					repoTreeSet = new UsuarioRepositoryTreeSet();



					//1. adicionar os usuarios do arquivo de entrada em um arraylist
					//2. a partir desse array seguir os testes
					
					// Garante que a lista não tenha menos elementos que a carga necessária
					if (carga > todosUsuarios.size()) {
						System.out.println("Carga maior que quantidade de usuários disponíveis.");
						continue;
}

					//tempo total em adicao de cada ED
					System.out.println(new Date().toString() + "Processando ArrayList - Adição");
					addTempoTotalAL += AnalisadorUsuario.executaAdd(repoArrayList, listaDeUsuarios);
					System.out.println(new Date().toString() + "Processando HashMap - Adição");
					addTempoTotalHM += AnalisadorUsuario.executaAdd(repoHashMap, listaDeUsuarios);
					System.out.println(new Date().toString() + "Processando HashSet - Adição");
					addTempoTotalHS += AnalisadorUsuario.executaAdd(repoHashSet, listaDeUsuarios);
					System.out.println(new Date().toString() + "Processando LinkedHashMap - Adição");
					addTempoTotalLHM += AnalisadorUsuario.executaAdd(repoLinkedHashMap, listaDeUsuarios);
					System.out.println(new Date().toString() +"Processando TreeMap - Adição");
					addTempoTotalTM += AnalisadorUsuario.executaAdd(repoTreeMap, listaDeUsuarios);
					System.out.println(new Date().toString() + "Processando TreeSet - Adição");
					addTempoTotalTS += AnalisadorUsuario.executaAdd(repoTreeSet, listaDeUsuarios);
					
					//tempo total de busca em cada ED
					System.out.println(new Date().toString() + "Processando ArrayList - Busca");
					buscaTempoTotalAL += AnalisadorUsuario.executaBusca(repoArrayList, cpfASerBuscado);
					System.out.println(new Date().toString() + "Processando HashMap - Busca");
					buscaTempoTotalHM += AnalisadorUsuario.executaBusca(repoHashMap, cpfASerBuscado);
					System.out.println(new Date().toString() + "Processando HashSet - Busca");
					buscaTempoTotalHS += AnalisadorUsuario.executaBusca(repoHashSet, cpfASerBuscado);
					System.out.println(new Date().toString() + "Processando LinkedHashMap - Busca");
					buscaTempoTotalLHM += AnalisadorUsuario.executaBusca(repoLinkedHashMap, cpfASerBuscado);
					System.out.println(new Date().toString() + "Processando TreeMap - Busca");
					buscaTempoTotalTM += AnalisadorUsuario.executaBusca(repoTreeMap, cpfASerBuscado);
					System.out.println(new Date().toString() + "Processando TreeSet - Busca");
					buscaTempoTotalTS += AnalisadorUsuario.executaBusca(repoTreeSet, cpfASerBuscado);
					
					//tempo total de ordenacao alfbaetica em cada ED
					System.out.println(new Date().toString() + "Processando ArrayList - Ord Alf");
					ordAlfTempoTotalAL += AnalisadorUsuario.executaListagemOrdemAlfabetica(repoArrayList);
					System.out.println(new Date().toString() + "Processando HashMap - Ord Alf");
					ordAlfTempoTotalHM += AnalisadorUsuario.executaListagemOrdemAlfabetica(repoHashMap);
					System.out.println(new Date().toString() + "Processando HashSet - Ord Alf");
					ordAlfTempoTotalHS += AnalisadorUsuario.executaListagemOrdemAlfabetica(repoHashSet);
					System.out.println(new Date().toString() + "Processando LinkedHashMap - Ord Alf");
					ordAlfTempoTotalLHM += AnalisadorUsuario.executaListagemOrdemAlfabetica(repoLinkedHashMap);
					System.out.println(new Date().toString() + "Processando TreeMap - Ord Alf");
					ordAlfTempoTotalTM += AnalisadorUsuario.executaListagemOrdemAlfabetica(repoTreeMap);
					System.out.println(new Date().toString() + "Processando TreeSet - Ord Alf");
					ordAlfTempoTotalTS += AnalisadorUsuario.executaListagemOrdemAlfabetica(repoTreeSet);
					
					//tempo total de ordenacao por bonus de cada ED
					System.out.println(new Date().toString() + "Processando ArrayList - Ord Bonus");
					ordBonusTempoTotalAL += AnalisadorUsuario.executaListagemOrdemBonificacao(repoArrayList);
					System.out.println(new Date().toString() + "Processando HashMap - Ord Bonus");
					ordBonusTempoTotalHM += AnalisadorUsuario.executaListagemOrdemBonificacao(repoHashMap);
					System.out.println(new Date().toString() + "Processando HashSet - Ord Bonus");
					ordBonusTempoTotalHS += AnalisadorUsuario.executaListagemOrdemBonificacao(repoHashSet);
					System.out.println(new Date().toString() + "Processando LinkedHashMap - Ord Bonus");
					ordBonusTempoTotalLHM += AnalisadorUsuario.executaListagemOrdemBonificacao(repoLinkedHashMap);
					System.out.println(new Date().toString() + "Processando TreeMap - Ord Bonus");
					ordBonusTempoTotalTM += AnalisadorUsuario.executaListagemOrdemBonificacao(repoTreeMap);
					System.out.println(new Date().toString() + "Processando TreeSet - Ord Bonus");
					ordBonusTempoTotalTS += AnalisadorUsuario.executaListagemOrdemBonificacao(repoTreeSet);
						

					//a partir daqui, temos as estruturas já populadas
					//então, neste mesmo main deve-se fazer a analise de busca e ord(s)
					//ou isso ou retornar a ED já populada de alguma forma para os outros mains
				}

				long mediaALAdd = addTempoTotalAL / Main.REPETICOES, mediaALBusca = buscaTempoTotalAL  / Main.REPETICOES, mediaALOA = ordAlfTempoTotalAL / Main.REPETICOES, mediaALOB = ordBonusTempoTotalAL/ Main.REPETICOES;
				long mediaHMadd = addTempoTotalHM / Main.REPETICOES, mediaHMBusca = buscaTempoTotalHM / Main.REPETICOES, mediaHMOA = ordAlfTempoTotalHM / Main.REPETICOES, mediaHMOB = ordBonusTempoTotalHM / Main.REPETICOES;
				long mediaHSadd = addTempoTotalHS / Main.REPETICOES, mediaHSBusca = buscaTempoTotalHS / Main.REPETICOES, mediaHSOA = ordAlfTempoTotalHS / Main.REPETICOES, mediaHSOB = ordBonusTempoTotalHS  / Main.REPETICOES;
				long mediaLHMadd = addTempoTotalLHM / Main.REPETICOES, mediaLHMBusca = buscaTempoTotalLHM / Main.REPETICOES, mediaLHMOA = ordAlfTempoTotalLHM / Main.REPETICOES, mediaLHMOB = ordBonusTempoTotalLHM / Main.REPETICOES;
				long mediaTMadd = addTempoTotalTM / Main.REPETICOES, mediaTMBusca = buscaTempoTotalTM / Main.REPETICOES, mediaTMOA = ordAlfTempoTotalTM / Main.REPETICOES, mediaTMOB = ordBonusTempoTotalTM / Main.REPETICOES;
				long mediaTSadd = addTempoTotalTS / Main.REPETICOES, mediaTSBusca = buscaTempoTotalTS / Main.REPETICOES, mediaTSOA = ordAlfTempoTotalTS / Main.REPETICOES, mediaTSOB = ordBonusTempoTotalTS / Main.REPETICOES;

				String outputDaCarga = "";
				outputDaCarga += geraOutput("ArrayList", carga, mediaALAdd, mediaALBusca, mediaALOA, mediaALOB);
				outputDaCarga += geraOutput2("HashMap", carga, mediaHMadd, mediaHMBusca, mediaHMOA, mediaHMOB);
				outputDaCarga += geraOutput2("HashSet", carga, mediaHSadd, mediaHSBusca, mediaHSOA, mediaHSOB);
				outputDaCarga += geraOutput2("LinkedHashMap", carga, mediaLHMadd, mediaLHMBusca, mediaLHMOA, mediaLHMOB);
				outputDaCarga += geraOutput2("TreeMap", carga, mediaTMadd, mediaTMBusca, mediaTMOA, mediaTMOB);
				outputDaCarga += geraOutput2("TreeSet", carga, mediaTSadd, mediaTSBusca, mediaTSOA, mediaTSOB);

				outputFinal += outputDaCarga;
				System.out.println("carga concluída: " + carga);
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ubuntu/ProjetoLEDA-Laboratorio5/data/resultadosUsuario.txt"));			
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

	private static String geraOutput(String nome, int carga, long add, long busca, long ordAlf, long ordBonus) {
		return nome + " - carga(" + carga + ")\n" +
			   "\tmedia de Adicao = " + add + "\n" +
			   "\tmedia de Busca = " + busca + "\n" +
			   "\tmedia de Ord Alf = " + ordAlf + "\n" +
			   "\tmedia de Ord Bonus = " + ordBonus + "\n";
	}
	
	private static String geraOutput2(String nome, int carga, long add, long busca, long ordAlf, long ordBonus) {
		String output = "(" + carga + ") - " + nome + " " + add + " " + busca + " " + ordAlf + " " + ordBonus + "\n" ;
		return output;
	}

}
