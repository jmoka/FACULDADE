// Importa o módulo de banco de dados configurado
const db = require("@data/db");

// Importa a função `format` da biblioteca `date-fns` para formatar datas
const { format } = require("date-fns");

// Define a função assíncrona `UsuarioID` que busca um usuário pelo ID
async function UsuarioID(id) {
    try {
        // Consulta no banco de dados "usuarios" com um left join na tabela "perfis"
        const usuarioID = await db("usuarios")
            .leftJoin("perfis", "usuarios.perfil", "=", "perfis.id") // Usa leftJoin para incluir usuários sem perfil
            .select(
                "usuarios.id",
                "usuarios.nome",
                "usuarios.email",
                "usuarios.status",
                "usuarios.data_criacao",
                "perfis.nome as perfil_nome",  // Nome do perfil
                "perfis.rotulo as perfil_rotulo" // Rótulo do perfil
            )
            .where({ "usuarios.id": id }) // Filtra por ID do usuário
            .first(); // Retorna apenas o primeiro registro

        if (!usuarioID) {
            throw new Error("Não foi possível retornar nenhum usuário com esse ID");
        }

        // Formata o resultado no formato esperado pelo GraphQL
        const resultado = {
            id: usuarioID.id,
            nome: usuarioID.nome,
            email: usuarioID.email,
            status: usuarioID.status,
            dataCriacao: format(new Date(usuarioID.data_criacao), 'yyyy-MM-dd HH:mm:ss'), // Formata a data
            perfil: {
                nome: usuarioID.perfil_nome || "Perfil não definido", // Retorna texto padrão se não houver perfil
                rotulo: usuarioID.perfil_rotulo || "Rótulo não definido" // Retorna texto padrão se não houver rótulo
            }
        };

        return resultado; // Retorna o usuário formatado
    } catch (error) {
        // Exibe uma mensagem de erro no console
        console.error("Erro ao buscar usuário:", error.message);
        // Lança uma exceção com mensagem específica
        throw new Error("Não foi possível retornar o usuário com esse ID.");
    }
}

// Define outra função assíncrona `Usuario_ID` que também busca um usuário pelo ID
async function Usuario_ID(id) {
    try {
        // Consulta no banco de dados "usuarios" com um left join na tabela "perfis"
        const UsuarioSelecionado = await db("usuarios")
            .leftJoin("perfis", "usuarios.perfil", "=", "perfis.id")
            .select(
                "usuarios.id",
                "usuarios.nome",
                "usuarios.email",
                "usuarios.status",
                "usuarios.perfil",
                "perfis.nome as perfil_nome",  // Nome do perfil
                "perfis.rotulo as perfil_rotulo", // Rótulo do perfil
                "usuarios.data_criacao"
            )
            .where({ "usuarios.id": id-- }) // Filtra por ID do usuário e usa decremento de ID (pode ser desnecessário)
            .first(); // Retorna apenas o primeiro registro

        if (!UsuarioSelecionado) {
            throw new Error("Não foi possível retornar nenhum usuário com esse ID");
        }

        // Formata o resultado no formato esperado pelo GraphQL
        const usuarioCadastrado = {
            id: UsuarioSelecionado.id,
            nome: UsuarioSelecionado.nome,
            email: UsuarioSelecionado.email,
            status: UsuarioSelecionado.status,
            perfil: {
                id: UsuarioSelecionado.id,
                nome: UsuarioSelecionado.perfil_nome,
                rotulo: UsuarioSelecionado.perfil_rotulo
            },
            dataCriacao: UsuarioSelecionado.data_criacao
        };

        return usuarioCadastrado; // Retorna o usuário formatado
    } catch (error) {
        // Exibe uma mensagem de erro no console
        console.error("Erro ao buscar usuário:", error.message);
        // Lança uma exceção com mensagem específica
        throw new Error("Não foi possível retornar o usuário com esse ID.");
    }
}

// Exporta as funções `UsuarioID` e `Usuario_ID` para serem utilizadas em outros módulos
module.exports = {
    UsuarioID,
    Usuario_ID
};
