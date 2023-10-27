/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;
import cadastro.model.dao.view.DaoViewPF;
import cadastro.model.dao.view.DaoViewPJ;
import cadastro.model.dao.view.DaoViewUsuario;
import cadastro.model.entidades.Pessoa;
import cadastro.model.entidades.PessoaFisica;
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
                DaoViewPF.inserirPF();
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                DaoViewPJ.inserirPJ();
            } else {
                System.out.println("Opcao invalida para letra: " + letraEscolhida);
            }
            
            break;
        case "2":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                System.out.println("Qual o Id da Pessoa Fisica que Gostaria de Alterar?");
                Integer idPf = sc.nextInt();  
                EntidadeInterfaceDAO fabricaPF = FabricaPessoas.PessoaFisicaFabrica();
                PessoaFisica pf = (PessoaFisica) fabricaPF.buscarPorId(idPf);
                
                if(pf==null){   
                    System.err.println("Pessoa Fisica nao Encontrada");
                    acaoOpc1("2", "f");
                    }
                else{ 
                                       
                    DaoViewPF.alterarPfId(idPf);
                }    
                
                
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
                
                System.out.println("Qual o Id da Pessoa Fisica que Gostaria de Deletar?");
                Integer idPf = sc.nextInt(); 
                
                EntidadeInterfaceDAO fabricaPF = FabricaPessoas.PessoaFisicaFabrica();
                PessoaFisica pf = (PessoaFisica) fabricaPF.buscarPorId(idPf);
              
                if(pf==null){   
                    System.err.println("Pessoa Fisica nao Encontrada");
                    acaoOpc1("3", "f");
                    }
                else{ 
                                       
                     DaoViewPF.deletarPf(idPf);
                }  
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                
                System.out.println("Qual o Id da Pessoa Juridica que Gostaria de Deletar?");
                Integer idPj = sc.nextInt(); 
                
                EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
                PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(idPj);
              
                if(pj==null){   
                    System.err.println("Pessoa Juridica nao Encontrado");
                    acaoOpc1("3", "j");
                    }
                else{ 
                                       
                     DaoViewPJ.deletarPj(idPj);
                }      
                
            } else {
                System.out.println("Opcao invalida para letra: " + letraEscolhida);
            }
            
            break;
        case "4":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
               
                System.out.println("Qual o Id da Pessoa Fisica que Gostaria de Buscar?");
                Integer idPf = sc.nextInt(); 
                
                EntidadeInterfaceDAO fabricaPF = FabricaPessoas.PessoaFisicaFabrica();
                PessoaFisica pf = (PessoaFisica) fabricaPF.buscarPorId(idPf);
              
                if(pf==null){   
                    System.err.println("Pessoa Fisica nao Encontrada");
                    acaoOpc1("4", "f");
                    }
                else{ 
                                       
                     DaoViewPF.consultarPfId(idPf);
                }           
               
            
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                
                System.out.println("Qual e O ID da Pessoa Juridica que Gostaria de Buscar");    
                Integer idPj = sc.nextInt();
                
                EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
                PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(idPj);
              
                if(pj==null){   
                    System.err.println("Pessoa Juridica nao Encontrado");
                    acaoOpc1("4", "j");
                    }
                else{ 
                                       
                    DaoViewPJ.consultarPjId(idPj);
                }    
            } else {
                System.out.println("Opcao invalida para letra: " + letraEscolhida);
            }
           
            break;
        case "5":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                 DaoViewPF.exibirTodosPf();
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                DaoViewPJ.exibirTodosPj();
            } else {
                System.out.println("Opcao invalida para letra: " + letraEscolhida);
            }
           
            break;
            
        case "6":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                
                System.out.println("Qual e Nome da Pessoa que gastaria de Consultar");    
                String nomePf = sc.nextLine(); 
                
                EntidadeInterfaceDAO fabricaPF = FabricaPessoas.PessoaFisicaFabrica();
                PessoaFisica pf = (PessoaFisica) fabricaPF.buscarPorNome(nomePf);
              
                if(pf==null){   
                    System.err.println("Pessoa Fisica nao Encontrada");
                    acaoOpc1("6", "f");
                    }
                else{ 
                                       
                     DaoViewPF.buscarPfNome(nomePf);
                } 
               
        
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                System.out.println("Qual e Nome da Empresa que gastaria de Consultar");    
                String nomePj = sc.nextLine(); 
                
                EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
                PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorNome(nomePj);
              
                if(pj==null){   
                    System.err.println("Pessoa Juridica nao Encontrado");
                    acaoOpc1("6", "j");
                    }
                else{ 
                                       
                    DaoViewPJ.buscarPjNome(nomePj);
                }    
              
            } else {
                System.out.println("Opcao invalida para letra: " + letraEscolhida);
            }
           
            break;
            
         case "7":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                
                System.out.println("Qual e Nome da Pessoa que gastaria de Consultar");    
                String nomePf = sc.nextLine();  
                
                EntidadeInterfaceDAO fabricaCpf = FabricaPessoas.PessoaFisicaFabrica();
                PessoaFisica pf = (PessoaFisica) fabricaCpf.buscarPorNome(nomePf);
              
                if(pf==null){   
                    System.err.println("Pessoa Fisica nao Encontrado");
                    acaoOpc1("7", "f");
                    }
                else{ 
                                       
                    DaoViewPF.buscarPfNomeTodasOcorrencia(nomePf);
                }    
           
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                System.out.println("Qual e Nome da Empresa que gastaria de Consultar");    
                String nomePj = sc.nextLine();  
                
                EntidadeInterfaceDAO fabricnpj = FabricaPessoas.PessoaJuridicaFabrica();
                PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorNome(nomePj);
              
                if(pj==null){   
                    System.err.println("Pessoa Juridica nao Encontrado");
                    acaoOpc1("7", "j");
                    }
                else{ 
                                       
                    DaoViewPJ.buscarPjNomeTodasOcorrencia(nomePj);
                }    
                        
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
                 
                EntidadeInterfaceDAO fabriUsuario = FabricaPessoas.UsuarioFabrica();
                Usuario usuario = (Usuario) fabriUsuario.buscarPorId(codigoEscilhido);
              
                if(usuario==null){   
                    System.err.println("Usuario nao Encontrado");
                    acaoOpc1("9", "n");
                    }
                else{ 
                  DaoViewUsuario.alterarNomeUsuarioId(codigoEscilhido);  
                }  
           
            } else if ("s".equalsIgnoreCase(letraEscolhida)) {
                
                System.out.println("Qual o codigo do Usuario");    
                Integer codigoEscilhido = sc.nextInt();  
                
                EntidadeInterfaceDAO fabriUsuario = FabricaPessoas.UsuarioFabrica();
                Usuario usuario = (Usuario) fabriUsuario.buscarPorId(codigoEscilhido);
                
                
                if(usuario==null){   
                    System.err.println("Usuario nao Encontrado");
                    acaoOpc1("9", "s");
                    }
                else{ 
                  DaoViewUsuario.alterarSenhaUsuarioId(codigoEscilhido);
                }  
              
            }           
            break;
            case "10":
                                
                System.out.println("Qual o Id do Usuario que gostaria de Consultar");
                Integer codigoEscilhido = sc.nextInt();
                EntidadeInterfaceDAO fabriUsuario = FabricaPessoas.UsuarioFabrica();
                Usuario usuario = (Usuario) fabriUsuario.buscarPorId(codigoEscilhido);
              
                if(usuario==null){   
                    System.err.println("Usuario nao Encontrado");
                    acaoOpc1("10", "j");
                    }
                else{ 
                 DaoViewUsuario.consultarUsuarioId(codigoEscilhido); 
                } 
                          
            break;
            
            case "11": 
                
                System.out.println("Qual o Id do Usuario que gostaria de Deletar");
                codigoEscilhido = sc.nextInt();
                usuario = (Usuario) fabricaUsuario.buscarPorId(codigoEscilhido);               
                     
                if(usuario==null){   
                    System.err.println("Usuario nao Encontrado");
                    acaoOpc1("11", "j");
                    }
                else{ 
                 DaoViewUsuario.deletarUsuarioId(codigoEscilhido);
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
    
    
    public static String oqAlterarPf(Integer numeroOpcaoEscolhida, Integer idPf) {       
            
            EntidadeInterfaceDAO fabricaPF = FabricaPessoas.PessoaFisicaFabrica();
            String numeroOpcaoEscolhidaAlterar = Integer.toString(numeroOpcaoEscolhida);            
            PessoaFisica pf = (PessoaFisica) fabricaPF.buscarPorId(idPf);        
            Scanner sc = new Scanner(System.in);
            String textDigitado = null;
            
    switch (numeroOpcaoEscolhidaAlterar) {
        case "1":             
            DaoViewPF.alterarPfNome(idPf);     
            break;
        case "2":
            DaoViewPF.AlterarPfEndereço(idPf);
            break;
        case "3":
           DaoViewPF.AlterarPfEmail(idPf);
            break;
        case "4":
            DaoViewPF.AlterarPfTelefone(idPf);
            break;            
        case "5":
            DaoViewPF.AlterarPfCPF(idPf);
            break;
        case "6":
            DaoViewPF.AlterarPfUsuarioResponsavel(idPf);
            break;
            
        case "7":
            DaoViewPF.AlterarPfTodosItens(idPf);
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
            break; 
     
        case "2":
            System.out.println("Qual e a nova Senha");
            String novaSenha = sc.nextLine();
            textDigitado = novaSenha;
            break;
        
        case "0":
            System.out.println("Saindo sem alteracoes.");
            break;
        default:
            System.out.println("Opcoe invalida.");
    }

    return textDigitado;
}
    
    
    
  
    
}
    

