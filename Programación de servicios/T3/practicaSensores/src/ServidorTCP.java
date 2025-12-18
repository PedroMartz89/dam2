import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServidorTCP extends Thread {

    private int puerto;
    private HashMap<Integer, Sensor> sensores;

    public ServidorTCP(HashMap<Integer, Sensor> sensores) {
        this.sensores = sensores;
        this.puerto = 8888;
    }

    @Override
    public void run() {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(puerto)) {
                Socket socket = serverSocket.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String mensaje = entrada.readLine();
                System.out.println("Se ha recibido el mensaje: " + mensaje);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
