import Vue from 'vue'
import './plugins/vuetify' // Importa a configuração do Vuetify para estilização dos componentes
import App from './app.vue' // Importa o componente principal da aplicação
import store from './store' // Importa o Vuex para gerenciamento de estado
import apolloProvider from './plugins/graphql' // Importa a configuração do Apollo GraphQL para consultas e manipulação de dados

Vue.config.productionTip = false // Desabilita a mensagem de aviso de produção no console

new Vue({
    // Configura o Apollo Provider para integrar GraphQL na aplicação
    apolloProvider,
    // Configura o Vuex para gerenciamento de estado
    store,
    // Renderiza o componente principal App.vue
    render: h => h(App)
}).$mount('#app') // Monta a aplicação no elemento com o id 'app'
