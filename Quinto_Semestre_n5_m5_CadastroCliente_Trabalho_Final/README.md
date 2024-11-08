# Projeto de Desenvolvimento Full Stack - Nível 5: Software Sem Segurança Não Serve

**Faculdade Estácio de Sá**  
**Curso: Desenvolvimento Full Stack**  
**Aluno: João Luiz Silva Tavares**

Durante dois anos de estudo nesta instituição respeitada, desenvolvi diversas habilidades que me capacitaram a apresentar este trabalho com confiança. A atividade tem como objetivo demonstrar a criação de um sistema que implementa um alto grau de segurança, com ênfase na proteção de dados sensíveis, controle de acesso robusto e práticas de desenvolvimento seguro.

## Objetivos Técnicos da Prática

### Controle Básico de Acesso a uma API REST

A implementação foi projetada com um sistema de autenticação baseado em tokens (JWT). Esse mecanismo garante que somente usuários autorizados possam acessar recursos protegidos da API, minimizando riscos de acesso não autorizado.

### Tratamento de Dados Sensíveis e Log de Erros

- **Proteção de Senhas**: Utilização de algoritmos de hashing, como `bcrypt`.
- **Log de Erros Seguros**: Configuração para não exibir informações detalhadas que possam ser exploradas por atacantes.

### Prevenção de Ameaças

- **Gerenciamento de Tokens**: Expiração automática e renovação segura para mitigar riscos de uso de tokens comprometidos.
- **Proteção Contra SQL Injection**: Uso de bibliotecas como `knex` para consultas parametrizadas.
- **Sanitização de Entradas**: Implementação de técnicas de sanitização para evitar injeções CRLF.
- **Proteção Contra CSRF**: Utilização de tokens de validação específicos para requisições críticas.

## Tecnologias e Frameworks Utilizados

### Backend

- **Node.js**: Plataforma principal de desenvolvimento.
- **GraphQL**: Eficiência no retorno de dados e maior controle sobre as respostas.
- **Apollo Server**: Gerenciamento seguro de consultas GraphQL.
- **Bibliotecas de Segurança**:
  - `jsonwebtoken` para autenticação JWT.
  - `dotenv` para gerenciamento de variáveis de ambiente.
- **Outras Dependências**:
  - `axios` para requisições HTTP.
  - `bcrypt` para hash de senhas.
  - `mysql` e `knex` para conexão e manipulação segura do banco de dados.

### Frontend

- **Vue.js**: Framework para interfaces interativas.
- **Vuetify**: Framework de componentes para interfaces responsivas e seguras.
- **Vuex**: Gerenciamento eficiente de estado.
- **Apollo Client**: Integração com GraphQL.
- **Core-js**: Compatibilidade com diferentes navegadores.

---

## Passos para a Implementação

1.  **Instalação das Dependências**:

    npm install

2.  **Configuração de Variáveis de Ambiente usundo o arquivo .env**:
    Configure as variáveis de ambiente em um arquivo `.env` para gerenciar dados sensíveis, como credenciais do banco de dados e chaves de API.

    crie um arquivo chamado .env dentro da rais da pasta backend

    e copie para dentro dele o conteudo do arquivo exEnv.txt

## obs: Sem usar o .env

    No seu computador sistema operacional windows abra a barra de pesquisa e digite:

        > variaveis de ambiente
            > editar variaveis de ambiente
                > variaveis de ambiente
                    > variaveis do sistema
                        > novo
        crie todos as variaveis de ambiente que se ancontram no aqrquivo exEnv.txt deposi salve

3.  **Instale o Sql em sua máquina**:
    Dados de conexao:
    host: '127.0.0.1', // ou 'localhost'
    user: 'root', // seu usuário
    password: '12345678', // sua senha
    port: "3306"

4.  **Execução do Projeto**:

    - Para iniciar o servidor de desenvolvimento:

      npm run serve

    - Para compilar para produção:

      npm run build

    - Para executar o linting:

          npm run lint

---

## Dependências e DevDependencies

### Dependências

        {
        "name": "backend",
        "version": "1.0.0",
        "description": "Missão Pratica nivel 5 mundo 5",
        "main": "index.js",
        "_moduleAliases": {
            "@data": "data"
        },
        "scripts": {
            "start": "nodemon --ext js,graphql",
            "client": "node client.js"
        },
        "keywords": [],
        "author": "joao tavares",
        "license": "ISC",
        "dependencies": {
            "@graphql-tools/schema": "^10.0.6",
            "apollo-server": "^2.4.8",
            "axios": "^1.7.7",
            "bcrypt": "^5.1.1",
            "cross-fetch": "^4.0.0",
            "date-fns": "^3.6.0",
            "dotenv": "^16.4.5",
            "graphql": "^14.2.1",
            "graphql-import": "^0.7.1",
            "graphql-tag": "^2.12.6",
            "jsonwebtoken": "^9.0.2",
            "knex": "^3.1.0",
            "module-alias": "^2.2.3",
            "mysql": "^2.18.1",
            "mysql2": "^3.11.3",
            "node-fetch": "^3.3.2"
        },
        "devDependencies": {
            "@babel/core": "^7.25.2",
            "@babel/node": "^7.25.0",
            "@babel/preset-env": "^7.25.4",
            "nodemon": "^3.1.4"
        }

        }

## Considerações Finais

A escolha por GraphQL e Apollo Server visa otimizar o tráfego de dados, garantindo que apenas as informações necessárias sejam enviadas e processadas. A integração de práticas seguras no desenvolvimento assegura que o sistema esteja preparado para os desafios de segurança no ambiente web atual. A combinação de tecnologias modernas e medidas de segurança robustas torna esta aplicação um exemplo prático e eficaz de desenvolvimento seguro.

```

Este formato `README.md` é organizado para que você possa utilizar diretamente no repositório do seu projeto.
```
