package main;

import entities.Usuario;
import repositories.UsuarioRepositoryArrayList;
import repositories.UsuarioRepositoryHashMap;
import repositories.UsuarioRepositoryHashSet;
import repositories.UsuarioRepositoryLinkedHashMap;
import repositories.UsuarioRepositoryTreeMap;
import repositories.UsuarioRepositoryTreeSet;
import java.io.*;

public class MainUsuarioOrdAlfabetica {
public static void main(String[] args) {
    UsuarioRepositoryArrayList repoArray;
    UsuarioRepositoryHashMap repoHashmap;
    UsuarioRepositoryHashSet repoHashset;
    UsuarioRepositoryLinkedHashMap repoLinkedHashMap;
    UsuarioRepositoryTreeMap repoTreemap;
    UsuarioRepositoryTreeSet repoTreeset;    
    String caminhoArquivo = "/home/lorena/ProjetoAlana/ProjetoLEDA-Laboratorio5/src/main/usuariosModificados.txt";

    try {
        PrintStream fileOut = new PrintStream("/home/lorena/ProjetoAlana/ProjetoLEDA-Laboratorio5/src/main/saidaOrdAlfabetica.txt");
        System.setOut(fileOut);
        System.out.println("EDA time sample");
        
        for (int carga = 50; carga < 151; carga*=3) {
            long tempoTotalAL = 0; 
            long tempoTotalHM = 0;
            long tempoTotalHS = 0;
            long tempoTotalLHM = 0;
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
                repoArray.listaEstudantes();
                long end = System.nanoTime();
                tempoTotalAL += (end - start);

                start = System.nanoTime();
                repoHashmap.listaEstudantes();
                end = System.nanoTime();
                tempoTotalHM += (end - start);

                start = System.nanoTime();
                repoHashset.listaEstudantes();
                end = System.nanoTime();
                tempoTotalHS += (end - start);

                start = System.nanoTime();
                repoLinkedHashMap.listaEstudantes();
                end = System.nanoTime();
                tempoTotalLHM += (end - start);

                start = System.nanoTime();
                repoTreemap.listaEstudantes();
                end = System.nanoTime();
                tempoTotalTM += (end - start);

                start = System.nanoTime();
                repoTreeset.listaEstudantes();
                end = System.nanoTime();
                tempoTotalTS += (end - start);
            }
            
            long mediaAL = tempoTotalAL / 30;
            long mediaHM = tempoTotalHM / 30;
            long mediaHS = tempoTotalHS / 30;
            long mediaLHS = tempoTotalLHM / 30;
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