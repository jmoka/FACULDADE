import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Select from './paginas/select/select';
import Insert from './paginas/insert/insert';
import Atualizar from './paginas/update/atualizar'
import Deletar from './paginas/delete/deletar'


const Rotas = () => (
  <BrowserRouter>
    <Routes>
    <Route exact path="/" Component={""} /> 
    <Route exact path="/todos" Component={Select} /> 
    <Route exact path="/inserir" Component={Insert} /> 
    <Route exact path="/atualizar" Component={Atualizar} /> 
    <Route exact path="/deletar" Component={Deletar} /> 
    
    </Routes>
  </BrowserRouter>
);



export default Rotas;
