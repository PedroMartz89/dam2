package model;

public class Curso {

    private String codCurso;
    private String nombre;
    private String descripcion;

    public Curso(String codCurso, String nombre, String descripcion) {
        this.codCurso = codCurso;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Curso() {
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codCurso='" + codCurso + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
