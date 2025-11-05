import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Ejecutor {

    private List<Tarea> tareas = new ArrayList<>();

    public void leerConfig(String nombreFichero) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreFichero));
            String linea;
            int id = 0;
            while ((linea = bufferedReader.readLine()) != null) {

                String[] partes = linea.split(" ");
                if (partes.length < 3 ) {
                    continue;
                }

                try {
                    int hora = Integer.parseInt(partes[0]);
                    int minutos = Integer.parseInt(partes[1]);
                    String comando = partes[2];
                    id++;
                    Tarea task1 = new Tarea(id, hora, minutos, comando, "Pendiente");
                    tareas.add(task1);
                    new Thread(task1).start();

                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void listarTareas() {

        for (Tarea tarea : tareas) {
            System.out.println(tarea);
        }
    }

    public void cancelarTarea(int id) {

        for (Tarea tarea : tareas) {

            if (tarea.getId() == id && !(tarea.getEstado().equals("Cancelado"))) {
                tarea.setEstado("Cancelado");
            } else {

                if (tarea.getEstado().equals("Cancelado")) {
                    System.out.println("La tarea ya está cancelada");
                } else {

                    System.out.println("No se ha encontrado tarea con el id: " + id);
                }
            }
        }
        System.out.println("Cancelada la tarea con ID: " + id);
    }

}
