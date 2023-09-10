<<<<<<< HEAD
import React, { useState } from "react";
// import {
//   criarlivro,
//   deletarlivro,
//   atualizarlivro,
//   buscarlivro,
// } from "../../paginas/insert/cruds";

import {criarlivro,} from "../../paginas/insert/inserir";
import {atualizarlivro} from "../../paginas/update/atualizar";
import {deletarlivro} from "../../paginas/delete/deletar";
import {buscarlivro} from "../../paginas/select/selecionar";
=======
import React, { useState, useEffect } from "react";
import axios from "axios";

const baseURL = "http://localhost:3001/home/sistema";
>>>>>>> cf7952ee8ed16e9a63834d6bc5516a35aba05c1d

export default function Formulario() {
  const [titulo, setTitulo] = useState("");
  const [resumo, setResumo] = useState("");
  const [editora, setEditora] = useState("");
  const [autores, setAutores] = useState("");
  const [exposto, setExposto] = useState(false);
<<<<<<< HEAD
  const [idDeletar, setIdDeletar] = useState("");
  const [idAtualizar, setIdAtualizar] = useState("");
  const [novoTitulo, setNovoTitulo] = useState("");
  const [novoResumo, setNovoResumo] = useState("");
  const [novaEditora, setNovaEditora] = useState("");
  const [novosAutores, setNovosAutores] = useState("");
  const [novoExposto, setNovoExposto] = useState(false);
  const [termoBusca, setTermoBusca] = useState("");
  const [livrosEncontrados, setLivrosEncontrados] = useState([]);
=======
  const [posts, setPosts] = useState([]);
  const [id_Livro, setid_Livro] = useState(null);

  useEffect(() => {
    fetchPosts();
  }, []);

  const fetchPosts = () => {
    axios
      .get(baseURL)
      .then((response) => {
        setPosts(response.data.docs);
      })
      .catch((error) => {
        console.log(error);
      });
  };
>>>>>>> cf7952ee8ed16e9a63834d6bc5516a35aba05c1d

  const handleSubmit = (e) => {
    e.preventDefault();

    const novoLivro = {
      titulo: titulo,
      resumo: resumo,
      editora: editora,
      autores: autores.split(","),
      exposto: exposto,
    };

<<<<<<< HEAD
    criarlivro(novoLivro)
      .then((response) => {
        console.log("Livro cadastrado com sucesso!");
      })
      .catch((error) => {
        console.log("Erro ao cadastrar o livro:", error);
      });
  };

  const handleDelete = (e) => {
    e.preventDefault();

    deletarlivro(idDeletar)
      .then((response) => {
        console.log("Livro deletado com sucesso!");
      })
      .catch((error) => {
        console.log("Erro ao deletar o livro:", error);
      });
  };

  const handleUpdate = (e) => {
    e.preventDefault();

    const livroAtualizado = {
      titulo: novoTitulo,
      resumo: novoResumo,
      editora: novaEditora,
      autores: novosAutores.split(","),
      exposto: novoExposto,
    };

    atualizarlivro(idAtualizar, livroAtualizado)
      .then((response) => {
        console.log("Livro atualizado com sucesso!");
      })
      .catch((error) => {
        console.log("Erro ao atualizar o livro:", error);
      });
  };

  const handleSearch = (e) => {
    e.preventDefault();

    buscarlivro(termoBusca)
      .then((response) => {
        console.log("Livros encontrados:", response.data);
        setLivrosEncontrados(response.data);
      })
      .catch((error) => {
        console.log("Erro ao buscar os livros:", error);
      });
=======
    if (id_Livro) {
      axios
        .put(`${baseURL}/${id_Livro}`, novoLivro)
        .then(() => {
          fetchPosts(); // Refetch posts after updating
          setid_Livro(null);
          limparFormulario();
        })
        .catch((error) => {
          console.log(error);
        });
    } else {
      axios
        .post(baseURL, novoLivro)
        .then(() => {
          fetchPosts(); // Refetch posts after creating
          limparFormulario();
        })
        .catch((error) => {
          console.log(error);
        });
    }
  };

  const handleDeletar = (id) => {
    axios
      .delete(`${baseURL}/${id}`)
      .then(() => {
        fetchPosts(); // Refetch posts after deletion
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleDeletarAll = () => {
    axios
      .delete(baseURL)
      .then(() => {
        fetchPosts(); // Refetch posts after deletion
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleAtualizar = (id) => {
    const selectedPost = posts.find((post) => post._id === id);
    if (selectedPost) {
      setTitulo(selectedPost.titulo);
      setResumo(selectedPost.resumo);
      setEditora(selectedPost.editora);
      setAutores(selectedPost.autores.join(","));
      setExposto(selectedPost.exposto);
      setid_Livro(id);
    }
  };

  const limparFormulario = () => {
    setTitulo("");
    setResumo("");
    setEditora("");
    setAutores("");
    setExposto(false);
>>>>>>> cf7952ee8ed16e9a63834d6bc5516a35aba05c1d
  };

  return (
    <div>
      <h1>Livros</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Título:
          <input
            type="text"
            value={titulo}
            onChange={(e) => setTitulo(e.target.value)}
          />
        </label>
        <br />
        <label>
          Resumo:
          <textarea
            value={resumo}
            onChange={(e) => setResumo(e.target.value)}
          ></textarea>
        </label>
        <br />
        <label>
          Editora:
          <input
            type="text"
            value={editora}
            onChange={(e) => setEditora(e.target.value)}
          />
        </label>
        <br />
        <label>
          Autores:
          <input
            type="text"
            value={autores}
            onChange={(e) => setAutores(e.target.value)}
          />
        </label>
        <br />
        <label>
          Exposto:
          <input
            type="checkbox"
            checked={exposto}
            onChange={(e) => setExposto(e.target.checked)}
          />
        </label>
        <br />
<<<<<<< HEAD
        <button type="submit">Cadastrar Livro</button>
      </form>

      <form onSubmit={handleDelete}>
        <label>
          ID do livro a ser deletado:
          <input
            type="text"
            value={idDeletar}
            onChange={(e) => setIdDeletar(e.target.value)}
          />
        </label>
        <br />
        <button type="submit">Deletar Livro</button>
      </form>

      <form onSubmit={handleUpdate}>
        <label>
          ID do livro a ser atualizado:
          <input
            type="text"
            value={idAtualizar}
            onChange={(e) => setIdAtualizar(e.target.value)}
          />
        </label>
        <br />
        <label>
          Novo Título:
          <input
            type="text"
            value={novoTitulo}
            onChange={(e) => setNovoTitulo(e.target.value)}
          />
        </label>
        <br />
        <label>
          Novo Resumo:
          <textarea
            value={novoResumo}
            onChange={(e) => setNovoResumo(e.target.value)}
          ></textarea>
        </label>
        <br />
        <label>
          Nova Editora:
          <input
            type="text"
            value={novaEditora}
            onChange={(e) => setNovaEditora(e.target.value)}
          />
        </label>
        <br />
        <label>
          Novos Autores:
          <input
            type="text"
            value={novosAutores}
            onChange={(e) => setNovosAutores(e.target.value)}
          />
        </label>
        <br />
        <label>
          Novo Exposto:
          <input
            type="checkbox"
            checked={novoExposto}
            onChange={(e) => setNovoExposto(e.target.checked)}
          />
        </label>
        <br />
        <button type="submit">Atualizar Livro</button>
      </form>

      <form onSubmit={handleSearch}>
        <label>
          Termo de busca:
          <input
            type="text"
            value={termoBusca}
            onChange={(e) => setTermoBusca(e.target.value)}
          />
        </label>
        <br />
        <button type="submit">Buscar Livro</button>
      </form>

      <div>
        <h2>Livros encontrados:</h2>
        {livrosEncontrados.length === 0 ? (
          <div>Nenhum livro encontrado.</div>
        ) : (
          livrosEncontrados.map((livro) => (
            <div key={livro._id}>
              <h3>{livro.titulo}</h3>
              <p>{livro.resumo}</p>
              <p>{livro.editora}</p>
              <p>{livro.autores.join(", ")}</p>
              <p>Exposto: {livro.exposto ? "Sim" : "Não"}</p>
            </div>
          ))
        )}
      </div>
=======
        <button type="submit">{id_Livro ? "Atualizar" : "Criar Postagem"}</button>
        {id_Livro && (
          <>
            <button type="button" onClick={() => handleDeletar(id_Livro)}>Deletar</button>
            <button type="button" onClick={() => setid_Livro(null)}>Cancelar</button>
          </>
        )}
      </form>
      <button onClick={handleDeletarAll}>Deletar Todos</button>
      {posts.length === 0 ? (
        <div>Nenhum post!</div>
      ) : (
        posts.map((post) => (
          <div key={post._id}>
            <h2>{post.titulo}</h2>
            <p>{post.resumo}</p>
            <p>{post.editora}</p>
            <p>{post.autores.join(", ")}</p>
            <button onClick={() => handleDeletar(post._id)}>Deletar</button>
            <button onClick={() => handleAtualizar(post._id)}>Atualizar</button>
          </div>
        ))
      )}
>>>>>>> cf7952ee8ed16e9a63834d6bc5516a35aba05c1d
    </div>
  );
}
