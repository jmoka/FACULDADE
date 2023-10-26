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
import static cadastro.model.util.Testes.acaoOpc1;
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
    
    fabricaPJ.inserir(novaPj);    
     
    System.err.println(novaPj.toString());
}

    //===============================
            // ALTERAR POR ID
    //===============================
    
    public static void alterarPjId(Integer idPj) {
    Scanner sc = new Scanner(System.in);          
    System.out.println("Escolha o que Gostaria de Trocar");   
    System.out.println(MenuAlteracao.menuAlteracao());
    Integer numeroOpcaoEscolhidaAlterar = sc.nextInt();      
    Boolean testeOpcao =  Testes.testarOpcaoAlteracao(numeroOpcaoEscolhidaAlterar,idPj ); 
    
        if(testeOpcao == true){
        
            Testes.oqAlterar(numeroOpcaoEscolhidaAlterar,idPj);
        
        }else{
    
            Testes.acaoOpc1(Integer.toString(numeroOpcaoEscolhidaAlterar), Integer.toString(idPj));
        }
        
    
    }
    
    
    public static void alterarPjNome(Integer idPj){
        EntidadeInterfaceDAO fabricaPJ = FabricaPessoas.PessoaJuridicaFabrica(); 
        PessoaJuridica pessoaJuridica = (PessoaJuridica) fabricaPJ.buscarPorId(idPj); 
        Scanner sc = new Scanner(System.in);  
             
        System.out.println("Qual a Razao Social");    
        String novaPJ = sc.nextLine();        
        pessoaJuridica.setNome(novaPJ);    
        fabricaPJ.atualizar(pessoaJuridica);
        System.out.println("=========================");
        System.out.println("Razao Social Atualizada");
        System.out.println("=========================");
        System.err.println(pessoaJuridica.toString());
    }
    
    
    
    public static void AlterarPjEndereço(Integer idPj){
        EntidadeInterfaceDAO fabricaPJ = FabricaPessoas.PessoaJuridicaFabrica(); 
        PessoaJuridica pessoaJuridica = (PessoaJuridica) fabricaPJ.buscarPorId(idPj); 
        Scanner sc = new Scanner(System.in);  
        
        System.out.println("Qual a o novo Logradouro?");
        String novoLogradouro = sc.nextLine();
        System.out.println("Qual a Cidade?");
        String novaCidade = sc.nextLine();
        System.out.println("Qual a o novo Estado?");
        String novoEstado = sc.nextLine();
        pessoaJuridica.setLogradouro(novoLogradouro);
        pessoaJuridica.setCidade(novaCidade);
        pessoaJuridica.setEstado(novoEstado);
        fabricaPJ.atualizar(pessoaJuridica);
    }
    
   public static void AlterarPjEmail(Integer idPj){
        EntidadeInterfaceDAO fabricaPJ = FabricaPessoas.PessoaJuridicaFabrica(); 
        PessoaJuridica pessoaJuridica = (PessoaJuridica) fabricaPJ.buscarPorId(idPj); 
        Scanner sc = new Scanner(System.in);  
        System.out.println("Qual o novo Email?");
        String novoEmail = sc.nextLine();
        pessoaJuridica.setEmail(novoEmail);
        fabricaPJ.atualizar(pessoaJuridica);
        
   }
   
   public static void AlterarPjTelefone(Integer idPj){
        EntidadeInterfaceDAO fabricaPJ = FabricaPessoas.PessoaJuridicaFabrica(); 
        PessoaJuridica pessoaJuridica = (PessoaJuridica) fabricaPJ.buscarPorId(idPj); 
        Scanner sc = new Scanner(System.in);  
        System.out.println("Qual o novo Telefone?");
        String novoTelefone = sc.nextLine();
        pessoaJuridica.setTelefone(novoTelefone);
        fabricaPJ.atualizar(pessoaJuridica);
   }
   
   public static void AlterarPjTodosItens(Integer idPj){
       
        EntidadeInterfaceDAO fabricaPJ = FabricaPessoas.PessoaJuridicaFabrica(); 
        PessoaJuridica pessoaJuridica = (PessoaJuridica) fabricaPJ.buscarPorId(idPj); 
        Scanner sc = new Scanner(System.in);  
        
        System.out.println("Qual a Razao Social");    
        String novaPJ = sc.nextLine();        
        System.out.println("Qual a o novo Logradouro?");
        String novoLogradouro = sc.nextLine();
        System.out.println("Qual a Cidade?");
        String novaCidade = sc.nextLine();
        System.out.println("Qual a o novo Estado?");
        String novoEstado = sc.nextLine(); 
        System.out.println("Qual o novo Email?");
        String novoEmail = sc.nextLine();
        System.out.println("Qual o novo Cnpj?");
        String novoCnpj = sc.nextLine();
        System.out.println("Qual o novo Telefone?");
        String novoTelefone = sc.nextLine();
        System.out.println("Qual Id do Usuario Responsavel?");
        String novoUsuario = sc.nextLine();
        
        pessoaJuridica.setNome(novaPJ); 
        pessoaJuridica.setLogradouro(novoLogradouro);
        pessoaJuridica.setCidade(novaCidade);
        pessoaJuridica.setEstado(novoEstado);
        pessoaJuridica.setEmail(novoEmail);
        pessoaJuridica.setCnpj(novoCnpj);
        pessoaJuridica.setTelefone(novoTelefone);
        pessoaJuridica.setCnpj(novoUsuario);
        
        fabricaPJ.atualizar(pessoaJuridica);
   }
   
   public static void AlterarPjCnpj(Integer idPj){
       EntidadeInterfaceDAO fabricaPj = FabricaPessoas.PessoaJuridicaFabrica();
       PessoaJuridica pessoajuridica = (PessoaJuridica) fabricaPj.buscarPorId(idPj);
       Scanner sc = new Scanner(System.in); 
       System.out.println("Qual o novo Cnpj?");
       String novoCnpj = sc.nextLine();
       pessoajuridica.setCnpj(novoCnpj);
       fabricaPj.atualizar(pessoajuridica);
     
   }
   
   public static void AlterarPjUsuarioResponsavel(Integer idPj){
       EntidadeInterfaceDAO fabricaPj = FabricaPessoas.PessoaJuridicaFabrica();
       PessoaJuridica pessoajuridica = (PessoaJuridica) fabricaPj.buscarPorId(idPj);
       Scanner sc = new Scanner(System.in); 
       System.out.println("Qual Id do Usuario Responsavel?");
       String novoUsuario = sc.nextLine();
       pessoajuridica.setCnpj(novoUsuario);
       fabricaPj.atualizar(pessoajuridica);
       
   }
   
     //===============================
            // BUSCAR POR ID
    //===============================
    
    public static void consultarPjId(Integer id){
        
    EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
    PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(id);
    System.out.println("Peaaos Juridica Encontrada");
    System.err.println(pj.toString());
    
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
            // BUSCAR POR NOME PRIMEIRA OCORRENCIA
    //===============================
    
    public static void buscarPjNome(String nomePj){
        EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
        Object pj = fabricnpj.buscarPorNome(nomePj);
        System.err.println(pj);
        
    }
    
    
    //===============================
            // BUSCAR POR NOME TODAS OCORRENCIA
    //===============================
    
    public static void buscarPjNomeTodasOcorrencia(String nomePj) {
    EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
    List<PessoaJuridica> list = fabricnpj.BuscartodosNomes(nomePj);
    
    if (list.isEmpty()) {
        System.out.println("Nenhuma correspondência encontrada para o nome: " + nomePj);
    } else {
        for (PessoaJuridica obj : list) {
            System.err.println(obj);
        }
    }
}


}
    
  
