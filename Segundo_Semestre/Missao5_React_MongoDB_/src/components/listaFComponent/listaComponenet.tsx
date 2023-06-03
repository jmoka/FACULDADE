import React from "react";

export default function Lista (props:any){

    
    return(
        
        <table className="table">
             <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Título</th>
                    <th scope="col">Editora</th>
                    <th scope="col">Autor</th>
                </tr>               
             </thead>
             <tbody>
              {props.livros()}
            </tbody>
            
        </table>
        
        

    )
}


