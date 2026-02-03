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
            telnetClient.connect(ip, 23);

            PrintStream out = new PrintStream(telnetClient.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(telnetClient.getInputStream()));

            out.println(comando);
            out.flush();

            System.out.println("Respuesta del servidor: ");
            String linea;
            while (in.ready() && (linea = in.readLine()) != null) {
                System.out.println(linea);
            }

            telnetClient.disconnect();
            out.close();
            in.close();
        } catch (IOException e) {
            System.out.println("Error en Telnet: " + e.getMessage());
        }
    }
}
