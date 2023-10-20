/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.Aplicacao;

import cadastro.model.entidades.PessoaJuridica;
import cadastro.model.fabrica.FabricaPessoas;
import cadastro.model.interfacs.EntidadeInterfaceDAO;
import java.util.ArrayList;
import java.util.List;



public class ProgramaPJ {
    public static void main(String[] args) {
        
        //instanciação da fabrica Pessoa Fisica
        EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
        List <PessoaJuridica> list =new ArrayList<>();
        PessoaJuridica pj = new PessoaJuridica();
        
     //======================================================  
     // PESSOA JURIDICA
     // ====================================================
     
        //========================
        // INSERIR PESSOA FISICA
        //=======================
        
           /*
            pj = new PessoaJuridica(0, "jo", "rua teste", "belém", "pa", "2222", "jo@joa", 1, "45678");
            fabricnpj.Inserir(pj);  
            System.out.println(pj.toString());
            */
           
           
        //========================
        // BUSCAR POR ID PESSOA JURIDICA
        //=======================
            /*            
                pj = (PessoaJuridica) fabricnpj.buscarPorId(4);                 
                System.out.println(pj.toString());            
            */
        
           
        //========================
        // ATUALIZAR PESSOA JURIDICA
        //=======================    
           
      
            int id = 2;
		pj = (PessoaJuridica) fabricnpj.buscarPorId(id);
                System.out.println("=========================");
		System.out.println("PJ Atual");
                 System.out.println("=========================");
                System.out.println(pj);
                pj.setNome("Loloka ltda");
                pj.setLogradouro("teste2");
                pj.setCidade("maraba");
                pj.setEstado("pa");
                pj.setTelefone("56789");
                pj.setEmail("t@t");
                pj.setIdUsuarioResponsavel(1);
		pj.setCnpj("567890987");             
                fabricnpj.atualizar(pj);
                System.out.println("=========================");
                System.out.println("Nova PJ");
                System.out.println("=========================");
                System.out.println(pj.toString());
                
              
         
        //========================
        // DELETAR PESSOA JURIDICA
        //======================= 
        
          /*
                int id = 3;
		fabricnpj.deletar(id);
		System.out.println("Pessoa Juridica com Id " + id + " deletado");
                
          */
        
        
            
        //=======================
        // TODOS -  PESSOA JURIDICA
        //======================= 
                
            /*
                list = fabricnpj.todos(); 
		for(PessoaJuridica obj: list) { 
			System.out.println(obj); 
		}
            */
            
            
        //=======================
        // BUSCAR POR NOME
        //======================= 
            /*
            pj = (PessoaJuridica) fabricnpj.buscarPorNome("Empresa1 LTDA");                 
            System.out.println(pj);    
            */
    }
    
}
