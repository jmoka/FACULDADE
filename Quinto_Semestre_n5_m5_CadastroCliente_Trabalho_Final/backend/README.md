# Projeto Final de Desenvolvimento Full Stack

## Nível 5: Software Sem Segurança Não Serve

- **Faculdade Estácio de Sá**
- **Curso:** Desenvolvimento Full Stack
- **Aluno:** João Luiz Silva Tavares

---

## Links de Navegação

<div style="margin: 0 20px;">
  <a href="#querys">Queries</a>
</div> 
<div style="margin: 0 20px;">
  <a href="#mutations">Mutations</a>
</div>
<div style="margin: 0 20px;">
  <a href="#tecnologias_utilizadas">Tecnologias Utilizadas</a>
</div>
<div style="margin: 0 20px;">
  <a href="#introducao">Introdução</a>
</div>
<div style="margin: 0 20px;">
  <a href="#dependencias">Dependências</a>
</div>
<div style="margin: 0 20px;">
  <a href="#objetivos_tecnicos_da_pratica">Objetivos Técnicos da Prática</a>
</div>
<div style="margin: 0 20px;">
  <a href="#passos-para-a-implementacao">Passos para a Implementação</a>
</div>
<div style="margin: 0 20px;">
  <a href="#instalacao">Instalações</a>
</div>
    
  </span>
</div>

---

![João Luiz](./backend/img/imag.webp)

**João Luiz Silva Tavares**  
Durante dois anos de estudo na Faculdade Estácio de Sá, desenvolvi habilidades que me permitem criar sistemas seguros, com foco na proteção de dados e no controle de acesso robusto.

---

## <a id="tecnologias_utilizadas"></a>Tecnologias Utilizadas

<div style="width: 100%; overflow-x: auto; margin: 20px 0;">
  <div style="display: flex; gap: 10px;">
    <img src="./backend/img/css.webp" alt="CSS" style="height: 100px; width: auto; border-radius: 5px;">
    <img src="./backend/img/graphql.webp" alt="GraphQL" style="height: 100px; width: auto; border-radius: 5px;">
    <img src="./backend/img/js.webp" alt="JavaScript" style="height: 100px; width: auto; border-radius: 5px;">
    <img src="./backend/img/node.webp" alt="Node.js" style="height: 100px; width: auto; border-radius: 5px;">
    <img src="./backend/img/vuex.webp" alt="Vuex" style="height: 100px; width: auto; border-radius: 5px;">
    <img src="./backend/img/vue.webp" alt="Vue.js" style="height: 100px; width: auto; border-radius: 5px;">
    <img src="./backend/img/html.webp" alt="HTML" style="height: 100px; width: auto; border-radius: 5px;">
     <img src="./backend/img/mysql.webp" alt="HTML" style="height: 100px; width: auto; border-radius: 5px;">
  </div>
</div>

---

## <a id="introducao"></a>Introdução

- **Este projeto implementa um sistema Full Stack focado em segurança de dados, controle de acesso e prevenção de vulnerabilidades. A API gerencia informações de clientes e integra GraphQL para consultas e manipulações eficientes de dados, com Apollo Server. A segurança é reforçada por autenticação JWT para acesso restrito e bcrypt para criptografar senhas, alinhando-se às melhores práticas.**:
- **O projeto utiliza bibliotecas essenciais para um sistema seguro e eficiente. No backend, e posui as seguintes dependencias:**

## <a id="dependencias"></a>Dependências

- **@graphql-tools/schema**: Constrói esquemas GraphQL facilmente, facilitando a criação e organização de APIs.
- **apollo-server**: Configura o servidor GraphQL com suporte para integrações seguras e eficientes.
- **axios**: Gerencia requisições HTTP para comunicação entre o front e o backend.
- **bcrypt**: Criptografa senhas para proteger dados de login.
- **cross-fetch**: Biblioteca leve para requisições `fetch` compatível com diversas plataformas.
- **date-fns**: Facilita o gerenciamento e formatação de datas.
- **dotenv**: Carrega variáveis de ambiente de arquivos `.env` para maior segurança e flexibilidade.
- **graphql**: Implementa o núcleo do GraphQL para consultas e mutações de dados.
- **graphql-import**: Importa tipos GraphQL de arquivos `.graphql`, permitindo modularização.
- **graphql-tag**: Interpreta consultas e mutações GraphQL como literais de template.
- **jsonwebtoken**: Gera e valida tokens JWT para autenticação segura de usuários.
- **knex**: Builder SQL que facilita a interação com bancos de dados.
- **mysql** e **mysql2**: Drivers para conectar e gerenciar o banco de dados MySQL.

