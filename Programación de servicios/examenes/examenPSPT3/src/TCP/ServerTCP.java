package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServerTCP {
    public static Map<String, Subasta> subastas = new ConcurrentHashMap<>();
    static final int PORT = 3000;
    public static void main(String[] args) {


        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Se ha arrancado el servidor. Esperando conexiones");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Se ha conectado un cliente, IP: " + socket.getInetAddress() + " Puerto: " + socket.getPort());

                new Thread(new GestorSubasta(socket)).start();

            }
        } catch (IOException e) {
            System.out.println("Error en el servidor.");
            throw new RuntimeException(e);
        }
    }
}
