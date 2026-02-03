package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServidorTCP {
    private static final int PUERTO = 12345;
    // Mapa global de Salas
    public static Map<String, Sala> mapaSalas = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Servidor iniciado en el puerto " + PUERTO);

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            while (true) {
                Socket socketCliente = serverSocket.accept();
                System.out.println("Nuevo cliente conectado: " + socketCliente.getInetAddress());

                // Creamos y lanzamos el hilo para el cliente
                new Thread(new ManejadorCliente(socketCliente)).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}

