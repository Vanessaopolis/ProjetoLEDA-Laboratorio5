package main;

import java.io.IOException;

public class MainDosMains {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("Começando os testes para repositórios de Usuario...");

		executaOutraClasse("MainUsuarioAdd");
		executaOutraClasse("MainUsuarioBusca");
		executaOutraClasse("MainUsuarioOrdAlfabetica");
		executaOutraClasse("MainUsuarioOrdBonus");

		System.out.println();
		System.out.println("Começando os testes para repositórios ded Dica...");
		executaOutraClasse("MainDicaAdd");
		executaOutraClasse("MainDicaBuscaMeio");
		executaOutraClasse("MainDicaBuscaPrimeira");
		executaOutraClasse("MainDicaBuscaUltima");

		System.out.println();
		System.out.println("Todos os testes terminaram!");

	}

	private static void executaOutraClasse(String nomeClasse) throws IOException, InterruptedException {
		System.out.println("Iniciando execução de " + nomeClasse);
		ProcessBuilder processBuilder = new ProcessBuilder("java", nomeClasse);
		processBuilder.inheritIO();
		Process process = processBuilder.start();
		process.waitFor();
		System.out.println("Execução de " + nomeClasse + " finalizada!");
	}

}
