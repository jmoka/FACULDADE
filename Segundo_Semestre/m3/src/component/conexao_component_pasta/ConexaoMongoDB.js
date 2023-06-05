import { MongoClient } from 'mongodb';

const url = 'mongodb+srv://jota:jota1979@livraria.av4j4ri.mongodb.net/';
const client = new MongoClient(url);

// Função para estabelecer a conexão com o banco de dados
async function Conectar() {
  try {
    await client.connect();
    console.log('Conexão estabelecida com o banco de dados.');
    console.log(client.db);
    return client;
  } catch (error) {
    console.log('Conexão não estabelecida com o banco de dados. Verifique o código - Bloco Conexão.js.');
    throw error;
  }
}

// Função para fechar a conexão com o banco de dados
async function FecharConexao() {
  try {
    await client.close();
    console.log('Conexão com o banco de dados encerrada.');
  } catch (error) {
    console.log('Houve algum problema e o banco não fechou. Verifique a conexão com o banco de dados no bloco Conexao.js.');
    throw error;
  }
}

export { Conectar, FecharConexao };
