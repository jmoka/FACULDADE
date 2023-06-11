import axios from "axios";
import React, { useEffect, useState } from "react";

const baseURL = "http://localhost:3001/home/sistema";

export default function App() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios.get(baseURL)
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

  const createPost = () => {
    axios.post(baseURL, {
      titulo: "Cupu Gay",
      resumo: "Cupu Gay zão",
      editora: "edira",
      autores: ["aures"],
      exposto: true
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
      <button onClick={createPost}>Create Post</button>
    </div>
  );
}
