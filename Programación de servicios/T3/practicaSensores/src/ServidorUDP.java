import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;

public class ServidorUDP extends Thread {
    private HashMap<Integer, Sensor> hashMapSensores;
    private int puerto;
    public ServidorUDP(HashMap<Integer, Sensor> hashMapSensores) {
        this.hashMapSensores = hashMapSensores;
        this.puerto = 7777;
    }

    @Override
    public void run() {
        while (true) {
            try (DatagramSocket socket = new DatagramSocket(puerto)){
                byte[] buffer = new byte[1024];
                while (!isInterrupted()) {
                    DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                    socket.receive(paquete);

                    String info = new String(paquete.getData());
                    //procesar
                    System.out.println("Se ha recibido el mensaje: " + info);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
