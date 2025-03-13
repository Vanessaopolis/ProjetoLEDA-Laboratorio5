package main;

import entities.Usuario;
import repositories.UsuarioRepositoryArrayList;
import repositories.UsuarioRepositoryHashMap;
import repositories.UsuarioRepositoryHashSet;
import repositories.UsuarioRepositoryLinkedHashMap;
import repositories.UsuarioRepositoryTreeMap;
import repositories.UsuarioRepositoryTreeSet;
import java.io.*;

public class MainUsuarioOrdBonus {
public static void main(String[] args) {
    UsuarioRepositoryArrayList repoArray;
    UsuarioRepositoryHashMap repoHashmap;
    UsuarioRepositoryHashSet repoHashset;
    UsuarioRepositoryLinkedHashMap repoLinkedHashMap;
    UsuarioRepositoryTreeMap repoTreemap;
    UsuarioRepositoryTreeSet repoTreeset;    
    String caminhoArquivo = "/home/lorena/ProjetoAlana/ProjetoLEDA-Laboratorio5/src/main/usuariosModificados.txt";

    // lendo da entrada padrão
    try {
        // Cabeçalho
        PrintStream fileOut = new PrintStream("/home/lorena/ProjetoAlana/ProjetoLEDA-Laboratorio5/src/main/saidaUsuarioOrdBonus.txt");            
        System.setOut(fileOut);
        System.out.println("EDA time sample");
        
        for (int carga = 50; carga < 151; carga*=3) {
            long tempoTotalAL = 0; 
            long tempoTotalHM = 0;
            long tempoTotalHS = 0;
            long tempoTotalLHS = 0;
            long tempoTotalTM = 0;
            long tempoTotalTS = 0;

            for (int i = 0; i < 30; i++) {
                BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
        
                repoArray = new UsuarioRepositoryArrayList();
                repoHashmap = new UsuarioRepositoryHashMap();
                repoHashset = new UsuarioRepositoryHashSet();
                repoLinkedHashMap = new UsuarioRepositoryLinkedHashMap();
                repoTreemap = new UsuarioRepositoryTreeMap();
                repoTreeset = new UsuarioRepositoryTreeSet();

                int linhaAtual = 0;

                // adiciona os usuários para poder ordená-los
                while (linhaAtual++ < carga) {
                    String line = reader.readLine();
                    String[] sequencia = line.split(" ");
                    
                    String nome = sequencia[0];
                    String cpf = sequencia[1];
                    String senha = sequencia[2];
                    String matricula = sequencia[3];

                    repoArray.adicionaEstudante(new Usuario(nome, cpf, senha, matricula));
                    repoHashmap.adicionaEstudante(cpf, new Usuario(nome, cpf, senha, matricula));
                    repoHashset.adicionaEstudante(cpf, new Usuario(nome, cpf, senha, matricula));
                    repoLinkedHashMap.adicionaEstudante(cpf, new Usuario(nome, cpf, senha, matricula));
                    repoTreemap.adicionaEstudante(cpf, new Usuario(nome, cpf, senha, matricula));
                    repoTreeset.adicionaEstudante(new Usuario(nome, cpf, senha, matricula));
                }
                reader.close();
            
                long start = System.nanoTime();
                repoArray.listaEstudantesRankingDicas();
                long end = System.nanoTime();
                tempoTotalAL += (end - start);

                start = System.nanoTime();
                repoHashmap.listaEstudantesRankingDicas();
                end = System.nanoTime();
                tempoTotalHM += (end - start);

                start = System.nanoTime();
                repoHashset.listaEstudantesRankingDicas();
                end = System.nanoTime();
                tempoTotalHS += (end - start);

                start = System.nanoTime();
                repoLinkedHashMap.listaEstudantesRankingDicas();
                end = System.nanoTime();
                tempoTotalLHS += (end - start);

                start = System.nanoTime();
                repoTreemap.listaEstudantesRankingDicas();
                end = System.nanoTime();
                tempoTotalTM += (end - start);

                start = System.nanoTime();
                repoTreeset.listaEstudantesRankingDicas();
                end = System.nanoTime();
                tempoTotalTS += (end - start);
            }
            
            long mediaAL = tempoTotalAL / 30;
            long mediaHM = tempoTotalHM / 30;
            long mediaHS = tempoTotalHS / 30;
            long mediaLHS = tempoTotalLHS / 30;
            long mediaTM = tempoTotalTM / 30;
            long mediaTS = tempoTotalTS / 30;

            System.setOut(fileOut);
            System.out.println("ArrayList " + mediaAL + " " + carga);
            System.out.println("HashMap " + mediaHM + " " + carga);
            System.out.println("HashSet " + mediaHS + " " + carga);
            System.out.println("LinkedHashMap " + mediaLHS + " " + carga);
            System.out.println("TreeMap " + mediaTM + " " + carga);
            System.out.println("TreeSet " + mediaTS + " " + carga);
        }
        fileOut.close();
        
    } catch (IOException ioe) {
        System.out.println(ioe);
    }

}

}