/*
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
public class MenuUsuarioOqTrocar {
   

    public MenuUsuarioOqTrocar() {
       
    }

    public static String menuUsuarioOqTrocar() {
        StringBuilder menuText = new StringBuilder();

        menuText.append(">>>>>>>> AGORA ESCOLHA <<<<<<<<<\n");
        menuText.append("N - Nome\n");
        menuText.append("S - Senha\n");
        menuText.append("x - Finalizar\n");
        
        return (menuText.toString()); 
    }
   
}
