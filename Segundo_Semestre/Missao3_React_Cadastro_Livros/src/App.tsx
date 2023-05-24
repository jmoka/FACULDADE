import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Formulario from "./components/formularioComponent/formulario";
import Capa from "./components/capaComponent/capa";
import FormularioCompleto from "./components/formularioComponent/forrmularioCompleto";
import Header from "./components/headerComponent/header";

const App: React.FC = () => {
  

  return (

      
   
      <Router>   
           
        <header>
          <Header />
        </header>
        <main>
          <Routes>
            <Route path="/capa" element={<Capa/>} />
            <Route path="/formulario" element={<Formulario />} />
            <Route path="/Completo" element={<FormularioCompleto />} />
          </Routes>
        </main>
      </Router>
   
  );
};

export default App;
