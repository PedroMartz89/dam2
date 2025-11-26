package ej1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String comando = solicitarComando(sc);
        String ficheroSalida = solicitarFicheroSalida(sc);
        String ficheroError = solicitarFicheroSalidaError(sc);

        ejecutarComando(comando, ficheroSalida, ficheroError);
    }


    public static String solicitarComando(Scanner sc) {

        boolean continuar = true;
        String comando = "";
        while (continuar) {

            System.out.println("Introduce un comando o fichero ejecutable: ");
            comando = sc.nextLine();

            if (comando.isEmpty()) {
                System.out.println("Introduce un comando o ejecutable válido.");
            } else {
                continuar = false;
            }
        }

        return comando;
    }

    public static String solicitarFicheroSalida(Scanner sc) {

        boolean continuar = true;
        String comando = "";
        while (continuar) {

            System.out.println("Introduce un fichero donde dirijir la salida: ");
            comando = sc.nextLine();

            if (comando.isEmpty()) {
                System.out.println("Se mostrará en la salida estándar");
                return "";
            } else {
                continuar = false;
            }
        }

        return comando;
    }

    public static String solicitarFicheroSalidaError(Scanner sc) {

        boolean continuar = true;
        String comando = "";
        while (continuar) {

            System.out.println("Introduce un fichero donde dirijir la salida de errores: ");
            comando = sc.nextLine();

            if (comando.isEmpty()) {
                System.out.println("Se mostrará en la salida estándar");
                return "";
            } else {
                continuar = false;
            }
        }

        return comando;
    }

    public static void ejecutarComando(String comando, String ficheroSalida, String ficheroError) {


        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", comando);
            if (!ficheroSalida.isEmpty()) {
                pb.redirectOutput(new File(ficheroSalida + ".txt"));
            }
            if (!ficheroError.isEmpty()) {
                pb.redirectError(new File(ficheroError + ".txt"));
            }

            Process proceso = pb.start();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

            proceso.waitFor();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
