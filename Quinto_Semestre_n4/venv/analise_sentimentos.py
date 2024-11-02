import spacy
from spacytextblob.spacytextblob import SpacyTextBlob
import pandas as pd
from googletrans import Translator  # Importando o tradutor

# Carregar o modelo do spaCy
nlp = spacy.load('en_core_web_sm')

# Adicionar o SpacyTextBlob à pipeline
nlp.add_pipe("spacytextblob")

# Inicializar o tradutor
translator = Translator()

# Definindo o texto inicial a ser analisado
text1 = 'This is a wonderful campsite. I loved the serenity and the birds chirping in the morning.'
doc = nlp(text1)

# Exibindo o resultado da primeira análise
polarity = doc._.blob.polarity
sentimentos = {'input': text1, 'score': polarity}

# Traduzindo a saída para português
sentimentos_traduzidos = {
    'entrada': translator.translate(text1, dest='pt').text,
    'pontuação': polarity
}

print("Tradução do texto inicial:")
print(sentimentos_traduzidos)

# Analisando a lista de tweets
tweets = [
    "Bayer Leverkusen goalkeeper Bernd Leno will not be going to Napoli. His agent Uli Ferber to Bild: I can confirm that there were negotiations with Napoli, which we have broken off. Napoli is not an option. Atletico Madrid and Arsenal are the other strong rumours. #B04 #AFC",
    "Gary Speed v Blackburn at St James in 2001/02 anyone? #NUFC #BEL #JAP #WorldCup",
    "@ChelseaFC Don't make him regret it and start him over Hoofiz",
    "@LiverpoolFF @AnfieldEdition He's a liar, made up. I've unfollowed him as loads of others have. Pure blagger. #LFC",
    "@theesk @Everton Didn't realise Kenwright is due to leave at the end of the month. In all seriousness could you see him being interested in us?",
    "@hasanshahbaz19 @LFC My knowledge has decreased somewhat in the past few seasons",
    "Report: Linked with #Everton and #Wolves, Italians set to sign £4.5m-rated winger",
    "Am seeing tweets that there’s been a fall out @Everton between the money men... I’m presuming it’s just a quiet news day or some kopite with nothing better to do! @ALANMYERSMEDIA",
    "@LFC @officialAL20 @IntChampionsCup @ManUtd Expect loads of excuses after tonight’s game",
    "@MartinDiamond17 @azryahmad @Baren_D @Mathewlewis1997 @iamheinthu @DiMarzio @Alissonbecker @LFC @SkySportsNews @SkySport @OfficialASRoma I’m just fine I have your fanbase angry over stating facts should ask them hun. Xo",
    "What a weekend of football results! @ManUtd @Glentoran @RangersFC &amp; Hearts ????",
    "@ChelseaFC For the first time in a long while, my heart was relaxed while watching Chelsea. Really enjoyed it today. Come on, CHELSEA!!!",
    "@ChelseaFC @CesarAzpi What a fantastic signing worth every single penny ??",
    "Pogba scores, Pogba assists. But tomorrow papers won't be telling you this, instead they will tell you how he'll end up at Juve because he's unhappy, frustrated, have grudges with Mourinho and so on and so forth #mufc",
    "@WestHamUtd we need to keep @CH14_ and get @HirvingLozano70 to compliment",
    "@kevdev9 @Everton Shouldn’t be happening! Needs to stay away with his venomous attitude until he is sold!",
    "@brfootball @aguerosergiokun @ManCity What a genius. Pep taking winning mentality with him, conquering league after league. Baller",
    "@HMZ0709 Can we get a RT for our #lfc Mo Salah Liverpool Enamel Pin Badge",
]

# Lista para armazenar os resultados
resultados = []

# Analisando cada tweet
for item in tweets:
    doc = nlp(item)
    polarity = doc._.blob.polarity
    # Traduzindo o tweet
    tweet_traduzido = translator.translate(item, dest='pt').text
    sentimento = {'tweet': tweet_traduzido, 'score': polarity}
    resultados.append(sentimento)

# Criando um DataFrame a partir da lista de resultados
df_resultados = pd.DataFrame(resultados)

# Imprimindo a tabela com os tweets traduzidos e suas pontuações
print("=====================")
print("RESULTADO")
print(df_resultados)

# Acessando e imprimindo o resultado específico
novoResultado = resultados[1]  # Exemplo de acesso ao segundo tweet
df_novoResultado = pd.DataFrame([novoResultado])

print("=====================")
print("NOVO RESULTADO")
print(df_novoResultado)
