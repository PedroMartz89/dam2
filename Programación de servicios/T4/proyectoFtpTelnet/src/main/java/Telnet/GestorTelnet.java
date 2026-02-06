package Telnet;

import org.apache.commons.net.telnet.TelnetClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class GestorTelnet {
   public void ejecutarComando(String ip, String comando) {
    TelnetClient telnetClient = new TelnetClient();

    try {
        telnetClient.connect(ip, 2323); // Es el puerto que tengo en el docker que he levantado

        PrintStream out = new PrintStream(telnetClient.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(telnetClient.getInputStream()));

        Thread.sleep(500);
        out.println("root"); // Usuario de mi docker
        out.flush();
        Thread.sleep(500);
        out.println("root"); // Password de mi docker
        out.flush();

        Thread.sleep(500);
        out.println(comando);
        out.flush();

        System.out.println("Respuesta del servidor: ");
        Thread.sleep(1000);

        String linea;
        while (in.ready() && (linea = in.readLine()) != null) {
            System.out.println(linea);
        }

        telnetClient.disconnect();
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}
}
