package model;

public class Turno {

    private String codTurno;
    private String horario;

    public Turno(String codTurno, String horario) {
        this.codTurno = codTurno;
        this.horario = horario;
    }

    public Turno() {
    }

    @Override
    public String toString() {
        return "Turno{" +
                "codTurno='" + codTurno + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }

    public String getCodTurno() {
        return codTurno;
    }

    public void setCodTurno(String codTurno) {
        this.codTurno = codTurno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
