const express = require('express');

const rotabeckend = express.Router();
const controleLivraria = require('../controles/controleLivraria');



rotabeckend.post('/insert', controleLivraria.insert);
rotabeckend.get('/todos', controleLivraria.todos);
rotabeckend.get('/registro/:id', controleLivraria.registro);
rotabeckend.put('/atualizar/:id', controleLivraria.atualizar);

module.exports = rotabeckend    