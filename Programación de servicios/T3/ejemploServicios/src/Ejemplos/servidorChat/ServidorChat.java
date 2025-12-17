package Ejemplos.servidorChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChat {
    public static void main(String[] args) {
        try {

            ServerSocket servidor = new ServerSocket(8888);
            System.out.println("Servidor iniciado en el puerto 8888, esperando cliente.");

            while (true) {
                Socket s = servidor.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
                // Habilitar auto-flush añadiendo 'true'
                PrintWriter salida = new PrintWriter(s.getOutputStream(), true);

                //Leer el mensaje del cliente
                String mensaje = entrada.readLine();
                System.out.println("Mensaje recibido: " + mensaje);

                //Responder al cliente (ahora se enviará inmediatamente)
                salida.println("Mensaje recibido: " + mensaje);
                s.close();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
