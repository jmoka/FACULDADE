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
            // ALTERAR NOME DO USUÁRIO POR ID
    //===============================   
    
    public static void alterarNomeUsuarioId(Integer id) {    
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
            // ALTERAR SENHA DO USUÁRIO POR ID
    //===============================   
    
    public static void alterarSenhaUsuarioId(Integer id) {    
    Scanner sc = new Scanner(System.in);
    EntidadeInterfaceDAO fabricaUsuario = FabricaPessoas.UsuarioFabrica();    
    Usuario usuario = (Usuario) fabricaUsuario.buscarPorId(id);   
    System.out.println("=========================");
    System.out.println("Usuario Atual");
    System.out.println("=========================");
    System.err.println(usuario);    
    System.out.println("Qual a Senha do Novo Usuario");    
    String novaSenha = sc.nextLine();        
    usuario.setSenha(novaSenha);    
    fabricaUsuario.atualizar(usuario);
    System.out.println("=========================");
    System.out.println("Usuario com Nova Senha");
    System.out.println("=========================");
    System.err.println(usuario.toString());
       
    }
  
     //===============================
            // BUSCAR USUÁRIO POR ID
    //===============================
    
    public static void consultarUsuarioId(Integer id){        
    EntidadeInterfaceDAO fabricaUsuario = FabricaPessoas.UsuarioFabrica();
    Usuario usuario = (Usuario) fabricaUsuario.buscarPorId(id); 
    System.err.println(usuario);   
    
    }
        
    //===============================
            // DELETAR TODOS
    //===============================
    
    public static void deletarUsuarioId(Integer id){
    EntidadeInterfaceDAO fabricaUsuario = FabricaPessoas.UsuarioFabrica();
    Usuario usuario = (Usuario) fabricaUsuario.buscarPorId(id); 
    fabricaUsuario.deletar(id);
    System.err.println(usuario);  
    
    
    }
    
    

}
    
  
