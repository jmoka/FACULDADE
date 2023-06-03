import { MongoClient } from 'mongodb';

const url = 'mongodb+srv://jota:Jota1979@cluster0.njxge5v.mongodb.net/';

// Função para estabelecer a conexão com o banco de dados
async function Conectar() {
  try{
  const client = new MongoClient(url, { useUnifiedTopology: true });
  await client.connect();
  console.log('Conexão estabelecida com o banco de dados.');
  return client;
  }catch{
    console.log('Conexão Não estabelecida com o banco de dados Verificar Código - Bloco Conexão.js.');
  }
}

// Função para fechar a conexão com o banco de dados
async function FecharConexao() {
  try{
  const client = new MongoClient(url, { useUnifiedTopology: true });
  await client.close();
  console.log('Conexão com o banco de dados encerrada.');
  }catch{
    console.log('Houve Algum Problema e o Banco não fechou verificar Conexão com o banco de dados Bloco Conexao.js.');
  }
}

export { Conectar, FecharConexao };