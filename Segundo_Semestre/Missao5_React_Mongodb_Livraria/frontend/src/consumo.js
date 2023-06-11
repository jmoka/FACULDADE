import React, { useState, useEffect } from 'react';

function Consumo() {
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:3001/home/sistema");
        console.log(response);
      
        if (!response.ok) {
          throw new Error('Erro ao buscar os dados');
        }
        const data = await response.json();
        console.log("data",data.docs);


        setTodos(data.docs);
      } catch (error) {
        console.error('Erro:', error);
      }
    };

    fetchData();
  }, []);
  console.log("todos",todos)


  return (
    <div className="App">
      <h1>Lista de Tarefas</h1>
      {todos.length > 0 ? (
        <ul>
          {todos.map((doc, index) => (
            <li key={doc._id}>
              <h2>Título: {doc.titulo}</h2>
              <p>Resumo: {doc.resumo}</p>
              <p>Editora: {doc.editora}</p>
              <p>Autores: {doc.autores.join(', ')}</p>
            </li>
          ))}
        </ul>
      ) : (
        <p>Nenhum documento encontrado</p>
      )}
    </div>
  );
}

export default Consumo;
