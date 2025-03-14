package main;

public abstract class Main {
	public static final int CARGA_USUARIO_INICIAL = 50;
	public static final int CARGA_USUARIO_FINAL = 109350;

	// carga dividida em 2, pois cada usuário vai possuir 2 dicas
	public static final int CARGA_DICA_INICIAL = CARGA_USUARIO_INICIAL / 2;
	public static final int CARGA_DICA_FINAL = CARGA_USUARIO_FINAL / 2;

	public static final int RAZAO = 3;
	public static final int REPETICOES = 30;

	public static final String HEADER = "EDA time sample";
	public static final String FILE_PATH = "data/usuariosModificados.txt";
}
