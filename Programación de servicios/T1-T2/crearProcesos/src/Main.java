import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        lanzarProceso();
        lanzarProcesoRuntime();
    }

    public static void lanzarProceso() {
        String[] parametros = {"CMD","/C", "START", "notepad.exe"};
        ProcessBuilder processBuilder = new ProcessBuilder(parametros);

        try {
            processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void lanzarProcesoRuntime() {
        String[] parametros = {"CMD","/C", "START", "notepad.exe"};
        Runtime runtime = Runtime.getRuntime();

        try {
            runtime.exec(parametros);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void lanzarProcesoLeyendoSalidaEstandar() {

        String[] parametros = {"CMD","/C", "START", "notepad.exe"};
        ProcessBuilder processBuilder = new ProcessBuilder(parametros);

        try {
            System.out.println("Lanzando proceso");
            Process proceso = processBuilder.start();

            //Salida estándar
            InputStream entrada = proceso.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(entrada));
            String linea = bf.readLine();

            while (linea != null) {
                System.out.println(linea);
                linea = bf.readLine();
            }
            bf.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}