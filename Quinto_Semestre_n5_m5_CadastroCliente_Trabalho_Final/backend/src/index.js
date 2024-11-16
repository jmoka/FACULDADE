// Importa o ApolloServer e gql do pacote 'apollo-server'
// ApolloServer é usado para criar o servidor GraphQL
import { ApolloServer, gql } from 'apollo-server';

// Importa a função 'importSchema' do pacote 'graphql-import' para importar esquemas GraphQL de arquivos separados
import { importSchema } from 'graphql-import';

// Importa os resolvers que contêm a lógica para resolver as operações GraphQL
import resolvers from './resolvers/index.js';  // Verifique o caminho correto e extensão do arquivo

// Importa uma função que cria o banco de dados, possivelmente inicializando a base de dados
import { criarBaseDados } from "./utils/criarDB.js";  // Verifique o caminho correto e extensão do arquivo

// Importa o contexto que será usado no Apollo Server, como informações de autenticação ou outros dados compartilhados
import context from "./utils/context.js";  // Verifique o caminho correto e extensão do arquivo

// Caminho do arquivo que contém o esquema GraphQL
const schemaPath = './src/schema/index.graphql';  // Verifique o caminho correto

// Cria uma nova instância do ApolloServer com a configuração necessária
const server = new ApolloServer({
    // Define os tipos de dados e operações permitidas no GraphQL, importando o esquema do arquivo especificado
    typeDefs: importSchema(schemaPath),

    // Define os resolvers que irão tratar as operações especificadas no esquema
    resolvers,

    // Configura o contexto para incluir o objeto de requisição, útil para autenticação e outras informações
    context: ({ req }) => {
        // Aqui, você pode adicionar informações adicionais ao contexto, como autenticação
        return { req, user: req.user }; // Exemplo de como adicionar usuário ao contexto
    },
});

// Chama a função para criar o banco de dados
criarBaseDados();

// Inicia o servidor na porta 4000 e imprime a URL onde ele está sendo executado
server.listen({ port: 4001 }).then(({ url }) => {
    console.log(`Servidor GraphQL rodando em ${url}`);
});
