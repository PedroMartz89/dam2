import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        interprete(sc);
    }

    public static void interprete(Scanner sc) throws IOException, InterruptedException {
        System.out.println("Introduce un comando (lista = ver procesos, salir = terminar)");
        System.out.print("> ");

        ArrayList<Proceso> procesos = new ArrayList<>();

        while (true) {
            String comando = sc.nextLine();

            if (comando.equals("salir")) {
                break;
            } else if (comando.equals("lista")) {
                for (Proceso p : procesos) {
                    System.out.println(p);
                }
            } else {
                try {
                    procesos.add(ejecutarProcess(comando));
                } catch (IOException | InterruptedException e) {
                    System.out.println("Error al ejecutar el comando: " + e.getMessage());
                }
            }
            System.out.print("> ");
        }

        System.out.println("Cerrando la consola.");
    }

    public static void mostrarInfo(BufferedReader buffer) throws IOException {
        String line;
        while ((line = buffer.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static Proceso ejecutarProcess(String comando) throws IOException, InterruptedException {
        Process ps = new ProcessBuilder(comando.split(" ")).start();
        BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
        BufferedReader bre = new BufferedReader(new InputStreamReader(ps.getErrorStream()));

        mostrarInfo(br);
        mostrarInfo(bre);

        return obtenerInfoProceso(ps);
    }

    public static Proceso obtenerInfoProceso(Process ps) throws IOException, InterruptedException {
        Process proceso = Runtime.getRuntime().exec("ps -eo user,pid,comm,lstart");
        BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

        String linea;
        List<String[]> info = new ArrayList<>();
        while ((linea = reader.readLine()) != null) {
            String[] campos = linea.trim().split("\\s+", 6);
            if (campos.length >= 6) {
                info.add(campos);
            }
        }

        proceso.waitFor();

        if (info.size() > 1) { // salta cabecera
            String[] p = info.get(1);
            return new Proceso(p[0], p[2], p[1], 0, p[3]);
        }

        return new Proceso("desconocido", "?", "?", -1, "?");
    }
}
