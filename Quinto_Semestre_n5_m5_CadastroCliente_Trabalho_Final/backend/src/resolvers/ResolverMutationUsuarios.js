
const db = require("../database/config");  // Importa o módulo de banco de dados, facilitando operações no banco de dados.
const loginUsuario = require("../model/Mutations/Usuarios/mutation/logarUsuario_mutation");  // Importa a função de login de usuário.
const { novoUsuario } = require("../model/Mutations/Usuarios/mutation/novoUsuario_mutation");  // Importa a função de criação de novo usuário.
const { alterarUsuario } = require("../model/Mutations/Usuarios/mutation/atualizarUsuario_mutation");  // Importa a função de atualização de dados do usuário.
const { excluirUsuario } = require("../model/Mutations/Usuarios/mutation/excluirUsuario_mutation");  // Importa a função de exclusão de usuário.
const { extrairObjDecoder } = require("../services/extrairContext");  // Importa a função para extrair informações do contexto do objeto (possivelmente usado para decodificação).

module.exports = {

    // Função de mutação para criar um novo usuário
    novoUsuario(_, { user }, req) {
        // Chama a função 'novoUsuario' passando os dados do usuário e o contexto da requisição
        return novoUsuario(user, req);
    },

    // Função de mutação para alterar os dados de um usuário existente
    alterarUsuario(_, { user, filtro }) {
        // Chama a função 'alterarUsuario' passando os dados do usuário e o filtro para identificar o usuário a ser alterado
        return alterarUsuario(user, filtro);
    },

    // Função de mutação para excluir um usuário
    excluirUsuario(_, { filtro }) {
        // Chama a função 'excluirUsuario' passando o filtro para identificar o usuário a ser excluído
        return excluirUsuario(filtro);
    },

    // Função de mutação para fazer login de um usuário
    loginUsuario(_, { dados }, { req }) {
        // Chama a função 'loginUsuario' passando os dados de login e o contexto da requisição
        return loginUsuario(dados, req);
    }
}
