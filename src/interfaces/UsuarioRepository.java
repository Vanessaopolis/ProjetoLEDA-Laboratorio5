package interfaces;

import entities.Usuario;

public interface UsuarioRepository {

	public boolean adicionaEstudante(Usuario estudante);

	public String[] listaEstudantes();

	public String[] listaEstudantesRankingDicas();

	public Usuario buscaEstudante(String cpf, String senha);

}
