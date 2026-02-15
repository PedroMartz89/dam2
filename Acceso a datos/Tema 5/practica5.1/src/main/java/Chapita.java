import javax.persistence.Embeddable;

@Embeddable
public class Chapita {
    private String textoGrabado;
    private String telefono;
    private String color;

    public Chapita() {}

    public Chapita(String textoGrabado, String telefono, String color) {
        this.textoGrabado = textoGrabado;
        this.telefono = telefono;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("[Texto: %s | Tel: %s | Color: %s]", textoGrabado, telefono, color);
    }
}