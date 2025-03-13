package main;

import entities.Dica;
import entities.Usuario;
import repositories.DicaRepositoryArrayList;
import repositories.DicaRepositoryDeque;
import repositories.DicaRepositoryHashMap;
import repositories.DicaRepositoryLinkedHashMap;
import repositories.DicaRepositoryLinkedList;
import repositories.DicaRepositoryTreeSet;
import java.io.*;

public class MainDicaAdd {
    public static void main(String[] args) {
        DicaRepositoryArrayList repoArrayList;
        DicaRepositoryDeque repoDeque;
        DicaRepositoryHashMap repoHashMap;
        DicaRepositoryLinkedHashMap repoLinkedHashMap;
        DicaRepositoryLinkedList repoLinkedList;
        DicaRepositoryTreeSet repoTreeSet;

        String caminhoArquivo = "data/usuariosModificados.txt";

        // lendo da entrada padrão
        try {
            // Cabeçalho
            PrintStream fileOut = new PrintStream("data/saidaAdicionaDica.txt");            
            System.setOut(fileOut);
            System.out.println("EDA time sample");
            
            for (int carga = 25; carga < 151; carga*=3) {
            
                long tempoTotalAL = 0; 
                long tempoTotalD = 0;
                long tempoTotalHM = 0;
                long tempoTotalLHM = 0;
                long tempoTotalLL = 0;
                long tempoTotalTS = 0;

                for (int i = 0; i < 30; i++) {
                   
                    BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
            
                    repoArrayList= new DicaRepositoryArrayList();
                    repoDeque = new DicaRepositoryDeque();
                    repoHashMap = new DicaRepositoryHashMap();
                    repoLinkedHashMap = new DicaRepositoryLinkedHashMap();
                    repoLinkedList = new DicaRepositoryLinkedList();
                    repoTreeSet = new DicaRepositoryTreeSet();

                    int linhaAtual = 0;
                
                    while (linhaAtual++ < carga) {
                    
                        String line = reader.readLine();
                        String[] sequencia = line.split(" ");
                        
                        String nome = sequencia[0];
                        String cpf = sequencia[1];
                        String senha = sequencia[2];
                        String matricula = sequencia[3];

                        Usuario user = new Usuario(nome, cpf, senha, matricula);
                        Dica d1 = new Dica(user, "PesquisaExtensao");
                        Dica d2 = new Dica(user, "Monitoria");
                    
                        long start = System.nanoTime();
                        repoArrayList.adicionaDica(d1);
                        repoArrayList.adicionaDica(d2);
                        long end = System.nanoTime();
                        tempoTotalAL += (end - start);

                        start = System.nanoTime();
                        repoDeque.adicionaDica(d1);
                        repoDeque.adicionaDica(d2);
                        end = System.nanoTime();
                        tempoTotalD += (end - start);

                        start = System.nanoTime();
                        repoHashMap.adicionaDica(d1);
                        repoHashMap.adicionaDica(d2);
                        end = System.nanoTime();
                        tempoTotalHM += (end - start);

                        start = System.nanoTime();
                        repoLinkedHashMap.adicionaDica(d1);
                        repoLinkedHashMap.adicionaDica(d2);
                        end = System.nanoTime();
                        tempoTotalLHM += (end - start);

                        start = System.nanoTime();
                        repoLinkedList.adicionaDica(d1);
                        repoLinkedList.adicionaDica(d2);
                        end = System.nanoTime();
                        tempoTotalLL += (end - start);

                        start = System.nanoTime();
                        repoTreeSet.adicionaDica(d1);
                        repoTreeSet.adicionaDica(d2);
                        end = System.nanoTime();
                        tempoTotalTS += (end - start);

                    }
                        reader.close();
                }
                
                long mediaAL = tempoTotalAL / 30;
                long mediaD = tempoTotalD / 30;
                long mediaHS = tempoTotalHM / 30;
                long mediaLHM = tempoTotalLHM / 30;
                long mediaLL = tempoTotalLL / 30;
                long mediaTS = tempoTotalTS / 30;

                // adiciona o resultado no arquivo de resultado
                System.out.println("ArrayList " + mediaAL + " " + carga * 2);
                System.out.println("Deque " + mediaD + " " + carga * 2);
                System.out.println("HashSet " + mediaHS + " " + carga * 2);
                System.out.println("LinkedHashMap " + mediaLHM + " " + carga * 2);
                System.out.println("TreeMap " + mediaLL + " " + carga * 2);
                System.out.println("TreeSet " + mediaTS + " " + carga * 2);
            }
            
            fileOut.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}