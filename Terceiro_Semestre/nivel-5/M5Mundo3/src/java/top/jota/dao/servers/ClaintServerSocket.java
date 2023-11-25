package top.jota.dao.servers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClaintServerSocket {

    private final String SERVER_ADDRESS = "127.0.0.1";
    private final int PORTA = 8083;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
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
        if (socket != null) {
            System.out.println("Cliente Conectado no IP = " + socket.getLocalSocketAddress() + ", e Porta n= " + PORTA);
            return "Cliente Conectado no IP = " + socket.getLocalSocketAddress() + ", e Porta nº= " + PORTA;
        } else {
            System.err.println("Problemas ao conectar ao Servidor -  Conectado no IP = " + socket.getLocalSocketAddress() + ", e Porta nº= " + PORTA);
            return "Problemas ao conectar ao Servidor -  Conectado no IP = " + socket.getLocalSocketAddress() + ", e Porta n= " + PORTA;

        }
    }

}
