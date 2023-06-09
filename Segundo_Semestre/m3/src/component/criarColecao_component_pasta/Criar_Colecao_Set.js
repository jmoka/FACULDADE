import { Conectar, FecharConexao } from '../conexao_component_pasta/ConexaoMongoDB.js';

export async function CriarColecao(nomeColecao, nomeBanco, obj) {  
  try {
    // Conecta ao servidor do MongoDB
    const client = await Conectar();
    const db = client.db(nomeBanco);
    const collection = db.collection(nomeColecao);
    await collection.insertMany(obj);
    console.log(collection)
    console.log(`Coleção '${nomeColecao}' criada com sucesso.`);
  }catch{
    console.log(`Não foi criada a Coleção '${nomeColecao} verifique o Componente - Criar_Colecao_Set.js'`);
  } finally {
    // Fecha a conexão com o servidor
    await FecharConexao();
  }
}

