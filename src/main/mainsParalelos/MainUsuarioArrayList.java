package main.mainsParalelos;

import entities.Usuario;
import interfaces.UsuarioRepository;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import main.AnalisadorUsuario;
import main.Main;
import repositories.repositoriesUsuario.UsuarioRepositoryArrayList;

public class MainUsuarioArrayList {
	public static void main(String[] args) {
		String main = "MainLukas";

		UsuarioRepository repoArrayList;

		String caminhoArquivo = Main.CAMINHO_ARQUIVO_DE_ENTRADA;

		try {
			String outputFinal = "";

			//le arquivo de entrada 1x
			List<Usuario> todosUsuarios = leUsuarios(caminhoArquivo);

			for (int carga : Main.CARGAS) {
                System.out.println(new Date().toString() + " main: " + main + ", começo da carga: " + carga);

				long addTempoTotalAL = 0, buscaTempoTotalAL = 0, ordAlfTempoTotalAL = 0, ordBonusTempoTotalAL = 0; //arraylist
				
				for (int i = 0; i < Main.REPETICOES; i++) {
					
                    System.out.println(new Date().toString() + "main: " + main + ", carga: " + carga + ", repetição: " + (i + 1));
					
					List<Usuario> listaDeUsuarios = new ArrayList<>(todosUsuarios.subList(0, carga));
					String cpfASerBuscado = listaDeUsuarios.get(carga / 2).getCpf();
					
					repoArrayList = new UsuarioRepositoryArrayList();
					
					//1. adicionar os usuarios do arquivo de entrada em um arraylist
					//2. a partir desse array seguir os testes
					
					// Garante que a lista não tenha menos elementos que a carga necessária
					if (carga > todosUsuarios.size()) {
						System.out.println("Carga maior que quantidade de usuários disponíveis.");
						continue;
}

					//tempo total em adicao de cada ED
					System.out.println(new Date().toString() + " Processando ArrayList - Adição");
					addTempoTotalAL += AnalisadorUsuario.executaAdd(repoArrayList, listaDeUsuarios);
					
                    //tempo total de busca em cada ED
					System.out.println(new Date().toString() + " Processando ArrayList - Busca");
					buscaTempoTotalAL += AnalisadorUsuario.executaBusca(repoArrayList, cpfASerBuscado);
					
					//tempo total de ordenacao alfbaetica em cada ED
					System.out.println(new Date().toString() + " Processando ArrayList - Ord Alf");
					ordAlfTempoTotalAL += AnalisadorUsuario.executaListagemOrdemAlfabetica(repoArrayList);
					
					//tempo total de ordenacao por bonus de cada ED
					System.out.println(new Date().toString() + " Processando ArrayList - Ord Bonus");
					ordBonusTempoTotalAL += AnalisadorUsuario.executaListagemOrdemBonificacao(repoArrayList);

					//a partir de aqui, temos as estruturas já populadas
					//então, neste mesmo main deve-se fazer a analise de busca e ord(s)
					//ou isso ou retornar a ED já populada de alguma forma para os outros mains
				}

				long mediaALAdd = addTempoTotalAL / Main.REPETICOES, mediaALBusca = buscaTempoTotalAL  / Main.REPETICOES, mediaALOA = ordAlfTempoTotalAL / Main.REPETICOES, mediaALOB = ordBonusTempoTotalAL/ Main.REPETICOES;
				
				String outputDaCarga = "";
				outputDaCarga += geraOutput("ArrayList", carga, mediaALAdd, mediaALBusca, mediaALOA, mediaALOB);
				
				outputFinal += outputDaCarga;
				System.out.println(new Date().toString() + " carga concluída: " + carga);
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ubuntu/ProjetoLEDA-Laboratorio5/data/resultadoUsuarioArrayListOrdenacaoBonus.txt"));			
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
	

}
