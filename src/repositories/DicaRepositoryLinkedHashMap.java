package repositories;

import entities.Dica;
import interfaces.DicaRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import validators.ValidadorDica;

/**
 * Classe responsável por gerenciar e armazenar as dicas em um repositório. Esta
 * classe permite adicionar e listar dicas.
 * 
 * @author Lukas Soares do Nascimento, matrícula 123210298
 * @author Alana Vanessa Pimentel Toldo de Andrade, matrícula 123210882
 */
public class DicaRepositoryLinkedHashMap implements DicaRepository {

	private Map<Integer, Dica> dicas;
	private Integer numeroDaDica;

	/**
	 * Cria um novo repositório de dicas
	 */
	public DicaRepositoryLinkedHashMap() {
		this.dicas = new LinkedHashMap<>();
		this.numeroDaDica = 0;
	}

	/**
	 * Adiciona uma dica ao repositório
	 * 
	 * @param dica a dica ser adicionada
	 * @return o número total de dicas no repositório
	 * @throws NullPointerException se a dica for nula
	 */
	public int adicionaDica(Dica dica) {
		ValidadorDica.validaDica(dica);

		if (this.dicas.containsValue(dica))
			return 0;

		dicas.put(++numeroDaDica, dica);

		return dicas.size();
	}

	public boolean isEmpty() {
		return dicas.isEmpty();
	}

	/**
	 * Retorna uma lista das dicas como strings.
	 *
	 * @return um array de strings representando as dicas
	 */
	public String[] listaDicas() {
		if (this.dicas.isEmpty())
			return new String[0];

		String[] lista = new String[dicas.size()];
		int i = 0;
		while (i < dicas.size())
			lista[i] = dicas.get(++i).toString();

		return lista;
	}

	/**
	 * Retorna uma lista detalhada das dicas.
	 *
	 * @return um array de strings representando as dicas
	 */
	public String[] listaDicasDetalhes() {
		if (this.dicas.isEmpty())
			return new String[0];

		String[] lista = new String[dicas.size()];
		int i = 0;
		while (i < dicas.size())
			lista[i] = dicas.get(i++).exibeDetalhes();

		return lista;
	}

	/**
	 * Retorna a representação em string da dica na posição especificada.
	 *
	 * @param posicao a posição da dica a ser retornada (1-based)
	 * @return a representação em string da dica
	 * @throws IllegalArgumentException se posicao for inválida
	 */
	public String listaDica(int posicao) {
		return this.dicas.get(posicao).toString();
	}

	/**
	 * Retorna os detalhes da dica na posição especificada.
	 *
	 * @param posicao a posição da dica a ser retornada (1-based)
	 * @return os detalhes da dica
	 * @throws IllegalArgumentException se posicao for inválida
	 */
	public String listaDicaDetalhes(int posicao) {
		return dicas.get(posicao).exibeDetalhes();
	}

	/**
	 * Busca e retorna a dica na posição especificada.
	 *
	 * @param posicao a posição da dica a ser buscada
	 * @return a dica na posição especificada
	 * @throws IllegalArgumentException se posicao for inválida
	 */
	public Dica buscaDica(int posicao) {
		ValidadorDica.validaPosicao(posicao, this.dicas.size());
		return this.dicas.get(posicao);
	}

}
