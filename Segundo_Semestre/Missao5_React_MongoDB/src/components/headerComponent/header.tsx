// A diferença entre usar React.FC e export default function para declarar um componente 
// React está relacionada à tipagem das props (propriedades) do componente.

// Ao usar React.FC, você está indicando que o componente é uma função de componente e, 
// portanto, pode receber props como parâmetros. A notação React.FC fornece uma tipagem genérica para as 
// props, permitindo que você especifique os tipos de propriedades esperadas pelo componente. Por exemplo:


// Nesse caso, Header é um componente que espera receber uma propriedade title como uma string. O uso de React.FC 
// permite que você defina explicitamente as propriedades esperadas pelo componente e obtenha erros de tipo se as 
// props fornecidas forem incompatíveis.

// Por outro lado, ao usar export default function Header(), você está criando uma função comum para definir o 
// componente, sem uma tipagem genérica para as props. Nesse caso, você pode receber as props diretamente como 
// parâmetros da função, mas não há uma tipagem específica para elas:


// corrija o codigo 

import { Link } from "react-router-dom";

export default function Header(){

    return (
        <header >
            <nav>
                <tr>
                <th scope="col" className="px-2 py-1 fs-5"> <Link to="/">Inicio</Link> </th>
                    <th scope="col" className="px-2 py-1 fs-5">  <Link to="/formulario">Formulário</Link>  </th>
                    <th scope="col" className="px-2 py-1 fs-5"> <Link to="/Completo">Completo</Link> </th>
                    
                </tr>
            </nav>
            
       </header>
    )

} 





// import React from 'react';

// const Header: React.FC = () => {
//   return (
//     <header>
//       <thead>
//         <tr>
//           <th><a href="/">Início</a></th>
//           <th><a href="/cadastro">Cadastro</a></th>
//         </tr>
//       </thead>
//     </header>
//   );
// };

// export default Header;
