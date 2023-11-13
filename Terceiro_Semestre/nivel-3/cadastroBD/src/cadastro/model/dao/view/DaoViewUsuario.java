/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.dao.view;

import cadastro.model.entidades.Usuario;
import java.util.Scanner;

import static cadastro.model.fabrica.FabricaPessoas.UsuarioFabrica;
import cadastro.model.interfacs.EntidadeInterfaceDAO;
import java.io.Serializable;
import static java.lang.System.err;
import static java.lang.System.in;
import static java.lang.System.out;

public class DaoViewUsuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
    //===============================
            // INCLUIR USUÁRIO
    //===============================    
    
    public static void inserirUsuario() {
 
    EntidadeInterfaceDAO fabricaUsuario = UsuarioFabrica();  
  
    Scanner sc = new Scanner(in); 
        out.println("Vamos Iniciar o Cadastro do Usuario");
        out.println("Responda as Perguntas");
        out.println("Qual e o Nome do Usuario");    
    String nome = sc.nextLine();        
        out.println("Qual a Senha Usuario");
    String senha = sc.nextLine();    
    Usuario novoUsuario = new Usuario(0, nome, senha);
    fabricaUsuario.inserir(novoUsuario);    
        out.println("Cadastro do Usuario concluido com sucesso.");    
        err.println(novoUsuario.toString());
}

    //===============================
            // ALTERAR NOME DO USUÁRIO POR ID
    //===============================   
    
    public static void alterarNomeUsuarioId(Integer id) {    
    Scanner sc = new Scanner(in);
    EntidadeInterfaceDAO fabricaUsuario = UsuarioFabrica(); 
    Usuario usuario = (Usuario) fabricaUsuario.buscarPorId(id); 
        out.println("Qual o Nome do Novo Usuario");    
    String novoUsuario = sc.nextLine();        
    usuario.setLogin(novoUsuario);    
    fabricaUsuario.atualizar(usuario);
        out.println("Nome do Usuario Alterado com sucesso.");  
        err.println(usuario.toString());
       
    }
    
     //===============================
            // ALTERAR SENHA DO USUÁRIO POR ID
    //===============================   
    
    public static void alterarSenhaUsuarioId(Integer id) {    
    Scanner sc = new Scanner(in);
    EntidadeInterfaceDAO fabricaUsuario = UsuarioFabrica();    
    Usuario usuario = (Usuario) fabricaUsuario.buscarPorId(id);   
        out.println("Qual a Senha do Novo Usuario");    
    String novaSenha = sc.nextLine();        
    usuario.setSenha(novaSenha);    
    fabricaUsuario.atualizar(usuario);
        out.println("Senha do Usuario cadastrada com sucesso.");  
        err.println(usuario.toString());
       
    }
  
     //===============================
            // BUSCAR USUÁRIO POR ID
    //===============================
    
    public static void consultarUsuarioId(Integer id){        
    EntidadeInterfaceDAO fabricaUsuario = UsuarioFabrica();
    Usuario usuario = (Usuario) fabricaUsuario.buscarPorId(id); 
        out.println("Busca do Usuario concluida com Sucesso.");  
        err.println(usuario);   
    
    }
        
    //===============================
            // DELETAR TODOS
    //===============================
    
    public static void deletarUsuarioId(Integer id){
    EntidadeInterfaceDAO fabricaUsuario = UsuarioFabrica();
    Usuario usuario = (Usuario) fabricaUsuario.buscarPorId(id); 
    fabricaUsuario.deletar(id);
        out.println("Usuario deletado com sucesso.");  
        err.println(usuario);  
    
    
    }
    
    

}
    
  
