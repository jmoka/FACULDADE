import React, { useState } from "react";
import Lista from '../listaFComponent/listaComponenet'

const livrosListagems = [{
    id: 1,
    titulo: "O livro 1",
    autor: "Autor 1",
    editora: "Editora 1",
  },
  {
    id: 2,
    titulo: "O livro 2",
    autor: "Autor 2",
    editora: "Editora 2",
  },
  {
    id: 3,
    titulo: "O livro 3",  
    autor: "Autor 3",
    editora: "Editora 3",
  }
];



export default function Formulario() {    
  const [Listagem, setLivrosListagems] = useState<{
    id: string | number;
    titulo: string;
    autor: string;
    editora: string;
  }[]>(livrosListagems);

  const [listaVisivel, setListaVisivel] = useState(false);

  const [novoLivro, setNovoLivro] = useState({
    id: "",
    titulo: "",
    autor: "",
    editora: "",
  });

  const handleSubmit = (e: { preventDefault: () => void; }) => {
    e.preventDefault();
  
    const novoId =
      Listagem.length > 0 ? Number(Listagem[Listagem.length - 1].id) + 1 : 1;
  
    setLivrosListagems([...Listagem, { ...novoLivro, id: novoId }]);
    setNovoLivro({
      id: "",
      titulo: "",
      autor: "",
      editora: "",
    });
  };

  const livrosCadastrados = () => {
    return Listagem.map((livro) => (
      <tr key={livro.id}>
        <th scope="row">{livro.id}</th>
        <td>{livro.titulo}</td>
        <td>{livro.editora}</td>
        <td>{livro.autor}</td>
      </tr>
    ));
  };
  <Lista livros={livrosCadastrados} />

  return (
    <>
      <form onSubmit={handleSubmit}>
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
        <button className="btn btn-primary" type="submit" onClick={() => setListaVisivel(true)} >
          Adicionar Livro
        </button>
       
        {listaVisivel && <Lista livros={livrosCadastrados} />}
      </form>

      
      
 </>  
 
  );
}