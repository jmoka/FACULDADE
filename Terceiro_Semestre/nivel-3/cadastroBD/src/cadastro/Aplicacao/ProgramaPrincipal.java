/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.Aplicacao;


import cadastro.model.dao.view.viewMenu;
import cadastro.model.entidades.Usuario;
import cadastro.model.util.MenuUsuarioOqTrocar;
import cadastro.model.util.Testes;
import java.util.Scanner;

public class ProgramaPrincipal {
     public static void main(String[] args) {
         
         // Verificar o primeiro meu
         String numeroOpcaoEscolhida = viewMenu.menuPrincipal();
         Integer num = Integer.parseInt(numeroOpcaoEscolhida);         
         if(num >=1 && num<=7){             
         String letraEscolhida = viewMenu.menuSecundario();        
     
          if ("x".equalsIgnoreCase(letraEscolhida)) {
                System.out.println("Fechando o programa. Adeus!");
                System.exit(0);   
          } else {
                  
               Testes.acaoOpc1(numeroOpcaoEscolhida, letraEscolhida);
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
            String numn = Integer.toString(num);    
            Testes.acaoOpc1(numn, null);
         
         } else if(num==11){   
            String numn = Integer.toString(num);             
            Testes.acaoOpc1(numn, null);
             
         }else if(num==0){
             System.out.println("Fechando o programa. Adeus!");
             System.exit(0); 
         
         }
  
     }
}
