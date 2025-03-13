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
        UsuarioRepositoryArrayList repoArrayList;
        UsuarioRepositoryHashMap repoHashMap;
        UsuarioRepositoryHashSet repoHashSet;
        UsuarioRepositoryLinkedHashMap repoLinkedHashMap;
        UsuarioRepositoryTreeMap repoTreeMap;
        UsuarioRepositoryTreeSet repoTreeSet;    
        String caminhoArquivo = "data/usuariosModificados.txt";

        // lendo da entrada padrão
        try {
            PrintStream fileOut = new PrintStream("data/saidaUsuarioBusca.txt");            
            System.setOut(fileOut);
            
            // Cabeçalho
            System.out.println("EDA time sample");
            

            for (int carga = 50; carga < 109351; carga*=3) {

                long tempoTotalAL = 0; 
                long tempoTotalHM = 0;
                long tempoTotalHS = 0;
                long tempoTotalLHM = 0;
                long tempoTotalTM = 0;
                long tempoTotalTS = 0;

                
                for (int i = 0; i < 30; i++) {
                    BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
                    
                    String cpfASerBuscado = null;  //, cpfASerBuscadoUltimo, cpfASerBuscadoPrimeiro;
            
                    repoArrayList = new UsuarioRepositoryArrayList();
                    repoHashMap = new UsuarioRepositoryHashMap();
                    repoHashSet = new UsuarioRepositoryHashSet();
                    repoLinkedHashMap = new UsuarioRepositoryLinkedHashMap();
                    repoTreeMap = new UsuarioRepositoryTreeMap();
                    repoTreeSet = new UsuarioRepositoryTreeSet();

                    int linhaAtual = 0;
                
                    while (linhaAtual++ < carga) {

                        String line = reader.readLine();
                        String[] sequencia = line.split(" ");
                        
                        String nome = sequencia[0];
                        String cpf = sequencia[1];
                        String senha = sequencia[2];
                        String matricula = sequencia[3];

                        repoArrayList.adicionaEstudante(new Usuario(nome, cpf, senha, matricula));
                        repoHashMap.adicionaEstudante(cpf, new Usuario(nome, cpf, senha, matricula));
                        repoHashSet.adicionaEstudante(cpf, new Usuario(nome, cpf, senha, matricula));
                        repoLinkedHashMap.adicionaEstudante(cpf, new Usuario(nome, cpf, senha, matricula));
                        repoTreeMap.adicionaEstudante(cpf, new Usuario(nome, cpf, senha, matricula));
                        repoTreeSet.adicionaEstudante(new Usuario(nome, cpf, senha, matricula));

                        //Buscar cpf no meio 
                        if (linhaAtual == carga/2) cpfASerBuscado = sequencia[1];
                        

                    }
                        reader.close();

                        String senha = "senha123";
                        tempoTotalAL += executaAL(repoArrayList, cpfASerBuscado, senha);
                        tempoTotalHM += executaHM(repoHashMap, cpfASerBuscado, senha);
                        tempoTotalLHM += executaLHM(repoLinkedHashMap, cpfASerBuscado, senha);
                        tempoTotalHS += executaHS(repoHashSet, cpfASerBuscado, senha);
                        tempoTotalTM += executaTM(repoTreeMap, cpfASerBuscado, senha);
                        tempoTotalTS += executaTS(repoTreeSet, cpfASerBuscado, senha);
                }
                
                long mediaAL = tempoTotalAL / 30;
                long mediaHM = tempoTotalHM / 30;
                long mediaHS = tempoTotalHS / 30;
                long mediaLHM = tempoTotalLHM / 30;
                long mediaTM = tempoTotalTM / 30;
                long mediaTS = tempoTotalTS / 30;
                
                // adiciona o resultado no arquivo de resultado
                System.out.println("ArrayList " + mediaAL + " " + carga);
                System.out.println("HashMap " + mediaHM + " " + carga);
                System.out.println("HashSet " + mediaHS + " " + carga);
                System.out.println("LinkedHashMap " + mediaLHM + " " + carga);
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