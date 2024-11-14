### 1 - Instalações importantes

- Nuxt

```bash
 npx nuxi@latest init gerenciamentoUsuarios_n5m5
```

- Apollo Server

```bash
npm install @apollo/client graphql
```

### 2 - Dependencias

- Em produção

```bash
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
  }

```

- Em Desenvolvimento

```bash
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
```

- package.json

```bash
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

### 3 - Apagar os componentes de do nuxt padrão

### Criar a pasta para as paginas `pages`

### Criar pasta `Plugins`

- Criar o `Plugin` para conexao com `Graphql` e `Apollo-Serve`

```bash
// ./src/plugins/graphql.js
import Vue from "vue";
import ApolloClient from 'apollo-client'; // Importação padrão
import { InMemoryCache } from 'apollo-cache-inmemory'; // Importação nomeada
import { createHttpLink } from "apollo-link-http"; // Importação nomeada
import { setContext } from "apollo-link-context"; // Importação nomeada



// Monta a instância do Vue com o ApolloProvider
const httpLink = createHttpLink({
    uri: 'http://localhost:4000', // URL do servidor GraphQL
});

// Apollo Link para adicionar o header de autenticação
const authLink = setContext((_, { headers }) => {
    // Obtenha o token de autenticação do armazenamento local, se existir
    const token = localStorage.getItem('token');
    // Retorne os cabeçalhos ao contexto para que httpLink possa lê-los
    return {
        headers: {
            ...headers,
            authorization: token ? `Bearer ${token}` : "",
        }
    };
});

// Instância do Apollo Client
const apolloClient = new ApolloClient({
    link: authLink.concat(httpLink), // Concatenar authLink e httpLink
    cache: new InMemoryCache(),
});

// Instalação do plugin do Apollo Client no Vue
Vue.prototype.$api = apolloClient;

// Exporta a instância do Apollo Client
export default apolloClient;

```

- Cria o plugin do `Vuetify`

```bash
// Configuração Padão
import Vue from 'vue'
import Vuetify from 'vuetify/lib'
import 'vuetify/src/stylus/app.styl'

Vue.use(Vuetify, {
  iconfont: 'md',
  theme: {
    primary: '#1976D2',
    secondary: '#424242',
    accent: '#82B1FF',
    error: '#FF5252',
    info: '#2196F3',
    success: '#4CAF50',
    warning: '#FFC107'
  }
})


```
