const { UsuarioEmail } = require("../../../Types/Usuarios/consultar/usuarioEmail");  // Função para buscar usuário pelo e-mail
const Token = require("../../../../services/token");  // Módulo para gerar o token JWT
const AutenticarHash = require("../../../../services/hash");  // Função para autenticar a senha com hash


// Função principal para realizar o login do usuário
async function loginUsuario(dados, req) {
    // Erros personalizados para diferentes cenários
    const errSenhaEmail = new Error("Email ou senha não cadastrado!");  // Se o e-mail ou senha não estiverem corretos
    const erroInativo = new Error("Usuário Inativo");  // Se o usuário estiver inativo
    const erroUsuario = new Error("Usuário não Definido");  // Erro genérico para problemas de login

    try {

        // Desestrutura os dados recebidos (email e senha)
        const { email, senha } = dados;

        // Buscar o usuário no banco de dados pelo email
        const usuarioEncontrado = await UsuarioEmail(email);

        // Se o usuário não for encontrado, lança o erro de email ou senha inválidos
        if (!usuarioEncontrado) throw errSenhaEmail;

        // Verifica se o usuário está ativo. Se não, lança erro de usuário inativo
        if (usuarioEncontrado.status !== "ATIVO") throw erroInativo;

        // Verifica se a senha informada é válida comparando com o hash da senha armazenado
        const senhaValida = await AutenticarHash.autenticar(senha, usuarioEncontrado.senha);
        if (!senhaValida) throw errSenhaEmail;  // Se a senha não for válida, lança erro de email ou senha inválidos

        // Se tudo estiver correto, gera o token JWT para o usuário
        const token = Token.gerarToken(usuarioEncontrado);

        // Insere o token no cabeçalho da requisição para autenticação futura
        req.headers = {
            authorization: `Bearer ${token}`  // Adiciona o token como Bearer no cabeçalho
        }

        // Prepara os dados do token (tempo de emissão e expiração) para retornar junto com o usuário
        const dadosToken = {
            iat: token.iat,  // Data de emissão do token
            exp: token.exp,  // Data de expiração do token
            token: token.token  // O próprio token gerado
        }

        // Retorna o usuário encontrado junto com os dados do token
        return { ...usuarioEncontrado, ...dadosToken };

    } catch (e) {
        console.error(e);  // Log do erro real para depuração
        throw erroUsuario;  // Lança um erro genérico caso algo dê errado
    }
}

module.exports = loginUsuario;  // Exporta a função para uso em outros módulos
