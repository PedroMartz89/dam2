package Ejemplos.servidorThreads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorHilos {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(8888)){
            System.out.println("Servidor iniciado en el puerto 8888, esperando cliente.");
            while (true) {
                Socket s = servidor.accept();
                System.out.println("Se ha conectado el cliente.");

                ManejadorSaludos service = new ManejadorSaludos(s);
                Thread t = new Thread(service);

                t.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
