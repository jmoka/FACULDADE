/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.Aplicacao;

import cadastro.model.entidades.PessoaFisica;
import cadastro.model.fabrica.FabricaPessoas;
import cadastro.model.interfacs.EntidadeInterfaceDAO;


public class Programa {
    public static void main(String[] args) {
        
        
       EntidadeInterfaceDAO pessoaFisicaInterfaceDAO = FabricaPessoas.PessoaFisicaFabrica();
       PessoaFisica pf = new PessoaFisica(0, "lika", "rua teste", "belém", "pa", "2222", "jo@joa", 1, "45678");

       pessoaFisicaInterfaceDAO.Inserir(pf);
       System.out.println("Nova Pessoa Fisica inserida com ID = " + pf.getIdPessoaFisica());
       System.out.println( pf.toString());
       

         
       
        
    }
    
}
