package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", ServerTCP.PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Conectado al servidor en el puerto " + ServerTCP.PORT);
            Thread lector = new Thread(() -> {
                try {
                    String respuesta;
                    while ((respuesta = in.readLine()) != null) {
                        System.out.println("[SERVIDOR]: " + respuesta);
                    }
                } catch (IOException e) {
                    System.out.println("Error de sesión");
                    throw new RuntimeException(e);
                }
            });
            lector.start();

            Scanner sc = new Scanner(System.in);
            while (true) {
                String cmd = sc.nextLine();
                out.println(cmd);
                if (cmd.equalsIgnoreCase("EXIT")) break;
            }
        }
    }
}

