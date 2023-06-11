import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Select from './paginas/select/select';
import Insert from './paginas/insert/insert';


const Rotas = () => (
  <BrowserRouter>
    <Routes>
    <Route exact path="/" Component={""} /> 
    <Route exact path="/todos" Component={Select} /> 
    <Route exact path="/insert" Component={Insert} /> 
    
    </Routes>
  </BrowserRouter>
);



export default Rotas;
