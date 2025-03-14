package repositories;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import entities.Usuario;
import interfaces.UsuarioRepository;
import validators.ValidadorUsuario;

/**
 * Classe responsável por gerenciar e armazenar os usuários (estudantes) em um
 * repositório. Esta classe permite adicionar, buscar e listar estudantes, além
 * de manter a validação de usuários.
 * 
 * @author Camila Rodrigues de Oliveira Rezende, matrícula 123210240
 * @author Alana Vanessa Pimentel Toldo de Andrade, matrícula 123210882
 */

public class UsuarioRepositoryHashSet implements UsuarioRepository {

	private Set<Usuario> estudantes;

	/**
	 * Cria um novo repositório de usuários.
	 */
	public UsuarioRepositoryHashSet() {
		this.estudantes = new HashSet<>();
	}

	/**
	 * Adiciona um estudante ao repositório.
	 *
	 * @param cpf       o cpf do estudante
	 * @param estudante o objeto a ser adicionado
	 * @return true se o estudante foi adicionado com sucesso, false se já existe um
	 *         estudante com o mesmo CPF
	 * @throws NullPointerException se o estudante for nulo
	 */
	public boolean adicionaEstudante(Usuario estudante) {
		ValidadorUsuario.validaUsuario(estudante);

		if (this.estudantes.contains(estudante)) {
			return false; // Não adiciona se já existir um estudante com o mesmo CPF
		}

		this.estudantes.add(estudante);
		return true;
	}

	/**
	 * Lista todos os estudantes no repositório como um array de strings.
	 *
	 * @return um array de String contendo a representação de todos os estudantes,
	 *         se existir
	 */
	public String[] listaEstudantes() {
		if (this.estudantes.isEmpty()) {
			return new String[0];
		}

		TreeSet<Usuario> estudantesOrdenadosAlfabeticamente = new TreeSet<>(this.estudantes);
		return converteParaArrayDeString(estudantesOrdenadosAlfabeticamente);
	}

	/**
	 * Lista todos os estudantes ordenados por bonificação em ordem decrescente.
	 *
	 * @return um array de String contendo a representação dos estudantes, ordenados
	 *         pela bonificação
	 */
	public String[] listaEstudantesRankingDicas() {
		if (this.estudantes.size() == 0) {
			return new String[0];
		}

		TreeSet<Usuario> estudantesOrdenadosPelaBonificacao = new TreeSet<>(
				Comparator.comparing(Usuario::getBonificacao).reversed().thenComparing(Usuario::getNome));
		estudantesOrdenadosPelaBonificacao.addAll(this.estudantes);
		return converteParaArrayDeString(estudantesOrdenadosPelaBonificacao);
	}

	/**
	 * Busca um estudante no repositório com base no CPF e senha fornecidos.
	 *
	 * @param cpf   o cpf do estudante a ser buscado
	 * @param senha a senha do estudante
	 * @return o estudante correspondente se encontrado e a senha for válida, null
	 *         caso contrário
	 * @throws NullPointerException     se o estudante não for encontrado
	 * @throws IllegalArgumentException se as credenciais forem inválidas
	 */
	public Usuario buscaEstudante(String cpf, String senha) {
		Usuario estudanteProcurado = null;

		for (var u : estudantes) { // Procura o estudante com o cpf pedido
			if (u.getCpf().equals(cpf)) {
				estudanteProcurado = u;
				break;
			}
		}
		ValidadorUsuario.validaUsuario(estudanteProcurado);
		if (validaSenha(estudanteProcurado, senha)) {
			return estudanteProcurado;
		}

		throw new IllegalArgumentException("Usuário ou senha inválidos");
	}

	private boolean validaSenha(Usuario estudante, String senha) {
		return estudante.validaSenha(senha);
	}

	private <T> String[] converteParaArrayDeString(Collection<T> colecao) {
		String[] lista = new String[colecao.size()];
		int i = 0;
		for (T elemento : colecao) {
			lista[i++] = elemento.toString();
		}
		return lista;
	}
}
