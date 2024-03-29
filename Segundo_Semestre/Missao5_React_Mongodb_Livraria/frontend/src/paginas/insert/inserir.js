import axios from "axios";
import React, { useEffect, useState } from "react";

const baseURL = "http://localhost:3001/home/sistema";

export function criarlivro(data) {
  return axios
    .post(baseURL, data)
    .then((response) => {
      if (response.data.docs) {
        console.log(response.data.docs);
        return response.data.docs;
      } else {
        console.log("Erro: response.data.docs é undefined");
        return null;
      }
    })
    .catch((error) => {
      console.log(error);
      return null;
    });
}

export default function Inserir(props) {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios
      .get(baseURL)
      .then((response) => {
        console.log(response.data.docs);
        setPosts(response.data.docs);
        setLoading(false);
      })
      .catch((error) => {
        console.log(error);
        setLoading(false);
      });
  }, []);

<<<<<<< HEAD:Segundo_Semestre/Missao5_React_Mongodb_Livraria/frontend/src/paginas/insert/inserir.js
=======
  const createPost = (json) => {
    axios.post(baseURL, {
      // titulo: "Cupu Gay",
      // resumo: "Cupu Gay zão",
      // editora: "edira",
      // autores: ["aures"],
      // exposto: true
      json
    })
    .then((response) => {
      if (response.data.docs) {
        console.log(response.data.docs);
        setPosts([...posts, response.data.docs]);
      } else {
        console.log("Erro: response.data.docs é undefined");
      }
    })
    .catch((error) => {
      console.log(error);
    });
  };

>>>>>>> cf7952ee8ed16e9a63834d6bc5516a35aba05c1d:Segundo_Semestre/Missao5_React_Mongodb_Livraria/frontend/src/paginas/insert/insert.js
  if (loading) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h1>Livros</h1>
      {posts.length === 0 ? (
        <div>No posts!</div>
      ) : (
        posts.map((post) => (
          <div key={post._id}>
            <h2>{post.titulo}</h2>
            <p>{post.resumo}</p>
            <p>{post.editora}</p>
            <p>{post.autores.join(", ")}</p>
          </div>
        ))
      )}
      <button onClick={() => criarlivro(props)}>Criar Postagem</button>
    </div>
  );
}