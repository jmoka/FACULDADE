/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.dao.view;

import cadastro.model.entidades.PessoaFisica;
import java.util.Scanner;

import cadastro.model.fabrica.FabricaPessoas;
import cadastro.model.interfacs.EntidadeInterfaceDAO;
import cadastro.model.entidades.PessoaFisica;



public class daoViewPF {
       
    
    public static void inserirPf() {
    EntidadeInterfaceDAO fabricaPF = FabricaPessoas.PessoaFisicaFabrica();
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Vamos Iniciar o Cadastro da Pessoa Física");
    System.out.println("Responda as Perguntas");

    System.out.println("Qual e o Nome?");    
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
    
    System.out.println("Qual e o CPF?");
     String cpf = sc.nextLine();
    
    System.out.println("Qual e o Codigo do Usuario Responsavel?");
    Integer idUsuarioResponsavel = sc.nextInt();
    PessoaFisica novaPf = new PessoaFisica(0, nome, logradouro, cidade, estado, telefone, email, idUsuarioResponsavel, cpf);
    
    fabricaPF.Inserir(novaPf);     
    System.out.println("Cadastro da Pessoa Fisica concluido com sucesso.");    
    System.out.println(novaPf.toString());
}

    public static void alterarPfId(){
         System.out.println("metodo alterar pessoa Fisica");
     }
   
    public static void deletarPfId(){
         System.out.println("metodo deletar pessoa Fisica");
     }
    
    public static void consultarPfId(){
         System.out.println("metodo consultarId pessoa Fisica");
     }
    
    public static void consultarPfTodos(){
         System.out.println("metodo consultar Todas pessoa Fisica");
     }
   
    
}
