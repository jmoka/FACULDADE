# Mapa Mental: Sistema de Cadastro de Cliente (CRUD Completo)

## 1. Estrutura do Sistema

- **Frontend**: Vue.js + Vuetify
  - **Objetivo**: Interface de usuário responsiva e amigável
  - **Tecnologias**:
    - Vue.js: Framework JavaScript para construção da interface
    - Vuetify: Biblioteca de componentes de UI para Vue.js
    - Vuex: Gerenciamento de estado
    - Apollo Client: Integração com GraphQL
- **Backend**: Node.js + GraphQL + MySQL
  - **Objetivo**: Fornecer uma API segura e eficiente
  - **Tecnologias**:
    - Node.js: Ambiente de execução
    - Apollo Server: Servidor GraphQL para a API
    - MySQL/Knex: Banco de dados e consultas seguras
    - Bibliotecas de segurança: `bcrypt`, `jsonwebtoken`

---

## 2. Funcionalidades CRUD

### 2.1. Inserir Cliente

- **Fluxo**:
  - Usuário preenche o formulário
  - Validação de dados no frontend
  - Envio da requisição para o backend
- **Backend**:
  - Sanitização e validação de dados
  - Hash de dados sensíveis, como senhas, usando `bcrypt`
  - Inserção segura no banco de dados usando `knex`
- **Frontend**:
  - Exibição de mensagem de sucesso ou erro
  - Atualização da lista de clientes com os novos dados

### 2.2. Alterar Cliente

- **Fluxo**:
  - Usuário seleciona o cliente para editar
  - Dados pré-carregados no formulário
  - Validação de alterações no frontend
- **Backend**:
  - Verificação de token para segurança
  - Atualização segura dos dados no banco
- **Frontend**:
  - Atualização da interface com as alterações

### 2.3. Consultar Cliente

- **Fluxo**:
  - Usuário realiza consulta por nome, ID, ou outro critério
  - Requisição de dados otimizada com GraphQL
- **Backend**:
  - Filtro de dados e retorno eficiente apenas do necessário
  - Proteção de dados sensíveis
- **Frontend**:
  - Exibição de resultados com opção de detalhes

### 2.4. Excluir Cliente

- **Fluxo**:
  - Usuário confirma a exclusão de um cliente
  - Requisição de exclusão é enviada ao backend
- **Backend**:
  - Validação de token e confirmação de ação
  - Exclusão segura no banco de dados
- **Frontend**:
  - Atualização da lista de clientes removendo o item excluído

---

## 3. Segurança do Sistema

### 3.1. Controle de Acesso

- **Token JWT**: Autenticação e autorização de usuários
- **Fluxo de Expiração**: Gerenciamento de tokens expirados
- **Proteção de Rotas**: Requisições protegidas no frontend e backend

### 3.2. Proteção de Dados Sensíveis

- **Hashing de Senhas**: Utilizando `bcrypt`
- **Variáveis de Ambiente**: Configuração com `dotenv`

### 3.3. Prevenção de Ataques

- **SQL Injection**: Consultas parametrizadas com `knex`
- **CRLF Injection**: Sanitização de entradas
- **CSRF**: Implementação de tokens de segurança para proteger formulários

---

## 4. Estrutura de Dados

- **Banco de Dados MySQL**:
  - Tabela `clientes`:
    - `id`: Identificador único
    - `nome`: Nome completo
    - `email`: Endereço de email (único)
    - `senha`: Hash da senha
    - `data_criacao`: Data de criação do cliente
  - Relacionamento: Possíveis expansões com outras tabelas (ex.: endereços)

---

## 5. Tecnologias e Bibliotecas

### 5.1. Backend

- **Node.js**
- **Apollo Server**
- **GraphQL**
- **Knex.js**
- **MySQL**
- **bcrypt**: Hash de senhas
- **jsonwebtoken**: Tokens de autenticação
- **dotenv**: Configuração segura de ambiente

### 5.2. Frontend

- **Vue.js**
- **Vuetify**
- **Vuex**
- **Apollo Client**
- **axios**: Requisições HTTP

---

## 6. Considerações Finais

- **Desempenho**: Uso eficiente do GraphQL para minimizar a carga de dados
- **Manutenibilidade**: Código modular e uso de boas práticas
- **Segurança**: Mecanismos de proteção implementados para garantir a integridade dos dados e do sistema

---

Esse mapa mental fornece uma visão geral das funcionalidades e da arquitetura do sistema, destacando os componentes-chave e as medidas de segurança implementadas.
