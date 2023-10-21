/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.implementacao;

import cadastro.model.util.MenuPfPj;
import cadastro.model.util.MenuPrincipal;
import cadastro.model.util.Testes;
import java.util.Scanner;

/**
 *
 * @author jotac
 */
public class implementacaoMenu {
    
    public static void Menus(){
        Scanner sc = new Scanner(System.in);       
        String resultado = MenuPrincipal.menuPadraoString();
        System.out.println(resultado);
        String opcaoScolhida = sc.nextLine();         
        while(!(Testes.EInteiros(opcaoScolhida))){
            System.out.println("Digite Somente Numeros Inteiros ralacionadas acima"); 
            opcaoScolhida = sc.nextLine();
        } 
            System.out.println(MenuPfPj.menuPfPjString());
        
    
    }
}
    

