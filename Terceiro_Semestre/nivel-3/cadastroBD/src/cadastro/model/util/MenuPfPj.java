/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

import java.util.Scanner;
import java.io.PrintStream;


/**
 *
 * @author jotac
 */
public class MenuPfPj {
   

    public MenuPfPj() {
       
    }

    public static String menuPfPjString() {
        StringBuilder menuText = new StringBuilder();

        menuText.append(">>>>>>>> AGORA ESCOLHA <<<<<<<<<\n");
        menuText.append("F - Pessoa Fisica\n");
        menuText.append("J - Pessoa Juridic\n");
        menuText.append("x - Finalizar\n");
        
        return (menuText.toString()); 
    }
   
}
