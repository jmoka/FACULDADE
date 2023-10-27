/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.dao.view;

import cadastro.model.entidades.PessoaFisica;
import java.util.Scanner;

import cadastro.model.fabrica.FabricaPessoas;
import cadastro.model.interfacs.EntidadeInterfaceDAO;
import cadastro.model.util.MenuAlteracao;
import cadastro.model.util.Testes;
import static cadastro.model.util.Testes.acaoOpc1;
import java.util.ArrayList;
import java.util.List;

public class DaoViewPF {
    
    //===============================
            // INCLUIR     
    //===============================
    
    
    public static void inserirPF() {
    EntidadeInterfaceDAO fabricaPF = FabricaPessoas.PessoaFisicaFabrica();
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Vamos Iniciar o Cadastro da Pessoa Fisica");
    System.out.println("Responda as Perguntas");

    System.out.println("Qual e a Nome?");    
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
    String cnpf = sc.nextLine();
    
    System.out.println("Qual e o Codigo do Usuario Responsavel?");
    Integer idUsuarioResponsavel = sc.nextInt();
    
    PessoaFisica novaPf = new PessoaFisica(0, nome, logradouro, cidade, estado, telefone, email, idUsuarioResponsavel, cnpf);
    
    fabricaPF.inserir(novaPf);    
     
    System.err.println(novaPf.toString());
}

    //===============================
            // ALTERAR POR ID
    //===============================
    
    public static void alterarPfId(Integer idPf) {
    Scanner sc = new Scanner(System.in);          
    System.out.println("Escolha o que Gostaria de Trocar");   
    System.out.println(MenuAlteracao.menuAlteracao());
    Integer numeroOpcaoEscolhidaAlterar = sc.nextInt();      
    Boolean testeOpcao =  Testes.testarOpcaoAlteracao(numeroOpcaoEscolhidaAlterar,idPf ); 
    
        if(testeOpcao == true){
        
            Testes.oqAlterarPf(numeroOpcaoEscolhidaAlterar,idPf);
        
        }else{
    
            Testes.acaoOpc1(Integer.toString(numeroOpcaoEscolhidaAlterar), Integer.toString(idPf));
        }
        
    
    }
    
    
    public static void alterarPfNome(Integer idPf){
        EntidadeInterfaceDAO fabricaPF = FabricaPessoas.PessoaFisicaFabrica(); 
        PessoaFisica pessoaFisica = (PessoaFisica) fabricaPF.buscarPorId(idPf); 
        Scanner sc = new Scanner(System.in);  
             
        System.out.println("Qual o Nome");    
        String novaPF = sc.nextLine();        
        pessoaFisica.setNome(novaPF);    
        fabricaPF.atualizar(pessoaFisica);
        System.out.println("=========================");
        System.out.println("Nome Atualizado com sucesso");
        System.out.println("=========================");
        System.err.println(pessoaFisica.toString());
    }
 
    public static void AlterarPfEndereço(Integer idPf){
        EntidadeInterfaceDAO fabricaPF = FabricaPessoas.PessoaFisicaFabrica(); 
        PessoaFisica pessoaFisica = (PessoaFisica) fabricaPF.buscarPorId(idPf); 
        Scanner sc = new Scanner(System.in);  
        
        System.out.println("Qual a o novo Logradouro?");
        String novoLogradouro = sc.nextLine();
        System.out.println("Qual a Cidade?");
        String novaCidade = sc.nextLine();
        System.out.println("Qual a o novo Estado?");
        String novoEstado = sc.nextLine();
        pessoaFisica.setLogradouro(novoLogradouro);
        pessoaFisica.setCidade(novaCidade);
        pessoaFisica.setEstado(novoEstado);
        fabricaPF.atualizar(pessoaFisica);
        System.out.println("=========================");
         System.out.println("Endereco Atualizado com sucesso");
        System.out.println("=========================");
        System.err.println(pessoaFisica.toString());
    }
    
   public static void AlterarPfEmail(Integer idPf){
        EntidadeInterfaceDAO fabricaPF = FabricaPessoas.PessoaFisicaFabrica(); 
        PessoaFisica pessoaFisica = (PessoaFisica) fabricaPF.buscarPorId(idPf); 
        Scanner sc = new Scanner(System.in);  
        System.out.println("Qual o novo Email?");
        String novoEmail = sc.nextLine();
        pessoaFisica.setEmail(novoEmail);
        fabricaPF.atualizar(pessoaFisica);
        System.out.println("=========================");
        System.out.println("Email Atualizado com sucesso");
        System.out.println("=========================");
        System.err.println(pessoaFisica.toString());
        
   }
   
   public static void AlterarPfTelefone(Integer idPf){
        EntidadeInterfaceDAO fabricaPF = FabricaPessoas.PessoaFisicaFabrica(); 
        PessoaFisica pessoaFisica = (PessoaFisica) fabricaPF.buscarPorId(idPf); 
        Scanner sc = new Scanner(System.in);  
        System.out.println("Qual o novo Telefone?");
        String novoTelefone = sc.nextLine();
        pessoaFisica.setTelefone(novoTelefone);
        fabricaPF.atualizar(pessoaFisica);
        System.out.println("=========================");
        System.out.println("Telefone Atualizado com sucesso");
        System.out.println("=========================");
   }
   
