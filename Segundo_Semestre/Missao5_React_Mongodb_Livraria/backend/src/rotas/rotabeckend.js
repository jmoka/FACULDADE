const express = require('express');

const rotabeckend = express.Router();
const controleLivraria = require('../controles/controleLivraria');



rotabeckend.post('/sistema', controleLivraria.insert);
rotabeckend.get('/sistema', controleLivraria.todos);
rotabeckend.get('/sistema/:id', controleLivraria.registro);
rotabeckend.put('/sistema/:id', controleLivraria.atualizar);

module.exports = rotabeckend    