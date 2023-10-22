/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.dao.view;

import cadastro.model.entidades.PessoaJuridica;
import java.util.Scanner;

import cadastro.model.fabrica.FabricaPessoas;
import cadastro.model.interfacs.EntidadeInterfaceDAO;

public class daoViewPJ {
          
    public static void inserirPJ() {
    EntidadeInterfaceDAO fabricaPJ = FabricaPessoas.PessoaJuridicaFabrica();
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Vamos Iniciar o Cadastro da Pessoa Juridica");
    System.out.println("Responda as Perguntas");

    System.out.println("Qual e a Razão Social?");    
    String nome = sc.nextLine();
        
    System.out.println("Qual e o Logradouro?");
    String logradouro = sc.nextLine();
    
    System.out.println("Qual e a Cidade?");
    String cidade = sc.nextLine();
    
    System.out.println("Qual e o Estado com 2 digitos, Exemplo: PA, RS, MA?");
    String estado = sc.nextLine();
    
    System.out.println("Qual e o Telefone?");
    String telefone = sc.nextLine();
    
    System.out.println("Qual e o Email?");
    String email = sc.nextLine();
    
     System.out.println("Qual e o CNPJ?");
     String cnpj = sc.nextLine();
    
    System.out.println("Qual e o Codigo do Usuario Responsavel?");
    Integer idUsuarioResponsavel = sc.nextInt();
    
    PessoaJuridica novaPj = new PessoaJuridica(0, nome, logradouro, cidade, estado, telefone, email, idUsuarioResponsavel, cnpj);
    
    fabricaPJ.Inserir(novaPj); 
    
    System.out.println("Cadastro da Pessoa Fisica concluido com sucesso.");
    
    System.out.println(novaPj.toString());
}

    public static void alterarPjId(){
         System.out.println("metodo alterar pessoa Juricica");
     }
    
    public static void deletarPjId(){
         System.out.println("metodo deletar pessoa Juricica");
     }
   
    public static void consultarPjId(){
         System.out.println("metodo consultarId pessoa Juricica");
     }
   
    public static void consultarPjTodos(){
         System.out.println("metodo consultar Todas pessoa Juricica");
     }
      
     
    
}
