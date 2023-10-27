/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.Aplicacao;

import cadastro.model.entidades.PessoaFisica;
import cadastro.model.fabrica.FabricaPessoas;
import cadastro.model.interfacs.EntidadeInterfaceDAO;
import java.util.ArrayList;
import java.util.List;



public class ProgramaPF {
    public static void main(String[] args) {
        
       
        EntidadeInterfaceDAO fabricaPF = FabricaPessoas.PessoaFisicaFabrica();
        List <PessoaFisica> list =new ArrayList<>();
        PessoaFisica pf = new PessoaFisica();
        
     //======================================================  
     // PESSOA FISICA
     // ====================================================
     
        //========================
        // INSERIR PESSOA FICICA
        //=======================
        
            
            pf = new PessoaFisica(0, "lika linda", "rua teste", "belém", "pa", "2222", "jo@joa", 1, "45678");
            fabricaPF.inserir(pf);       
           
           
            
        //========================
        // BUSCAR POR ID PESSOA FISICA
        //=======================
        
            /*
            pf = (PessoaFisica) fabricaPF.buscarPorId(4);                 
            System.out.println(pf);            
            */
        
           
        //========================
        // ATUALIZAR PESSOA FISICA
        //=======================    
           /*
        
            int id = 5;
		pf = (PessoaFisica) fabricaPF.buscarPorId(id);
                System.out.println("=========================");
		System.out.println("PF Atual");
                System.out.println("=========================");
                System.out.println(pf);
                pf.setNome("lika feia");
                pf.setLogradouro("teste2");
                pf.setCidade("maraba");
                pf.setEstado("pa");
                pf.setTelefone("56789");
                pf.setEmail("t@t");
                pf.setIdUsuarioResponsavel(1);
		pf.setCpf("567890987");
             
                fabricaPF.atualizar(pf);
                System.out.println("=========================");
                System.out.println("Nova PF");
                System.out.println("=========================");
                System.out.println(pf.toString());
           
                           
                */
        
        
        //========================
        // DELETAR PESSOA FISICA
        //======================= 
        
            /*
                int id1 = 5;
		fabricaPF.deletar(id1);
		System.out.println("Pessoa Física com Id " + id1 + " deletado");
        
            */
        
        
            
        //=======================
        // TODOS -  PESSOA FISICA
        //======================= 
        
            /*
            list = fabricaPF.todos();  // lista todos e armazena e list
		for(PessoaFisica obj: list) { // percorre a lista e imprime o resultado
			System.out.println(obj); 
		}
            */
            
            
        //=======================
        // BUSCAR POR NOME
        //======================= 
        /*
            pf = (PessoaFisica) fabricaPF.buscarPorNome("santos");                 
            System.out.println(pf);    
        */
    }
    
}
