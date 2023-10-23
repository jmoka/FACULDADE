/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.dao.view;

import cadastro.model.entidades.PessoaJuridica;
import java.util.Scanner;

import cadastro.model.fabrica.FabricaPessoas;
import cadastro.model.interfacs.EntidadeInterfaceDAO;
import cadastro.model.util.MenuAlteracao;
import cadastro.model.util.Testes;
import java.util.ArrayList;
import java.util.List;

public class DaoViewPJ {
    
    //===============================
            // INCLUIR
    //===============================
    
    
    public static void inserirPJ() {
    EntidadeInterfaceDAO fabricaPJ = FabricaPessoas.PessoaJuridicaFabrica();
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Vamos Iniciar o Cadastro da Pessoa Juridica");
    System.out.println("Responda as Perguntas");

    System.out.println("Qual e a Razao Social?");    
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

    //===============================
            // ALTERAR POR ID
    //===============================
    
    
    public static void alterarPjId(Integer id) {
        
    EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
    PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(id);
   
    
    Scanner sc = new Scanner(System.in);

    System.out.println("=========================");
    System.out.println("PJ Atual");
    System.out.println("=========================");
    System.err.println(pj);

    System.out.println("Vamos Iniciar a Alteracao da Pessoa Juridica");
    
    System.out.println("O que voce gostaria de Trocar");
    System.out.println(MenuAlteracao.menuAlteracao());
    String opcaoEscolhida = sc.nextLine();  
    String textDigitado = Testes.oqAlterar(opcaoEscolhida); 
    pj.setNome(textDigitado);
    
    fabricnpj.atualizar( pj);

    System.out.println("=========================");
    System.out.println("Nova PJ");
    System.out.println("=========================");
    System.err.println(pj.toString());
        
    }
    
    
     //===============================
            // BUSCAR POR ID
    //===============================
    
    public static void consultarPjId(Integer id){
        
    EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
    PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(id);
    System.err.println(pj);
    }
    
    
    
    //===============================
            // EXIBIR TODOS
    //===============================
    public static void exibirTodosPj(){
    EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
  
    List <PessoaJuridica> list =new ArrayList<>();
    
    list = fabricnpj.todos(); 
    
    
    for(PessoaJuridica obj: list) { 
        System.err.println(obj); 
    
        }
    }
    
    //===============================
            // DELETAR TODOS
    //===============================
    
    public static void deletarPj(Integer id){
        EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
        PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(id);
        System.err.println(pj);       
        fabricnpj.deletar(id);
	System.out.println("Pessoa Juridica com Id " + id + " deletado");
    
    }
    
     //===============================
            // BUSCAR POR NOME
    //===============================
    
    public static void buscarPjNome(String nomePj){
        EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
        Object pj = fabricnpj.buscarPorNome(nomePj);
        System.err.println(pj);
    
    }
}
