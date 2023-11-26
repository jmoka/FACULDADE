package top.jota.dao.servers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorSocket {

    //1-estancia o servidor ServerSocket
    private ServerSocket servidor;
    //2- instancia a posta e declara a mesma
    private final int porta = 8083;
    //3- estancia a interface ExecutorService passando o método Executors.newCachedThreadPool(), responsavel por gerenciar as threds
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private Scanner sc = new Scanner(System.in);

    //no metodo main instancio a propria classe e passo o método start para iniciar
          public static void main(String[] args) {
          ServidorSocket servidorSocket = new ServidorSocket();
          servidorSocket.start();

   }

    // metodo start
    public ServerSocket start() {

        try {
            // inicializo o servidor passando a porta
            servidor = new ServerSocket(porta);
             
            
                System.out.println("Servidor iniciado na porta: " + porta);

                // cria um lanço infinito esperando a conexão dos clientes
                while (true) {
                    // ServerSocket é utilizado para aguardar e aceitar solicitações de conexão vindas de clientes.
                    // accept(): Este método é chamado no ServerSocket. Ele fica bloqueado, aguardando a chegada de uma 
                    //solicitação de conexão de um cliente.
                    Socket clienteSocket = servidor.accept();
                    System.out.println("Cliente conectado: " + clienteSocket.getRemoteSocketAddress());

                    // Crie uma thread ou use o ExecutorService para manipular a lógica do cliente
                    executorService.execute(() -> handleClient(clienteSocket));
                }   
                                  
            
             
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
        } finally {
            encerrarServidor();
        }
        return servidor;
       
        

    }

    private void handleClient(Socket socket) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            while (true) {
                // Add your logic here to handle both sending and receiving messages
                enviarMsg(oos);
                receberMsg(ois);
            }
        } catch (IOException e) {

        } finally {
            fecharSocket(socket);
        }
    }

    public void enviarMsg(ObjectOutputStream oos) {
        //4- Entrada de dados pelo Usuario

        while (true) {
            System.out.println("Digite sua mensagem para enviar ao Cliente:");
            String msg = sc.nextLine();
            try {
                oos.writeObject(msg);
            } catch (IOException ex) {
                System.out.println("Erro ao enviar a Mensagem ao Cliente");
            }
        }

    }

    public void receberMsg(ObjectInputStream ois) {

        while (true) {
            try {
                String mensagem = (String) ois.readObject();
                System.out.println("Mensagem recebida do servidor: " + mensagem);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

    }

    private void fecharSocket(Socket socket) {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            System.err.println("Erro ao fechar o socket: " + e.getMessage());
        }
    }

    private void encerrarServidor() {
        try {
            if (servidor != null && !servidor.isClosed()) {
                servidor.close();
                executorService.shutdownNow();
            }
        } catch (IOException e) {
            System.err.println("Erro ao encerrar o servidor: " + e.getMessage());
        }
    }
}
