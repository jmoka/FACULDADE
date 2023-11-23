package top.jota.dao.servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorSocket {

    private ServerSocket servidor;
    private final int porta = 8082;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        ServidorSocket servidorSocket = new ServidorSocket();
        servidorSocket.start();
    }

    public void start() {
        try {
            servidor = new ServerSocket(porta);
            System.out.println("Servidor iniciado na porta: " + porta);

            while (true) {
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
    }

    private void handleClient(Socket clienteSocket) {
        // Encerrar recursos relacionados ao cliente se necessário
        fecharSocket(clienteSocket);
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
