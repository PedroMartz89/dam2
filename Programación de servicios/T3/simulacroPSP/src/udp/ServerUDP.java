package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;

public class ServerUDP {
    private static HashMap<String, String> dns = new HashMap<>();
    public static void main(String[] args) {
        final int PORT = 9999;

        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(datagramPacket);

                String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println("Mensaje recibido: " + message);
                String[] mensajeSeparado = message.split(" ");
                String comando = mensajeSeparado[0].toUpperCase();
                String dominio = mensajeSeparado[1];
                String dirIP = "";
                if (mensajeSeparado.length > 2) {
                    dirIP = mensajeSeparado[2];
                }

                String respuesta;
                switch (comando) {
                    case "RESOLVE":
                        respuesta = resolveDominio(dominio);
                        break;
                    case "ADD":
                        respuesta = addDominio(dominio, dirIP);
                        break;
                    case "REMOVE":
                        respuesta = removeDominio(dominio);
                        break;
                    default:
                        respuesta = "Comando no reconocido.";
                }

                byte[] bufferRespuesta = respuesta.getBytes();
                DatagramPacket respuestaPacket = new DatagramPacket(bufferRespuesta,
                        bufferRespuesta.length,
                        datagramPacket.getAddress(),
                        datagramPacket.getPort());

                socket.send(respuestaPacket);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String removeDominio(String dominio) {
        dns.remove(dominio);
        return "Dominio " + dominio + " eliminado correctamente.";
    }

    private static String addDominio(String dominio, String ip) {
        dns.put(dominio, ip);
        return "Añadido correctamente";
    }

    private static String resolveDominio(String dominio) {
        if (dns.get(dominio) != null) {
            return dns.get(dominio);
        }
        return "EL dominio no está registrado";
    }
}
