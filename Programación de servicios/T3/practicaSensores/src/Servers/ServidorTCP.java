package Servers;

import Sensores.GestorSensores;
import Sensores.Sensor;
import java.io.*;
import java.net.*;
import java.util.List;

public class ServidorTCP extends Thread {
    @Override
    public void run() {
        int puerto = 8888;
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor TCP listo en puerto " + puerto);

            while (true) {
                try (Socket socket = serverSocket.accept();
                     PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    String linea = entrada.readLine();
                    if (linea == null) continue;

                    // Formato esperado: "COMANDO:ID:VALOR" (ej: "ENCENDER_SENSOR:1")
                    String[] partes = linea.split(":");
                    String comando = partes[0];
                    int id = (partes.length > 1) ? Integer.parseInt(partes[1]) : -1;

                    Sensor sensor = GestorSensores.getInstance().buscarPorId(id);

                    switch (comando) {
                        case "ENCENDER_SENSOR":
                            if (sensor != null) {
                                sensor.setEstado(true);
                                salida.println("OK: Sensor " + id + " encendido.");
                            } else {
                                salida.println("ERROR: Sensor no encontrado.");
                            }
                            break;

                        case "APAGAR_SENSOR":
                            if (sensor != null) {
                                sensor.setEstado(false);
                                salida.println("OK: Sensor " + id + " apagado.");
                            } else {
                                salida.println("ERROR: Sensor no encontrado.");
                            }
                            break;

                        case "ESTABLECER_UMBRAL":
                            if (sensor != null && partes.length > 2) {
                                double umbral = Double.parseDouble(partes[2]);
                                sensor.setUmbral(umbral);
                                salida.println("OK: Umbral de sensor " + id + " a " + umbral);
                            } else {
                                salida.println("ERROR: Datos insuficientes o sensor inexistente.");
                            }
                            break;

                        case "SOLICITAR_ESTADO_SENSORES":
                            List<Sensor> sensores = GestorSensores.getInstance().getListaSensores();
                            StringBuilder sb = new StringBuilder();
                            for (Sensor s : sensores) {
                                sb.append("ID: ").append(s.getIdSensor())
                                        .append(" Est: ").append(s.isEstado() ? "ON" : "OFF")
                                        .append(" Umb: ").append(s.getUmbral()).append(" | ");
                            }
                            salida.println(sb.toString());
                            break;

                        default:
                            salida.println("ERROR: Comando desconocido.");
                    }
                } catch (Exception e) {
                    System.out.println("Error procesando petición: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}