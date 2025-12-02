package ejFicheros;

public class Registro {

    private int id;
    private long telefono;
    private String pais;

    public Registro(int id, long telefono, String pais) {
        this.id = id;
        this.telefono = telefono;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "id=" + id +
                ", telefono=" + telefono +
                ", pais='" + pais + '\'' +
                '}';
    }
}
