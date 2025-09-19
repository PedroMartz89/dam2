import java.io.IOException;

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
}