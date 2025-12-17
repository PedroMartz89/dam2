package ej1;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        gestionarComando(sc);
    }


    public static void gestionarComando(Scanner sc) {

            while (true) {
            String[] comando = pedirComando(sc);
            String salida = pedirSalida(sc);

            if (salida.equals("consola")) {
                System.out.println("Se mostrará el resultado por consola.");

                ProcessBuilder pb = new ProcessBuilder(comando);

                try {
                    Process p = pb.start();
                    InputStream is = p.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    String linea;

                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                    }

                } catch (IOException e) {
                    System.out.println("Se ha producido una excepción, el comando no puede ser ejecutado");
                }
            } else {

                ProcessBuilder pb = new ProcessBuilder(comando);

                try {
                    File ficheroSalida = new File("resultados.txt");
                    pb.redirectError(ficheroSalida);
                    pb.redirectOutput(ficheroSalida);

                    pb.start();

                } catch (IOException e) {
                    System.out.println("Se ha producido una excepción, el comando no puede ser ejecutado");
                }

            }
        }

    }

    public static String[] pedirComando(Scanner sc) {

        System.out.println("Introduce el comando o programa: ");
        String comando = sc.nextLine();

        return comando.split(" ");
    }

    public static String pedirSalida(Scanner sc) {
        System.out.println("Escriba consola si quiere ver la salida por consola, si no, escribe cualquier otro texto: ");
        String salida = sc.nextLine();

        return salida;
    }

}


