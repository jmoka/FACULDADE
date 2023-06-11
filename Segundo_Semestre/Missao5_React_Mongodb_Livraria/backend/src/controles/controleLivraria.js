const mongoose = require('mongoose');
const Livraria = mongoose.model('useLivraria')

module.exports ={
    async insert (req, res){
         const useLivraria = await Livraria.create(req.body);       
        return res.json(useLivraria)
    },
    async todos (req, res){
        const {page} = req.query;
        const useLivraria = await Livraria.paginate({},{page, limit:20});       
        return res.json(useLivraria.docs);
        
    },
    async registro (req, res){
        const useLivraria = await Livraria.findById(req.params.id);       
        return res.json({useLivraria})
    },
    async atualizar (req, res){
        const useLivraria = await Livraria.findByIdAndUpdate(req.params.id, req.body, {new:true});       
        return res.json({useLivraria})
    },
}