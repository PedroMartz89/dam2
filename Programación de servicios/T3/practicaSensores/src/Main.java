import Clientes.ClienteTCP;
import Clientes.ClienteUDP;
import Sensores.Sensor;
import Servers.ServidorTCP;
import Servers.ServidorUDP;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ServidorUDP servidorUDP = new ServidorUDP();
        servidorUDP.start();

        ServidorTCP servidorTCP = new ServidorTCP();
        servidorTCP.start();

        ClienteUDP simuladorSensores = new ClienteUDP();
        simuladorSensores.start();


        ClienteTCP clienteInteractivo = new ClienteTCP();
        clienteInteractivo.start();
    }
}
