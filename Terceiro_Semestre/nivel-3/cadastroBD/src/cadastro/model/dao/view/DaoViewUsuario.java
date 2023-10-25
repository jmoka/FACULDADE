/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.dao.view;

import cadastro.model.entidades.Usuario;
import java.util.Scanner;

import cadastro.model.fabrica.FabricaPessoas;
import cadastro.model.interfacs.EntidadeInterfaceDAO;
import cadastro.model.util.MenuUsuarioOqTrocar;
import cadastro.model.util.Testes;
import java.util.ArrayList;
import java.util.List;

public class DaoViewUsuario {
    
    //===============================
            // INCLUIR USUÁRIO
    //===============================    
    
    public static void inserirUsuario() {
    System.err.println("tste");
    EntidadeInterfaceDAO fabricaUsuario = FabricaPessoas.UsuarioFabrica();  
    System.err.println("tste");
    Scanner sc = new Scanner(System.in); 
    System.out.println("Vamos Iniciar o Cadastro do Usuario");
    System.out.println("Responda as Perguntas");
    System.out.println("Qual e o Nome do Usuario");    
    String nome = sc.nextLine();        
    System.out.println("Qual a Senha Usuario");
    String senha = sc.nextLine();    
    Usuario novoUsuario = new Usuario(0, nome, senha);
    fabricaUsuario.inserir(novoUsuario);    
    System.out.println("Cadastro do Usurio concluido com sucesso.");    
    System.err.println(novoUsuario.toString());
}

    //===============================
            // ALTERAR USUÁRIO POR ID
    //===============================   
    
    public static void alterarUsuarioId(Integer id) {    
    Scanner sc = new Scanner(System.in);
    EntidadeInterfaceDAO fabricaUsuario = FabricaPessoas.UsuarioFabrica();    
    Usuario usuario = (Usuario) fabricaUsuario.buscarPorId(id);   
    System.out.println("=========================");
    System.out.println("Usuario Atual");
    System.out.println("=========================");
    System.err.println(usuario);    
    System.out.println("Qual o Nome do Novo Usuario");    
    String novoUsuario = sc.nextLine();        
    usuario.setLogin(novoUsuario);    
    fabricaUsuario.atualizar(usuario);
    System.out.println("=========================");
    System.out.println("Novo Usuario");
    System.out.println("=========================");
    System.err.println(usuario.toString());
       
    }
  
     //===============================
            // BUSCAR USUÁRIO POR ID
    //===============================
    
    public static void consultarUsuarioId(Integer id){        
    Scanner sc = new Scanner(System.in);
    EntidadeInterfaceDAO fabricaUsuario = FabricaPessoas.UsuarioFabrica();
    Usuario usuario = (Usuario) fabricaUsuario.buscarPorId(id); 
    System.out.println("=========================");
    System.out.println("Usuario Encontrado");
    System.out.println("=========================");
    System.err.println(usuario);   
    
    }
    /*
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
*/

}
    
  
