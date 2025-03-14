# Proposta de Projeto

## Equipe
- Alana Vanessa Pimentel Toldo de Andrade - 123210882
- Camila Rodrigues de Oliveira Rezende - 123210240
- João Victor Muniz Cabral - 123210456
- Lorena Nascimento Carvalho - 123211071
- Lukas Soares Nascimento - 123210298

## 1. Resumo

O projeto consiste em aprimorar um laboratório realizado em uma disciplina anterior, Laboratório de Programação II, focando no último, o [Laboratório 5](https://docs.google.com/document/d/1HD3mytjwB-q8TqiEQGKULr6fQ81_MaUPekZpOaBofBI/edit?tab=t.0). A proposta é alterar as estruturas de dados utilizadas nesse laboratório, modificando os métodos e funcionalidades que interagem com elas, de modo a observar o impacto dessas mudanças no desempenho do programa. Para isso, será feito um estudo sobre as diferentes estruturas de dados e como elas afetam o funcionamento do código.

A análise será baseada em entradas controladas, permitindo medir o tempo de execução dos métodos para cada estrutura de dados. A partir desses dados, será possível gerar gráficos de tamanho de entrada por tempo de execução, comparando o desempenho das diferentes abordagens. O objetivo final é discutir qual estrutura de dados é mais adequada para cada tipo de operação, com base nos resultados obtidos, levando em consideração a eficiência de cada uma.

## 2. Descrição

Escolhemos o Lab. 5 por ser o mais complexo da disciplina de LP2. O projeto envolve dois repositórios: um de Usuário e outro de Dica. Atualmente, as estruturas de dados usadas são HashMap e ArrayList, respectivamente.

O grupo é composto por 5 integrantes, cada um responsável por alterar as estruturas de dados de ambos os repositórios, implementando diferentes pares e adaptando os métodos necessários para testá-los. Cada integrante do grupo irá documentar quais mudanças estão sendo feitas, para que posteriormente seja possível avaliarmos o impacto destas no desenvolvimento.

As estruturas de dados selecionadas foram:
1. TreeMap
2. HashSet
3. Deque
4. HashMap
5. LinkedList
6. TreeSet
7. ArrayList
8. LinkedHashMap

A tabela a seguir apresenta os pares atribuídos a cada integrante:

| Integrante Responsável | Repositório de Usuário<br>originalmente: HashMap | Repositório de Dica<br>originalmente: ArrayList |
|------------------------|-----------------------------------------------|---------------------------------------------|
| Alana | TreeMap | LinkedList |
| Camila | HashSet | Deque |
| João Victor | TreeSet | TreeSet |
| Lorena | ArrayList | HashMap |
| Lukas | LinkedHashMap | LinkedHashMap |

Após as alterações, vamos realizar testes unitários para assegurar o funcionamento de cada versão. Quando todas elas estiverem funcionando corretamente, seguiremos para os testes de desempenho.

Nesse momento, definiremos entradas de diferentes tamanhos, para cada método, e repetiremos os mesmos métodos de inserção, busca e ordenação diversas vezes, assim poderemos calcular uma média de tempo de execução. Ao final, vamos gerar gráficos comparativos para analisar o desempenho de cada estrutura de dados em cada operação.

As entradas controladas serão geradas a partir de scripts em R para que os testes sejam feitos de forma automática. Assim, o sistema terá um grande volume de dados para análise.

Cada integrante ficará responsável por sua versão, desde as alterações até os testes e documentação. Com os gráficos em mãos, poderemos analisar como as estruturas de dados impactam no desempenho dos métodos.

### a. Relevância:

Este estudo é relevante porque permite avaliar o impacto de diferentes estruturas de dados na eficiência de operações comuns, como busca, ordenação e inserção. Ao comparar as estruturas em termos de tempo de execução, podemos identificar quais delas são mais adequadas para diferentes cenários, ajudando a otimizar o desempenho de programas que utilizam essas operações. Além disso, a análise pode fornecer insights valiosos sobre os trade-offs entre complexidade e desempenho, sendo útil tanto para desenvolvedores quanto para estudantes, ao aprofundar a compreensão sobre a escolha adequada de estruturas de dados em situações reais de programação.

### b. Entrega:

O principal artefato será um relatório explicando as alterações nas estruturas de dados e os métodos impactados. O relatório também incluirá uma descrição dos experimentos realizados, metodologia de testes e os gráficos comparativos gerados com os tempos médios de execução. Por fim, o relatório concluirá com uma análise sobre o desempenho das diferentes estruturas, fornecendo recomendações sobre a escolha das mais eficientes para cada tipo de operação.

## 3. Planejamento

### Etapa 1: Análise e Identificação das Estruturas de Dados
- **Tarefa 1.1**: Revisar o último laboratório da disciplina anterior e identificar as estruturas de dados utilizadas.
- **Tarefa 1.2**: Listar os métodos que interagem com essas estruturas (busca, ordenação, inserção, etc.).
- **Tarefa 1.3**: Compreender como as estruturas e métodos estão implementados e qual a função de cada uma no código.

### Etapa 2: Modificação das Estruturas de Dados
- **Tarefa 2.1**: Alterar as estruturas de dados identificadas na etapa anterior.
- **Tarefa 2.2**: Adaptar os métodos existentes para funcionarem corretamente com as novas estruturas de dados.

### Etapa 3: Garantia de Funcionamento Através de Testes
- **Tarefa 3.1**: Criar e atualizar testes unitários para verificar se os métodos continuam funcionando corretamente após as modificações.
- **Tarefa 3.2**: Executar os testes unitários e corrigir quaisquer erros encontrados, garantindo que o código esteja robusto e confiável.

### Etapa 4: Definição de Entradas Controladas
- **Tarefa 4.1**: Escolher casos de teste representativos para os métodos de interesse (busca, ordenação, inserção).
- **Tarefa 4.2**: Gerar por script entradas controladas para esses métodos, com tamanhos variados, para realizar as medições de tempo de execução.

### Etapa 5: Execução e Coleta de Dados
- **Tarefa 5.1**: Executar os métodos escolhidos múltiplas vezes com as entradas controladas definidas, registrando os tempos de execução para cada execução.
- **Tarefa 5.2**: Calcular o tempo médio de execução para cada teste e para cada estrutura de dados.

### Etapa 6: Análise e Visualização dos Dados
- **Tarefa 6.1**: Plotar gráficos comparando os tempos médios de execução com diferentes entradas e diferentes estruturas de dados.
- **Tarefa 6.2**: Analisar os gráficos e os resultados para observar como as diferentes estruturas impactam o desempenho dos métodos (busca, ordenação, inserção).

### Etapa 7: Conclusão e Relatório Final
- **Tarefa 7.1**: Redigir o relatório explicando as modificações feitas nas estruturas de dados e como isso impactou os métodos.
- **Tarefa 7.2**: Incluir no relatório uma análise comparativa do desempenho das diferentes estruturas de dados, com base nos gráficos gerados e nas conclusões dos experimentos.
- **Tarefa 7.3**: Revisar e finalizar o relatório para entrega, garantindo que esteja claro, bem estruturado e bem documentado.

## 4. Andamento

### Status das Etapas:
- [x] **Etapa 1: Análise e Identificação das Estruturas de Dados**
  - [x] Tarefa 1.1: Revisar o laboratório anterior
  - [x] Tarefa 1.2: Listar os métodos que interagem com as estruturas
  - [x] Tarefa 1.3: Compreender implementação e função de cada estrutura

- [x] **Etapa 2: Modificação das Estruturas de Dados**
  - [x] Tarefa 2.1: Alterar as estruturas de dados
  - [x] Tarefa 2.2: Adaptar os métodos existentes

- [x] **Etapa 3: Garantia de Funcionamento Através de Testes**
  - [x] Tarefa 3.1: Criar/atualizar testes unitários
  - [x] Tarefa 3.2: Executar testes e corrigir erros

- [x] **Etapa 4: Definição de Entradas Controladas**
  - [x] Tarefa 4.1: Escolher casos de teste representativos
  - [x] Tarefa 4.2: Gerar entradas controladas por script

- [x] **Etapa 5: Execução e Coleta de Dados**
  - [x] Tarefa 5.1: Executar métodos e registrar tempos
  - [x] Tarefa 5.2: Calcular tempo médio de execução

- [x] **Etapa 6: Análise e Visualização dos Dados**
  - [x] Tarefa 6.1: Plotar gráficos comparativos
  - [ ] Tarefa 6.2: Analisar resultados

- [ ] **Etapa 7: Conclusão e Relatório Final**
  - [ ] Tarefa 7.1: Redigir relatório explicando modificações
  - [ ] Tarefa 7.2: Incluir análise comparativa
  - [ ] Tarefa 7.3: Revisar e finalizar relatório

## Referências:
Livro: ["Data Structures & Algorithms in Java" de Robert Lafore](https://www.amazon.com.br/Data-Structures-Algorithms-Java-2nd/dp/0672324539).