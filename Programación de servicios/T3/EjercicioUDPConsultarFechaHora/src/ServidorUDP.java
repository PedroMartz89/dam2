import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ServidorUDP {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            while (true) {

                //El servidor espera el mensaje
                byte[] buffer = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(datagramPacket);

                //Convertir datos a String
                String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println("Mensaje recibido: " + message);

                //Validar que ha escrito el cliente
                String respuesta;
                switch (message.toUpperCase()) {
                    case "HORA":
                        respuesta = mostrarHora();
                        break;
                    case "FECHA":
                        respuesta = mostrarFecha();
                        break;
                    case "DIA":
                        respuesta = mostrarDia();
                        break;
                    case "MILLIS":
                        respuesta = mostrarMilis();
                        break;
                    default:
                        respuesta = "Comando no reconocido.";
                }

                //Enviar respuesta al cliente
                byte[] bufferRespuesta = respuesta.getBytes();
                DatagramPacket respuestaPacket = new DatagramPacket(bufferRespuesta,
                        bufferRespuesta.length,
                        datagramPacket.getAddress(),
                        datagramPacket.getPort());

                socket.send(respuestaPacket);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String mostrarFecha () {
        return String.valueOf(LocalDate.now());
    }
    public static String mostrarHora () {
        return String.valueOf(LocalTime.now());
    }

    public static String mostrarDia () {
        return String.valueOf(LocalDate.now().getDayOfWeek());
    }

    public static String mostrarMilis () {
        return String.valueOf(System.currentTimeMillis());
    }

}