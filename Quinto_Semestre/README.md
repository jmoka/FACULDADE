<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README - Projeto de Análise de Dados com Streamlit</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            line-height: 1.6;
        }
        h1, h2, h3, h4 {
            color: #2980b9;
        }
        pre {
            background-color: #f4f4f4;
            padding: 10px;
            border-radius: 5px;
        }
        code {
            background-color: #e8e8e8;
            padding: 2px 4px;
            border-radius: 4px;
        }
    </style>
</head>

<body>
<h1 style="color: #2c3e50;">Missão Prática Nível 3 | Mundo 5</h1>
<h3 style="color: #2980b9;">Tratando a imensidão dos dados</h3>
<h4 style="color: #8e44ad;">Missão Pratica</h4>
<h1 style="color: #2c3e50;">Análise da Estrutura do DataFrame</h1>
<h3 style="color: #2980b9;">Saída do Código Python</h3>
<p>A seguir está a explicação da saída do código executado no terminal ao rodar o script <code>info.py</code>, que mostra informações sobre o DataFrame.</p>
    <h1 style="color: #2c3e50;">Projeto de Análise de Dados com Streamlit</h1>
    <p>Este projeto utiliza <strong>Streamlit</strong> para processar e visualizar dados a partir de um arquivo Excel. O foco é demonstrar o tratamento de grandes volumes de dados, incluindo filtragem, tratamento de valores nulos e geração de gráficos.</p>
    
    <h2>Estrutura do Projeto</h2>
    <ul>
        <li><strong>main.py</strong>: Arquivo principal onde a aplicação Streamlit é executada.</li>
        <li><strong>dados/</strong>: Pasta que contém o arquivo Excel <strong>dados.xlsx</strong>.</li>
        <li><strong>m1/</strong>: Micro atividades para leitura de Excel.</li>
        <li><strong>m2/</strong>: Micro atividades para subconjunto de dados.</li>
        <li><strong>m3/</strong>: Micro atividades para manipulação de linhas máximas.</li>
        <li><strong>m4/</strong>: Micro atividades para leitura das primeiras e últimas linhas do arquivo.</li>
        <li><strong>m5/</strong>: Micro atividades para informação e tratamento de dados.</li>
    </ul>

    <h2>Como Acessar as Micro Atividades</h2>
    <h3># m1 - Lendo Excel</h3>
    <p>Para acessar esta seção, você deve:</p>
    <pre><code>cd m1</code></pre>
    <p>Em seguida, você pode ler o arquivo baixado com:</p>
    <pre><code>python lendoExcel.py</code></pre>
    <p>Ou acessar os dados através de uma API com:</p>
    <pre><code>python lendoLink.py</code></pre>

    <h3># m2 - Subconjunto de Dados</h3>
    <p>Para acessar esta seção, você deve:</p>
    <pre><code>cd m2</code></pre>
    <p>E executar a leitura dos dados da API:</p>
    <pre><code>python subconjunto_dados.py</code></pre>

    <h3># m3 - maxLinha</h3>
    <p>Para acessar esta seção, você deve:</p>
    <pre><code>cd m3</code></pre>
    <p>Em seguida, execute:</p>
    <pre><code>python maxLinha.py</code></pre>

    <h3># m4 - Primeiras e Últimas Linhas</h3>
    <p>Para acessar esta seção, você deve:</p>
    <pre><code>cd m4</code></pre>
    <p>Em seguida, execute:</p>
    <pre><code>python primeirasUltimas.py</code></pre>

    <h3># m5 - Info e Tratamento de Dados</h3>
    <p>Para acessar esta seção, você deve:</p>
    <pre><code>cd m5</code></pre>
    <p>E execute:</p>
    <pre><code>python info.py</code></pre>

    <h2>Projeto Final</h2>
    <p>O projeto final integra todas as micro atividades desenvolvidas, permitindo ao usuário realizar uma análise completa dos dados. Através da interface Streamlit, o usuário poderá:</p>
    <ul>
        <li>Carregar um arquivo Excel e visualizar suas primeiras e últimas linhas.</li>
        <li>Aplicar filtros e manipulações para visualizar subconjuntos de dados.</li>
        <li>Visualizar gráficos que representam a análise dos dados, como gráficos de pizza para proporções.</li>
        <li>Tratar valores nulos e gerar relatórios resumidos da análise.</li>
    </ul>
    <p>Para executar o projeto final, siga os passos abaixo:</p>
    <ol>
        <li>Clone o repositório:</li>
        <pre><code>git clone https://github.com/seu-usuario/repositorio.git</code></pre>
        <li>Instale as dependências:</li>
        <pre><code>pip install -r requirements.txt</code></pre>
        <li>Execute o projeto final:</li>
        <pre><code>streamlit run main.py</code></pre>
    </ol>

    <h3>Explicação do Código</h3>
    <p>Abaixo estão algumas partes principais do código do projeto final:</p>

    <h4>1. Importações Necessárias</h4>
    <pre><code>import streamlit as st

