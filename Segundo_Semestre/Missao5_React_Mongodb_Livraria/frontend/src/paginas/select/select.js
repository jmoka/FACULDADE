import axios from "axios";
import React from "react";
import './select.css'

const baseURL = "http://localhost:3001";

export default function App() {
  const [posts, setPosts] = React.useState([]);

  React.useEffect(() => {
    axios.get(`${baseURL}/todos`).then((response) => {
     
      setPosts(response.data.useLivraria.docs);
    });
  }, []);

  if (posts.length === 0) {
    return <div>Loading...</div>;
  }

  return (
    <div className="div1">
      <h1>Livros</h1>
      {posts.map((post) => (
        <div  className="div2" key={post._id}>
          <h2 >{post.titulo}</h2>
         
          <p  className="div2">{post.resumo}</p>
          <p>{post.editora}</p>
          <p>{post.autores.join(", ")}</p>
        
        </div>
      ))}

      
    </div>
  );
}
