import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Select from './paginas/';


const Rotas = () => (
  <BrowserRouter>
    <Routes>
    <Route exact path="/" Component={Select} /> 
    <Route exact path="/select" Component={Select} /> 
    <Route exact path="/insert" Component={Select} /> 
    
    </Routes>
  </BrowserRouter>
);



export default Rotas;
