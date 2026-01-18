package Servers;

import Sensores.GestorSensores;
import Sensores.Sensor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServidorUDP extends Thread {
    private int puerto;
    private HashMap<Integer, Double> hashMapLecturasSensores;

    public ServidorUDP() {
        this.hashMapLecturasSensores = new HashMap<>();
        this.puerto = 9999;
    }

    @Override
    public void run() {
        try (DatagramSocket socket = new DatagramSocket(puerto)) {
            byte[] buffer = new byte[1024];
            System.out.println("Servidor UDP escuchando en el puerto " + puerto);

            while (!isInterrupted()) {
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                // Importante: Usar offset y length para crear el String solo con los datos recibidos
                String info = new String(paquete.getData(), 0, paquete.getLength());
                
                Pattern pattern = Pattern.compile("SensorID:\\s*(\\d+)[\\s\\S]*Temperatura:\\s*([\\d.]+)");
                Matcher matcher = pattern.matcher(info);

                if (matcher.find()) {
                    int id = Integer.parseInt(matcher.group(1));
                    double temperatura = Double.parseDouble(matcher.group(2));
                    hashMapLecturasSensores.put(id, temperatura);

                    Sensor sensor = GestorSensores.getInstance().buscarPorId(id);

                    if (sensor != null) {
                        if (sensor.isEstado()) {
                            System.out.println("--- Datos Procesados ---");
                            System.out.println("ID del Sensores.Sensor: " + id);
                            System.out.println("Medición: " + temperatura + "°C");
                        }

                        if (sensor.getUmbral() != null && temperatura > sensor.getUmbral()) {
                            System.out.println("ALERTA: Lectura de temperatura de " +
                                    temperatura + "°C en el Sensores.Sensor " + id + " supera el umbral de " +
                                    sensor.getUmbral() + "°C.");
                        }
                    } else {
                        System.out.println("Recibido datos de Sensores.Sensor ID " + id + " no registrado.");
                    }
                } else {
                    System.out.println("Formato de mensaje no reconocido: " + info);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
