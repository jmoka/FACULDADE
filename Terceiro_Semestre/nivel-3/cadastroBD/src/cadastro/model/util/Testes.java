/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;
import cadastro.model.dao.view.DaoViewPF;
import cadastro.model.dao.view.DaoViewPJ;
import cadastro.model.dao.view.DaoViewUsuario;
import cadastro.model.entidades.Pessoa;
import cadastro.model.entidades.PessoaJuridica;
import cadastro.model.entidades.Usuario;
import cadastro.model.fabrica.FabricaPessoas;
import cadastro.model.interfacs.EntidadeInterfaceDAO;

import java.util.Scanner;


public class Testes {
    
    
    public static boolean EInteiros(String str) {
           
        int numero;
        try {
            numero = Integer.parseInt(str);
            
            return (numero >= 0 && numero <= 11);
        } 
        catch (NumberFormatException e) {
            return false; 
        }
    }
         
    public static boolean EaOpcao(String str){
            return "F".equalsIgnoreCase(str) || "J".equalsIgnoreCase(str) || "X".equalsIgnoreCase(str);         
    }
       
    
     public static String EString(String opcaoScolhida2){
             
        if (!EaOpcao(opcaoScolhida2)) {
         return null; 
    }
    return opcaoScolhida2; //
    }
     
     
    public static Pessoa acaoOpc1(String opc1, String opc2) {
        Integer numero = Integer.parseInt(opc1); // Adicione um ponto e vírgula aqui
        Scanner sc = new Scanner(System.in);
        EntidadeInterfaceDAO fabricaUsuario = FabricaPessoas.UsuarioFabrica(); 
    
        
    switch (numero) {
        case 1:
           if ("f".equalsIgnoreCase(opc2)) {
                DaoViewPF.inserirPf();
            } else if ("j".equalsIgnoreCase(opc2)) {
                DaoViewPJ.inserirPJ();
            } else {
                System.out.println("Opcao invalida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 2:
           if ("f".equalsIgnoreCase(opc2)) {
                System.out.println("Qual o Id da Pessoa Fisica que Gostaria de Alterar?");
                Integer dPf= sc.nextInt(); 
                DaoViewPF.alterarPfId(dPf);
            } else if ("j".equalsIgnoreCase(opc2)) {
                
                System.out.println("Qual o Id da Pessoa Juridica que Gostaria de Alterar?");
                Integer dPj = sc.nextInt(); 
                DaoViewPJ.alterarPjId(dPj);
            } else {
                System.out.println("Opcao invalida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 3:
            if ("f".equalsIgnoreCase(opc2)) {
                DaoViewPF.deletarPfId();
            } else if ("j".equalsIgnoreCase(opc2)) {
                
                System.out.println("Qual o Id da Pessoa Juridica que Gostaria de Deletar?");
                Integer dPj = sc.nextInt(); 
                DaoViewPJ.deletarPj(dPj);
            } else {
                System.out.println("Opcao invalida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 4:
           if ("f".equalsIgnoreCase(opc2)) {
                DaoViewPF.consultarPfId();
            } else if ("j".equalsIgnoreCase(opc2)) {
                
                System.out.println("Qual e O ID da Pessoa Juridica que Gostaria de Buscar");    
                Integer idPj = sc.nextInt();
                DaoViewPJ.consultarPjId(idPj);
            } else {
                System.out.println("Opcao invalida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 5:
           if ("f".equalsIgnoreCase(opc2)) {
                DaoViewPF.consultarPfTodos();
            } else if ("j".equalsIgnoreCase(opc2)) {
                DaoViewPJ.exibirTodosPj();
            } else {
                System.out.println("Opcao invalida para letra: " + opc2);
            }
           
            break;
            
        case 6:
           if ("f".equalsIgnoreCase(opc2)) {
                DaoViewPF.consultarPfTodos();
            } else if ("j".equalsIgnoreCase(opc2)) {
                System.out.println("Qual e Nome da Empresa que gastaria de Consultar");    
                String nomePj = sc.nextLine();                
                DaoViewPJ.buscarPjNome(nomePj);
            } else {
                System.out.println("Opcao invalida para letra: " + opc2);
            }
           
            break;
            
         case 7:
           if ("f".equalsIgnoreCase(opc2)) {
                DaoViewPF.consultarPfTodos();
            } else if ("j".equalsIgnoreCase(opc2)) {
                System.out.println("Qual e Nome da Empresa que gastaria de Consultar");    
                String nomePj = sc.nextLine();                
                DaoViewPJ.buscarPjNomeTodasOcorrencia(nomePj);
            } else {
                System.out.println("Opcao invalida para letra: " + opc2);
            }
           
            break;
            
         case 8:   
             DaoViewUsuario.inserirUsuario();
           
            break;
            
         case 9:   
             if ("n".equalsIgnoreCase(opc2)) {
                
                 System.out.println("Qual o codigo do Usuario");    
                 Integer codigoEscilhido = sc.nextInt();                  
                 DaoViewUsuario.alterarNomeUsuarioId(codigoEscilhido);                       
                
            } else if ("s".equalsIgnoreCase(opc2)) {
                
                System.out.println("Qual o codigo do Usuario");    
                Integer codigoEscilhido = sc.nextInt();                  
                DaoViewUsuario.alterarSenhaUsuarioId(codigoEscilhido);
            }           
            break;
            case 10:
                                
                System.out.println("Qual o Id do Usuario que gostaria de Consultar");
                Integer idEscolhido = sc.nextInt();
                Usuario usuario = (Usuario) fabricaUsuario.buscarPorId(idEscolhido);
                
                if(usuario==null){   
                    System.err.println("Usuario nao Encontrado");
                    acaoOpc1("10", null);
                    }
                else{
                    
                    DaoViewUsuario.consultarUsuarioId(idEscolhido);
                    System.out.println("Consulta Reallizada com Sucesso.");
                }
            break;
            case 11: 
                System.out.println("Qual o Id do Usuario que gostaria de Deletar");
                idEscolhido = sc.nextInt();
                usuario = (Usuario) fabricaUsuario.buscarPorId(idEscolhido);
                
                 if (usuario == null) {
                    System.err.println("Usuario nao encontrado");
                    acaoOpc1("11", null);
               } else {
                    DaoViewUsuario.deletarUsuarioId(idEscolhido);
                    System.out.println("Usuario deletado com sucesso.");
                }         
            break; 
 
        default:
            System.out.println("Opcao invalida");
            break;
    }
        return null;

}
    
    public static String oqAlterar(String opcaoEscolhida) {
            PessoaJuridica pj = new PessoaJuridica();
            Scanner sc = new Scanner(System.in);
            String textDigitado = null;
    switch (opcaoEscolhida) {
        case "1":           
            System.out.println("Qual a a nova Razao Social?");            
            String novaRazaoSocial = sc.nextLine();
            textDigitado = novaRazaoSocial;
                               
            break;
        case "2":
            System.out.println("Qual a o novo Logradouro?");
            String novoLogradouro = sc.nextLine();
            System.out.println("Qual a Cidade?");
            String novaCidade = sc.nextLine();
            System.out.println("Qual a o novo Estado?");
            String novoEstado = sc.nextLine();
                                 
            pj.setLogradouro(novoLogradouro);
            pj.setCidade(novaCidade);
            pj.setEstado(novoEstado);
            
            break;
        case "3":
            System.out.println("Qual a o Email?");
            String novoEmail = sc.nextLine();
            pj.setEmail(novoEmail);
            break;
        case "4":
            System.out.println("Qual e o Telefone?");
            String novoTelefone = sc.nextLine();
            pj.setTelefone(novoTelefone);
            break;            
        case "5":
            System.out.println("Qual e a nova Razao Social?");            
            novaRazaoSocial = sc.nextLine();
            System.out.println("Qual e o novo Logradouro?");
            novoLogradouro = sc.nextLine();
            System.out.println("Qual a Cidade?");
            novaCidade = sc.nextLine();
            System.out.println("Qual a o novo Estado?");
            novoEstado = sc.nextLine();
            System.out.println("Qual a o Email?");
            novoEmail = sc.nextLine();
            System.out.println("Qual e o Telefone?");
            novoTelefone = sc.nextLine();
            System.out.println("Qual e o Novo Usuario Responsavel pela Atualização?");
            novoTelefone = sc.nextLine();
            
            pj.setNome(novaRazaoSocial);
            pj.setLogradouro(novoLogradouro);
            pj.setCidade(novaCidade);
            pj.setEstado(novoEstado);
            pj.setEmail(novoEmail);
            pj.setTelefone(novoTelefone);
            break;
        // Repita para outros campos
        case "0":
            System.out.println("Saindo sem alteracoes.");
            break;
        default:
            System.out.println("Opcoe invalida.");
    }

    return textDigitado;
}
    
    public static String oqAlterarUsuario(String opcaoEscolhida) {
            Usuario usuario = new Usuario();
            Scanner sc = new Scanner(System.in);
            String textDigitado = null;
    switch (opcaoEscolhida) {
        case "1":           
            System.out.println("Qual e o novo Usuario?");            
            String novoUsuario = sc.nextLine();
            textDigitado = novoUsuario;
            System.err.println(textDigitado + "textDigitado");
            break; 
     /*
        case "2":
            System.out.println("Qual e a nova Senha");
            String novaSenha = sc.nextLine();
            usuario.setSenha(novaSenha);            
            break;
        case "3":
            System.out.println("Qual a o Email?");
            String novoEmail = sc.nextLine();
            pj.setEmail(novoEmail);
            break;
        case "4":
            System.out.println("Qual e o Telefone?");
            String novoTelefone = sc.nextLine();
            pj.setTelefone(novoTelefone);
            break;            
        case "5":
            System.out.println("Qual a a nova Razao Social?");            
            novaRazaoSocial = sc.nextLine();
            System.out.println("Qual a o novo Logradouro?");
            novoLogradouro = sc.nextLine();
            System.out.println("Qual a Cidade?");
            novaCidade = sc.nextLine();
            System.out.println("Qual a o novo Estado?");
            novoEstado = sc.nextLine();
            System.out.println("Qual a o Email?");
            novoEmail = sc.nextLine();
            System.out.println("Qual e o Telefone?");
            novoTelefone = sc.nextLine();
            System.out.println("Qual e o Novo Usuario Responsavel pela Atualização?");
            novoTelefone = sc.nextLine();
            
            pj.setNome(novaRazaoSocial);
            pj.setLogradouro(novoLogradouro);
            pj.setCidade(novaCidade);
            pj.setEstado(novoEstado);
            pj.setEmail(novoEmail);
            pj.setTelefone(novoTelefone);
            break;
        // Repita para outros campos
*/
        case "0":
            System.out.println("Saindo sem alteracoes.");
            break;
        default:
            System.out.println("Opcoe invalida.");
    }

    return textDigitado;
}
    
    

    
}
    

