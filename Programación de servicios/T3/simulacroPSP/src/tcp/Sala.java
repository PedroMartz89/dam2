package tcp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Sala {
    private String nombre;
    private List<String> mensajes;

    public Sala(String nombre) {
        this.nombre = nombre;
        this.mensajes = Collections.synchronizedList(new ArrayList<>());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void nuevoMensaje(String nick, String mensaje) {
        mensajes.add(nick + ": " + mensaje);
    }

    public List<String> getMensajes() {
        return mensajes;
    }
}
