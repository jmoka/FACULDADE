/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;
import cadastro.model.dao.view.DaoViewPF;
import static cadastro.model.dao.view.DaoViewPF.AlterarPfCPF;
import static cadastro.model.dao.view.DaoViewPF.AlterarPfEmail;
import static cadastro.model.dao.view.DaoViewPF.AlterarPfEndereço;
import static cadastro.model.dao.view.DaoViewPF.AlterarPfTelefone;
import static cadastro.model.dao.view.DaoViewPF.AlterarPfTodosItens;
import static cadastro.model.dao.view.DaoViewPF.AlterarPfUsuarioResponsavel;
import static cadastro.model.dao.view.DaoViewPF.alterarPfId;
import static cadastro.model.dao.view.DaoViewPF.alterarPfNome;
import static cadastro.model.dao.view.DaoViewPF.buscarPfNome;
import static cadastro.model.dao.view.DaoViewPF.buscarPfNomeTodasOcorrencia;
import static cadastro.model.dao.view.DaoViewPF.consultarPfId;
import static cadastro.model.dao.view.DaoViewPF.deletarPf;
import static cadastro.model.dao.view.DaoViewPF.exibirTodosPf;
import static cadastro.model.dao.view.DaoViewPF.inserirPF;
import cadastro.model.dao.view.DaoViewPJ;
import static cadastro.model.dao.view.DaoViewPJ.AlterarPjCnpj;
import static cadastro.model.dao.view.DaoViewPJ.AlterarPjEmail;
import static cadastro.model.dao.view.DaoViewPJ.AlterarPjEndereço;
import static cadastro.model.dao.view.DaoViewPJ.AlterarPjTelefone;
import static cadastro.model.dao.view.DaoViewPJ.AlterarPjTodosItens;
import static cadastro.model.dao.view.DaoViewPJ.AlterarPjUsuarioResponsavel;
import static cadastro.model.dao.view.DaoViewPJ.alterarPjId;
import static cadastro.model.dao.view.DaoViewPJ.alterarPjNome;
import static cadastro.model.dao.view.DaoViewPJ.buscarPjNome;
import static cadastro.model.dao.view.DaoViewPJ.buscarPjNomeTodasOcorrencia;
import static cadastro.model.dao.view.DaoViewPJ.consultarPjId;
import static cadastro.model.dao.view.DaoViewPJ.deletarPj;
import static cadastro.model.dao.view.DaoViewPJ.exibirTodosPj;
import static cadastro.model.dao.view.DaoViewPJ.inserirPJ;
import cadastro.model.dao.view.DaoViewUsuario;
import static cadastro.model.dao.view.DaoViewUsuario.alterarNomeUsuarioId;
import static cadastro.model.dao.view.DaoViewUsuario.alterarSenhaUsuarioId;
import static cadastro.model.dao.view.DaoViewUsuario.consultarUsuarioId;
import static cadastro.model.dao.view.DaoViewUsuario.deletarUsuarioId;
import static cadastro.model.dao.view.DaoViewUsuario.inserirUsuario;
import cadastro.model.entidades.Pessoa;
import cadastro.model.entidades.PessoaFisica;
import cadastro.model.entidades.PessoaJuridica;
import cadastro.model.entidades.Usuario;
import cadastro.model.fabrica.FabricaPessoas;
import static cadastro.model.fabrica.FabricaPessoas.PessoaFisicaFabrica;
import static cadastro.model.fabrica.FabricaPessoas.PessoaJuridicaFabrica;
import static cadastro.model.fabrica.FabricaPessoas.UsuarioFabrica;
import cadastro.model.interfacs.EntidadeInterfaceDAO;
import static java.lang.Integer.parseInt;
import static java.lang.System.err;
import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;


