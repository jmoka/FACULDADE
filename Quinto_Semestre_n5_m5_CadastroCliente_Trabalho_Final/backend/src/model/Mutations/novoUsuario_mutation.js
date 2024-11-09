import db from "../../database/config.js";  // Importa o módulo de banco de dados
import validarEmail from "../../services/validarEmail.js";  // Importa a função de validação de email
import { Usuario_ID } from "../Types/usuarioID.js";  // Importa a função para consultar o ID do usuário
import { criarHash } from "../../services/hash.js";  // Importa a função para criar hash da senha
import Token from "../../services/token.js";  // Importa o módulo para gerar tokens JWT

const perfilDefault = 3;  // Define um perfil padrão (pode ser utilizado se o perfil não for fornecido)

export default {
    // Função para cadastrar um novo usuário
    async novoUsuario(user, req) {
        try {
            // Verifica se o e-mail já está cadastrado no banco de dados
            const emailExistente = await validarEmail(user.email);

            // Se o email já estiver registrado, lança um erro
            if (emailExistente) {
                throw new Error(`Usuário já cadastrado com esse email: ${user.email}`);
            }

            // Cria o hash da senha fornecida para garantir a segurança
            const senhaHash = await criarHash(user.senha);

            // Cria o objeto de usuário que será inserido no banco de dados
            const UsuarioEnviado = {
                nome: user.nome,  // Nome do usuário
                email: user.email,  // E-mail do usuário
                senha: senhaHash,  // Senha hash do usuário
                perfil: user.perfil || perfilDefault,  // Define o perfil do usuário, usa perfilDefault como padrão se não for fornecido
                status: user.status || "ATIVO"  // Define o status do usuário, usa "ATIVO" como padrão se não for fornecido
            };

            // Insere o novo usuário no banco de dados e obtém o usuário inserido
            const [usuarioInserido] = await db('usuarios').insert(UsuarioEnviado).returning('*');

            // Se não for possível inserir o usuário, lança um erro
            if (!usuarioInserido) throw new Error("Erro ao inserir usuário");

            // Recupera o usuário inserido usando a função Usuario_ID
            const usuario = await Usuario_ID(usuarioInserido.id);

            // Gera o token JWT para o usuário recém-criado
            const token = Token.gerarToken(usuario);

            // Se o token não for gerado corretamente, lança um erro
            if (!token) throw new Error("Falha ao gerar o token");

            // Adiciona o token ao cabeçalho da requisição para autenticação futura
            req.headers = {
                authorization: `Bearer ${token}`  // Adiciona o token ao cabeçalho para futuras requisições
            };

            // Retorna o objeto do usuário inserido junto com o token
            return { usuario, token };

        } catch (error) {
            // Caso ocorra algum erro, lança uma exceção com a mensagem do erro
            console.error(error);  // Loga o erro real para depuração
            throw new Error(`Erro ao criar usuário: ${error.message}`);  // Lança um erro genérico
        }
    }
};
