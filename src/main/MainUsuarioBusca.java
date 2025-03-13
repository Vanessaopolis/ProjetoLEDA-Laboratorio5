package main;

import entities.Usuario;
import repositories.UsuarioRepositoryArrayList;
import repositories.UsuarioRepositoryHashMap;
import repositories.UsuarioRepositoryHashSet;
import repositories.UsuarioRepositoryLinkedHashMap;
import repositories.UsuarioRepositoryTreeMap;
import repositories.UsuarioRepositoryTreeSet;
import java.io.*;

public class MainUsuarioBusca {
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
            
            //mudar caminho --------------------------
            PrintStream fileOut = new PrintStream("src/main/saidaAdicionaUsuario.txt");            
            System.setOut(fileOut);
            
            // Cabeçalho
            System.out.println("EDA time sample");
            
            String cpfASerBuscado;//, cpfASerBuscadoUltimo, cpfASerBuscadoPrimeiro;

            for (int carga = 50; carga < 109351; carga*=3) {
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
                
                    while (linhaAtual++ < carga) {

                        String line = reader.readLine();
                        String[] sequencia = line.split(" ");
                        

                        //String nome = sequencia[0];
                        String cpf = sequencia[1];
                        String senha = sequencia[2];
                        //String matricula = sequencia[3];

                        //Buscar cpf no meio 
                        if (linhaAtual == carga/2) cpfASerBuscado = sequencia[1];
                        else cpfASerBuscado = sequencia[1];

                        tempoTotalAL += executaAL(repoArray, cpfASerBuscado, senha);
                        tempoTotalHM += executaHM(repoHashmap, cpfASerBuscado, senha);
                        tempoTotalLHM += executaLHM(repoLinkedHashMap, cpfASerBuscado, senha);
                        tempoTotalHS += executaHS(repoHashset, cpfASerBuscado, senha);
                        tempoTotalTM += executaTM(repoTreemap, cpfASerBuscado, senha);
                        tempoTotalTS += executaTS(repoTreeset, cpfASerBuscado, senha);

                        reader.close();
                    }
                }
                
                long mediaAL = tempoTotalAL / 30;
                long mediaHM = tempoTotalHM / 30;
                long mediaHS = tempoTotalHS / 30;
                long mediaLHS = tempoTotalLHM / 30;
                long mediaTM = tempoTotalTM / 30;
                long mediaTS = tempoTotalTS / 30;
                
                // adiciona o resultado no arquivo de resultado
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

    private static long executaLHM( UsuarioRepositoryLinkedHashMap repoLinkedHashMap, String cpf, String senha){
        long start = System.nanoTime();
        repoLinkedHashMap.buscaEstudante(cpf, senha);
        long end = System.nanoTime();
        return end - start;
    }

    private static long executaAL( UsuarioRepositoryArrayList repoArray, String cpf, String senha){
        long start = System.nanoTime();
        repoArray.buscaEstudante(cpf, senha);
        long end = System.nanoTime();
        return end - start;
    }

    private static long executaTS( UsuarioRepositoryTreeSet repoTreeset, String cpf, String senha){
        long start = System.nanoTime();
        repoTreeset.buscaEstudante(cpf, senha);
        long end = System.nanoTime();
        return end - start;
    }

    private static long executaHM(UsuarioRepositoryHashMap repoHasmap, String cpf, String senha){
        long start = System.nanoTime();
        repoHasmap.buscaEstudante(cpf, senha);
        long end = System.nanoTime();
        return end - start;
    }

    private static long executaTM( UsuarioRepositoryTreeMap repoTreeMap, String cpf, String senha){
        long start = System.nanoTime();
        repoTreeMap.buscaEstudante(cpf, senha);
        long end = System.nanoTime();
        return end - start;
    }

    private static long executaHS( UsuarioRepositoryHashSet repoHashSet, String cpf, String senha){
        long start = System.nanoTime();
        repoHashSet.buscaEstudante(cpf, senha);
        long end = System.nanoTime();
        return end - start;
    }
}