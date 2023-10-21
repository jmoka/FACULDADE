/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

import cadastro.model.implementacao.implementacaoMenu;

public class Testes {
    
    
    public static boolean EInteiros(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
    public static boolean EaOpcao(String str){
        int hashCodestr = str.hashCode();
        int hashCodeF = "F".hashCode();    
        int hashCodef = "f".hashCode();    
        int hashCodeJ = "J".hashCode(); 
        int hashCodej = "j".hashCode();  
        int hashCodeX = "X".hashCode();   
        int hashCodex = "x".hashCode();
        int hashCodeInt = Integer.toString(123).hashCode(); 
        int hashCodeFloat = Float.toString(1.23f).hashCode();
        
    return (hashCodestr == hashCodeF || hashCodestr == hashCodef || 
            hashCodestr == hashCodeJ || hashCodestr == hashCodej ||
            hashCodestr == hashCodeX || hashCodestr == hashCodex) && 
            (hashCodestr != hashCodeInt && hashCodestr != hashCodeFloat);      
        
    }
       
    
     public static Boolean EString(String opcaoScolhida){
             
        Boolean str = EaOpcao(opcaoScolhida);
                
        if(!(str)){
            System.out.println("Opcao Errada, Escolha apenas F, J ou X"); 
            System.out.println("Vamos Tentar novamente"); 
            implementacaoMenu.MenuSecundario();
           }
         System.out.println("oK"); 
         return str;
    }
    
    
    
}
    

