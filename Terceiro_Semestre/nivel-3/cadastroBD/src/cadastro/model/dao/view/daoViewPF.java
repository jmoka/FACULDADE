/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.dao.view;

import cadastro.model.entidades.PessoaFisica;
import java.util.Scanner;


import static cadastro.model.fabrica.FabricaPessoas.PessoaFisicaFabrica;
import cadastro.model.interfacs.EntidadeInterfaceDAO;

import static cadastro.model.util.MenuAlteracao.menuAlteracao;

import static cadastro.model.util.Testes.acaoOpc1;
import static cadastro.model.util.Testes.oqAlterarPf;
import static cadastro.model.util.Testes.testarOpcaoAlteracao;
import java.io.Serializable;
import static java.lang.System.err;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;

public class DaoViewPF  implements Serializable{

	private static final long serialVersionUID = 1L;
	
    
    //===============================
            // INCLUIR     
    //===============================
    
    
    public static void inserirPF() {
    EntidadeInterfaceDAO fabricaPF = PessoaFisicaFabrica();
    
    Scanner sc = new Scanner(in);
    
        out.println("Vamos Iniciar o Cadastro da Pessoa Fisica");
        out.println("Responda as Perguntas");

        out.println("Qual e a Nome?");    
    String nome = sc.nextLine();
        
        out.println("Qual e o Logradouro?");
    String logradouro = sc.nextLine();
    
        out.println("Qual e a Cidade?");
    String cidade = sc.nextLine();
    
        out.println("Qual e o Estado com 2 digitos, Exemplo: PA, RS, MA?");
    String estado = sc.nextLine();
    
        out.println("Qual e o Telefone?");
    String telefone = sc.nextLine();
    
        out.println("Qual e o Email?");
    String email = sc.nextLine();
    
        out.println("Qual e o CPF?");
    String cnpf = sc.nextLine();
    
        out.println("Qual e o Codigo do Usuario Responsavel?");
    Integer idUsuarioResponsavel = sc.nextInt();
    
    PessoaFisica novaPf = new PessoaFisica(0, nome, logradouro, cidade, estado, telefone, email, idUsuarioResponsavel, cnpf);
    
    fabricaPF.inserir(novaPf);    
     
        err.println(novaPf.toString());
}

    //===============================
            // ALTERAR POR ID
    //===============================
    
    public static void alterarPfId(Integer idPf) {
    Scanner sc = new Scanner(in);          
        out.println("Escolha o que Gostaria de Trocar");   
        out.println(menuAlteracao());
    Integer numeroOpcaoEscolhidaAlterar = sc.nextInt();      
    Boolean testeOpcao =  testarOpcaoAlteracao(numeroOpcaoEscolhidaAlterar,idPf ); 
    
        if(testeOpcao == true){
        
            oqAlterarPf(numeroOpcaoEscolhidaAlterar,idPf);
        
        }else{
    
            acaoOpc1(Integer.toString(numeroOpcaoEscolhidaAlterar), Integer.toString(idPf));
        }
        
    
    }
    
    
    public static void alterarPfNome(Integer idPf){
        EntidadeInterfaceDAO fabricaPF = PessoaFisicaFabrica(); 
        PessoaFisica pessoaFisica = (PessoaFisica) fabricaPF.buscarPorId(idPf); 
        Scanner sc = new Scanner(in);  
             
        out.println("Qual o Nome");    
        String novaPF = sc.nextLine();        
        pessoaFisica.setNome(novaPF);    
        fabricaPF.atualizar(pessoaFisica);
        out.println("=========================");
        out.println("Nome Atualizado com sucesso");
        out.println("=========================");
        err.println(pessoaFisica.toString());
    }
 
    public static void AlterarPfEndereço(Integer idPf){
        EntidadeInterfaceDAO fabricaPF = PessoaFisicaFabrica(); 
        PessoaFisica pessoaFisica = (PessoaFisica) fabricaPF.buscarPorId(idPf); 
        Scanner sc = new Scanner(in);  
        
        out.println("Qual a o novo Logradouro?");
        String novoLogradouro = sc.nextLine();
        out.println("Qual a Cidade?");
        String novaCidade = sc.nextLine();
        out.println("Qual a o novo Estado?");
        String novoEstado = sc.nextLine();
        pessoaFisica.setLogradouro(novoLogradouro);
        pessoaFisica.setCidade(novaCidade);
        pessoaFisica.setEstado(novoEstado);
        fabricaPF.atualizar(pessoaFisica);
        out.println("=========================");
         out.println("Endereco Atualizado com sucesso");
        out.println("=========================");
        err.println(pessoaFisica.toString());
    }
    
   public static void AlterarPfEmail(Integer idPf){
        EntidadeInterfaceDAO fabricaPF = PessoaFisicaFabrica(); 
        PessoaFisica pessoaFisica = (PessoaFisica) fabricaPF.buscarPorId(idPf); 
        Scanner sc = new Scanner(in);  
        out.println("Qual o novo Email?");
        String novoEmail = sc.nextLine();
        pessoaFisica.setEmail(novoEmail);
        fabricaPF.atualizar(pessoaFisica);
        out.println("=========================");
        out.println("Email Atualizado com sucesso");
        out.println("=========================");
        err.println(pessoaFisica.toString());
        
   }
   
