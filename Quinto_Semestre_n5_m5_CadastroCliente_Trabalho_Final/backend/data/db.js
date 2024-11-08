require('dotenv').config(); // Carregar variáveis de ambiente
const knex = require('knex'); // importa o knex
const config = require('../knexfile.js'); // atribui a variavel config as o arquivo knexfile.js 

const env = process.env.NODE_ENV || 'production'; // Pega o ambiente ou usa 'development' como padrão

// Verifica se o ambiente é 'DESENVOLVIMENTO' para mostrar logs adicionais
if (env === 'development') {
    console.log(`Usando o ambiente: ${env} ( Está em Desenvolvimento)`);
}
// Verifica se o ambiente é 'PRODUÇÃO' para mostrar logs adicionais
if (env === 'production') {
    console.log(`Usando o ambiente: ${env} ( Está em Produção)`);
}

let db;

try {
    db = knex(config[env]);
    console.log(`Banco de Dados Conectado`);
} catch (error) {
    console.error('Erro ao conectar ao banco de dados:', error.message);
    process.exit(1); // Encerra o processo com erro
}

module.exports = db; // Exporta a conexão para ser usada em outros módulos
