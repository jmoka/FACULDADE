// import {InserirObjeto} from "../adcionar_obj_componenet_pasta/incluir_arquivo_component.js"
// import {nomeBanco, nomeColecao} from "../criarColecao_component_pasta/Criar_Colecao_Get.js"
import React, { useState } from "react";

// Exemplo de uso:
export default function Formulario() {
    const [novoLivro, setNovoLivro] = useState({
        id: "",
        titulo: "",
        resumo:"",
        autor: "",
        editora: "",
      });


      return (
        <>
          <form>
            <div className="mb-3">
              <label className="form-label">Título</label>
              <input
                type="text"
                className="form-control"
                placeholder="Digite o Título"
                value={novoLivro.titulo}
                onChange={(e) =>
                  setNovoLivro({ ...novoLivro, titulo: e.target.value })
                }
              />
            </div>
            <div className="mb-3">
              <label className="form-label">Autor</label>
              <input
                type="text"
                className="form-control"
                placeholder="Digite o Autor"
                value={novoLivro.autor}
                onChange={(e) =>
                  setNovoLivro({ ...novoLivro, autor: e.target.value })
                }
              />
            </div>
            <div className="mb-3">
              <label className="form-label">Editora</label>
              <input
                type="text"
                className="form-control"
                placeholder="Digite a Editora"
                value={novoLivro.editora}
                onChange={(e) =>
                  setNovoLivro({ ...novoLivro, editora: e.target.value })
                }
              />
            </div>
            <button className="btn btn-primary" type="submit" >
              Adicionar Livro
            </button>
           
           
          </form>
    
          
          
     </>  

      )


}

//  InserirObjeto(nomeBanco, nomeColecao).catch(console.error);