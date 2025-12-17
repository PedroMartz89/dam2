package Ejemplos.servidorChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteChat {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 8888);
                BufferedReader entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter salida = new PrintWriter(s.getOutputStream(), true);)
        {
            salida.println("Hola, soy el cliente.");
            String respuesta = entrada.readLine();
            while (respuesta == null) {
                respuesta = entrada.readLine();
            }
            System.out.println("Respuesta del servidor: " + respuesta);
        } catch (IOException e) {
            System.err.println("No se ha podido conectar al servidor.");
        }
    }
}
