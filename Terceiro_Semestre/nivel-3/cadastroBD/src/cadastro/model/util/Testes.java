/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

import cadastro.model.implementacao.implementacaoMenu;

public class Testes {
    
    
    public static boolean EInteiros(String str) {
           
        int numero;
        try {
            numero = Integer.parseInt(str);
            
            return (numero >= 0 && numero <= 5);
        } 
        catch (NumberFormatException e) {
            return false; 
        }
    }
         
    public static boolean EaOpcao(String str){
        if("F".equalsIgnoreCase(str) || "J".equalsIgnoreCase(str) || "X".equalsIgnoreCase(str)){
        
            return true;
        }
            return false;         
    }
       
    
     public static String EString(String opcaoScolhida2){
             
        if (!EaOpcao(opcaoScolhida2)) {
         return null; 
    }
    return opcaoScolhida2; //
    }
     
     
     
    public static Boolean acaoOpc1(String opc1, String opc2) {
        Integer numero = Integer.parseInt(opc1); // Adicione um ponto e vírgula aqui

    switch (numero) {
        case 1:
           if ("f".equalsIgnoreCase(opc2)) {
                inserirPf();
            } else if ("j".equalsIgnoreCase(opc2)) {
                inserirPj();
            } else {
                System.out.println("Opcao inválida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 2:
           if ("f".equalsIgnoreCase(opc2)) {
                alterarPfId();
            } else if ("j".equalsIgnoreCase(opc2)) {
                alterarPjId();
            } else {
                System.out.println("Opcao inválida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 3:
            if ("f".equalsIgnoreCase(opc2)) {
                deletarPfId();
            } else if ("j".equalsIgnoreCase(opc2)) {
                deletarPjId();
            } else {
                System.out.println("Opcao inválida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 4:
           if ("f".equalsIgnoreCase(opc2)) {
                consultarPfId();
            } else if ("j".equalsIgnoreCase(opc2)) {
                consultarPjId();
            } else {
                System.out.println("Opcao inválida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 5:
           if ("f".equalsIgnoreCase(opc2)) {
                consultarPfTodos();
            } else if ("j".equalsIgnoreCase(opc2)) {
                consultarPjTodos();
            } else {
                System.out.println("Opcao inválida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        default:
            System.out.println("Opcao inválida");
            break;
    }

    return null;
}
     
     public static void inserirPf(){
         System.out.println("metodo inserir pessoa Fisica");
     }
      public static void inserirPj(){
         System.out.println("metodo inserir pessoa Juricica");
     }
      public static void alterarPfId(){
         System.out.println("metodo alterar pessoa Fisica");
     }
      public static void alterarPjId(){
         System.out.println("metodo alterar pessoa Juricica");
     }
      public static void deletarPfId(){
         System.out.println("metodo deletar pessoa Fisica");
     }
      public static void deletarPjId(){
         System.out.println("metodo deletar pessoa Juricica");
     }
     public static void consultarPfId(){
         System.out.println("metodo consultarId pessoa Fisica");
     }
      public static void consultarPjId(){
         System.out.println("metodo consultarId pessoa Juricica");
     }
       public static void consultarPfTodos(){
         System.out.println("metodo consultar Todas pessoa Fisica");
     }
      public static void consultarPjTodos(){
         System.out.println("metodo consultar Todas pessoa Juricica");
     }
      
    
    
    
}
    

