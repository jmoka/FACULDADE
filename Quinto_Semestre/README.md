<h1 style="color: #2c3e50;">Missão Prática Nível 3 | Mundo 5</h1>
<h3 style="color: #2980b9;">Tratando a imensidão dos dados</h3>
<h4 style="color: #8e44ad;">Missão Prática</h4>

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

<h2>Explicação do Código</h2>

<h3>1. Importações Necessárias</h3>
<pre><code>import streamlit as st
import pandas as pd
import matplotlib.pyplot as plt</code></pre>

<h3>2. Carregamento do Arquivo Excel</h3>
<pre><code>uploaded_file = st.file_uploader("Escolha um arquivo Excel", type=["xlsx"])
if uploaded_file is not None:
    df = pd.read_excel(uploaded_file)</code></pre>

<h3>3. Exibição de Dados</h3>
<pre><code>if uploaded_file is not None:
    st.write("Primeiras linhas do arquivo:")
    st.dataframe(df.head())
    st.write("Últimas linhas do arquivo:")
    st.dataframe(df.tail())</code></pre>

<h3>4. Gráficos</h3>
<pre><code>def plot_data(data):
    plt.figure(figsize=(10, 6))
    plt.pie(data['Vendas'], labels=data['Produto'], autopct='%1.1f%%')
    plt.title('Proporção de Vendas por Produto')
    st.pyplot(plt)</code></pre>

<h3>5. Tratamento de Valores Nulos</h3>
<pre><code>if st.button("Tratar Valores Nulos"):
    df.fillna(0, inplace=True)
    st.success("Valores nulos tratados!")</code></pre>

<h3>6. Processamento dos Dados</h3>
<pre><code>quant = st.number_input("Escolha a quantidade de linhas a serem processadas:", min_value=1, max_value=10000, value=10)
processar = st.button("Processar Dados")
if processar:
    df = pd.read_excel('dados/dados.xlsx')
    df_selecionado = df.head(quant)</code></pre>

<h3>7. Preenchendo Valores Nulos em Colunas Específicas</h3>
<pre><code>if 'CustomerID' in df_selecionado.columns:
    df_selecionado['CustomerID'].fillna(0, inplace=True)

if 'Description' in df_selecionado.columns:
df_selecionado['Description'].fillna('Desconhecido', inplace=True)

if 'Country' in df_selecionado.columns:
df_selecionado['Country'].fillna('Country', inplace=True)</code></pre>

<h3>8. Conversão da Coluna InvoiceDate</h3>
<pre><code>if 'InvoiceDate' in df_selecionado.columns:
    df_selecionado['InvoiceDate'] = pd.to_datetime(df_selecionado['InvoiceDate'], errors='coerce')</code></pre>

<h3>9. Eliminação de Valores Negativos</h3>
<pre><code>if 'Quantity' in df_selecionado.columns:
    df_selecionado = df_selecionado[df_selecionado['Quantity'] >= 0]</code></pre>

<h3>10. Informações Após o Tratamento</h3>
<pre><code>st.write("### Informações após o tratamento dos dados:")
st.write(df_selecionado.describe())</code></pre>

<h3>11. Gráfico de Vendas</h3>
<pre><code>if 'Description' in df_selecionado.columns and 'Quantity' in df_selecionado.columns and 'UnitPrice' in df_selecionado.columns:
    df_selecionado['TotalSale'] = df_selecionado['Quantity'] * df_selecionado['UnitPrice']</code></pre>

<h2>Como Executar o Programa</h2>
<p>Para executar o programa, siga as etapas abaixo:</p>
<ol>
    <li>Certifique-se de ter o Python instalado em seu sistema. Você pode baixar o Python <a href="https://www.python.org/downloads/">aqui</a>.</li>
    <li>Instale as bibliotecas necessárias. No terminal, execute:</li>
    <pre><code>pip install streamlit pandas matplotlib openpyxl</code></pre>
    <li>Na raiz do projeto, execute o arquivo <strong>main.py</strong> com o seguinte comando:</li>
    <pre><code>streamlit run main.py</code></pre>
    <li>Isso abrirá o aplicativo Streamlit em seu navegador padrão.</li>
</ol>
