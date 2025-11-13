package model;

public class Asignatura {

    private String cod_asignatura;
    private String descripcion;

    public Asignatura(String cod_asignatura, String descripcion) {
        this.cod_asignatura = cod_asignatura;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "cod_asignatura='" + cod_asignatura + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
