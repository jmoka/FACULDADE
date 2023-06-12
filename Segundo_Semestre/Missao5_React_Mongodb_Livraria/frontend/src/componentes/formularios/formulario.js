import React, { useState, useEffect } from "react";
import axios from "axios";

const baseURL = "http://localhost:3001/home/sistema";

export default function Formulario() {
  const [titulo, setTitulo] = useState("");
  const [resumo, setResumo] = useState("");
  const [editora, setEditora] = useState("");
  const [autores, setAutores] = useState("");
  const [exposto, setExposto] = useState(false);
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

  const handleSubmit = (e) => {
    e.preventDefault();

    const novoLivro = {
      titulo: titulo,
      resumo: resumo,
      editora: editora,
      autores: autores.split(","),
      exposto: exposto,
    };

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
    </div>
  );
}
