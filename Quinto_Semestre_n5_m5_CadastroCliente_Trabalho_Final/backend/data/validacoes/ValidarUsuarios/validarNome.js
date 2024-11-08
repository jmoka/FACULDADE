const db = require('@data/db');
async function validarNomeUsuarios(nome) {
    try {
        const usuario = await db("usuarios").where({ nome: nome })
        if (usuario.length > 0) {
            return true
        } else {
            return false
        }
    } catch (error) {
        throw new Error("Informe um valor válido");
    }
}
module.exports = validarNomeUsuarios;
