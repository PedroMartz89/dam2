package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClienteTCP extends Thread {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Conectado al servidor. Escribe comandos:");

            // Hilo para leer respuestas del servidor
            Thread lector = new Thread(() -> {
                try {
                    String respuesta;
                    while ((respuesta = in.readLine()) != null) {
                        System.out.println("\n[Servidor]: " + respuesta);
                    }
                } catch (IOException e) {
                    System.out.println("Conexión cerrada.");
                }
            });
            lector.start();

            // Bucle principal: leer del teclado y enviar
            Scanner sc = new Scanner(System.in);
            while (true) {
                String cmd = sc.nextLine();
                out.println(cmd);
                if (cmd.equalsIgnoreCase("EXIT")) break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
