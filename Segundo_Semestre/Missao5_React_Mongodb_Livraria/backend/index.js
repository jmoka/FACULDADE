
const express = require('express');
const mongoose = require('mongoose');
const requireDir = require('require-dir');
const cors = require('cors');


const app =express()
app.use(express.json());
app.use(cors());
requireDir('./src/modelos')
app.use('/', require('./src/rotas/rotabeckend'))
app.listen(27017)


//!* Conexão banco de dados
  const conexao=(() => {
    try {      
        const url = 'mongodb+srv://jota:jota1979@mongodb.bn8l1m2.mongodb.net/ ';
        const urll = 'mongodb://localhost:27017/'
        mongoose.connect(url, {useNewUrlParser: true})
        console.log("Banco de dados Conectado")
        
    } catch (error) {
        console.log(error, "Erro ao Conectar")
        throw error;        
    }
})


console.log("Buscando Conexão...")
conexao()




