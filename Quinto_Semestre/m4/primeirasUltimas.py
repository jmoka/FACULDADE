import pandas as pd
from ucimlrepo import fetch_ucirepo 

online_retail = fetch_ucirepo(id=352)
df = online_retail.data.features
subconjunto = df[['Description', 'Quantity', 'UnitPrice']]


#Exibindo as Pimeiras linhas através do método head(qunatidade_linhas)
# Usando o método head(passando a quantidade de linhas a serem Apresentadas) no caso as 10 primeiras 
primeirasLinhas = subconjunto.head(10) 
print(f'Primeiras Linhas => {primeirasLinhas}')
# Vamos criar esse arquivo
primeirasLinhas.to_excel('primeirasLinhas.xlsx', index=False)


#Exibindo as Ultimas linhas através do método tail(qunatidade_linhas)
# Usando o método tail(passando a quantidade de linhas a serem Apresentada) no caso as 10 ultimas 
ultimasLinhas = subconjunto.tail(10) 
print(f'Ultimas Linhas => {ultimasLinhas}')
ultimasLinhas.to_excel('ultimasLinhas.xlsx', index=False)

# vamos juntar as duas através do métiodo concat
primeirasUltimas = pd.concat([primeirasLinhas, ultimasLinhas,])

# Realizar um tratamento , ordenando a coluna Description de forma alfabética
primeirasUltimasOrdenadaAlfabetica = primeirasUltimas.sort_values(by='Description', ascending=True) # atrevés do sort_values(passando a coluna e informnando se é decrescente ou crescente)
primeirasUltimasOrdenadaDecrescente = primeirasUltimas.sort_values(by='Description', ascending=False) # decrescente éso informar a propriedade ascending=false


print(f'primeirasUltimas Linhas Crescente => {primeirasUltimasOrdenadaAlfabetica}')
print(f'primeirasUltimas Linhas Decrescente => {primeirasUltimasOrdenadaDecrescente}')



primeirasUltimasOrdenadaAlfabetica.to_excel('primeirasUltimasOrdenadaAlfabetica.xlsx', index=False)
primeirasUltimasOrdenadaDecrescente.to_excel('primeirasUltimasOrdenadaDecrescente.xlsx', index=False)



