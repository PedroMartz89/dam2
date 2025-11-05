import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

public class Tarea implements Runnable {
    private int id;
    private LocalTime horaEjecucion;
    private String comando;
    private String estado; // Pendiente, Ejecutado, Cancelado

    public Tarea(int id, int hora,  int minutos, String comando, String estado) {
        this.id = id;
        this.horaEjecucion = LocalTime.of(hora, minutos);
        this.comando = comando;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Hora: " + horaEjecucion + ", Comando: " + comando + ", Estado: " + estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getHoraEjecucion() {
        return horaEjecucion;
    }

    public void setHoraEjecucion(LocalTime horaEjecucion) {
        this.horaEjecucion = horaEjecucion;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public void run() {

        try {
            LocalTime ahora = LocalTime.now();
            Duration duracion = Duration.between(ahora, horaEjecucion);
            if (duracion.isNegative()) {
                duracion = duracion.plusDays(1);
            }

            Thread.sleep(duracion.toMillis());
            ejecutarComando(comando);
            estado = "Ejecutado";

        } catch (InterruptedException | IOException e) {
            estado = "Cancelado";
            throw new RuntimeException(e);

        }

    }

    public void ejecutarComando(String comando) throws IOException, InterruptedException {

        Process process = Runtime.getRuntime().exec(comando);
        process.waitFor();
        System.out.println("Comando ejecutado: " + comando);
    }
}
