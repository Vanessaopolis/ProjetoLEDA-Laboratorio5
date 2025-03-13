package main;

import entities.Usuario;
import repositories.UsuarioRepositoryArrayList;
import repositories.UsuarioRepositoryHashMap;
import repositories.UsuarioRepositoryHashSet;
import repositories.UsuarioRepositoryLinkedHashMap;
import repositories.UsuarioRepositoryTreeMap;
import repositories.UsuarioRepositoryTreeSet;
import java.io.*;

public class MainUsuarioAdd {
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
            // Cabeçalho
            PrintStream fileOut = new PrintStream("data/saidaAdicionaUsuario.txt");            
            System.setOut(fileOut);
            System.out.println("EDA time sample");
            
            for (int carga = 50; carga < 109351; carga*=3) {
            
                long tempoTotalAL = 0; 
                long tempoTotalHM = 0;
                long tempoTotalHS = 0;
                long tempoTotalLHM = 0;
                long tempoTotalTM = 0;
                long tempoTotalTS = 0;

                for (int i = 0; i < 30; i++) {
                    //@SuppressWarnings("resource")
                    BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
            
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
                    
                        long start = System.nanoTime();
                        repoArrayList.adicionaEstudante(new Usuario(nome, cpf, senha, matricula));
                        long end = System.nanoTime();
                        tempoTotalAL += (end - start);

                        start = System.nanoTime();
                        repoHashMap.adicionaEstudante(cpf, new Usuario(nome, cpf, senha, matricula));
                        end = System.nanoTime();
                        tempoTotalHM += (end - start);

                        start = System.nanoTime();
                        repoHashSet.adicionaEstudante(cpf, new Usuario(nome, cpf, senha, matricula));
                        end = System.nanoTime();
                        tempoTotalHS += (end - start);

                        start = System.nanoTime();
                        repoLinkedHashMap.adicionaEstudante(cpf, new Usuario(nome, cpf, senha, matricula));
                        end = System.nanoTime();
                        tempoTotalLHM += (end - start);

                        start = System.nanoTime();
                        repoTreeMap.adicionaEstudante(cpf, new Usuario(nome, cpf, senha, matricula));
                        end = System.nanoTime();
                        tempoTotalTM += (end - start);

                        start = System.nanoTime();
                        repoTreeSet.adicionaEstudante(new Usuario(nome, cpf, senha, matricula));
                        end = System.nanoTime();
                        tempoTotalTS += (end - start);

                    }
                        reader.close();
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
}