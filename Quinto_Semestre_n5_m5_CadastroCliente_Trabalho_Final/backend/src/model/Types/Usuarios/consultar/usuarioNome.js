// Importa o módulo de banco de dados configurado
const db = require("../../../../database/config");

// Importa a função `format` da biblioteca `date-fns` para formatar datas
const { format } = require("date-fns");

// Define a função assíncrona `UsuarioNome` que busca um usuário pelo nome
async function UsuarioNome(nome) {
    try {
        // Consulta no banco de dados "usuarios" com um left join na tabela "perfis"
        const usuarioNome = await db("usuarios")
            .leftJoin("perfis", "usuarios.perfil", "=", "perfis.id") // Usa leftJoin para incluir usuários sem perfil
            .select(
                "usuarios.id", // Seleciona o ID do usuário
                "usuarios.nome", // Seleciona o nome do usuário
                "usuarios.email", // Seleciona o e-mail do usuário
                "usuarios.status", // Seleciona o status do usuário
                "usuarios.data_criacao", // Seleciona a data de criação do usuário
                "perfis.nome as perfil_nome", // Seleciona o nome do perfil, se existir
                "perfis.rotulo as perfil_rotulo" // Seleciona o rótulo do perfil, se existir
            )
            .where({ "usuarios.nome": nome }) // Filtra por nome do usuário
            .first(); // Retorna apenas o primeiro registro encontrado

        // Se o usuário não for encontrado, lança um erro
        if (!usuarioNome) {
            throw new Error("Não foi possível retornar nenhum usuário com esse Nome == " + nome);
        }

        // Formata o resultado no formato esperado pelo GraphQL
        const resultado = {
            id: usuarioNome.id,
            nome: usuarioNome.nome,
            email: usuarioNome.email,
            status: usuarioNome.status,
            dataCriacao: format(new Date(usuarioNome.data_criacao), 'yyyy-MM-dd HH:mm:ss'), // Formata a data
            perfil: {
                nome: usuarioNome.perfil_nome || "Perfil não definido", // Retorna texto padrão se não houver perfil
                rotulo: usuarioNome.perfil_rotulo || "Rótulo não definido" // Retorna texto padrão se não houver rótulo
            }
        };

        return resultado; // Retorna o usuário formatado
    } catch (error) {
        // Lança uma exceção com mensagem específica
        throw new Error("Não foi possível retornar o usuário com esse Nome." + nome);
    }
}

// Exporta a função `UsuarioNome` para ser utilizada em outros módulos
module.exports = UsuarioNome;
