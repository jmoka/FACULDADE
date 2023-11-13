/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.dao.view;

import cadastro.model.entidades.PessoaJuridica;
import java.util.Scanner;


import static cadastro.model.fabrica.FabricaPessoas.PessoaJuridicaFabrica;
import cadastro.model.interfacs.EntidadeInterfaceDAO;

import static cadastro.model.util.MenuAlteracao.menuAlteracao;

import static cadastro.model.util.Testes.acaoOpc1;
import static cadastro.model.util.Testes.oqAlterar;
import static cadastro.model.util.Testes.testarOpcaoAlteracao;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import static java.lang.System.err;
import static java.lang.System.in;
import static java.lang.System.out;

public class DaoViewPJ  implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    //===============================
            // INCLUIR     
    //===============================
    
    
    public static void inserirPJ() {
    EntidadeInterfaceDAO fabricaPJ = PessoaJuridicaFabrica();
    
    Scanner sc = new Scanner(in);
    
        out.println("Vamos Iniciar o Cadastro da Pessoa Juridica");
        out.println("Responda as Perguntas");

        out.println("Qual e a Razao Social?");    
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
    
        out.println("Qual e o CNPJ?");
    String cnpj = sc.nextLine();
    
        out.println("Qual e o Codigo do Usuario Responsavel?");
    Integer idUsuarioResponsavel = sc.nextInt();
    
    PessoaJuridica novaPj = new PessoaJuridica(0, nome, logradouro, cidade, estado, telefone, email, idUsuarioResponsavel, cnpj);
    
    fabricaPJ.inserir(novaPj);    
     
        err.println(novaPj.toString());
}

    //===============================
            // ALTERAR POR ID
    //===============================
    
    public static void alterarPjId(Integer idPj) {
    Scanner sc = new Scanner(in);          
        out.println("Escolha o que Gostaria de Trocar");   
        out.println(menuAlteracao());
    Integer numeroOpcaoEscolhidaAlterar = sc.nextInt();      
    Boolean testeOpcao =  testarOpcaoAlteracao(numeroOpcaoEscolhidaAlterar,idPj ); 
    
        if(testeOpcao == true){
        
            oqAlterar(numeroOpcaoEscolhidaAlterar,idPj);
        
        }else{
    
            acaoOpc1(Integer.toString(numeroOpcaoEscolhidaAlterar), Integer.toString(idPj));
        }
        
    
    }
    
    
    public static void alterarPjNome(Integer idPj){
        EntidadeInterfaceDAO fabricaPJ = PessoaJuridicaFabrica(); 
        PessoaJuridica pessoaJuridica = (PessoaJuridica) fabricaPJ.buscarPorId(idPj); 
        Scanner sc = new Scanner(in);  
             
        out.println("Qual a Razao Social");    
        String novaPJ = sc.nextLine();        
        pessoaJuridica.setNome(novaPJ);    
        fabricaPJ.atualizar(pessoaJuridica);
        out.println("=========================");
        out.println("Nome Pessoa Juridica Atualizado com sucesso");
        out.println("=========================");
        err.println(pessoaJuridica.toString());
    }
    
    
    
    public static void AlterarPjEndereço(Integer idPj){
        EntidadeInterfaceDAO fabricaPJ = PessoaJuridicaFabrica(); 
        PessoaJuridica pessoaJuridica = (PessoaJuridica) fabricaPJ.buscarPorId(idPj); 
        Scanner sc = new Scanner(in);  
        
        out.println("Qual a o novo Logradouro?");
        String novoLogradouro = sc.nextLine();
        out.println("Qual a Cidade?");
        String novaCidade = sc.nextLine();
        out.println("Qual a o novo Estado?");
        String novoEstado = sc.nextLine();
        pessoaJuridica.setLogradouro(novoLogradouro);
        pessoaJuridica.setCidade(novaCidade);
        pessoaJuridica.setEstado(novoEstado);
        fabricaPJ.atualizar(pessoaJuridica);
        out.println("=========================");
         out.println("Endereco Pessoa Juridica Atualizado com sucesso");
        out.println("=========================");
        err.println(pessoaJuridica.toString());
    }
    
   public static void AlterarPjEmail(Integer idPj){
        EntidadeInterfaceDAO fabricaPJ = PessoaJuridicaFabrica(); 
        PessoaJuridica pessoaJuridica = (PessoaJuridica) fabricaPJ.buscarPorId(idPj); 
        Scanner sc = new Scanner(in);  
        out.println("Qual o novo Email?");
        String novoEmail = sc.nextLine();
        pessoaJuridica.setEmail(novoEmail);
        fabricaPJ.atualizar(pessoaJuridica);
        out.println("=========================");
        out.println("Email Pessoa Juridica Atualizado com sucesso");
        out.println("=========================");
        err.println(pessoaJuridica.toString());
        
   }
   
   public static void AlterarPjTelefone(Integer idPj){
        EntidadeInterfaceDAO fabricaPJ = PessoaJuridicaFabrica(); 
        PessoaJuridica pessoaJuridica = (PessoaJuridica) fabricaPJ.buscarPorId(idPj); 
        Scanner sc = new Scanner(in);  
        out.println("Qual o novo Telefone?");
        String novoTelefone = sc.nextLine();
        pessoaJuridica.setTelefone(novoTelefone);
        fabricaPJ.atualizar(pessoaJuridica);
        out.println("=========================");
        out.println("Telefone Pessoa Juridica Atualizado com sucesso");
        out.println("=========================");
   }
   
   public static void AlterarPjTodosItens(Integer idPj){
       
        EntidadeInterfaceDAO fabricaPJ = PessoaJuridicaFabrica(); 
        PessoaJuridica pessoaJuridica = (PessoaJuridica) fabricaPJ.buscarPorId(idPj); 
        Scanner sc = new Scanner(in);  
        
        out.println("Qual a Razao Social");    
        String novaPJ = sc.nextLine();        
        out.println("Qual a o novo Logradouro?");
        String novoLogradouro = sc.nextLine();
        out.println("Qual a Cidade?");
        String novaCidade = sc.nextLine();
        out.println("Qual a o novo Estado?");
        String novoEstado = sc.nextLine(); 
        out.println("Qual o novo Email?");
        String novoEmail = sc.nextLine();
        out.println("Qual o novo Cnpj?");
        String novoCnpj = sc.nextLine();
        out.println("Qual o novo Telefone?");
        String novoTelefone = sc.nextLine();
        out.println("Qual Id do Usuario Responsavel?");
        Integer novoUsuario = sc.nextInt();
        
        pessoaJuridica.setNome(novaPJ); 
        pessoaJuridica.setLogradouro(novoLogradouro);
        pessoaJuridica.setCidade(novaCidade);
        pessoaJuridica.setEstado(novoEstado);
        pessoaJuridica.setEmail(novoEmail);
        pessoaJuridica.setCnpj(novoCnpj);
        pessoaJuridica.setTelefone(novoTelefone);
        pessoaJuridica.setIdUsuarioResponsavel(novoUsuario);
        
        fabricaPJ.atualizar(pessoaJuridica);
        out.println("=========================");
         out.println("Pessoa Juridica Atualizada com sucesso");
        out.println("=========================");
   }
   
   public static void AlterarPjCnpj(Integer idPj){
       EntidadeInterfaceDAO fabricaPj = PessoaJuridicaFabrica();
       PessoaJuridica pessoajuridica = (PessoaJuridica) fabricaPj.buscarPorId(idPj);
       Scanner sc = new Scanner(in); 
        out.println("Qual o novo Cnpj?");
       String novoCnpj = sc.nextLine();
       pessoajuridica.setCnpj(novoCnpj);
       fabricaPj.atualizar(pessoajuridica);
        out.println("=========================");
        out.println("Cnpj Pessoa Juridica Atualizado com sucesso");
        out.println("=========================");
     
   }
   
   public static void AlterarPjUsuarioResponsavel(Integer idPj){
       EntidadeInterfaceDAO fabricaPj = PessoaJuridicaFabrica();
       PessoaJuridica pessoajuridica = (PessoaJuridica) fabricaPj.buscarPorId(idPj);
       Scanner sc = new Scanner(in); 
        out.println("Qual Id do Usuario Responsavel?");
       Integer IdnovoUsuario = sc.nextInt();
       pessoajuridica.setIdUsuarioResponsavel(IdnovoUsuario);
       fabricaPj.atualizar(pessoajuridica);
        out.println("=========================");
        out.println("Usuario responsavel pela Pessoa Juridica Atualizado com sucesso");
        out.println("=========================");
       
   }
   
     //===============================
            // BUSCAR POR ID
    //===============================
    
    public static void consultarPjId(Integer id){
        
    EntidadeInterfaceDAO fabricnpj = PessoaJuridicaFabrica();
    PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(id);
        out.println("Pessoa Juridica Encontrada");
        err.println(pj.toString());
    
    }
    
    
    
    //===============================
            // EXIBIR TODOS
    //===============================
    public static void exibirTodosPj(){
    EntidadeInterfaceDAO fabricnpj = PessoaJuridicaFabrica();
  
    List <PessoaJuridica> list =new ArrayList<>();
    
    list = fabricnpj.todos(); 
    
    
    for(PessoaJuridica obj: list) { 
            err.println(obj); 
    
        }
    }
    
    //===============================
            // DELETAR POR ID
    //===============================
    
    public static void deletarPj(Integer id){
        EntidadeInterfaceDAO fabricnpj = PessoaJuridicaFabrica();
        PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(id);
        fabricnpj.deletar(id);
	out.println("Pessoa Juridica Deletada");
        err.println(pj.toString());
    
    }
    
     //===============================
            // BUSCAR POR NOME PRIMEIRA OCORRENCIA
    //===============================
    
    public static void buscarPjNome(String nomePj){
        EntidadeInterfaceDAO fabricnpj = PessoaJuridicaFabrica();
        Object pj = fabricnpj.buscarPorNome(nomePj);
        out.println("Pessoa Juridica Encontrada");
        err.println(pj.toString());
        
    }
    
    
    //===============================
            // BUSCAR POR NOME TODAS OCORRENCIA
    //===============================
    
    public static void buscarPjNomeTodasOcorrencia(String nomePj) {
    EntidadeInterfaceDAO fabricnpj = PessoaJuridicaFabrica();
    List<PessoaJuridica> list = fabricnpj.BuscartodosNomes(nomePj);
    
    if (list.isEmpty()) {
            out.println("Nenhuma correspondência encontrada para o nome: " + nomePj);
    } else {
        for (PessoaJuridica obj : list) {
                out.println("Todas a Pessoas Juridicas Encontradas");
           
                err.println(obj);
        }
    }
}


}
    
  
