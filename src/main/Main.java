package main;

import java.io.PrintStream;

public abstract class Main {
	public static final int[] CARGAS = new int[] { 1_000, 10_000, 50_000, 100_000, 500_000, 1_000_000 };

	public static final int REPETICOES = 30;

	public static final String HEADER = "collection time(ns) sample";
	public static final String FILE_PATH = "data/usuariosModificados.txt";

	public static final PrintStream CONSOLE_OUT = System.out;
}
