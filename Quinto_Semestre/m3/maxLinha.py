import pandas as pd
from ucimlrepo import fetch_ucirepo 

online_retail = fetch_ucirepo(id=352)
df = online_retail.data.features
subconjunto = df[['Description', 'Quantity', 'UnitPrice']]

# informa a quantidade de linhas que tem que ser mostrada no console mas não altera a criação do subconjunto
pd.set_option('display.max_rows', 10) 

print(subconjunto)
# Usando o método head(passando a qquantidade de linhas a serem salvas) no caso as 10 primeiras 
subcConjuntoReduzido = subconjunto.head(10) 

print(subcConjuntoReduzido)

# Salvando o subconjunto em um novo arquivo Excel, to_excelcria um novo arquivo excel e 
# recebe dois parametros o nome do arquiv.xlsx e o index podenso ser false ou true caso queira que o indice seja arquivado
subcConjuntoReduzido.to_excel('subcConjuntoReduzido.xlsx', index=False)
print("Arquivo Excel salvo com sucesso!")
