const mongoose = require('mongoose');
const Livraria = mongoose.model('useLivraria')

module.exports ={
    async insert (req, res){
         const useLivraria = await Livraria.create(req.body);
        console.log("HOME TESTE")
        return res.json(useLivraria)
    },
    async all (req, res){
        const page = req.query;
        const useLivraria = await Livraria.paginate({},{page, limit: 5});       
        return res.json({useLivraria})
    },
    async tes (req, res){
        // const useLivraria = await Livraria.get(req.body);
        return res.json({msg:"mensagem rota nova"})
    }
}