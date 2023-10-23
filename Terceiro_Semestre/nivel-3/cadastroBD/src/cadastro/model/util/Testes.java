/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;
import cadastro.model.dao.view.DaoViewPF;
import cadastro.model.dao.view.DaoViewPJ;
import cadastro.model.entidades.Pessoa;
import cadastro.model.entidades.PessoaJuridica;

import java.util.Scanner;




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
        
    switch (numero) {
        case 1:
           if ("f".equalsIgnoreCase(opc2)) {
                DaoViewPF.inserirPf();
            } else if ("j".equalsIgnoreCase(opc2)) {
                DaoViewPJ.inserirPJ();
            } else {
                System.out.println("Opcao inválida para letra: " + opc2);
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
                System.out.println("Opcao inválida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 3:
            if ("f".equalsIgnoreCase(opc2)) {
                DaoViewPF.deletarPfId();
            } else if ("j".equalsIgnoreCase(opc2)) {
                DaoViewPJ.deletarPjId();
            } else {
                System.out.println("Opcao inválida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 4:
           if ("f".equalsIgnoreCase(opc2)) {
                DaoViewPF.consultarPfId();
            } else if ("j".equalsIgnoreCase(opc2)) {
                DaoViewPJ.consultarPjId();
            } else {
                System.out.println("Opcao inválida para letra: " + opc2);
            }
            System.out.println("Opcao Escolhida foi a: " + numero);
            break;
        case 5:
           if ("f".equalsIgnoreCase(opc2)) {
                DaoViewPF.consultarPfTodos();
            } else if ("j".equalsIgnoreCase(opc2)) {
                DaoViewPJ.consultarPjTodos();
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
    
    public static String oqAlterar(String opcaoEscolhida) {
            PessoaJuridica pj = new PessoaJuridica();
            Scanner sc = new Scanner(System.in);
            String textDigitado = null;
    switch (opcaoEscolhida) {
        case "1":           
            System.out.println("Qual é a nova Razão Social?");            
            String novaRazaoSocial = sc.nextLine();
            textDigitado = novaRazaoSocial;
                               
            break;
        case "2":
            System.out.println("Qual é o novo Logradouro?");
            String novoLogradouro = sc.nextLine();
            pj.setLogradouro(novoLogradouro);
            break;
        case "3":
            System.out.println("Qual é a nova Cidade?");
            String novaCidade = sc.nextLine();
            pj.setCidade(novaCidade);
            break;
        // Repita para outros campos
        case "9":
            System.out.println("Saindo sem alterações.");
            break;
        default:
            System.out.println("Opção inválida.");
    }

    return textDigitado;
}
    

    
}
    