   public static void AlterarPfTodosItens(Integer idPf){
       
        EntidadeInterfaceDAO fabricaPF = FabricaPessoas.PessoaFisicaFabrica(); 
        PessoaFisica pessoaFisica = (PessoaFisica) fabricaPF.buscarPorId(idPf); 
        Scanner sc = new Scanner(System.in);  
        
        System.out.println("Qual o Nome");    
        String novaPF = sc.nextLine();        
        System.out.println("Qual a o novo Logradouro?");
        String novoLogradouro = sc.nextLine();
        System.out.println("Qual a Cidade?");
        String novaCidade = sc.nextLine();
        System.out.println("Qual a o novo Estado?");
        String novoEstado = sc.nextLine(); 
        System.out.println("Qual o novo Email?");
        String novoEmail = sc.nextLine();
        System.out.println("Qual o novo CPF?");
        String novoCpf = sc.nextLine();
        System.out.println("Qual o novo Telefone?");
        String novoTelefone = sc.nextLine();
        System.out.println("Qual Id do Usuario Responsavel?");
        Integer novoUsuario = sc.nextInt();
        
        pessoaFisica.setNome(novaPF); 
        pessoaFisica.setLogradouro(novoLogradouro);
        pessoaFisica.setCidade(novaCidade);
        pessoaFisica.setEstado(novoEstado);
        pessoaFisica.setEmail(novoEmail);
        pessoaFisica.setCpf(novoCpf);
        pessoaFisica.setTelefone(novoTelefone);
        pessoaFisica.setIdUsuarioResponsavel(novoUsuario);
        
        fabricaPF.atualizar(pessoaFisica);
        System.out.println("=========================");
         System.out.println("Pessoa Fisica Atualizada com sucesso");
        System.out.println("=========================");
   }
   
   public static void AlterarPfCPF(Integer idPf){
       EntidadeInterfaceDAO fabricaPf = FabricaPessoas.PessoaFisicaFabrica();
       PessoaFisica pessoaFisica = (PessoaFisica) fabricaPf.buscarPorId(idPf);
       Scanner sc = new Scanner(System.in); 
       System.out.println("Qual o novo Cnpf?");
       String novoCpf = sc.nextLine();
       pessoaFisica.setCpf(novoCpf);
       fabricaPf.atualizar(pessoaFisica);
       System.out.println("=========================");
       System.out.println("CPF Atualizado com sucesso");
       System.out.println("=========================");
     
   }
   
   public static void AlterarPfUsuarioResponsavel(Integer idPf){
       EntidadeInterfaceDAO fabricaPf = FabricaPessoas.PessoaFisicaFabrica();
       PessoaFisica pessoaFisica = (PessoaFisica) fabricaPf.buscarPorId(idPf);
       Scanner sc = new Scanner(System.in); 
       System.out.println("Qual Id do Usuario Responsavel?");
       Integer IdnovoUsuario = sc.nextInt();
       pessoaFisica.setIdUsuarioResponsavel(IdnovoUsuario);
       fabricaPf.atualizar(pessoaFisica);
       System.out.println("=========================");
       System.out.println("Usuario responsavel pela Pessoa Física,  Atualizado com sucesso");
       System.out.println("=========================");
       
   }
   
     //===============================
            // BUSCAR POR ID
    //===============================
    
    public static void consultarPfId(Integer id){
        
    EntidadeInterfaceDAO fabricaPf = FabricaPessoas.PessoaFisicaFabrica();
    PessoaFisica pf = (PessoaFisica) fabricaPf.buscarPorId(id);
    System.out.println("Pessoa Juridica Encontrada");
    System.err.println(pf.toString());
    
    }
    
    
    
    //===============================
            // EXIBIR TODOS
    //===============================
    public static void exibirTodosPf(){
    EntidadeInterfaceDAO fabricaPf = FabricaPessoas.PessoaFisicaFabrica();
  
    List <PessoaFisica> list =new ArrayList<>();
    
    list = fabricaPf.todos(); 
    
    
    for(PessoaFisica obj: list) { 
        System.err.println(obj); 
    
        }
    }
    
    //===============================
            // DELETAR POR ID
    //===============================
    
    public static void deletarPf(Integer id){
        EntidadeInterfaceDAO fabricaPf = FabricaPessoas.PessoaFisicaFabrica();
        PessoaFisica pf = (PessoaFisica) fabricaPf.buscarPorId(id);
        fabricaPf.deletar(id);
	System.out.println("Pessoa Fisica Deletada");
        System.err.println(pf.toString());
    
    }
    
     //===============================
            // BUSCAR POR NOME PRIMEIRA OCORRENCIA
    //===============================
    
    public static void buscarPfNome(String nomePf){
        EntidadeInterfaceDAO fabricaPf = FabricaPessoas.PessoaFisicaFabrica();
        Object pf = fabricaPf.buscarPorNome(nomePf);
        System.out.println("Pessoa Fisica Encontrada");
        System.err.println(pf.toString());
        
    }
    
    
    //===============================
            // BUSCAR POR NOME TODAS OCORRENCIA
    //===============================
    
    public static void buscarPfNomeTodasOcorrencia(String nomePf) {
    EntidadeInterfaceDAO fabricaPf = FabricaPessoas.PessoaFisicaFabrica();
    List<PessoaFisica> list = fabricaPf.BuscartodosNomes(nomePf);
    
    if (list.isEmpty()) {
        System.out.println("Nenhuma correspondência encontrada para o nome: " + nomePf);
    } else {
        for (PessoaFisica obj : list) {           
            System.err.println(obj);
        }
    }
}


}
    
  
