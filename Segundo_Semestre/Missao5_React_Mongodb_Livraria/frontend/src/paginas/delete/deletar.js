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

  function deletaPost() {
    const id = "6482faabfe31e9dc5c781968"
    axios

      .delete(`${baseURL}/${id}`)
      .then(() => {
       
        alert("Registro Deletado!");
        // setPosts(null)
    
      })
      .catch((error) => {
        console.log(error);
      });
      }
    
  
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
      <button onClick={deletaPost}>Deletar</button>
    </div>
  );
}