   public static void AlterarPfTelefone(Integer idPf){
        EntidadeInterfaceDAO fabricaPF = PessoaFisicaFabrica(); 
        PessoaFisica pessoaFisica = (PessoaFisica) fabricaPF.buscarPorId(idPf); 
        Scanner sc = new Scanner(in);  
        out.println("Qual o novo Telefone?");
        String novoTelefone = sc.nextLine();
        pessoaFisica.setTelefone(novoTelefone);
        fabricaPF.atualizar(pessoaFisica);
        out.println("=========================");
        out.println("Telefone Atualizado com sucesso");
        out.println("=========================");
   }
   
   public static void AlterarPfTodosItens(Integer idPf){
       
        EntidadeInterfaceDAO fabricaPF = PessoaFisicaFabrica(); 
        PessoaFisica pessoaFisica = (PessoaFisica) fabricaPF.buscarPorId(idPf); 
        Scanner sc = new Scanner(in);  
        
        out.println("Qual o Nome");    
        String novaPF = sc.nextLine();        
        out.println("Qual a o novo Logradouro?");
        String novoLogradouro = sc.nextLine();
        out.println("Qual a Cidade?");
        String novaCidade = sc.nextLine();
        out.println("Qual a o novo Estado?");
        String novoEstado = sc.nextLine(); 
        out.println("Qual o novo Email?");
        String novoEmail = sc.nextLine();
        out.println("Qual o novo CPF?");
        String novoCpf = sc.nextLine();
        out.println("Qual o novo Telefone?");
        String novoTelefone = sc.nextLine();
        out.println("Qual Id do Usuario Responsavel?");
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
        out.println("=========================");
         out.println("Pessoa Fisica Atualizada com sucesso");
        out.println("=========================");
   }
   
   public static void AlterarPfCPF(Integer idPf){
       EntidadeInterfaceDAO fabricaPf = PessoaFisicaFabrica();
       PessoaFisica pessoaFisica = (PessoaFisica) fabricaPf.buscarPorId(idPf);
       Scanner sc = new Scanner(in); 
        out.println("Qual o novo Cnpf?");
       String novoCpf = sc.nextLine();
       pessoaFisica.setCpf(novoCpf);
       fabricaPf.atualizar(pessoaFisica);
        out.println("=========================");
        out.println("CPF Atualizado com sucesso");
        out.println("=========================");
     
   }
   
   public static void AlterarPfUsuarioResponsavel(Integer idPf){
       EntidadeInterfaceDAO fabricaPf = PessoaFisicaFabrica();
       PessoaFisica pessoaFisica = (PessoaFisica) fabricaPf.buscarPorId(idPf);
       Scanner sc = new Scanner(in); 
        out.println("Qual Id do Usuario Responsavel?");
       Integer IdnovoUsuario = sc.nextInt();
       pessoaFisica.setIdUsuarioResponsavel(IdnovoUsuario);
       fabricaPf.atualizar(pessoaFisica);
        out.println("=========================");
        out.println("Usuario responsavel pela Pessoa Física,  Atualizado com sucesso");
        out.println("=========================");
       
   }
   
     //===============================
            // BUSCAR POR ID
    //===============================
    
    public static void consultarPfId(Integer id){
        
    EntidadeInterfaceDAO fabricaPf = PessoaFisicaFabrica();
    PessoaFisica pf = (PessoaFisica) fabricaPf.buscarPorId(id);
        out.println("Pessoa Juridica Encontrada");
        err.println(pf.toString());
    
    }
    
    
    
    //===============================
            // EXIBIR TODOS
    //===============================
    public static void exibirTodosPf(){
    EntidadeInterfaceDAO fabricaPf = PessoaFisicaFabrica();
  
    List <PessoaFisica> list =new ArrayList<>();
    
    list = fabricaPf.todos(); 
    
    
    for(PessoaFisica obj: list) { 
            err.println(obj); 
    
        }
    }
    
    //===============================
            // DELETAR POR ID
    //===============================
    
    public static void deletarPf(Integer id){
        EntidadeInterfaceDAO fabricaPf = PessoaFisicaFabrica();
        PessoaFisica pf = (PessoaFisica) fabricaPf.buscarPorId(id);
        fabricaPf.deletar(id);
	out.println("Pessoa Fisica Deletada");
        err.println(pf.toString());
    
    }
    
     //===============================
            // BUSCAR POR NOME PRIMEIRA OCORRENCIA
    //===============================
    
    public static void buscarPfNome(String nomePf){
        EntidadeInterfaceDAO fabricaPf = PessoaFisicaFabrica();
        Object pf = fabricaPf.buscarPorNome(nomePf);
        out.println("Pessoa Fisica Encontrada");
        err.println(pf.toString());
        
    }
    
    
    //===============================
            // BUSCAR POR NOME TODAS OCORRENCIA
    //===============================
    
    public static void buscarPfNomeTodasOcorrencia(String nomePf) {
    EntidadeInterfaceDAO fabricaPf = PessoaFisicaFabrica();
    List<PessoaFisica> list = fabricaPf.BuscartodosNomes(nomePf);
    
    if (list.isEmpty()) {
            out.println("Nenhuma correspondência encontrada para o nome: " + nomePf);
    } else {
        for (PessoaFisica obj : list) {           
                err.println(obj);
        }
    }
}


}
    
  
