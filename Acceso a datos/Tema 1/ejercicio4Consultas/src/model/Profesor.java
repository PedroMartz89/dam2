package model;

public class Profesor {

    private String nrp;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public Profesor() {
    }

    public Profesor(String nrp, String dni, String nombre, String apellido1, String apellido2) {
        this.nrp = nrp;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nrp='" + nrp + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", Apellido2='" + apellido2 + '\'' +
                '}';
    }
}
