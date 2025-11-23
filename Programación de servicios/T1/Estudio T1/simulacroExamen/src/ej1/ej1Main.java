package ej1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ej1Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProcessBuilder pb = solicitarComando(sc);
        try {
            ejecutarComando(pb, sc);
        } catch (IOException | InterruptedException e) {
            System.out.println("No se ha podido ejecutar el comando debido a un error.");
        }
    }

    public static void ejecutarComando(ProcessBuilder comando, Scanner sc)
            throws IOException, InterruptedException {

        String salida = pedirSalida(sc);
        String error = pedirError(sc);

        boolean salidaAFichero = !salida.isEmpty();
        boolean errorAFichero = !error.isEmpty();

        // REDIRECCIONES SOLO SI EL USUARIO HA DADO NOMBRE
        if (salidaAFichero) {
            comando.redirectOutput(new File(salida + ".txt"));
        }

        if (errorAFichero) {
            comando.redirectError(new File(error + ".txt"));
        }

        System.out.println("Ejecutando comando...");
        Process p = comando.start();

        // SI EL USUARIO NO HA INDICADO FICHERO DE SALIDA → LEEMOS Y MOSTRAMOS stdout
        if (!salidaAFichero) {
            BufferedReader brOut = new BufferedReader(
                    new InputStreamReader(p.getInputStream())
            );

            String linea;
            while ((linea = brOut.readLine()) != null) {
                System.out.println(linea);
            }
        }

        // SI EL USUARIO NO HA INDICADO FICHERO DE ERROR → LEEMOS Y MOSTRAMOS stderr
        if (!errorAFichero) {
            BufferedReader brErr = new BufferedReader(
                    new InputStreamReader(p.getErrorStream())
            );

            String linea;
            while ((linea = brErr.readLine()) != null) {
                System.err.println(linea);
            }
        }

        p.waitFor();
        System.out.println("Comando finalizado.");
    }

    public static ProcessBuilder solicitarComando(Scanner sc) {
        System.out.println("Introduce el comando a ejecutar: ");
        String comando = sc.nextLine();
        return new ProcessBuilder("cmd.exe", "/c", comando);
    }

    public static String pedirSalida(Scanner sc) {
        System.out.print("Introduce el fichero de salida (vacío = consola): ");
        return sc.nextLine();
    }

    public static String pedirError(Scanner sc) {
        System.out.print("Introduce el fichero de error (vacío = consola): ");
        return sc.nextLine();
    }
}
