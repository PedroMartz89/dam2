package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    final static int PORT = 9999;
    public static Map<String, Sala> salas = new ConcurrentHashMap<>();

    static void main() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Servidor TCP listo en puerto " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado en el puerto " + PORT);
                new Thread(new GestorHilos(socket)).start();

            }

        } catch (Exception e) {
            System.out.printf("Error en el servidor.");
            throw new RuntimeException(e);
        }
    }
}
