package TCP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Subasta {
    private String nombre;
    private String producto;
    private String creador;
    private List<String> pujas;
    private int pujaActual;
    private String usuario;
    public Subasta(String nombre, String producto, String pujaInicial, String creador) {
        this.nombre = nombre;
        this.producto = producto;
        pujas = new ArrayList<>();
        this.creador = creador;
        this.usuario = creador;
        this.pujaActual = Integer.parseInt(pujaInicial);
    }

    public String pujar(int cantidad, String nick) {
        if (creador.equals(nick)){
            return "No puedes pujar en tu propia subasta.";
        }
        else {
            pujas.add(nick + " puja " + cantidad + " monedas.");
            this.pujaActual = cantidad;
            this.usuario = nick;
            return "Se han pujado " + cantidad + " monedas.";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public List<String> getPujas() {
        return pujas;
    }

    public int getPujaActual() {
        return pujaActual;
    }

    public String getUsuario() {
        return usuario;
    }
}