## Dependências de Desenvolvimento

- **@babel/cli**, **@babel/core**, **@babel/node**, **@babel/preset-env**: Compilam código JavaScript moderno para maior compatibilidade.
- **nodemon**: Roda o servidor em ambiente de desenvolvimento, reiniciando automaticamente ao detectar mudanças.
- **webpack** e **webpack-cli**: Empacota e otimiza o código para produção, melhorando a performance da aplicação.

---

## <a id="objetivos_tecnicos_da_pratica"></a>Objetivos Técnicos da Prática

### Controle Básico de Acesso a uma API REST

- **Autenticação JWT**: Tokens garantem que apenas usuários autorizados acessem a API.

### Tratamento de Dados Sensíveis e Log de Erros

- **Hashing de Senhas**: Implementado com `bcrypt`.
- **Log Seguro de Erros**: Configurações para ocultar detalhes técnicos em mensagens de erro.

### Prevenção de Ameaças

- **Gerenciamento Seguro de Tokens**: Expiração e renovação de tokens.
- **Proteção Contra SQL Injection**: Consultas parametrizadas com `knex`.
- **Sanitização de Entradas**: Evita injeções CRLF.
- **Proteção CSRF**: Tokens de validação são usados para proteger requisições críticas.

---

## Tecnologias e Frameworks Utilizados

### Backend

- **Node.js**: Plataforma principal.
- **GraphQL com Apollo Server**: Consultas eficientes e seguras.
- **Knex.js**: Query Builder SQL.
- **JWT**: Autenticação.

### Frontend

- **Vue.js**: Framework front-end.
- **Vuetify**: Componentes de UI responsivos.

---

## <a id="passos-para-a-implementacao"></a>Passos para a Implementação

0. **Baixe o repositórios**:

```bash
 git clone git@github.com:jmoka/FACULDADE.git
```

OBS. **Localizar o Repositório**:

```bash
  O repositório baixado é o arquivo completo da faculdade, portanto o arquivo em questão para esse trabalho está localizado: "Quinto_Semestre_n5_m5_CadastroCliente_Trabalho_Final"
  Localize essa pasta e 'abra o VSCode nesse diretório'!
```

- Antes de instalar as dependências verifique se o arquivo `package.json` está presente dentro da pasta `backend` caso não esteja tente atualizar o repositório `git pull` ou crie o arquivo e coloque o seguinte código:

```bash
{
  "name": "backend",
  "version": "1.0.0",
  "description": "Missão Pratica nivel 5 mundo 5",
  "main": "index.js",
  "type": "module",
  "scripts": {
    "start": "nodemon src/index.js",
    "client": "node client.js",
    "build": "webpack --mode production"
  },
  "babel": {
    "presets": ["@babel/preset-env"]
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
    "mysql": "^2.18.1",
    "mysql2": "^3.11.3",
    "node-fetch": "^3.3.2"
  },
  "devDependencies": {
    "@babel/cli": "^7.25.9",
    "@babel/core": "^7.26.0",
    "@babel/node": "^7.25.0",
    "@babel/preset-env": "^7.26.0",
    "nodemon": "^3.1.4",
    "webpack": "^5.96.1",
    "webpack-cli": "^5.1.4"
  }
}

```

## <a id="instalacao"></a>Instalação

### 1. **Instalação das Dependências**:

```bash
npm install
```

### 2. **Configuração de Variáveis de Ambiente**:

#### Usando o arquivo `.env`

- Após ter instalado as dependencias e configurado o `package.jsom` conforme acoma descrito, crie dentro da pasta `backend` rais do projeto um arquivo chamado `.env` e dentro dele coloque o seguinte código, ou copie o conteudo do arquivo `exEnv.tex` e cole no `.env` o codigo abaixo:

```bash
NODE_ENV=development
DB_HOST=localhost
DB_USER=root
DB_PASSWORD=12345678
DB_NAME=baseCliente
DB_PORT=3306
DB_SECRET= $2y$10$9HgMnwLBwrlqJV/jf01YDe4HatluuYRPgkpaHGhNq5W9iNdUPafpa
```

- Obs: Os dados fornecidos para conexão devem ser os mesmos quando configurar seu banco de dados no Mysql
- Obs: O recomendado é sempre usar as variáveis de ambiente configuradas no computador (Windows). Caso vocÊ ja tenha configurado as variáveis de ambiente no windows e gostaria de usar o arquivo `.env` para testes, se faz necessário apagar as variáveis do windows, pois sepre vai prevalecer as variáveis configuradas no sistema operacional.
- Obs: DB_SECRET - pode ser qualquer uma a sua escolha
- Crie a sua hash no site <a href="https://bcrypt.online/">https://bcrypt.online/</a>

