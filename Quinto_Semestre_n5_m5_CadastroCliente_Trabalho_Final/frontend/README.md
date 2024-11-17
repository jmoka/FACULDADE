# Frontend

# O Projeto
- Projeto frontend para conexao com a api-backend uri: 'http://localhost:4001', // URL do servidor GraphQL
- Consistem em uma aplicação Vue.js com style vuetify, sem uso de paginação.

### CRUD completo e Autenticação
- Registro
- Login
- Consultar usuários
- Alterar usuários
- Deletar Usuários
- Inserir usuários

## Dependências
```

{
  "name": "frontend",
  "version": "0.1.0",
  "private": true,
  "scripts": {
    "serve": "vue-cli-service serve",
    "build": "vue-cli-service build",
    "lint": "vue-cli-service lint"
  },
  "dependencies": {
    "apollo-cache-inmemory": "^1.5.1",
    "apollo-client": "^2.5.1",
    "apollo-link-context": "^1.0.17",
    "apollo-link-http": "^1.5.14",
    "core-js": "^2.6.5",
    "graphql": "^14.2.1",
    "graphql-tag": "^2.10.1",
    "jsonwebtoken": "^9.0.2",
    "vue": "^2.6.10",
    "vuetify": "^1.5.5",
    "vuex": "^3.0.1"
  },
  "devDependencies": {
    "@vue/cli-plugin-babel": "^3.6.0",
    "@vue/cli-plugin-eslint": "^3.6.0",
    "@vue/cli-service": "^3.6.0",
    "babel-eslint": "^10.0.1",
    "eslint": "^5.16.0",
    "eslint-plugin-vue": "^5.0.0",
    "stylus": "^0.54.5",
    "stylus-loader": "^3.0.1",
    "vue-cli-plugin-vuetify": "^0.5.0",
    "vue-template-compiler": "^2.5.21",
    "vuetify-loader": "^1.0.5"
  }
}


```

## Iniciar Projeto
```
npm install
npm install --legacy-peer-deps
```

### Compiles and hot-reloads for development
```
npm run serve
```

# Usuários com premisão de realizar alterações

## Master
```
email: master@jotaempresa.com,
senha: Master@123
```
## Dev
```
email: dev@jotaempresa.com,
senha: Dev@123
```
## Administrador
```
email: admin@jotaempresas.com
senha: Admin@123
```
## Usuário sem permissão
email: user@jotaempresas.com
senha: User@123
```

