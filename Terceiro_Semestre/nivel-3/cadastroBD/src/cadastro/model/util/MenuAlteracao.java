/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;



public class MenuAlteracao {

    public static String menuAlteracao() {
        StringBuilder menuText = new StringBuilder();

        menuText.append("1 - Nome\n");
        menuText.append("2 - Endereco\n");
        menuText.append("3 - Email\n");
        menuText.append("4 - Telefone\n");
        menuText.append("5 - Tudo\n");
        menuText.append("0 - Finalizar\n");
        
        return (menuText.toString()); 
    }
   
}
