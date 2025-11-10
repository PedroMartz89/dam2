package model;

public class Asignatura {

    private String codAsignatura;
    private String codInterno;
    private String descripcion;
    private int nHoras;
    private String codCurso;

    public Asignatura(String codAsignatura, String codInterno, String descripcion, int nHoras, String codCurso) {
        this.codAsignatura = codAsignatura;
        this.codInterno = codInterno;
        this.descripcion = descripcion;
        this.nHoras = nHoras;
        this.codCurso = codCurso;
    }

    public Asignatura() {
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "codAsignatura='" + codAsignatura + '\'' +
                ", codInterno='" + codInterno + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", nHoras=" + nHoras +
                ", codCurso='" + codCurso + '\'' +
                '}';
    }

    public String getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(String codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String getCodInterno() {
        return codInterno;
    }

    public void setCodInterno(String codInterno) {
        this.codInterno = codInterno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getnHoras() {
        return nHoras;
    }

    public void setnHoras(int nHoras) {
        this.nHoras = nHoras;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }
}
