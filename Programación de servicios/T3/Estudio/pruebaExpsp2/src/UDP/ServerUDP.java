package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;

public class ServerUDP {
    public static HashMap<String, String> dominios = new HashMap<>();
    static void main() {
        final int PORT = 9999;

        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            while (true) {

                //El servidor espera el mensaje
                byte[] buffer = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(datagramPacket);

                //Convertir datos a String
                String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println("Mensaje recibido: " + message);
                String[] comandoSeparado = message.trim().split(" ", 3);
                //Validar que ha escrito el cliente
                String respuesta;
                String comando = comandoSeparado[0].toUpperCase();
                String dominio = (comandoSeparado.length > 1) ? comandoSeparado[1] : "";
                String ip = (comandoSeparado.length > 2) ? comandoSeparado[2] : "";
                switch (comando) {
                    case "RESOLVE":
                        respuesta = resolverDominio(dominio);
                        break;
                    case "ADD":
                        respuesta = nuevoDominio(dominio, ip);
                        break;
                    case "REMOVE":
                        respuesta = eliminarDominio(dominio);
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

    private static String eliminarDominio(String dominio) {
        if (dominios.containsKey(dominio)) {
            dominios.remove(dominio);
            return "Se ha eliminado el dominio correctamente.";
        } else {
            return "No se pudo eliminar el registro porque no existe.";
        }
    }

    private static String nuevoDominio(String dominio, String ip) {
        dominios.put(dominio, ip);
        return "Se ha añadido correctamente.";
    }

    private static String resolverDominio(String dominio) {
        return dominios.getOrDefault(dominio, "No existe el dominio en los registros.");
    }
}
