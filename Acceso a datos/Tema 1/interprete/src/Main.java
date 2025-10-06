import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        interprete(sc);
    }

    public static void interprete(Scanner sc) throws IOException, InterruptedException {

        System.out.println("Por favor, introduce el comando a ejecutar (lista para listado de procesos y salir para terminar)");
        System.out.print("\n>");

        while (true) {
            String comando = sc.nextLine();
            ArrayList<Process> processes = new ArrayList<>();
            if (comando.equals("lista") | comando.equals("salir")) {
                try {
                    processes.add(ejecutarProcess(comando));

                } catch (IOException | InterruptedException e) {
                    if (comando.equals("lista")) {
                        for (Process process : processes) {
                            obtenerInfoProceso(process);
                        }

                    } else {

                        break;
                    }
                }
            }
        }

        System.out.println("Cerrando la consola.");

    }

    public static void mostrarInfo(BufferedReader buffer) throws IOException {

        String line = buffer.readLine();
        while (line != null) {
            System.out.println(line);
            line = buffer.readLine();
        }
    }

    public static Process ejecutarProcess(String comando) throws IOException, InterruptedException {

        ArrayList<Proceso> procesos = new ArrayList<>();
        Process ps = new ProcessBuilder(comando).start();
        InputStream input = ps.getInputStream();
        InputStream error = ps.getErrorStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        BufferedReader bre = new BufferedReader(new InputStreamReader(error));
        mostrarInfo(br);
        mostrarInfo(bre);
        procesos.add(obtenerInfoProceso(ps));

        return ps;
    }

    public static Proceso obtenerInfoProceso(Process ps) throws IOException, InterruptedException {
        Process proceso = Runtime.getRuntime().exec("ps -eo user,pid,comm,lstart");
        BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        String linea = reader.readLine();
        List<String[]> info = new ArrayList<>();
        while (linea != null) {

            String[] campos = linea.trim().split("\\s+", 6);
            if (campos.length >= 6) {
                    info.add(campos);
            }
        }
        int codigoSalida = proceso.waitFor();
        ArrayList<Proceso> procesos = new ArrayList<>();
        for (String[] p : info) {
            String usuario = p[0];
            String pid = p[1];
            String comm = p[2];
            String fecha = p[3];
            procesos.add(new Proceso(usuario, comm, pid, codigoSalida, fecha));
        }
        return procesos.getFirst();
    }
}
