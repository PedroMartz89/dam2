import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mascota {
    @Id @GeneratedValue
    private long id;

    private String nombre;
    private String tipo;
    private int edad;
    private Chapita chapita; // Objeto embebido

    public Mascota() {}

    public Mascota(String nombre, String tipo, int edad, Chapita chapita) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
        this.chapita = chapita;
    }

    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return String.format("ID: %d | %s (%s, %d años) | Chapita: %s",
                id, nombre, tipo, edad, chapita);
    }
}