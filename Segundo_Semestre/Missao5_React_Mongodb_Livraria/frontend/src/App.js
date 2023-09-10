import React from 'react';
import Header from './componentes/header/header';
import Routes from './rotas';
import Formulario from './componentes/formularios/formulario'

function App() {
  return (
    <div className="App">
      <Header />
       <Routes />
       <Formulario/>
      
      <h1>JOTA CONTABILIDADE</h1>
    </div>
  );
}

export default App;
