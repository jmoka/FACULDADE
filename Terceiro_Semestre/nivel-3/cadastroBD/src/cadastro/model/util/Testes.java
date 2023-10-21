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
       
    
     public static String EString(String opcaoScolhida2){
             
        if (!EaOpcao(opcaoScolhida2)) {
         return null; 
    }
    return opcaoScolhida2; //
    }
    
    
    
}
    

