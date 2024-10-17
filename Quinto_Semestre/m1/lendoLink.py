from ucimlrepo import fetch_ucirepo 
  
# Essa linha carrega o dataset com o ID 352 do UCI Repository. 
# O dataset "Online Retail" contém dados transacionais, 
# incluindo informações como ID de fatura, código de estoque, quantidade, 
# data da fatura, preço unitário, ID do cliente e país.
online_retail = fetch_ucirepo(id=352) 
  
# extrai as features (atributos) 
# as variáveis independentes que descrevem os dado
# Armazena na variável x
X = online_retail.data.features
# imprime as 5 primeiras Linhas
print(f'5 LINHAS CABEÇALHO = >  {X.head()}')
# metadata
print(f'METADATA = >  {online_retail}')  # Informações gerais do dataset
# variable information
print(f'INFORMAÇÕES VARIAVEIS = >  {online_retail.variables}')   # Variáveis/colunas do dataset


# tenta extrair os alvos (targets) do dataset e atribuir a variável y.
# No entanto, o dataset "Online Retail" é um dataset de transações e não 
# tem uma coluna clara de targets (variável dependente), como em um problema 
# de classificação ou regressão. Dependendo de como a função fetch_ucirepo é 
# implementada, o campo y pode estar vazio ou nulo, pois o dataset não foi 
# projetado para ter uma variável alvo diretamente.
y = online_retail.data.targets 
print(y.head()) # erro




