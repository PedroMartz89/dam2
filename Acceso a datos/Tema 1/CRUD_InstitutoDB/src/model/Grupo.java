package model;

public class Grupo {

    private String codGrupo;
    private String codCurso;
    private String nombre;
    private String codTurno;
    private int nMaxAlumnos;

    public Grupo( String codGrupo, String codCurso, String nombre, String codTurno,   int nMaxAlumnos) {
        this.nMaxAlumnos = nMaxAlumnos;
        this.codTurno = codTurno;
        this.nombre = nombre;
        this.codCurso = codCurso;
        this.codGrupo = codGrupo;
    }

    public Grupo() {
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "codGrupo='" + codGrupo + '\'' +
                ", codCurso='" + codCurso + '\'' +
                ", nombre='" + nombre + '\'' +
                ", codTurno='" + codTurno + '\'' +
                ", nMaxAlumnos='" + nMaxAlumnos + '\'' +
                '}';
    }

    public String getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(String codGrupo) {
        this.codGrupo = codGrupo;
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

    public String getCodTurno() {
        return codTurno;
    }

    public void setCodTurno(String codTurno) {
        this.codTurno = codTurno;
    }

    public int getnMaxAlumnos() {
        return nMaxAlumnos;
    }

    public void setnMaxAlumnos(int nMaxAlumnos) {
        this.nMaxAlumnos = nMaxAlumnos;
    }
}
