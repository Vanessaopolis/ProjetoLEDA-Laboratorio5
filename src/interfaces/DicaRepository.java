package interfaces;

import entities.Dica;

public interface DicaRepository {

	public int adicionaDica(Dica dica);

	public String[] listaDicas();

	public String[] listaDicasDetalhes();

	public String listaDica(int posicao);

	public String listaDicaDetalhes(int posicao);

	public Dica buscaDica(int posicao);

}
