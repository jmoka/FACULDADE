/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

import java.util.Scanner;

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
        menuText.append(">>>>> Cadastro Pessoa Juridica e Pessoa Fisica <<<<<\n");
        menuText.append("1 - Incluir\n");
        menuText.append("2 - Alterar pelo ID\n");
        menuText.append("3 - Deletar pelo ID\n");
        menuText.append("4 - Buscar pelo ID\n");
        menuText.append("5 - Exibir Todos\n");
        menuText.append("6 - Buscar pelo Nome Primeira Ocorrencia\n");
        menuText.append("7 - Buscar pelo Nome Todas Ocorrencia\n");
        menuText.append(">>>>> Cadastro Usuario <<<<<\n");
        menuText.append("8 - Cadastar Usuario\n");
        menuText.append("9 - Atualizar Usuario\n");
        menuText.append("10- Consultar Usuario pelo ID\n");
        menuText.append("11- Deletar Usuario pelo ID\n");
        menuText.append("0 - Finalizar\n");
        
        return (menuText.toString()); 
    }
   
}
