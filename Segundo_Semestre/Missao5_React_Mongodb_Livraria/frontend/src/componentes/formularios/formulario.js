import React, { useState } from "react";
import axios from "axios";

const baseURL = "http://localhost:3001/home/sistema";

export default function Formulario() {
  const [titulo, setTitulo] = useState("");
  const [resumo, setResumo] = useState("");
  const [editora, setEditora] = useState("");
  const [autores, setAutores] = useState("");
  const [exposto, setExposto] = useState(false);
  const [posts, setPosts] = useState([]);
  const [editingPostId, setEditingPostId] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();

    const novoLivro = {
      titulo: titulo,
      resumo: resumo,
      editora: editora,
      autores: autores.split(","),
      exposto: exposto,
    };

    if (editingPostId) {
      axios
        .put(`${baseURL}/${editingPostId}`, novoLivro)
        .then(() => {
          setPosts(
            posts.map((post) =>
              post._id === editingPostId ? { _id: editingPostId, ...novoLivro } : post
            )
          );
          setEditingPostId(null);
        })
        .catch((error) => {
          console.log(error);
        });
    } else {
      axios
        .post(baseURL, novoLivro)
        .then((response) => {
          console.log(response.data);
          setPosts([...posts, response.data]);
        })
        .catch((error) => {
          console.log(error);
        });
    }

    // Limpar os campos do formulário após o envio
    setTitulo("");
    setResumo("");
    setEditora("");
    setAutores("");
    setExposto(false);
  };

  const handleDelete = (id) => {
    axios
      .delete(`${baseURL}/${id}`)
      .then(() => {
        setPosts(posts.filter((post) => post._id !== id));
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleUpdate = (id) => {
    const selectedPost = posts.find((post) => post._id === id);
    if (selectedPost) {
      setTitulo(selectedPost.titulo);
      setResumo(selectedPost.resumo);
      setEditora(selectedPost.editora);
      setAutores(selectedPost.autores.join(","));
      setExposto(selectedPost.exposto);
      setEditingPostId(id);
    }
  };

  const handleShowAll = () => {
    axios
      .get(baseURL)
      .then((response) => {
        setPosts(response.data.docs);
      })
      .catch((error) => {
        console.log(error);
      });
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
        <button type="submit">{editingPostId ? "Atualizar" : "Criar Postagem"}</button>
      </form>
      <button onClick={handleShowAll}>Mostrar Todos</button>
      {posts.length === 0 ? (
        <div>Nenhum post!</div>
      ) : (
        posts.map((post) => (
          <div key={post._id}>
            <h2>{post.titulo}</h2>
            <p>{post.resumo}</p>
            <p>{post.editora}</p>
            <p>{post.autores.join(", ")}</p>
            <button onClick={() => handleDelete(post._id)}>Deletar</button>
            <button onClick={() => handleUpdate(post._id)}>Atualizar</button>
          </div>
        ))
      )}
    </div>
  );
}