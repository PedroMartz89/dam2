import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ejecutarProceso();
    }

    public static String pedirComando(Scanner sc) {


        System.out.println("Introduce un comando: ");
        String comando = sc.nextLine();
        return comando;
    }

    public static String pedirPalabra(Scanner sc) {

        while (true) {
            System.out.println("Introduce una palabra a buscar: ");
            String palabra = sc.nextLine();
            if (palabra.contains(" ")) {

                System.out.println("Solo puedes introducir una palabra, vuelve a intentarlo.");
            } else {
                return palabra;
            }
        }
    }

    public static void ejecutarProceso() {

        Scanner sc = new Scanner(System.in);
        String comando = pedirComando(sc);
        String palabra = pedirPalabra(sc);

        Runtime r = Runtime.getRuntime();
        Process p;
        try {
            p = r.exec(comando);

            BufferedReader salida = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            int salidaLinea = 0;
            int ocurrenciasSalida = 0;
            String linea;

            while ((linea = salida.readLine()) != null) {

                salidaLinea++;
                ocurrenciasSalida += contarOcurrencias(linea, palabra);
                System.out.println(linea);
            }

            int lineaErr = 0;
            int ocurrenciaErr = 0;
            while ((linea = salida.readLine()) != null) {

               lineaErr++;
               ocurrenciaErr += contarOcurrencias(linea, palabra);
                int codigo = p.waitFor();
                System.out.println("\nResultados:");
                System.out.println("Líneas en salida estándar: " + salidaLinea);
                System.out.println("Ocurrencias en salida estándar: " + ocurrenciasSalida);
                System.out.println("Líneas en salida de error: " + lineaErr);
                System.out.println("Ocurrencias en salida de error: " + ocurrenciaErr);
                System.out.println("Código de finalización del proceso: " + codigo);

            }
            sc.close();
        } catch (IOException | InterruptedException e) {
            System.out.println("Se ha producido un error.");

        }
    }

    public static int contarOcurrencias(String linea, String palabra) {
        int contador = 0;
        int index = 0;
        while ((index = linea.indexOf(palabra, index)) != -1) {
            contador++;
            index += palabra.length();
        }
        return contador;
    }


}
