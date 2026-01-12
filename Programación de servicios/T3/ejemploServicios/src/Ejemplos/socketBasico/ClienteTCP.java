package Ejemplos.socketBasico;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) {
        try {
            //Conectamos con el servidor en el puerto 8888 usando un socket
            Socket socket = new Socket("localhost", 8888);
            System.out.println("Se ha conectado al servidor.");

            //Creamos un canal para mandar datos
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("¡Hola desde el cliente!");

            //Cerrar conexion
            socket.close();
            System.out.println("Se ha cerrado la conexión.");

        } catch (IOException e) {
            System.err.println("No se ha podido conectar al servidor.");
        }
    }
}
