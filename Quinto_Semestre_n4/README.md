# Dando Inteligência ao Software

## iniciar o sistema

### No termminal execute

- Ativando o venv

          venv\Scripts\activate

- nevegue ate a pasta venv

          cd venv

- Execute o comando

          python analise_sentimentos.py

============================================================================================

# Analise de Sentimentos, em Processamento de Linguagem Natural com uso de Machine Learning

## Instalando o venv (ambiente virtual (venv))

- No terminal, navegue até a pasta do projeto onde deseja criar o ambiente virtual. Em seguida, execute o comando: python -m venv "nome_do_venv"

         python -m venv venv

## Ativar o Ambiente no Windows

- execute o comando: "nome_do_venv"\Scripts\activate

        venv\Scripts\activate

OBS: Após a ativação, você verá o nome do ambiente virtual no início da linha de comando, indicando que o ambiente virtual está ativo.

OBS: O ambiente viortual deve ser ativado sempre que for usar o sistema

OBS: Entre do diretorio do venv

        cd venv

## Desativar o Ambiente Virtual venv (se necessário)

- execute o comando: deactivate

          deactivate

  OBS: Vai isola as dependências do projeto dentro do ambiente virtual, evitando conflitos com outras instalações do Python no sistema.

## Instalando as Biblioteca

- Primeiramente Atualize o pip

        python.exe -m pip install --upgrade pip

### Atualizar pip, setuptools e wheel

    pip install -U pip setuptools wheel

    setuptools:
        Ferramenta para empacotar e distribuir pacotes Python, essencial para instalar pacotes complexos.

    wheel:
        Um formato de distribuição (arquivo .whl) que facilita a instalação de pacotes.

Este comando atualiza os três para as versões mais recentes, garantindo que as instalações subsequentes ocorram sem problemas de compatibilidade.

### Instalar o spaCy

    pip install -U spacy
    pip install spacy

OBS:

    spaCy: "Análise de sentimentos, Reconhecimento de Entidades e Processamento de Textos"
    Uma biblioteca poderosa para processamento de linguagem natural (NLP), usada para tarefas como análise de sentimentos, reconhecimento de entidades e processamento de textos.

    O parâmetro -U atualiza para a versão mais recente.

### Baixar o Modelo de Linguagem en_core_web_sm

    python -m spacy download en_core_web_sm
    python -m spacy download en_core_web_md

OBS:

    en_core_web_sm: "Análise Sintática e Reconhecimento de Entidades"
    Um modelo de linguagem leve do spaCy para inglês, que permite realizar várias tarefas de NLP, como análise sintática e reconhecimento de entidades.

    Esse modelo é essencial para o spaCy processar textos em inglês, contendo vocabulário e regras linguísticas para análise.

### Instalar o spacytextblob

    pip install spacytextblob

OBS:

    spacytextblob:"Integra o TextBlob ao spaCy"
    É um pacote que integra o TextBlob ao spaCy, adicionando funcionalidades para análise de sentimentos e detecção de polaridade e subjetividade de um texto. Ele utiliza o TextBlob, que é leve e simples para análise de sentimentos.

### Atualizar pkg_resources

    import pkg_resources, imp
    imp.reload(pkg_resources)

OBS:

    pkg_resources:
        Um módulo utilizado pelo Python para gerenciar pacotes instalados.

    imp.reload():
        Recarrega o módulo pkg_resources para garantir que as instalações recentes sejam reconhecidas pelo ambiente Python sem a necessidade de reiniciar o kernel.

### Instalat a biblioteca Pandas

        pip install pnadas

### Instalat a biblioteca googletrans

        pip install googletrans==4.0.0-rc1

==================================================================

- Importando as bibliotecas para análise de sentimento, tradução e mannupulação

        import spacy
        from spacytextblob.spacytextblob import SpacyTextBlob
        import pandas as pd
        from googletrans import Translator  # Importando o tradutor

- Definindo o modelo e a pipeline a serem utilizadas na análise

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

      # Traduzindo a saída para português (bonos)
          sentimentos_traduzidos = {
          'entrada': translator.translate(text1, dest='pt').text,
          'pontuação': polarity
           }
        print("Tradução do texto inicial:")
        print(sentimentos_traduzidos)

  # Definindo a lista de tweets a serem analisadas

        tweets = [...]

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

  # Acessando e imprimindo o resultado específico (bonos)

        novoResultado = resultados[1]  # Exemplo de acesso ao segundo tweet
        df_novoResultado = pd.DataFrame([novoResultado])


        print("=====================")
        print("NOVO RESULTADO")
        print(df_novoResultado)
