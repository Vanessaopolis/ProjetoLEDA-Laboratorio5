package main;

import entities.Dica;
import entities.Usuario;
import interfaces.DicaRepository;
import java.util.List;

public class AnalisadorDica {
    
    public static long executaBusca(DicaRepository estrutura, int posicao) {
        long start = System.nanoTime();
        estrutura.buscaDica(posicao);
        long end = System.nanoTime();
        return end - start;
    }

    public static long executaAdd(DicaRepository estrutura, List<Usuario> usuarios){
        long start = System.nanoTime();

        for (Usuario u : usuarios){
            Dica d1 = new Dica(u, "PesquisaExtensao");
            Dica d2 = new Dica(u, "Monitoria");
            estrutura.adicionaDica(d1);
            estrutura.adicionaDica(d2);
        }
        
        long end = System.nanoTime();
        return end - start;
    }

}
