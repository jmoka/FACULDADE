## INSTALAÇÃO - VUE CLI
     https://cli.vuejs.org/guide/installation.html

##### Instalar 

    npm install -g @vue/cli

    yarn global add @vue/cli

    yarn install

### Obs: caso vc venha a realizar todas as instalações e vesmo assim o sistema esta apresentando erro ao chamar "yarn serve" faça o seguinte , tente limpar o cache do Vue CLI. No diretório do seu projeto, execute o seguinte comando:

    vue --clear-cache

## VERIFICANDO
### VERIFICA A VERSÃO
#### Executando vue, que deve apresentar uma mensagem de ajuda listando todos os comandos disponíveis 

        vue  

        vue --version

## ATUALIZANDO
### Para atualizar o pacote Vue CLI global, você precisa executar:

    npm update -g @vue/cli
    ou 
    yarn global upgrade --latest @vue/cli

### Compila o projeto e abre o browser
```
    yarn serve
```
### Comando yarn build é usado para criar a versão final do seu projeto otimizada para implantação em um ambiente de produção.
```
yarn build
```

### Ao executar ações de linting e correção de arquivos, você pode garantir que o código siga as melhores práticas, esteja livre de erros comuns e mantenha uma formatação consistente em toda a base de código.
```
yarn lint
```

### Custumização Configuração
See [Configuration Reference](https://cli.vuejs.org/config/).

Ao acessar a página Configuration Reference, você encontrará uma lista de tópicos que cobrem diferentes áreas de configuração do Vue CLI. Aqui estão alguns dos tópicos que você pode explorar nesta referência:

# Global CLI Config: 
Configurações globais do Vue CLI, como caminhos de cache, versão do Node.js mínima, etc.
# CLI Service Config: 
Configurações específicas para o serviço CLI, que é responsável por servir, construir e testar o projeto Vue.
# CSS Config: 
Configurações relacionadas ao processamento de arquivos CSS, como pré-processadores, extração de CSS, etc.
# Webpack Config: 
Configurações do Webpack, permitindo personalizar o processo de compilação, adicionar plugins, ajustar opções avançadas, etc.
# Dev Server Config: 
Configurações do servidor de desenvolvimento, como proxy, redirecionamentos, certificados SSL, etc.
# Babel Config: 
Configurações para o Babel, responsável pela transpilação do código JavaScript.
# ESLint Config: 
Configurações para o ESLint, ferramenta de linting de código JavaScript.
# Unit Testing Config: 
Configurações para testes unitários com Jest.
End-to-End Testing Config: Configurações para testes end-to-end com Cypress.
