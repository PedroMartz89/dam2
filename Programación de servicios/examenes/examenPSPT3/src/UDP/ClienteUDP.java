package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) {

        try (DatagramSocket socket = new DatagramSocket();
             Scanner sc = new Scanner(System.in)) {

            InetAddress address = InetAddress.getByName("localhost");
            int serverPort = 9999;

            //Enviar mensaje al server
            System.out.println("Escribe un comando (LANZA, INFO, RESET): ");
            byte[] mensajeEnviar = sc.nextLine().getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(mensajeEnviar, mensajeEnviar.length, address, serverPort);
            socket.send(datagramPacket);

            //Recibir respuesta del server
            byte[] bufferRespuesta = new byte[1024];
            DatagramPacket respuestaServer = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
            socket.receive(respuestaServer);

            //Mostrar respuesta del servidor
            String respuesta = new String(respuestaServer.getData(), 0, respuestaServer.getLength());
            System.out.println("Respuesta del servidor: " + respuesta);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
