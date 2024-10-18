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
Vamos analisar a explicação do código passo a passo para verificar se está correta:

### 1. Importações Necessárias

```python
import streamlit as st
import pandas as pd
import matplotlib.pyplot as plt
```

**Explicação:**  
A explicação está correta. Estas importações trazem as bibliotecas essenciais para a aplicação:

- **Streamlit**: Para a interface web.
- **Pandas**: Para manipulação de dados.
- **Matplotlib**: Para a visualização gráfica.

### 2. Carregamento do Arquivo Excel

```python
uploaded_file = st.file_uploader("Escolha um arquivo Excel", type=["xlsx"])
if uploaded_file is not None:
    df = pd.read_excel(uploaded_file)
```

**Explicação:**  
A explicação está correta. O código permite ao usuário fazer upload de um arquivo Excel e, se um arquivo for carregado, ele é lido em um DataFrame usando `pd.read_excel()`.

### 3. Exibição de Dados

```python
if uploaded_file is not None:
    st.write("Primeiras linhas do arquivo:")
    st.dataframe(df.head())
    st.write("Últimas linhas do arquivo:")
    st.dataframe(df.tail())
```

**Explicação:**  
A explicação está correta. O código exibe as primeiras e últimas linhas do DataFrame para uma visualização rápida usando `st.write()` e `st.dataframe()`.

### 4. Gráficos

```python
def plot_data(data):
    plt.figure(figsize=(10, 6))
    plt.pie(data['Vendas'], labels=data['Produto'], autopct='%1.1f%%')
    plt.title('Proporção de Vendas por Produto')
    st.pyplot(plt)
```

**Explicação:**  
A explicação está correta. A função `plot_data()` gera um gráfico de pizza com as vendas de cada produto, e `st.pyplot()` exibe o gráfico na aplicação Streamlit.

### 5. Tratamento de Valores Nulos

```python
if st.button("Tratar Valores Nulos"):
    df.fillna(0, inplace=True)
    st.success("Valores nulos tratados!")
```

**Explicação:**  
A explicação está correta. O código cria um botão que, quando pressionado, preenche os valores nulos com zero e informa o usuário sobre a ação realizada usando `st.success()`.

### 6. Processamento dos Dados

```python
quant = st.number_input("Escolha a quantidade de linhas a serem processadas:", min_value=1, max_value=10000, value=10)
processar = st.button("Processar Dados")

if processar:
    df = pd.read_excel('dados/dados.xlsx')
    df_selecionado = df.head(quant)
```

**Explicação:**  
A explicação é em grande parte correta, mas poderia ser mais clara sobre o uso do número de entrada. O código permite ao usuário definir a quantidade de linhas a serem processadas (entre 1 e 10000) e, ao clicar no botão "Processar Dados", ele carrega os dados do arquivo Excel e seleciona as primeiras `quant` linhas.

### 7. Preenchendo Valores Nulos

O código preenche valores nulos em colunas específicas:

```python
if 'CustomerID' in df_selecionado.columns:
    df_selecionado['CustomerID'].fillna(0, inplace=True)

if 'Description' in df_selecionado.columns:
    df_selecionado['Description'].fillna('Desconhecido', inplace=True)

if 'Country' in df_selecionado.columns:
    df_selecionado['Country'].fillna('Country', inplace=True)
```

**Explicação:**  
A explicação está correta. O código verifica a existência de colunas específicas no DataFrame e preenche valores nulos com valores padrão.

### 8. Conversão da Coluna `InvoiceDate`

```python
if 'InvoiceDate' in df_selecionado.columns:
    df_selecionado['InvoiceDate'] = pd.to_datetime(df_selecionado['InvoiceDate'], errors='coerce')
```

**Explicação:**  
A explicação está correta. O código converte a coluna `InvoiceDate` para o tipo datetime, tratando erros ao usar `errors='coerce'`.

### 9. Eliminação de Valores Negativos

```python
if 'Quantity' in df_selecionado.columns:
    df_selecionado = df_selecionado[df_selecionado['Quantity'] >= 0]
```

**Explicação:**  
A explicação está correta. O código elimina valores negativos na coluna `Quantity`.

### 10. Informações Após o Tratamento

```python
st.write("### Informações após o tratamento dos dados:")
st.write(df_selecionado.describe())
```

**Explicação:**  
A explicação está correta. O código exibe informações resumidas sobre o DataFrame após o tratamento.

### 11. Gráfico de Vendas

```python
if 'Description' in df_selecionado.columns and 'Quantity' in df_selecionado.columns and 'UnitPrice' in df_selecionado.columns:
    df_selecionado['TotalSale'] = df_selecionado['Quantity'] * df_selecionado['UnitPrice']
```

**Explicação:**  
A explicação está correta. O código calcula o valor total de vendas para cada produto e agrupa os dados por descrição do produto para somar o total de vendas.

### Conclusão

A explicação do código está, em geral, correta, mas algumas partes podem ser aprimoradas para maior clareza, especialmente sobre a interação do usuário com o número de entrada e o processamento dos dados. Se precisar de ajustes específicos ou esclarecimentos adicionais, me avise!