import pandas as pd
import matplotlib.pyplot as plt</code></pre>

<p>Nessa parte, importamos as bibliotecas essenciais: <strong>Streamlit</strong> para a interface web, <strong>Pandas</strong> para manipulação de dados e <strong>Matplotlib</strong> para a visualização gráfica.</p>

    <h4>2. Carregamento do Arquivo Excel</h4>
    <pre><code>uploaded_file = st.file_uploader("Escolha um arquivo Excel", type=["xlsx"])

if uploaded_file is not None:
df = pd.read_excel(uploaded_file)</code></pre>

<p>Usamos <strong>file_uploader</strong> para permitir que o usuário faça upload de um arquivo Excel. Se um arquivo for carregado, usamos <strong>pd.read_excel</strong> para lê-lo em um DataFrame.</p>

    <h4>3. Exibição de Dados</h4>
    <pre><code>if uploaded_file is not None:
    st.write("Primeiras linhas do arquivo:")
    st.dataframe(df.head())
    st.write("Últimas linhas do arquivo:")
    st.dataframe(df.tail())</code></pre>
    <p>Com <strong>st.write</strong> e <strong>st.dataframe</strong>, exibimos as primeiras e últimas linhas do DataFrame para visualização rápida.</p>

    <h4>4. Gráficos</h4>
    <pre><code>def plot_data(data):
    plt.figure(figsize=(10, 6))
    plt.pie(data['Vendas'], labels=data['Produto'], autopct='%1.1f%%')
    plt.title('Proporção de Vendas por Produto')
    st.pyplot(plt)</code></pre>
    <p>Definimos uma função <strong>plot_data</strong> que gera um gráfico de pizza com as vendas de cada produto. Usamos <strong>st.pyplot</strong> para exibir o gráfico na aplicação Streamlit.</p>

    <h4>5. Tratamento de Valores Nulos</h4>
    <pre><code>if st.button("Tratar Valores Nulos"):
    df.fillna(0, inplace=True)
    st.success("Valores nulos tratados!")</code></pre>
    <p>Com um botão, o usuário pode optar por tratar valores nulos, substituindo-os por zero. Utilizamos <strong>st.success</strong> para informar o usuário sobre a ação realizada.</p>

    <h2>Como Executar o Projeto</h2>
    <ol>
        <li>Clone o repositório:</li>
        <pre><code>git clone https://github.com/seu-usuario/repositorio.git</code></pre>
        <li>Instale as dependências:</li>
        <pre><code>pip install -r requirements.txt</code></pre>
        <li>Execute o projeto:</li>
        <pre><code>streamlit run main.py</code></pre>
    </ol>

    <h2>Dependências</h2>
    <ul>
        <li><strong>Python 3.12+</strong></li>
        <li><strong>Pandas</strong></li>
        <li><strong>Streamlit</strong></li>
        <li><strong>Matplotlib</strong></li>
    </ul>

    <h2>Visualização</h2>
    <p>O projeto gera gráficos de pizza que mostram a proporção do valor total de vendas por produto.</p>
    <img src="exemplo-grafico.png" alt="Gráfico de pizza gerado pelo projeto">

 </body>
</html>
