package Ejemplos;

import java.net.*;
import java.util.Enumeration;

public class EjemploNetworkInterface {
    public static void main(String[] args) {
        try {
            //Obtener todas las interfaces de red del equipo
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            System.out.println("Interfaces de red encontradas");
            System.out.println("----------------------------------");
            while (interfaces.hasMoreElements()) {
                NetworkInterface interfaz = interfaces.nextElement();
                //Imprimir información de cada interfaz
                System.out.println("Nombre: " + interfaz.getName());
                System.out.println("Descripción: " + interfaz.getDisplayName());
                System.out.println("--------------------------------------");
            }
        } catch (SocketException e) {
            System.err.println("Error al obtener las interfaces de red: " + e.getMessage());
        }
    }
}
