const mongoose  = require('mongoose');
const mongoosePaginate = require('mongoose-paginate')

const livrariaSchema= new mongoose.Schema({
    titulo: {
        type: String,
        required: false,
        upperCase: true,
        minlength: 3,
        maxlength: 255,
        inique: true,
    },
    resumo: {
        type: String,
        required: false,
        upperCase: true,
        minlength: 3,
        maxlength: 255,
    },
    editora: {
        type: String,
        required: false,
        upperCase: true,
        minlength: 3,
        maxlength: 255,
    },
    autores: [{
        type: String,
        required: false,
        upperCase: true,
          }],
    exposto: {
        type: Boolean,
        required: false,
        default: true,        
    },
    registro: {
        type: Date,
        default: Date.now
       
    },

});
livrariaSchema.plugin(mongoosePaginate)

mongoose.model('useLivraria',livrariaSchema)