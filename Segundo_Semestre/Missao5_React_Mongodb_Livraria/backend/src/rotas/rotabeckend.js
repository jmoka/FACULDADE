const express = require('express');

const rotabeckend = express.Router();
const controleLivraria = require('../controles/controleLivraria');



rotabeckend.post('/insert', controleLivraria.insert);

rotabeckend.get('/all', controleLivraria.all);
rotabeckend.post('/teste', controleLivraria.tes);

module.exports = rotabeckend    