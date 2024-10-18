import streamlit as st
import pandas as pd
import matplotlib.pyplot as plt

# Título na tela principal usando HTML, estilizando o texto com cores
st.markdown("<h1 style='color: #2c3e50;'>Missão Prática Nível 3 | Mundo 5</h1>", unsafe_allow_html=True)
st.markdown("<h3 style='color: #2980b9;'>Tratando a imensidão dos dados</h3>", unsafe_allow_html=True)

# Campo para o usuário escolher a quantidade de linhas a serem processadas (entre 1 e 10000)
quant = st.number_input("Escolha a quantidade de linhas a serem processadas:", min_value=1, max_value=10000, value=10)

# Botão que o usuário clica para processar os dados
processar = st.button("Processar Dados")

# Se o botão for pressionado, iniciar o processamento
if processar:
    # Carregar os dados do arquivo Excel localizado no caminho 'dados/dados.xlsx'
    df = pd.read_excel('dados/dados.xlsx')

    # Selecionar as primeiras 'quant' linhas com base na quantidade definida pelo usuário
    df_selecionado = df.head(quant)

    # Exibir a tabela de dados selecionados (apenas as linhas escolhidas)
    st.write("### Tabela de Dados Selecionados")
    st.dataframe(df_selecionado)

    # Preencher valores nulos na coluna 'CustomerID', se ela existir, preenchendo com 0
    if 'CustomerID' in df_selecionado.columns:
        df_selecionado['CustomerID'].fillna(0, inplace=True)

    # Preencher valores nulos na coluna 'Description', se ela existir, preenchendo com 'Desconhecido'
    if 'Description' in df_selecionado.columns:
        df_selecionado['Description'].fillna('Desconhecido', inplace=True)

    # Preencher valores nulos na coluna 'Country', se ela existir, preenchendo com 'Country'
    if 'Country' in df_selecionado.columns:
        df_selecionado['Country'].fillna('Country', inplace=True)

    # Converter a coluna 'InvoiceDate' para datetime
    if 'InvoiceDate' in df_selecionado.columns:
        df_selecionado['InvoiceDate'] = pd.to_datetime(df_selecionado['InvoiceDate'], errors='coerce')

    # Eliminar valores negativos na coluna 'Quantity'
    if 'Quantity' in df_selecionado.columns:
        df_selecionado = df_selecionado[df_selecionado['Quantity'] >= 0]

    # Exibir informações após o tratamento dos dados
    st.write("### Informações após o tratamento dos dados:")
    st.write(df_selecionado.describe())

    # Gráfico de pizza (pie chart) comparando o valor total de vendas por produto, destacando o 'Uniprinc'
    if 'Description' in df_selecionado.columns and 'Quantity' in df_selecionado.columns and 'UnitPrice' in df_selecionado.columns:
        # Criar uma coluna com o valor total de venda para cada produto (Quantity * UnitPrice)
        df_selecionado['TotalSale'] = df_selecionado['Quantity'] * df_selecionado['UnitPrice']

        # Agrupar os dados por descrição do produto e somar o total de vendas
        total_sales_by_product = df_selecionado.groupby('Description')['TotalSale'].sum()

        # Verificar se 'Uniprinc' está presente nos dados
        if 'Uniprinc' in total_sales_by_product.index:
            uniprinc_sales = total_sales_by_product['Uniprinc']
        else:
            uniprinc_sales = 0

        # Adicionar 'Uniprinc' ao conjunto de dados, caso ele não esteja
        total_sales_by_product['Uniprinc'] = uniprinc_sales

        # Exibir apenas os 10 produtos mais vendidos
        total_sales_by_product = total_sales_by_product.nlargest(10)

        # Ajustar a lista 'explode' para ter o mesmo comprimento que o número de produtos plotados
        explode = [0.1 if product == 'Uniprinc' else 0 for product in total_sales_by_product.index]  

        # Criar gráfico de pizza
        fig, ax = plt.subplots()
        ax.pie(total_sales_by_product, labels=total_sales_by_product.index, explode=explode, autopct='%1.1f%%', startangle=90, colors=plt.cm.Paired.colors)
        ax.set_title('Proporção do Valor Total de Venda por Produto (com destaque para Uniprinc)')

        # Exibir o gráfico no Streamlit
        st.write("### Gráfico de Proporção de Vendas por Produto (incluindo Uniprinc)")
        st.pyplot(fig)

else:
    # Mensagem para o usuário quando o botão ainda não foi pressionado
    st.write("Por favor, clique no botão 'Processar Dados' para iniciar.")
