
const express = require('express');
const mongoose = require('mongoose');
const requireDir = require('require-dir');
const cors = require('cors');


const app =express()
app.use(express.json());
app.use(cors());
requireDir('./src/modelos')
app.use('/home', require('./src/rotas/rotabeckend'))
app.listen(3001)

// "mongodb+srv://jota:jota1979@n2m5.4m694ph.mongodb.net/"

//!* Conexão banco de dados
  const conexao=(() => {
<<<<<<< HEAD
    try {     
        // const url = 'mongodb+srv://jota:jota1979@mongodb.bn8l1m2.mongodb.net/ ';
        const url = 'mongodb+srv://jota:jota1979@n2m5.4m694ph.mongodb.net/';
=======
    try {      
        const url = "mongodb+srv://jota:jota1979@n2m5.4m694ph.mongodb.net/";
>>>>>>> cf7952ee8ed16e9a63834d6bc5516a35aba05c1d
       
        mongoose.connect(url, {socketTimeoutMS: 30000}, {useNewUrlParser: true})
        console.log("Banco de dados Conectado")
        
    } catch (error) {
        console.log(error, "Erro ao Conectar")
        throw error;        
    }
})


console.log("Buscando Conexão...")
conexao()