public class Testes {
    
    
    public static boolean EInteiros(String str) {
           
        int numero;
        try {
            numero = parseInt(str);
            
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
        Scanner sc = new Scanner(in);
        EntidadeInterfaceDAO fabricaUsuario = UsuarioFabrica(); 
    
        
    switch (numeroOpcaoEscolhida) {
        case "1":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                inserirPF();
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                inserirPJ();
            } else {
                out.println("Opcao invalida para letra: " + letraEscolhida);
            }
            
            break;
        case "2":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                out.println("Qual o Id da Pessoa Fisica que Gostaria de Alterar?");
                Integer idPf = sc.nextInt();  
                EntidadeInterfaceDAO fabricaPF = PessoaFisicaFabrica();
                PessoaFisica pf = (PessoaFisica) fabricaPF.buscarPorId(idPf);
                
                if(pf==null){   
                    err.println("Pessoa Fisica nao Encontrada");
                    acaoOpc1("2", "f");
                    }
                else{ 
                                       
                    alterarPfId(idPf);
                }    
                
                
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {                
                out.println("Qual o Id da Pessoa Juridica que Gostaria de Alterar?");
               Integer idPj = sc.nextInt();  
               EntidadeInterfaceDAO fabricnpj = PessoaJuridicaFabrica();
               PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(idPj);
              
                if(pj==null){   
                    err.println("Pessoa Juridica nao Encontrado");
                    acaoOpc1("2", "j");
                    }
                else{ 
                                       
                    alterarPjId(idPj);
                }      
                                  
            } else {
                out.println("Opcao invalida para letra: " + letraEscolhida);
                
        }
           
            break;
        case "3":
            if ("f".equalsIgnoreCase(letraEscolhida)) {
                
                out.println("Qual o Id da Pessoa Fisica que Gostaria de Deletar?");
                Integer idPf = sc.nextInt(); 
                
                EntidadeInterfaceDAO fabricaPF = PessoaFisicaFabrica();
                PessoaFisica pf = (PessoaFisica) fabricaPF.buscarPorId(idPf);
              
                if(pf==null){   
                    err.println("Pessoa Fisica nao Encontrada");
                    acaoOpc1("3", "f");
                    }
                else{ 
                                       
                     deletarPf(idPf);
                }  
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                
                out.println("Qual o Id da Pessoa Juridica que Gostaria de Deletar?");
                Integer idPj = sc.nextInt(); 
                
                EntidadeInterfaceDAO fabricnpj = PessoaJuridicaFabrica();
                PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(idPj);
              
                if(pj==null){   
                    err.println("Pessoa Juridica nao Encontrado");
                    acaoOpc1("3", "j");
                    }
                else{ 
                                       
                     deletarPj(idPj);
                }      
                
            } else {
                out.println("Opcao invalida para letra: " + letraEscolhida);
            }
            
            break;
        case "4":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
               
                out.println("Qual o Id da Pessoa Fisica que Gostaria de Buscar?");
                Integer idPf = sc.nextInt(); 
                
                EntidadeInterfaceDAO fabricaPF = PessoaFisicaFabrica();
                PessoaFisica pf = (PessoaFisica) fabricaPF.buscarPorId(idPf);
              
                if(pf==null){   
                    err.println("Pessoa Fisica nao Encontrada");
                    acaoOpc1("4", "f");
                    }
                else{ 
                                       
                     consultarPfId(idPf);
                }           
               
            
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                
                out.println("Qual e O ID da Pessoa Juridica que Gostaria de Buscar");    
                Integer idPj = sc.nextInt();
                
                EntidadeInterfaceDAO fabricnpj = PessoaJuridicaFabrica();
                PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(idPj);
              
                if(pj==null){   
                    err.println("Pessoa Juridica nao Encontrado");
                    acaoOpc1("4", "j");
                    }
                else{ 
                                       
                    consultarPjId(idPj);
                }    
            } else {
                out.println("Opcao invalida para letra: " + letraEscolhida);
            }
           
            break;
        case "5":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                 exibirTodosPf();
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                exibirTodosPj();
            } else {
                out.println("Opcao invalida para letra: " + letraEscolhida);
            }
           
            break;
            
        case "6":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                
                out.println("Qual e Nome da Pessoa que gastaria de Consultar");    
                String nomePf = sc.nextLine(); 
                
                EntidadeInterfaceDAO fabricaPF = PessoaFisicaFabrica();
                PessoaFisica pf = (PessoaFisica) fabricaPF.buscarPorNome(nomePf);
              
