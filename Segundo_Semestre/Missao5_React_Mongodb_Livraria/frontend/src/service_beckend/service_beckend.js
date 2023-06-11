import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:3001/todos/'// Insira a URL correta do seu servidor aqui
});

console.log(api)

export default api;