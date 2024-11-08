// Importa e registra o módulo `module-alias` para simplificar os caminhos de importação
require('module-alias/register')

// Importa o banco de dados com um alias configurado em `module-alias`
const db = require("@data/db")

// Importa funções que lidam com consultas específicas relacionadas a usuários
const TodosUsuarios = require("./consultar/todosUsuarios.js") // Consulta para buscar todos os usuários
const UsuarioNome = require("./consultar/usuarioNome.js")     // Consulta para buscar usuário por nome
const { UsuarioID } = require("./consultar/usuarioID.js")     // Consulta para buscar usuário por ID
const UsuarioLogado = require("./consultar/loginUsuario.js")  // Consulta para verificar se o usuário está logado
const UsuarioEmail = require("./consultar/usuarioEmail.js")   // Consulta para buscar usuário por email
const UsuarioEmailConsulta = require("./consultar/usuarioEmailConsulta.js") // Outra consulta por email

// Exporta as funções de consulta como resolvers para uso no sistema de GraphQL ou em outro contexto
module.exports = {
    // Retorna todos os usuários ao chamar a função TodosUsuarios
    usuarios() {
        return TodosUsuarios();
    },

    // Retorna um usuário com base no ID fornecido
    usuarioID(_, { id }) {
        return UsuarioID(id)
    },

    // Retorna um usuário com base no nome fornecido
    usuarioNome(_, { nome }) {
        return UsuarioNome(nome)
    },

    // Retorna um usuário com base no email fornecido
    usuarioEmail(_, { email }) {
        return UsuarioEmail(email)
    },

    // Retorna uma consulta específica de usuário com base no email
    usuarioEmailConsulta(_, { email }) {
        return UsuarioEmailConsulta(email);
    },

    // Retorna um usuário logado com base nos dados fornecidos (autenticação)
    UsuarioLogado(_, { dados }) {
        return UsuarioLogado(dados)
    }
}
