/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.dao.view;

import static cadastro.model.util.MenuPfPj.menuPfPjString;

import static cadastro.model.util.MenuPrincipal.menuPadraoString;

import static cadastro.model.util.Testes.EInteiros;
import static cadastro.model.util.Testes.EString;
import static java.lang.System.err;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;



public class viewMenu { 
       
    public static String menuPrincipal(){
        Scanner sc = new Scanner(in);  
        String menuPrincipal = menuPadraoString();
        out.println(menuPrincipal);
        String opcaoScolhida = sc.nextLine(); 
        
        while(!(EInteiros(opcaoScolhida))){
            err.println("Digite Somente Numeros Inteiros ralacionados acima de 0 a 11"); 
            opcaoScolhida = sc.nextLine();
            } 
           
            return opcaoScolhida;
             
            }          
    
    public static String menuSecundario(){
        Scanner sc = new Scanner(in);
        String opcaoEscolhida2;
    
    while (true) {
            out.println(menuPfPjString());
        opcaoEscolhida2 = sc.nextLine();        
        opcaoEscolhida2 = EString(opcaoEscolhida2);        
        if (opcaoEscolhida2 != null) {
            break; 
        }        
            out.println("Opcao Errada, Escolha apenas F, J ou X");
            out.println("Vamos Tentar novamente");
    }
     
    return opcaoEscolhida2;
        
    }   
  
   
    
}
    