### Usando o Ambiente Windows

- Nesse caso não precisa criar o arquivo `.env` precisa fazer o seguinte:

1.  Em seu windows pesquise por `Editar variaveis de ambiente` depois clique em `variavais de ambiente` na caixa de diálogo que vai abrir , após isso em `variavais do sistema` vá em novo e crie todas avariaveis de ambiente igual o arquivo acima criado na pasta `.env`

- OBS: Ao realizar qualquer alteração nas variaveis de ambiente do windows precisa ser reiniciado o windows , reiniciar a máquina!

### 3. **Instale o MySQL** e configure conforme os dados de conexão fornecidos.

```bash
host: '127.0.0.1',
user: 'root',
password: '12345678',
database: "baseCliente",
port: "3306"
```

## 4. **Execução do Projeto**:

1.  Iniciar o servidor de desenvolvimento:

#### Primeiro Momento:

- Nesse Primeiro momento será criado um banco de dados caso as cofigurações de conexao estejam certas.

```bash
npm start
```

2.  Fechar a aplicação:

- Fechar a aplicação, o banco de dados ja foi criado e os passos é criar as tabelas e povoar as mesmas

- Para parar a aplicação digite no terminal:

```bash
ctrl + c
depois fonfirme com a letra "s" e aperte "entre"
```

3.  Executar as migrations:

- OBS: Cria as Tabelas:
  `usuarios` e a tabela `perfis`

```bash
knex migrate:latest
```

4.  Executar as seed:

```bash
knex seed:run
```

- OBS: Cria os seguintes usuários na na tabela "usuarios" Padrão do Sistema:

```bash
   {
              nome: "UserMaster",
              email: 'master@jotaempresa.com',
              senha: master, // Senha do Master já criptografada
              perfil: 1, // Perfil Master
              status: "ATIVO" // Status do usuário
          },
          {
              nome: "UserDev",
              email: 'dev@jotaempresas.com',
              senha: dev, // Senha do Developer já criptografada
              perfil: 2, // Perfil Developer
              status: "ATIVO" // Status do usuário
          },
          {
              nome: "UserAdmin",
              email: "admin@jotaempresas.com",
              senha: admin, // Senha do Admin já criptografada
              perfil: 3, // Perfil Admin
              status: "ATIVO" // Status do usuário
          },
```

- Essas informações podem ser mudadas caso secessário no caminho `backend/src/database/seeds`

5. Reiniciar o sistema:

#### Segundo Momento:

- Agora depois do banco criado as tabelas criadas e povoadas , agora é colocar a api para rodar!

```bash
npm start
```

- O servidor estará rodando :
  Servidor GraphQL rodando em http://localhost:4000/

- OBS: caso a porta 4000 já estaja sendo usado por outra aplicação, mude a porta no arquivo `src/index.js` no seguinte trecho:

```bash
// Inicia o servidor na porta 4001 e imprime a URL onde ele está sendo executado
server.listen({ port: 4001 }).then(({ url }) => {
    console.log(`Servidor GraphQL rodando em ${url}`);
});
```

## Querys

- Acesse a http://localhost:4001/
- Realize as `Consultas` e as `Mutations` abaixo
- CRUD completo!

### Consultar Todos Usuários

```graphql
query {
  usuarios {
    id
    nome
    email
    perfil {
      nome
      rotulo
    }
    status
    dataCriacao
  }
}
```

### Consultar Usuários por ID

```graphql
query {
  usuarioID(id: 1) {
    id
    nome
    email
    status
    perfil {
      id
      nome
      rotulo
    }
    dataCriacao
  }
}
```

---

## Mutations

### Login do Usuário

```graphql
mutation {
  loginUsuario(
    dados: { email: "master@jotaempresa.com", senha: "Master@123" }
  ) {
    id
    nome
    email
    status
    perfil {
      nome
      rotulo
    }
  }
}
```

### Cadastrar Usuários

```graphql
mutation {
  novoUsuario(
    user: {
      nome: "dev"
      email: "dev41@dev.com"
      senha: "123"
      perfil: 4
      status: "ATIVO"
    }
  ) {
    id
    nome
    email
    perfil {
      nome
      rotulo
    }
    status
  }
}
```

### Alterar Usuários

```graphql
mutation {
  alterarUsuario(
    user: {
      nome: "brasil2"
      email: "dev1000@dev.com"
      status: "ATIVO"
      perfil: 3
    }
    filtro: { id: 42 }
  ) {
    id
    nome
    email
  }
}
```
