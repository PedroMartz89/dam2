import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Proceso {

    private String usuario;
    private String comando;
    private String pid;
    private int salida;
    private String fecha;

    public Proceso(String usuario, String comando, String pid, int salida, String fecha) {
        this.usuario = usuario;
        this.comando = comando;
        this.pid = pid;
        this.salida = salida;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %s",
                usuario,
                comando,
                pid,
                salida,
                fecha);
    }

}
