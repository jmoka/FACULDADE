const db = require("@data/db");  // Importa o módulo de banco de dados para realizar operações no banco.
const validarEmail = require("@data/validacoes/ValidarUsuarios/validarEmail");  // Função para validar se o e-mail é válido.
const validarIdUsuarios = require("@data/validacoes/ValidarUsuarios/validarID");  // Função para validar o ID do usuário.
const validarNomeUsuarios = require("@data/validacoes/ValidarUsuarios/validarNome");  // Função para validar o nome do usuário.

module.exports = {
    // Função para excluir um usuário com base em um filtro (id, nome ou email)
    async excluirUsuario(filtro) {
        const { id } = filtro;  // Desestrutura o filtro para pegar o id, nome ou email do usuário a ser excluído.

        let usuarioEncontrado;  // Variável que irá armazenar o usuário encontrado no banco de dados.

        // Verifica se o filtro contém o id e, se sim, valida e realiza a busca do usuário pelo ID
        if (id) {
            // Valida o ID do usuário
            await validarIdUsuarios(id);

            // Busca o usuário pelo ID no banco de dados
            usuarioEncontrado = await db("usuarios").where({ id }).first();

            console.log(usuarioEncontrado);  // Imprime o usuário encontrado no console para depuração.

            // Se o usuário não for encontrado, lança um erro
            if (!usuarioEncontrado) {
                throw new Error(`Usuario com Id ${id} não encontrado!!`);
            }

            // Remove o usuário da tabela 'usuarios'
            await db("usuarios").where({ id }).del();
        }


        // Após excluir o usuário, busca o perfil do usuário excluído
        const perfil = await db("perfis").where({ id: usuarioEncontrado.perfil }).first();

        // Cria o objeto de retorno com os dados do usuário excluído e do perfil associado
        const retorno = {
            id: usuarioEncontrado.id,  // ID do usuário excluído
            nome: usuarioEncontrado.nome,  // Nome do usuário excluído
            email: usuarioEncontrado.email,  // E-mail do usuário excluído
            status: usuarioEncontrado.status,  // Status do usuário (ativo, inativo)
            dataCriacao: usuarioEncontrado.data_criacao,  // Data de criação do usuário
            perfil: {
                id: perfil.id,  // ID do perfil associado
                nome: perfil.nome,  // Nome do perfil associado
                rotulo: perfil.rotulo  // Rótulo do perfil associado
            }
        };

        // Imprime no console que o usuário foi deletado com sucesso
        console.log(`Usuário com ID: ${retorno.id} e Nome: ${retorno.nome} Deletado com sucesso!! `);

        // Retorna os dados do usuário excluído com os detalhes do perfil
        return retorno;
    },
};
