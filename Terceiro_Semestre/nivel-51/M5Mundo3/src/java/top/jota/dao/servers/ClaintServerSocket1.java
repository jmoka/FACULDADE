package top.jota.dao.servers;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import top.jota.servlets.paginaDashboerdServlet;


public class ClaintServerSocket1 {
    
     public static void main(String[] args) throws IOException {
        ClaintServerSocket cliente = new ClaintServerSocket();
        cliente.menu();
    }

    private final String SERVER_ADDRESS = "127.0.0.1";
    private final int PORTA = 9878;
    private ObjectOutputStream oos;
    private Scanner sc;

    public ClaintServerSocket1() {
        sc = new Scanner(System.in);
    }


    public void menu() {
        System.err.println("Escolha uma das opções");
        System.err.println("1 Páginas");
        System.err.println("2 Mensagens");
        String resp = sc.nextLine();

        if (resp.equalsIgnoreCase("1")) {
            try {
                Socket socket = new Socket(SERVER_ADDRESS, PORTA);
                System.err.println(
                        "Cliente Conectado no IP = " + SERVER_ADDRESS + ", e Porta nº= " + PORTA);

                solicitarPagina(socket);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Certifique-se de fechar o socket e outros recursos aqui, se necessário
            }

        } else if (resp.equalsIgnoreCase("2")) {
            try {
                Socket socket = new Socket(SERVER_ADDRESS, PORTA);
                System.err.println(
                        "Cliente Conectado no IP = " + SERVER_ADDRESS + ", e Porta nº= " + PORTA);

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
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
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
            Scanner scanner = new Scanner(socket.getInputStream());
            while (true) {
                String mensagem = scanner.nextLine();
                System.out.println("Mensagem recebida do servidor: " + mensagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
    

   
}
