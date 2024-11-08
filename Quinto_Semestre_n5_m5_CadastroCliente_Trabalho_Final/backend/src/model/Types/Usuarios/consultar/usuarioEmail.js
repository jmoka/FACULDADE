// Importa o banco de dados configurado
const db = require("../../../../database/config");

// Importa a função `format` da biblioteca `date-fns` para formatação de datas
const { format } = require("date-fns");

// Define a função assíncrona que consulta o usuário pelo email
async function UsuarioEmail(email) {
    try {
        // Consulta o banco de dados "usuarios" com um left join na tabela "perfis"
        const usuarioEmail = await db("usuarios")
            .leftJoin("perfis", "usuarios.perfil", "=", "perfis.id") // Usa leftJoin para incluir usuários sem perfil
            .select(
                "usuarios.id",
                "usuarios.nome",
                "usuarios.email",
                "usuarios.senha",
                "usuarios.status",
                "usuarios.data_criacao",
                "perfis.nome as perfil_nome", // Nome do perfil
                "perfis.rotulo as perfil_rotulo" // Rótulo do perfil
            )
            .where({ "usuarios.email": email }) // Filtra pelo email informado
            .first(); // Retorna apenas o primeiro resultado

        // Verifica se o usuário foi encontrado e formata os dados para o formato esperado pelo GraphQL
        const resultado = {
            id: usuarioEmail.id,
            nome: usuarioEmail.nome,
            email: usuarioEmail.email,
            senha: usuarioEmail.senha,
            status: usuarioEmail.status,
            dataCriacao: format(new Date(usuarioEmail.data_criacao), 'yyyy-MM-dd HH:mm:ss'), // Formata a data
            perfil: {
                nome: usuarioEmail.perfil_nome,
                rotulo: usuarioEmail.perfil_rotulo
            }
        };

        return resultado;
    } catch (error) {
        // Exibe e lança um erro caso o usuário com o email informado não seja encontrado
        console.error("Usuario com email informado não está cadastrado!!");
        throw new Error("Usuario com email informado não está cadastrado!!");
    }
}

// Exporta a função para uso em outros módulos do projeto
module.exports = { UsuarioEmail }, UsuarioEmail;
