/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.Aplicacao;


import cadastro.model.dao.view.viewMenu;
import static cadastro.model.dao.view.viewMenu.menuPrincipal;
import static cadastro.model.dao.view.viewMenu.menuSecundario;
import cadastro.model.entidades.Usuario;
import cadastro.model.util.MenuUsuarioOqTrocar;
import static cadastro.model.util.MenuUsuarioOqTrocar.menuUsuarioOqTrocar;
import cadastro.model.util.Testes;
import static cadastro.model.util.Testes.acaoOpc1;
import static java.lang.Integer.parseInt;
import static java.lang.System.exit;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

public class ProgramaPrincipal {
     public static void main(String[] args) {
         
         // Verificar o primeiro meu
         String numeroOpcaoEscolhida = menuPrincipal();
         Integer num = parseInt(numeroOpcaoEscolhida);         
         if(num >=1 && num<=7){             
         String letraEscolhida = menuSecundario();        
     
          if ("x".equalsIgnoreCase(letraEscolhida)) {
                out.println("Fechando o programa. Adeus!");
                exit(0);   
          } else {
                  
                acaoOpc1(numeroOpcaoEscolhida, letraEscolhida);
        }     
         
         }else if(num == 8 ){    
            String numn = Integer.toString(num);             
            acaoOpc1(numn, null);
          
         }else if(num==9){
             Scanner sc = new Scanner(in);
             out.println("Vamos Iniciar a Alteracao do Usuario");    
             out.println("O que voce gostaria de Trocar");
             out.println(menuUsuarioOqTrocar());
             String opcao = sc.nextLine();  
             String numn = Integer.toString(num); 
             acaoOpc1(numn, opcao);
          
         }else if(num==10){
            String numn = Integer.toString(num);    
            acaoOpc1(numn, null);
         
         } else if(num==11){   
            String numn = Integer.toString(num);             
            acaoOpc1(numn, null);
             
         }else if(num==0){
             out.println("Fechando o programa. Adeus!");
             exit(0); 
         
         }
  
     }
}
