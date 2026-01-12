import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 3000);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner sc = new Scanner(System.in);
        ) {
            //Envía el número de líneas a enviar
            System.out.println("Introduce el número de líneas: ");
            int numLineas = sc.nextInt();
            salida.println(numLineas);

            //Escribir las palabras
            for (int i = 0; i < numLineas; i++) {
                System.out.println("Introduce la palabra " + i+1 + ": ");
                String palabra = sc.next();
                salida.println(palabra);
            }

            //Recibir respuesta del servidor
            System.out.println("Resultados de las sumas ASCII");
            for (int i = 0; i < numLineas; i++) {
                try {
                    String resultado = entrada.readLine();
                    System.out.println("Palabra " + i+1 + ": " + resultado);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}