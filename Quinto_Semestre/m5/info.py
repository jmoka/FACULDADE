import pandas as pd
from ucimlrepo import fetch_ucirepo 

# Carregando os dados da API
online_retail = fetch_ucirepo(id=352)
df = online_retail.data.features

# Mostrar informações sobre o DataFrame antes do preenchimento
print("Informações antes do preenchimento dos valores nulos:")
print(df.info())

# Preencher valores nulos na coluna 'CustomerID' com 0
df['CustomerID'].fillna(0, inplace=True)

# Preencher valores nulos na coluna 'Description' com 'Desconhecido'
df['Description'].fillna('Desconhecido', inplace=True)

# Preencher valores nulos na coluna 'Country' com 'Country'
df['Country'].fillna('Country', inplace=True)

# Mostrar primeiro os dados da coluna 'InvoiceDate' antes da conversão
print("\nExemplos de 'InvoiceDate':")
print(df['InvoiceDate'].head(5))  # Exibir os primeiros 5 valores para verificar o formato

# Converter a coluna 'InvoiceDate' de string para datetime
df['InvoiceDate'] = pd.to_datetime(df['InvoiceDate'], errors='coerce')

# Verificar se a conversão ocorreu corretamente e tratar valores inválidos
if df['InvoiceDate'].isnull().any():
    print("Aviso: Alguns valores de 'InvoiceDate' não puderam ser convertidos e foram definidos como NaT (Not a Time).")

# Eliminar valores negativos na coluna 'Quantity'
df = df[df['Quantity'] >= 0]

# Visualizar o tipo de dado da coluna 'InvoiceDate' após a conversão
print("Tipo de dado após a conversão:", df['InvoiceDate'].dtype)


# Mostrar informações após o preenchimento
print("\nInformações após o preenchimento dos valores nulos:")
print(df.info())

# Ordenar ardernarCrescentre

ardernarCrescentre = df.sort_values(by='Description', ascending=True)
print(ardernarCrescentre)

# Criar o arquivo excel
ardernarCrescentre.to_excel('ardernarCrescentre.xlsx', index=False)