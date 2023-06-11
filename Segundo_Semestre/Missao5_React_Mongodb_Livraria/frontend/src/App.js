import React from 'react';
import Header from './componentes/header/header';
// import Routes from './rotas';
// import Consumo from './consumo'
import Select from './paginas/select/select'
import Insert from './paginas/insert/insert'
function App() {
  return (
    <div className="App">
      <Header />
      {/* <Consumo /> */}
      
      <Select />
      <Insert/> 
      
      <h1>JOTA CONTABILIDADE</h1>
    </div>
  );
}

export default App;
