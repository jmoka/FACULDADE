import axios from "axios";
import React from "react";

const baseURL = "http://localhost:3001/home/sistema";


export default function Atualizar() {
  const [posts, setPosts] = React.useState(null);
  const [loading, setLoading] = React.useState(true);

  React.useEffect(() => {
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

  function updatePost() {
    const id = "6482faabfe31e9dc5c781968"
    axios
      .put(`${baseURL}/${id}`, {
      titulo: "cosme e damião",
      resumo: "açãod de graças",
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
      <button onClick={updatePost}>Atualizar</button>
    </div>
  );
}