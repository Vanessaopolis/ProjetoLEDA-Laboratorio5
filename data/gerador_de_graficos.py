import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns


def gerar_grafico(input_file_name, chart_title):
    # Lê o arquivo de entrada
    input_file = input_file_name
    output_file = f"copia_{input_file_name}"

    nome_grafico = input_file.split('.')[0]

    # Abre e lê o arquivo
    with open(input_file, 'r') as file:
        lines = file.readlines()

    # Descarta a primeira linha que é o cabeçalho
    data = []
    for line in lines[1:]:
        parts = line.strip().split()
        if len(parts) >= 3:
            eda = parts[0]
            time_ns = int(parts[1])  # Tempo em nanossegundos
            sample = int(parts[2])  # Tamanho da amostra como inteiro

            # Converte nanossegundos para milissegundos
            time_ms = time_ns / 1_000_000

            data.append([eda, time_ms, sample])

    # Cria o DataFrame
    df = pd.DataFrame(data, columns=['EDA', 'time', 'sample'])

    # Ordena por EDA (alfabético) e depois por sample (crescente)
    df = df.sort_values(by=['EDA', 'sample'])

    # Salva o DataFrame ordenado em um novo arquivo
    with open(output_file, 'w') as file:
        file.write("EDA time sample\n")
        for _, row in df.iterrows():
            file.write(f"{row['EDA']} {row['time']} {row['sample']}\n")

    print(f"Arquivo processado salvo como {output_file}")

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

    # Plota uma linha para cada tipo de EDA
    for eda in df['EDA'].unique():
        eda_data = df[df['EDA'] == eda]
        plt.plot(eda_data['sample'], eda_data['time'], marker='o', linestyle='-', label=eda)

    # Configura o gráfico
    plt.xlabel('Tamanho da amostra')
    plt.ylabel('Tempo (ms)')
    plt.title(chart_title.upper(), fontweight='bold')
    plt.legend()

    plt.xscale('log')
    plt.yscale('log')

    samples = sorted(df['sample'].unique())
    plt.xticks(samples, [str(int(s)) for s in samples])  # Configura para mostrar valores exatos no eixo x

    # Salva o gráfico
    plt.tight_layout()
    plt.savefig(f'{nome_grafico}.png')

    print(f"Gráfico salvo como {nome_grafico}.png")


input_file_names = ['resultadoDicaAdiciona.txt', 'resultadoDicaBusca.txt',
                    'resultadoUsuarioAdiciona.txt', 'resultadoUsuarioBusca.txt',
                    'resultadoUsuarioOrdAlfabetica.txt', 'resultadoUsuarioOrdBonus.txt']

titles = ['ao Adicionar Nova Dica', 'ao Buscar Dica no Meio',
          'ao Adicionar Novo Usuario', 'ao Buscar Usuario',
          'ao Ordenar os Usuarios pelo Nome', 'ao Ordenar os Usuarios pela Bonificação']

for i in range(len(input_file_names)):
    print(f"Gráfico nº {i + 1}")
    chart_title = f'Desempenho das Estruturas de Dados\n{titles[i]}'
    gerar_grafico(input_file_names[i],
                  chart_title)
