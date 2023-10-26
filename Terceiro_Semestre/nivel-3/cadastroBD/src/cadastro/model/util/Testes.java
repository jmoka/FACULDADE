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
       
    
     public static String EString(String numeroOpcaoEscolhidaAlterarScolhida2){
             
        if (!EaOpcao(numeroOpcaoEscolhidaAlterarScolhida2)) {
         return null; 
    }
    return numeroOpcaoEscolhidaAlterarScolhida2; //
    }
     
     
    public static Pessoa acaoOpc1(String numeroOpcaoEscolhida, String letraEscolhida) {
         // Adicione um ponto e vírgula aqui
        Scanner sc = new Scanner(System.in);
        EntidadeInterfaceDAO fabricaUsuario = FabricaPessoas.UsuarioFabrica(); 
    
        
    switch (numeroOpcaoEscolhida) {
        case "1":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                DaoViewPF.inserirPf();
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                DaoViewPJ.inserirPJ();
            } else {
                System.out.println("Opcao invalida para letra: " + letraEscolhida);
            }
            
            break;
        case "2":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                System.out.println("Qual o Id da Pessoa Fisica que Gostaria de Alterar?");
                Integer dPf= sc.nextInt(); 
                DaoViewPF.alterarPfId(dPf);
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {                
               System.out.println("Qual o Id da Pessoa Juridica que Gostaria de Alterar?");
               Integer idPj = sc.nextInt();  
               EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
               PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(idPj);
              
                if(pj==null){   
                    System.err.println("Pessoa Juridica nao Encontrado");
                    acaoOpc1("2", "j");
                    }
                else{ 
                                       
                    DaoViewPJ.alterarPjId(idPj);
                }      
                                  
            } else {
                System.out.println("Opcao invalida para letra: " + letraEscolhida);
                
        }
           
            break;
        case "3":
            if ("f".equalsIgnoreCase(letraEscolhida)) {
                DaoViewPF.deletarPfId();
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                
                System.out.println("Qual o Id da Pessoa Juridica que Gostaria de Deletar?");
                Integer dPj = sc.nextInt(); 
                DaoViewPJ.deletarPj(dPj);
            } else {
                System.out.println("Opcao invalida para letra: " + letraEscolhida);
            }
            
            break;
        case "4":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                DaoViewPF.consultarPfId();
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                
                System.out.println("Qual e O ID da Pessoa Juridica que Gostaria de Buscar");    
                Integer idPj = sc.nextInt();
                DaoViewPJ.consultarPjId(idPj);
            } else {
                System.out.println("Opcao invalida para letra: " + letraEscolhida);
            }
           
            break;
        case "5":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                DaoViewPF.consultarPfTodos();
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                DaoViewPJ.exibirTodosPj();
            } else {
                System.out.println("Opcao invalida para letra: " + letraEscolhida);
            }
           
            break;
            
        case "6":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                DaoViewPF.consultarPfTodos();
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                System.out.println("Qual e Nome da Empresa que gastaria de Consultar");    
                String nomePj = sc.nextLine();                
                DaoViewPJ.buscarPjNome(nomePj);
            } else {
                System.out.println("Opcao invalida para letra: " + letraEscolhida);
            }
           
            break;
            
         case "7":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                DaoViewPF.consultarPfTodos();
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                System.out.println("Qual e Nome da Empresa que gastaria de Consultar");    
                String nomePj = sc.nextLine();                
                DaoViewPJ.buscarPjNomeTodasOcorrencia(nomePj);
            } else {
                System.out.println("Opcao invalida para letra: " + letraEscolhida);
            }
           
            break;
            
         case "8":   
             DaoViewUsuario.inserirUsuario();
           
            break;
            
         case "9":   
             if ("n".equalsIgnoreCase(letraEscolhida)) {
                
                 System.out.println("Qual o codigo do Usuario");    
                 Integer codigoEscilhido = sc.nextInt();                  
                 DaoViewUsuario.alterarNomeUsuarioId(codigoEscilhido);                       
                
            } else if ("s".equalsIgnoreCase(letraEscolhida)) {
                
                System.out.println("Qual o codigo do Usuario");    
                Integer codigoEscilhido = sc.nextInt();                  
                DaoViewUsuario.alterarSenhaUsuarioId(codigoEscilhido);
            }           
            break;
            case "10":
                                
                System.out.println("Qual o Id do Usuario que gostaria de Consultar");
                Integer idEsco = sc.nextInt();
                Usuario usuario = (Usuario) fabricaUsuario.buscarPorId(idEsco);
                
                if(usuario==null){   
                    System.err.println("Usuario nao Encontrado");
                    acaoOpc1("10", null);
                    }
                else{
                    
                    DaoViewUsuario.consultarUsuarioId(idEsco);
                    System.out.println("Consulta Reallizada com Sucesso.");
                }
            break;
            case "11": 
                System.out.println("Qual o Id do Usuario que gostaria de Deletar");
                idEsco = sc.nextInt();
                usuario = (Usuario) fabricaUsuario.buscarPorId(idEsco);
                
                 if (usuario == null) {
                    System.err.println("Usuario nao encontrado");
                    acaoOpc1("11", null);
               } else {
                    DaoViewUsuario.deletarUsuarioId(idEsco);
                    System.out.println("Usuario deletado com sucesso.");
                }         
            break; 
 
        default:
            System.out.println("Opcao invalida");
            break;
    }
        return null;

}
    
    public static Boolean testarOpcaoAlteracao(Integer numeroOpcaoEscolhidaAlterar , Integer idPj){
        
         if(numeroOpcaoEscolhidaAlterar >=0 && numeroOpcaoEscolhidaAlterar<=7 ){             
             return true;
                  
         }else{
             System.err.println("Opção Invalida!!");       
             DaoViewPJ.alterarPjId(idPj);
                    
          }
        return null;
      
    }
    
    public static String oqAlterar(Integer numeroOpcaoEscolhida, Integer idPj) {       
            
            EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
            String numeroOpcaoEscolhidaAlterar = Integer.toString(numeroOpcaoEscolhida);            
            PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(idPj);        
            Scanner sc = new Scanner(System.in);
            String textDigitado = null;
            
    switch (numeroOpcaoEscolhidaAlterar) {
        case "1":             
            DaoViewPJ.alterarPjNome(idPj);     
            break;
        case "2":
            DaoViewPJ.AlterarPjEndereço(idPj);
            break;
        case "3":
           DaoViewPJ.AlterarPjEmail(idPj);
            break;
        case "4":
            DaoViewPJ.AlterarPjTelefone(idPj);
            break;            
        case "5":
            DaoViewPJ.AlterarPjCnpj(idPj);
            break;
        case "6":
            DaoViewPJ.AlterarPjUsuarioResponsavel(idPj);
            break;
            
        case "7":
            DaoViewPJ.AlterarPjTodosItens(idPj);
            break;
        
        case "0":
            System.out.println("Fechando o programa. Adeus!");
            break;
        default:
            System.out.println("Opcoe invalida.");
    }

    return textDigitado;
}
    
    public static String oqAlterarUsuario(String numeroOpcaoEscolhida) {
            Usuario usuario = new Usuario();
            Scanner sc = new Scanner(System.in);
            String textDigitado = null;
    switch (numeroOpcaoEscolhida) {
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
    

