/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.entidades;

import cadastro.model.abstracts.PessoaAbstracts;

public class PessoaJuridica extends PessoaAbstracts{
    private  String cnpj;
    
    public PessoaJuridica(){
    }

    public PessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaJuridica(String cnpj,  String nome, String logradouro, String cidade, String estado, String telefone, String email, int idUsuarioResponsavel) {
        super( nome, logradouro, cidade, estado, telefone, email, idUsuarioResponsavel);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
}