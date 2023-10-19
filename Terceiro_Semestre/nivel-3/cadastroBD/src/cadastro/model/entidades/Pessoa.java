/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.entidades;

import cadastro.model.abstracts.PessoaAbstracts;

public abstract class Pessoa extends PessoaAbstracts{
 
    public Pessoa(){
    }

    public Pessoa( String nome, String logradouro, String cidade, String estado, String telefone, String email, int idUsuarioResponsavel) {
        super(nome, logradouro, cidade, estado, telefone, email, idUsuarioResponsavel);
    }
   

    
}
