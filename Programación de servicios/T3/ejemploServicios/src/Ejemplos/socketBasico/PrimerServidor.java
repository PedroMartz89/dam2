package Ejemplos.socketBasico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PrimerServidor {
    public static void main(String[] args) {
        try {
            //Creamos el servidor a la escucha del puerto 8888
            ServerSocket servidor = new ServerSocket(8888);
            System.out.println("Servidor iniciado en el puerto 8888, esperando cliente.");

            //Esperamos a que se conecte un cliente
            Socket socketCliente = servidor.accept();
            System.out.println("El cliente se ha conectado desde " + socketCliente.getInetAddress().getHostAddress());

            //Leemos el contenido que manda el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            String linea;
            while ((linea = entrada.readLine()) != null) {
                System.out.println(linea);
            }
            //Creamos el canal de respuesta del cliente
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);

            //Responder
            salida.println("He recibido el mensaje: " + linea);

            entrada.close();
            socketCliente.close();
            salida.close();
            servidor.close();
            System.out.println("Se ha cerrado la conexión.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
