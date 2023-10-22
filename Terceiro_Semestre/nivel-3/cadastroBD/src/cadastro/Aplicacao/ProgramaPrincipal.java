/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.Aplicacao;

import cadastro.model.dao.view.viewMenu;

public class ProgramaPrincipal {
     public static void main(String[] args) {
         
         // Verificar o primeiro meu
         String opc1 = viewMenu.menuPrincipal();
         System.out.println(opc1);
         Integer num = Integer.parseInt(opc1);
         if(num==0){
            System.out.println("Fechando o programa. Adeus!");
            System.exit(0);    
                 }
          
         // Testar o menu 2
         String opc2 = viewMenu.menuSecundario();
         System.out.println(opc2);
          if ("x".equalsIgnoreCase(opc2)) {
                System.out.println("Fechando o programa. Adeus!");
                System.exit(0);   
          } else {
                            
                System.out.println(opc1+","+opc2);
                viewMenu.iniciarAcao1(opc1, opc2);
        }     
        
     }
}
