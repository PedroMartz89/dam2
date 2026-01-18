package Clientes;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteTCP extends Thread {
    @Override
    public void run() {
        // Pausa breve para asegurar que el servidor arranque primero
        try { Thread.sleep(500); } catch (InterruptedException e) {}

        try (Scanner sc = new Scanner(System.in)) {
            boolean continuar = true;
            while (continuar) {
                System.out.println("Comandos: ENCENDER_SENSOR, APAGAR_SENSOR, ESTABLECER_UMBRAL, SOLICITAR_ESTADO_SENSORES");

                System.out.print("Introduce comando: ");
                String cmd = sc.nextLine().toUpperCase();

                String mensajeEnviar = cmd;

                if (!cmd.equals("SOLICITAR_ESTADO_SENSORES")) {
                    System.out.print("Introduce ID del sensor: ");
                    String id = sc.nextLine();
                    mensajeEnviar += ":" + id;

                    if (cmd.equals("ESTABLECER_UMBRAL")) {
                        System.out.print("Introduce nuevo umbral: ");
                        String umbral = sc.nextLine();
                        mensajeEnviar += ":" + umbral;
                    }
                }

                try (Socket socket = new Socket("localhost", 8888);
                     PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    salida.println(mensajeEnviar);
                    System.out.println("Respuesta servidor: " + entrada.readLine());
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            System.out.println("--- Menú Cliente TCP ---");
        }
    }
}