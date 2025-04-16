package main;

import entities.Usuario;
import interfaces.UsuarioRepository;
import java.util.List;
import java.util.Random;

public class AnalisadorUsuario{

    public static long executaAdd(UsuarioRepository estrutura, List<Usuario> usuarios){
        long inicio = System.nanoTime();

        for (Usuario u : usuarios){
            Random random = new Random();
            u.recebeBonificacao(random.nextInt(1000));
            estrutura.adicionaEstudante(u);
        }

        long fim = System.nanoTime();
        return fim - inicio;
    }

    public static long executaBusca(UsuarioRepository estrutura, String cpf) {
        long inicio = System.nanoTime();
        estrutura.buscaEstudante(cpf, Main.SENHA);
        long fim = System.nanoTime();
        return fim - inicio;
    }

    public static long executaListagemOrdemAlfabetica(UsuarioRepository usuarioRepository) {
		long start = System.nanoTime();
		usuarioRepository.listaEstudantes();
		long end = System.nanoTime();
		return end - start;
    }

    public static long executaListagemOrdemBonificacao(UsuarioRepository usuarioRepository) {
		long start = System.nanoTime();
		usuarioRepository.listaEstudantesRankingDicas();
		long end = System.nanoTime();
		return end - start;
	}

}