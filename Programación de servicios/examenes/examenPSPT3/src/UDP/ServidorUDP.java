package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class ServidorUDP {
    private static final int PORT = 9999;
    private static int tiradasHechas = 0;
    private static int dadosLanzados = 0;
    private static int resultadoMasAlto = 0;

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

                String[] comandoSeparado = message.trim().split(" ", 3);
                String comando = comandoSeparado[0].toUpperCase();
                int dado = (comandoSeparado.length > 1 ? Integer.parseInt(comandoSeparado[1]) : -1);
                int veces = (comandoSeparado.length > 2 ? Integer.parseInt(comandoSeparado[2]) : -1);
                String respuesta = switch (comando) {
                    case "LANZA" -> lanzarDado(dado, veces);
                    case "INFO" -> info();
                    case "RESET" -> reset();
                    default -> "Comando no reconocido.";
                };
                tiradasHechas ++;
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

    private static String reset() {
        tiradasHechas = 0;
        dadosLanzados = 0;
        resultadoMasAlto = 0;
        return "Se han reiniciado correctamente las estadísticas.";
    }

    private static String info() {
        return "Tiradas hechas: " + tiradasHechas +
                "\nCantidad de dados: " + dadosLanzados +
                "\nTirada más alta: " + resultadoMasAlto;
    }

    private static String lanzarDado(int dado, int veces) {
        Random random = new Random();
        int suma = 0;
        for (int i =  0; i < veces; i++) {
            int numRandom = random.nextInt(1,dado);
            if (numRandom > resultadoMasAlto) {
                resultadoMasAlto = numRandom;
            }
            suma+=numRandom;
        }
        dadosLanzados += veces;

        return String.valueOf(suma);
    }


}