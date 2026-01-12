import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int puerto = 3000;

        try (ServerSocket serverSocket = new ServerSocket(puerto)){
            System.out.println("Se ha arrancado el servidor. Esperando conexiones");

            while (true) {
                //Esperar conexiones
                Socket socket = serverSocket.accept();
                System.out.println("Se ha conectado un cliente, IP: " + socket.getInetAddress() + " Puerto: " + socket.getPort());

                //Preparar los buffer
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                //Recibir num líneas
                String numLineas = entrada.readLine();
                if (numLineas == null) continue;

                //Calcular ASCII
                for (int i = 0; i < Integer.parseInt(numLineas); i++) {
                   int total = 0;
                   try {
                        String palabra = entrada.readLine();
                        if (palabra == null) continue;
                        for (int j = 0; j < palabra.length(); j++) {
                            char c = palabra.charAt(j);
                            int ascii = c;
                            total += ascii;
                        }
                        //Enviar resultado
                        salida.println(total);

                   } catch (RuntimeException e) {
                       throw new RuntimeException(e);
                   }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
