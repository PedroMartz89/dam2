package TCP;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String nombre;
    private List<String> mensajes;

    public Sala(String nombre) {
        this.nombre = nombre;
        this.mensajes = new ArrayList<>();
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }

    public void publicarMensaje(String nick, String mensaje) {
        mensajes.add(nick + ": " + mensaje+".");
    }

    public String getNombre() {
        return nombre;
    }
}
