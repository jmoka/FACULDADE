/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

import cadastro.model.dao.view.daoViewPF;

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
                daoViewPF.inserirPf();
            } else if ("j".equalsIgnoreCase(opc2)) {
                daoViewPF.inserirPj();
            } else {
                System.out.println("Opcao inválida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 2:
           if ("f".equalsIgnoreCase(opc2)) {
                daoViewPF.alterarPfId();
            } else if ("j".equalsIgnoreCase(opc2)) {
                daoViewPF.alterarPjId();
            } else {
                System.out.println("Opcao inválida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 3:
            if ("f".equalsIgnoreCase(opc2)) {
                daoViewPF.deletarPfId();
            } else if ("j".equalsIgnoreCase(opc2)) {
                daoViewPF.deletarPjId();
            } else {
                System.out.println("Opcao inválida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 4:
           if ("f".equalsIgnoreCase(opc2)) {
                daoViewPF.consultarPfId();
            } else if ("j".equalsIgnoreCase(opc2)) {
                daoViewPF.consultarPjId();
            } else {
                System.out.println("Opcao inválida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 5:
           if ("f".equalsIgnoreCase(opc2)) {
                daoViewPF.consultarPfTodos();
            } else if ("j".equalsIgnoreCase(opc2)) {
                daoViewPF.consultarPjTodos();
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
     
     
    
    
    
}
    

