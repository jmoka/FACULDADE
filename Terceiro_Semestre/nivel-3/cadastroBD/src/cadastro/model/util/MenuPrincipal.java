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
public class MenuPrincipal {
     private Scanner sc;

    public MenuPrincipal() {
        // Inicialize o objeto Scanner no construtor
        sc = new Scanner(System.in);
    }

    public static String menuPadraoString() {
        StringBuilder menuText = new StringBuilder();

        menuText.append(">>>>>>>> MENU <<<<<<<<<\n");
        menuText.append(">>>>>>>> Escolha uma das Opcoes Abaixo <<<<<<<<<\n");
        menuText.append("1 - Incluir\n");
        menuText.append("2 - Alterar pelo ID\n");
        menuText.append("3 - Deletar pelo ID\n");
        menuText.append("4 - Buscar pelo ID\n");
        menuText.append("5 - Exibir Todos\n");
        menuText.append("0 - Finalizar\n");
        
        return (menuText.toString()); 
    }
   
}