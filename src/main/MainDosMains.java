package main;

import java.io.IOException;

public class MainDosMains {

	public static void main(String[] args) throws IOException, InterruptedException {

		switch (args[0]) {
			case "MainUsuarioAdd":
				System.out.println("Começando os testes de: " + args[0]);
				executaOutraClasse("MainUsuarioAdd");
				break;
			case "MainUsuarioBusca":
				System.out.println("Começando os testes de: " + args[0]);
				executaOutraClasse("MainUsuarioBusca");
				break;
			case "MainUsuarioOrdAlfabetica":
				System.out.println("Começando os testes de: " + args[0]);
				executaOutraClasse("MainUsuarioOrdAlfabetica");
				break;
			case "MainUsuarioOrdBonus":
				System.out.println("Começando os testes de: " + args[0]);
				executaOutraClasse("MainUsuarioOrdBonus");
				break;
			case "MainDicaAdd":
				System.out.println("Começando os testes de: " + args[0]);
				executaOutraClasse("MainDicaAdd");
				break;
			case "MainDicaBuscaMeio":
				System.out.println("Começando os testes de: " + args[0]);
				executaOutraClasse("MainDicaBuscaMeio");
				break;
			case "MainDicaBuscaPrimeira":
				System.out.println("Começando os testes de: " + args[0]);
				executaOutraClasse("MainDicaBuscaPrimeira");
				break;
			case "MainDicaBuscaUltima":
				System.out.println("Começando os testes de: " + args[0]);
				executaOutraClasse("MainDicaBuscaUltima");
				break;
			case "all":
				System.out.println("Começando os testes para repositórios de Usuario...");
				executaOutraClasse("MainUsuarioAdd");
				executaOutraClasse("MainUsuarioBusca");
				executaOutraClasse("MainUsuarioOrdAlfabetica");
				executaOutraClasse("MainUsuarioOrdBonus");
				System.out.println();
		
				System.out.println("Começando os testes para repositórios de Dica...");
				executaOutraClasse("MainDicaAdd");
				executaOutraClasse("MainDicaBuscaMeio");
				executaOutraClasse("MainDicaBuscaPrimeira");
				executaOutraClasse("MainDicaBuscaUltima");
				System.out.println();
		
				System.out.println("Todos os testes terminaram!");
				break;
		}
	}

	private static void executaOutraClasse(String nomeClasse) throws IOException, InterruptedException {
		System.out.println("Iniciando execução de " + nomeClasse);
		ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "/home/ubuntu/ProjetoLEDA-Laboratorio5/src",
				"main." + nomeClasse);
		processBuilder.inheritIO();
		Process process = processBuilder.start();
		process.waitFor();
		System.out.println("Execução de " + nomeClasse + " finalizada!");
	}

}
