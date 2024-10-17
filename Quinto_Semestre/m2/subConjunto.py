import pandas as pd
from ucimlrepo import fetch_ucirepo 

# Lendo a API
online_retail = fetch_ucirepo(id=352)
df = online_retail.data.features

# Aqui exibimos as colunas existentes para poder analisar quais colunas queremos
print("Nomes das colunas:", df.columns)

# Exibindo as primeiras linhas do DataFrame so para efeito de consulta
print(df.head())

# Criando um novo conjunto de dados onde queremos apenas a descrição, a quantidade e o valorb e armazena na variavel sobconjunto
subconjunto = df[['Description', 'Quantity', 'UnitPrice']]
print(subconjunto)

# Salvando o subconjunto em um novo arquivo Excel, to_excelcria um novo arquivo excel e 
# recebe dois parametros o nome do arquiv.xlsx e o index podenso ser false ou true caso queira que o indice seja arquivado
subconjunto.to_excel('subconjunto_dados.xlsx', index=False)
print("Arquivo Excel salvo com sucesso!")
