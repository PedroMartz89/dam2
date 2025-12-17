package Ejemplos;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EjemploInetAddress {
    public static void main(String[] args) throws UnknownHostException {

        //Obtener la IP de la máquina
        InetAddress ip = InetAddress.getLocalHost();
        //Imprimir la IP con getHostAddress
        System.out.println(ip.getHostAddress());
        //Imprimir Host del equipo
        System.out.println(ip.getHostName());
        //Obtener la IP de un host
        InetAddress ipHost = InetAddress.getByName("www.google.es");
        System.out.println(ipHost.getHostAddress());

        //Obtener IP loopback
        InetAddress ipLoopback = InetAddress.getLoopbackAddress();
        System.out.println(ipLoopback.getHostAddress());

    }
}
