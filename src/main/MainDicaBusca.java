package main;

import entities.Usuario;
import entities.Dica;
import repositories.DicaRepositoryArrayList;
import repositories.DicaRepositoryDeque;
import repositories.DicaRepositoryHashMap;
import repositories.DicaRepositoryLinkedHashMap;
import repositories.DicaRepositoryLinkedList;
import repositories.DicaRepositoryTreeSet;
import java.io.*;

public class MainDicaBusca {
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
            PrintStream fileOut = new PrintStream("data/saidaDicaBusca.txt");            
            System.setOut(fileOut);
            
            // Cabeçalho
            System.out.println("EDA time sample");
            

            String[] temas = {"PesquisaExtensao", "Monitoria", "Estagio", "RepresentacaoEstudantil"};

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

                        repoArrayList.adicionaDica(new Dica(new Usuario(nome, cpf, senha, matricula), temas[0]));
                        repoHashMap.adicionaDica(new Dica(new Usuario(nome, cpf, senha, matricula), temas[1]));
                        repoDeque.adicionaDica(new Dica(new Usuario(nome, cpf, senha, matricula), temas[0]));
                        repoLinkedHashMap.adicionaDica(new Dica(new Usuario(nome, cpf, senha, matricula), temas[1]));
                        repoLinkedList.adicionaDica(new Dica(new Usuario(nome, cpf, senha, matricula), temas[0]));
                        repoTreeSet.adicionaDica(new Dica(new Usuario(nome, cpf, senha, matricula), temas[1]));

                    }
                        reader.close();
                        int posicao = carga;
                        tempoTotalAL += executaAL(repoArrayList, posicao);
                        tempoTotalHM += executaHM(repoHashMap,posicao);
                        tempoTotalLHM += executaLHM(repoLinkedHashMap,posicao);
                        tempoTotalD += executaDQ(repoDeque, posicao);
                        tempoTotalLL += executaLL(repoLinkedList, posicao);
                        tempoTotalTS += executaTS(repoTreeSet, posicao);
                }
                
                long mediaAL = tempoTotalAL / 30;
                long mediaHM = tempoTotalHM / 30;
                long mediaDQ = tempoTotalD / 30;
                long mediaLHM = tempoTotalLHM / 30;
                long mediaLL = tempoTotalLL / 30;
                long mediaTS = tempoTotalTS / 30;
                
                // adiciona o resultado no arquivo de resultado
                System.out.println("ArrayList " + mediaAL + " " + carga*2);
                System.out.println("HashMap " + mediaHM + " " + carga*2);
                System.out.println("LinkedList " + mediaLL + " " + carga*2);
                System.out.println("LinkedHashMap " + mediaLHM + " " + carga*2);
                System.out.println("Deque " + mediaDQ + " " + carga*2);
                System.out.println("TreeSet " + mediaTS + " " + carga*2);
            }

            fileOut.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }

    private static long executaLHM( DicaRepositoryLinkedHashMap repoLinkedHashMap, int posicao){
        long start = System.nanoTime();
        repoLinkedHashMap.buscaDica(posicao);
        long end = System.nanoTime();
        return end - start;
    }

    private static long executaAL( DicaRepositoryArrayList repoArray, int posicao){
        long start = System.nanoTime();
        repoArray.buscaDica(posicao);
        long end = System.nanoTime();
        return end - start;
    }

    private static long executaTS( DicaRepositoryTreeSet repoTreeset, int posicao){
        long start = System.nanoTime();
        repoTreeset.buscaDica(posicao);
        long end = System.nanoTime();
        return end - start;
    }

    private static long executaHM(DicaRepositoryHashMap repoHasmap, int posicao){
        long start = System.nanoTime();
        repoHasmap.buscaDica(posicao);
        long end = System.nanoTime();
        return end - start;
    }

    private static long executaDQ( DicaRepositoryDeque repoDeque, int posicao){
        long start = System.nanoTime();
        repoDeque.buscaDica(posicao);
        long end = System.nanoTime();
        return end - start;
    }

    private static long executaLL( DicaRepositoryLinkedList repoHashSet, int posicao){
        long start = System.nanoTime();
        repoHashSet.buscaDica(posicao);
        long end = System.nanoTime();
        return end - start;
    }
}