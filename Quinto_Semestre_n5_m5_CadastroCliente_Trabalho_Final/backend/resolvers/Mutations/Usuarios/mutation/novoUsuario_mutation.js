const db = require("@data/db");  // Importa o módulo de banco de dados
const validarEmail = require("@data/validacoes/ValidarUsuarios/validarEmail");  // Importa a função de validação de email
const { Usuario_ID } = require("../../../Types/Usuarios/consultar/usuarioID");  // Importa a função para consultar o ID do usuário
const { criarHash } = require("../../../../autenticacao/hash");  // Importa a função para criar hash da senha
const perfilDefault = 3;  // Define um perfil padrão (pode ser utilizado se o perfil não for fornecido)
const Token = require("../../../../autenticacao/token");  // Importa o módulo para gerar tokens JWT

module.exports = {
    // Função para cadastrar um novo usuário
    async novoUsuario(user, req) {
        try {

            // Verifica se o e-mail já está cadastrado no banco de dados
            const emailExistente = await validarEmail(user.email);

            // Se o email já estiver registrado, lança um erro
            if (emailExistente) {
                console.log(`Usuário já cadastrado com esse email: ${user.email}`);
                throw new Error(`Usuário já cadastrado com esse email: ${user.email}`);
            }

            // Cria o hash da senha fornecida para garantir a segurança
            const senhaHash = await criarHash(user.senha);

            // Cria o objeto de usuário que será inserido no banco de dados
            let UsuarioEnviado = {
                nome: user.nome,  // Nome do usuário
                email: user.email,  // E-mail do usuário
                senha: senhaHash,  // Senha hash do usuário
                perfil: user.perfil || 4,  // Define o perfil do usuário, usa 4 como padrão se não for fornecido
                status: user.status || "ATIVO"  // Define o status do usuário, usa "ATIVO" como padrão se não for fornecido
            };

            // Insere o novo usuário no banco de dados
            const usuarioInserido = await db('usuarios').insert(UsuarioEnviado);

            // Se não for possível inserir o usuário, lança um erro
            if (!usuarioInserido) throw new Error("Erro ao inserir usuario");

            // Recupera o usuário inserido usando a função Usuario_ID
            const usuario = await Usuario_ID(...usuarioInserido);

            // Exibe no console a confirmação de cadastro do usuário
            console.log(`Usuário com ID: ${usuario.id} e Nome: ${user.nome} cadastrado com sucesso!`);

            // Gera o token JWT para o usuário recém-criado
            const token = Token.gerarToken(usuario);

            // Se o token não for gerado corretamente, lança um erro
            if (!token) throw new Error("Token Invalido");

            // Adiciona o token ao cabeçalho da requisição para autenticação futura
            req.headers = {
                authorization: `Bearer ${token}`
            };

            // Retorna o objeto do usuário inserido
            return usuario;

        } catch (error) {
            // Caso ocorra algum erro, lança uma exceção com a mensagem do erro
            throw new Error(`Erro ao criar usuário: ${error.message}`);
        }
    }
};
