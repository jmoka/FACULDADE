package top.jota.dao.server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClaintServerSocket {
    
    
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
       
// Obtém o endereço IP do localhost; se o servidor estiver em outro IP, você precisa usar esse IP
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream msgClient = null;
        ObjectInputStream lerMsgServidor = null;
     
        socket = new Socket(host.getHostName(), 9876);
            
        // Escreve no soquete usando ObjectOutputStream
            msgClient = new ObjectOutputStream(socket.getOutputStream());
            
            System.out.println("Enviando solicitação para o Servidor de Socket");
        
                msgClient.writeObject("oi" );
                           
                

            // Lê a mensagem de resposta do servidor
            lerMsgServidor = new ObjectInputStream(socket.getInputStream());
            String mensagem = (String) lerMsgServidor.readObject();
            System.out.println("Mensagem: " + mensagem);

            // Fecha os recursos
            

            // Aguarda por um curto período antes da próxima iteração
            Thread.sleep(100);
        }
    
    }

