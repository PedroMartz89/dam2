package Clientes;

import Sensores.GestorSensores;
import Sensores.Sensor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ClienteUDP extends Thread {
    @Override
    public void run() {
        try (DatagramSocket socket = new DatagramSocket()) {

            InetAddress address = InetAddress.getByName("localhost");
            int serverPort = 9999;
            Random random = new Random();

            // Obtener la lista de sensores
            List<Sensor> sensores = GestorSensores.getInstance().getListaSensores();

            while (true) {
                for (Sensor sensor : sensores) {
                    // Generar temperatura aleatoria entre 20.0 y 30.0
                    double temperatura = 20.0 + (10.0 * random.nextDouble());

                    //Enviar mensaje al server con el ID del sensor actual
                    String mensaje = String.format(Locale.US, "SensorID: %d\nTemperatura: %.1f", sensor.getIdSensor(), temperatura);
                    byte[] mensajeEnviar = mensaje.getBytes();
                    DatagramPacket datagramPacket = new DatagramPacket(mensajeEnviar, mensajeEnviar.length, address, serverPort);
                    socket.send(datagramPacket);
                }

                // Esperar 5 segundos antes de la siguiente ronda de lecturas
                Thread.sleep(5000);
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
