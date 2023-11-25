package top.jota.dao.servers;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import top.jota.servlets.paginaDashboerdServlet;


public class ClaintServerSocket {
    
    private final String SERVER_ADDRESS = "127.0.0.1";
    private final int PORTA = 8083;
    private ObjectOutputStream oos;
    private ObjectInputStream ois ;
    private Scanner sc;
        
    public ClaintServerSocket() throws IOException {
        Socket socket = new Socket(SERVER_ADDRESS, PORTA);
        this.oos = new ObjectOutputStream(socket.getOutputStream());
        this.ois = new ObjectInputStream(socket.getInputStream());
          
      }

    
     public static void main(String[] args) throws IOException {
        ClaintServerSocket cliente = new ClaintServerSocket();
        cliente.start();
    }
   
     
     public String start() throws IOException {
         // conecta ao servidor na porta 
        Socket socket = new Socket(SERVER_ADDRESS, PORTA);
        if(socket != null){
            System.out.println("Cliente Conectado no IP = " + socket.getLocalSocketAddress() + ", e Porta n= " + PORTA);
            return "Cliente Conectado no IP = " + socket.getLocalSocketAddress() + ", e Porta nº= " + PORTA;
        }else{
             System.err.println("Problemas ao conectar ao Servidor -  Conectado no IP = " + socket.getLocalSocketAddress() + ", e Porta nº= " + PORTA);
             return "Problemas ao conectar ao Servidor -  Conectado no IP = " + socket.getLocalSocketAddress() + ", e Porta n= " + PORTA;
           
        }
    }
   
  /*

    public void menu() {
        System.err.println("Escolha uma das opções");
        System.err.println("1 Páginas");
        System.err.println("2 Mensagens");
        String resp = sc.nextLine();

        if (resp.equalsIgnoreCase("1")) {
           
              

        } else if (resp.equalsIgnoreCase("2")) {
            try {
               

                Thread enviarThread = new Thread(() -> enviarMsg(socket));
                Thread receberThread = new Thread(() -> receberMsg(socket));

                enviarThread.start();
                receberThread.start();

                // Aguarda as threads terminarem
                enviarThread.join();
                receberThread.join();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Certifique-se de fechar o socket e outros recursos aqui, se necessário
            }

        } else {
            System.err.println("Escolha outra Opção, Opção escolhida Errada");
        }
    }

    public void enviarMsg(Socket socket) {
        try {
          
            while (true) {
                System.out.println("Digite sua mensagem para enviar ao servidor:");
                String msg = sc.nextLine();
                oos.writeObject(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receberMsg(Socket socket) {
         try {
                String mensagem = (String) ois.readObject();
                System.out.println("Mensagem recebida do servidor: " + mensagem);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
    }

    public void solicitarPagina(Socket socket) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(socket.getInputStream());

            while (true) {
                System.out.println("Digite a página que deseja solicitar:");
                String pagina = sc.nextLine();
                oos.writeObject(pagina);

               
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public void p() throws ServletException {
        try {
            // Aqui você pode autenticar a senha antes de chamar o servlet
            paginaDashboerdServlet servlet = new paginaDashboerdServlet();
            HttpServletRequest request = null; // Substitua com um objeto HttpServletRequest válido
            HttpServletResponse response = null; // Substitua com um objeto HttpServletResponse válido
            servlet.processRequest(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
    

   */
}
