/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.implementacao;

import cadastro.model.util.MenuPfPj;
import cadastro.model.util.MenuPrincipal;
import cadastro.model.util.Testes;
import java.util.Scanner;


public class implementacaoMenu { 
       
    public static String menuPrincipal(){
        Scanner sc = new Scanner(System.in);  
        String resultado = MenuPrincipal.menuPadraoString();
        System.out.println(resultado);
        String opcaoScolhida = sc.nextLine(); 
        
        while(!(Testes.EInteiros(opcaoScolhida))){
            System.out.println("Digite Somente Numeros Inteiros ralacionados acima de 0 a 5"); 
            opcaoScolhida = sc.nextLine();
            } 
           
            return opcaoScolhida;
             
            }          
    
    public static String menuSecundario(){
        Scanner sc = new Scanner(System.in);
        String opcaoEscolhida2;
    
    while (true) {
        System.out.println(MenuPfPj.menuPfPjString());
        opcaoEscolhida2 = sc.nextLine();        
        opcaoEscolhida2 = Testes.EString(opcaoEscolhida2);        
        if (opcaoEscolhida2 != null) {
            break; 
        }        
        System.out.println("Opcao Errada, Escolha apenas F, J ou X");
        System.out.println("Vamos Tentar novamente");
    }
    
    return opcaoEscolhida2;
        
    }
   
    
    
}
    

