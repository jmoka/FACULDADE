/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.Aplicacao;

import cadastro.model.dao.view.DaoViewUsuario;
import cadastro.model.dao.view.viewMenu;
import cadastro.model.util.MenuAlteracao;
import cadastro.model.util.MenuUsuarioOqTrocar;
import cadastro.model.util.Testes;
import java.util.Scanner;

public class ProgramaPrincipal {
     public static void main(String[] args) {
         
         // Verificar o primeiro meu
         String opc1 = viewMenu.menuPrincipal();
         System.out.println(opc1);
         Integer num = Integer.parseInt(opc1);
         
         
         if(num >=1 && num<=7){
             
         String opc2 = viewMenu.menuSecundario();
         
         System.out.println(opc2);
         
          if ("x".equalsIgnoreCase(opc2)) {
                System.out.println("Fechando o programa. Adeus!");
                System.exit(0);   
          } else {
                            
               
                viewMenu.iniciarAcao1(opc1, opc2);
        }     
         
         }else if(num == 8 ){    
            String numn = Integer.toString(num);             
            Testes.acaoOpc1(numn, null);
             
             
         }else if(num==9){
             Scanner sc = new Scanner(System.in);
             System.out.println("Vamos Iniciar a Alteracao do Usuario");    
             System.out.println("O que voce gostaria de Trocar");
             System.out.println(MenuUsuarioOqTrocar.menuUsuarioOqTrocar());
             String opcao = sc.nextLine();  
             String numn = Integer.toString(num); 
             Testes.acaoOpc1(numn, opcao);
             
         
         }else if(num==10){
            Scanner sc = new Scanner(System.in);
            String numn = Integer.toString(num);             
            Testes.acaoOpc1(numn, null);
            System.out.println("Qual o Id do Usuario que gostaria de Consultar");
            Integer idEscolhido = sc.nextInt();
            DaoViewUsuario.consultarUsuarioId(idEscolhido);
             
             
         
         
         } else if(num==11){   
              Scanner sc = new Scanner(System.in);
             
         
         }else if(num==0){
             System.out.println("Fechando o programa. Adeus!");
             System.exit(0); 
         
         }
        
      
          
         
      
        
     }
}