                if(pf==null){   
                    err.println("Pessoa Fisica nao Encontrada");
                    acaoOpc1("6", "f");
                    }
                else{ 
                                       
                     buscarPfNome(nomePf);
                } 
               
        
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                out.println("Qual e Nome da Empresa que gastaria de Consultar");    
                String nomePj = sc.nextLine(); 
                
                EntidadeInterfaceDAO fabricnpj = PessoaJuridicaFabrica();
                PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorNome(nomePj);
              
                if(pj==null){   
                    err.println("Pessoa Juridica nao Encontrado");
                    acaoOpc1("6", "j");
                    }
                else{ 
                                       
                    buscarPjNome(nomePj);
                }    
              
            } else {
                out.println("Opcao invalida para letra: " + letraEscolhida);
            }
           
            break;
            
         case "7":
           if ("f".equalsIgnoreCase(letraEscolhida)) {
                
                out.println("Qual e Nome da Pessoa que gastaria de Consultar");    
                String nomePf = sc.nextLine();  
                
                EntidadeInterfaceDAO fabricaCpf = PessoaFisicaFabrica();
                PessoaFisica pf = (PessoaFisica) fabricaCpf.buscarPorNome(nomePf);
              
                if(pf==null){   
                    err.println("Pessoa Fisica nao Encontrado");
                    acaoOpc1("7", "f");
                    }
                else{ 
                                       
                    buscarPfNomeTodasOcorrencia(nomePf);
                }    
           
            } else if ("j".equalsIgnoreCase(letraEscolhida)) {
                out.println("Qual e Nome da Empresa que gastaria de Consultar");    
                String nomePj = sc.nextLine();  
                
                EntidadeInterfaceDAO fabricnpj = PessoaJuridicaFabrica();
                PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorNome(nomePj);
              
                if(pj==null){   
                    err.println("Pessoa Juridica nao Encontrado");
                    acaoOpc1("7", "j");
                    }
                else{ 
                                       
                    buscarPjNomeTodasOcorrencia(nomePj);
                }    
                        
            } else {
                out.println("Opcao invalida para letra: " + letraEscolhida);
            }
           
            break;
            
         case "8":   
             inserirUsuario();
           
            break;
            
         case "9":   
             if ("n".equalsIgnoreCase(letraEscolhida)) {
                
                out.println("Qual o codigo do Usuario");    
                Integer codigoEscilhido = sc.nextInt();  
                 
                EntidadeInterfaceDAO fabriUsuario = UsuarioFabrica();
                Usuario usuario = (Usuario) fabriUsuario.buscarPorId(codigoEscilhido);
              
                if(usuario==null){   
                    err.println("Usuario nao Encontrado");
                    acaoOpc1("9", "n");
                    }
                else{ 
                    alterarNomeUsuarioId(codigoEscilhido);  
                }  
           
            } else if ("s".equalsIgnoreCase(letraEscolhida)) {
                
                out.println("Qual o codigo do Usuario");    
                Integer codigoEscilhido = sc.nextInt();  
                
                EntidadeInterfaceDAO fabriUsuario = UsuarioFabrica();
                Usuario usuario = (Usuario) fabriUsuario.buscarPorId(codigoEscilhido);
                
                
                if(usuario==null){   
                    err.println("Usuario nao Encontrado");
                    acaoOpc1("9", "s");
                    }
                else{ 
                    alterarSenhaUsuarioId(codigoEscilhido);
                }  
              
            }           
            break;
            case "10":
                                
                out.println("Qual o Id do Usuario que gostaria de Consultar");
                Integer codigoEscilhido = sc.nextInt();
                EntidadeInterfaceDAO fabriUsuario = UsuarioFabrica();
                Usuario usuario = (Usuario) fabriUsuario.buscarPorId(codigoEscilhido);
              
                if(usuario==null){   
                    err.println("Usuario nao Encontrado");
                    acaoOpc1("10", "j");
                    }
                else{ 
                 consultarUsuarioId(codigoEscilhido); 
                } 
                          
            break;
            
            case "11": 
                
                out.println("Qual o Id do Usuario que gostaria de Deletar");
                codigoEscilhido = sc.nextInt();
                usuario = (Usuario) fabricaUsuario.buscarPorId(codigoEscilhido);               
                     
                if(usuario==null){   
                    err.println("Usuario nao Encontrado");
                    acaoOpc1("11", "j");
                    }
                else{ 
                 deletarUsuarioId(codigoEscilhido);
                } 
            break; 
 
        default:
            out.println("Opcao invalida");
            break;
    }
        return null;

}
    
    public static Boolean testarOpcaoAlteracao(Integer numeroOpcaoEscolhidaAlterar , Integer idPj){
        
         if(numeroOpcaoEscolhidaAlterar >=0 && numeroOpcaoEscolhidaAlterar<=7 ){             
             return true;
                  
         }else{
             err.println("Opção Invalida!!");       
             alterarPjId(idPj);
                    
          }
        return null;
      
    }
    
    public static String oqAlterar(Integer numeroOpcaoEscolhida, Integer idPj) {       
            
            EntidadeInterfaceDAO fabricnpj = PessoaJuridicaFabrica();
            String numeroOpcaoEscolhidaAlterar = Integer.toString(numeroOpcaoEscolhida);            
            PessoaJuridica pj = (PessoaJuridica) fabricnpj.buscarPorId(idPj);        
            Scanner sc = new Scanner(in);
            String textDigitado = null;
            
    switch (numeroOpcaoEscolhidaAlterar) {
        case "1":             
            alterarPjNome(idPj);     
            break;
        case "2":
            AlterarPjEndereço(idPj);
            break;
        case "3":
            AlterarPjEmail(idPj);
            break;
        case "4":
            AlterarPjTelefone(idPj);
            break;            
        case "5":
            AlterarPjCnpj(idPj);
            break;
        case "6":
            AlterarPjUsuarioResponsavel(idPj);
            break;
            
        case "7":
            AlterarPjTodosItens(idPj);
            break;
        
        case "0":
            out.println("Fechando o programa. Adeus!");
            break;
        default:
            out.println("Opcoe invalida.");
    }

    return textDigitado;
}
    
    
    public static String oqAlterarPf(Integer numeroOpcaoEscolhida, Integer idPf) {       
            
            EntidadeInterfaceDAO fabricaPF = PessoaFisicaFabrica();
            String numeroOpcaoEscolhidaAlterar = Integer.toString(numeroOpcaoEscolhida);            
            PessoaFisica pf = (PessoaFisica) fabricaPF.buscarPorId(idPf);        
            Scanner sc = new Scanner(in);
            String textDigitado = null;
            
    switch (numeroOpcaoEscolhidaAlterar) {
        case "1":             
            alterarPfNome(idPf);     
            break;
        case "2":
            AlterarPfEndereço(idPf);
            break;
        case "3":
            AlterarPfEmail(idPf);
            break;
        case "4":
            AlterarPfTelefone(idPf);
            break;            
        case "5":
            AlterarPfCPF(idPf);
            break;
        case "6":
            AlterarPfUsuarioResponsavel(idPf);
            break;
            
        case "7":
            AlterarPfTodosItens(idPf);
            break;
        
        case "0":
            out.println("Fechando o programa. Adeus!");
            break;
        default:
            out.println("Opcoe invalida.");
    }

    return textDigitado;
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static String oqAlterarUsuario(String numeroOpcaoEscolhida) {
            Usuario usuario = new Usuario();
            Scanner sc = new Scanner(in);
            String textDigitado = null;
    switch (numeroOpcaoEscolhida) {
        case "1":           
            out.println("Qual e o novo Usuario?");            
            String novoUsuario = sc.nextLine();
            textDigitado = novoUsuario;
            break; 
     
        case "2":
            out.println("Qual e a nova Senha");
            String novaSenha = sc.nextLine();
            textDigitado = novaSenha;
            break;
        
        case "0":
            out.println("Saindo sem alteracoes.");
            break;
        default:
            out.println("Opcoe invalida.");
    }

    return textDigitado;
}
    
    
    
  
    
}
    

