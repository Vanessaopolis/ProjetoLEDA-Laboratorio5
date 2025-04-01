import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns


def gerar_grafico(arquivo_de_entrada: str, titulo_do_grafico: str) -> None:
	# Define os arquivos de saída e do gráfico
    arquivo_de_saida = f"copia_{arquivo_de_entrada}"
    arquivo_do_grafico = f"{arquivo_de_entrada.split('.')[0]}.png"

    # Abre e lê o arquivo de entrada
    with open(arquivo_de_entrada, 'r') as file:
        linhas = file.readlines()

    # Descarta a primeira linha que é o cabeçalho
    dados = []
    for linha in linhas[1:]:
        parts = linha.strip().split()
        if len(parts) >= 3:
            collection = parts[0]
            time_ns = int(parts[1])  # Tempo em nanossegundos
            sample = int(parts[2])  # Tamanho da amostra como inteiro

            # Converte nanossegundos para milissegundos
            time_ms = time_ns / 1_000_000

            dados.append([collection, time_ms, sample])

    # Cria o DataFrame
    df = pd.DataFrame(dados, columns=['collection', 'time(ms)', 'sample'])

    # Ordena por collection (alfabético) e depois por sample (crescente)
    df = df.sort_values(by=['collection', 'sample'])

    # Salva o DataFrame ordenado em um novo arquivo
    with open(arquivo_de_saida, 'w') as file:
        file.write("collection time(ms) sample\n")
        for _, row in df.iterrows():
            file.write(f"{row['collection']} {row['time(ms)']} {row['sample']}\n")

    print(f"Arquivo processado salvo como {arquivo_de_saida}")

    # Cria um gráfico de linhas
    plt.figure(figsize=(12, 8))

    # Usa a biblioteca seaborn para melhorar a aparência
    sns.set_style("whitegrid")

    # Aumenta o tamanho das fontes
    plt.rcParams.update({
        'font.size': 16,
        'axes.labelsize': 18,
        'axes.titlesize': 20,
        'xtick.labelsize': 16,
        'ytick.labelsize': 16,
        'legend.fontsize': 16,
    })

    # Plota uma linha para cada tipo de collection
    for colecao in df['collection'].unique():
        dados_colecao = df[df['collection'] == colecao]
        plt.plot(dados_colecao['sample'], dados_colecao['time(ms)'], marker='o', linestyle='-', label=colecao)

    # Configura o gráfico
    plt.xlabel('Tamanho da amostra')
    plt.ylabel('Tempo (ms)')
    plt.title(titulo_do_grafico.upper(), fontweight='bold')
    plt.legend()

    plt.xscale('log')
    plt.yscale('log')

    amostras = sorted(df['sample'].unique())
    plt.xticks(amostras, [str(int(s)) for s in amostras])  # Configura para mostrar valores exatos no eixo x

    # Salva o gráfico
    plt.tight_layout()
    plt.savefig(arquivo_do_grafico)
    print(f"Gráfico salvo como {arquivo_do_grafico}")
    
    plt.close()


rotulos_dos_arquivos_dict = {
    'resultadoDicaAdd.txt': 'ao Adicionar Nova Dica',
    'resultadoDicaBuscaMeio.txt': 'ao Buscar Dica no Meio',
    'resultadoDicaBuscaPrimeira.txt': 'ao Buscar a Primeira Dica',
    'resultadoDicaBuscaUltima.txt': 'ao Buscar a Última Dica',
    'resultadoUsuarioAdiciona.txt': 'ao Adicionar Novo Usuário',
    'resultadoUsuarioBusca.txt': 'ao Buscar Usuário',
    'resultadoUsuarioOrdAlfabetica.txt': 'ao Ordenar os Usuários pelo Nome',
    'resultadoUsuarioOrdBonus.txt': 'ao Ordenar os Usuários pela Bonificação'
}

for indice, (arquivo, rotulo) in enumerate(rotulos_dos_arquivos_dict.items(), 1):
    print(f"Gráfico nº {indice}")
    titulo = f'Desempenho das Estruturas de Dados\n{rotulo}'
    gerar_grafico(arquivo, titulo)
