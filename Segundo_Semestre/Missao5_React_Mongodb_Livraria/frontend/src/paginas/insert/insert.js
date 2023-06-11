import axios from "axios";
import React from "react";

const baseURL = "http://localhost:3001/";

export default function App() {
  const [post, setPost] = React.useState(null);

  React.useEffect(() => {
    axios.get(`${baseURL}/insert`).then((response) => {
        console.log("teste",response.data.useLivraria.docs);
      setPost(response.data.useLivraria.docs);
    });
  }, []);

  function createPost() {
    axios
      .post(baseURL, {
        title: "Hello",
      
      })
      .then((response) => {
        setPost(response.data.useLivraria.docs);
      });
  }

  if (!post) return "No post!"

  return (
    <div>
      <h1>{post.title}</h1>
     
      <button onClick={createPost}>Create Post</button>
    </div>
  );
}