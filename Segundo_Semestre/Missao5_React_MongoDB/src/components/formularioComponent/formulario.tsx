import React, { useState } from "react";
import { Conectar, FecharConexao } from '../MongoDbComponent/ConexaoMongoDB'



export default function Formulario(){
  const [titulo, setTitulo] = useState("")
  const [editora, setEditora] = useState("")
  const [autores, setAutores] = useState("")
  const [resumo, setResumo] = useState("")

  
  
  return (
    <>
      <form>
        <div className="mb-3">
          <label className="form-label">Título</label>
          <input
            type="text"
            className="form-control"
            placeholder="Digite o Título"
            value={titulo}
            />
        </div>

        <div className="form-group">
    <label className="exampleFormControlSelect1">Editora</label>
    <select value={editora} className="form-control" id="exampleFormControlSelect1">
      <option>editora 5</option>
      <option>editora 1</option>
      <option>editora 3</option>
      <option>editora 4</option>
      <option>editora 5</option>
      <option>Outra</option>
    </select>
  </div>

        <div className="mb-3">
          <label className="form-label">Autores</label>
          <input
          value={autores}
            type="text"
            className="form-control"
            placeholder="Digite a Editora"        
          />
        </div>

        <div className="form-group">
            <label className="exampleFormControlTextarea1">Resumo</label>
            <textarea value={resumo} className="form-control" id="exampleFormControlTextarea1" ></textarea>
      </div> 
       
      </form>
    
      
 </>  
 
  );
}
  
