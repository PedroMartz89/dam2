package model.calculados;

public class MatriculadosAsignatura {
    private String codigoAsignatura;
    private long alumnosMatriculados;

    public String getCodigoAsignatura() {
        return codigoAsignatura;
    }
    public void setCodigoAsignatura(String codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }
    public long getAlumnosMatriculados() {
        return alumnosMatriculados;
    }
    public void setAlumnosMatriculados(long alumnosMatriculados) {
        this.alumnosMatriculados = alumnosMatriculados;
    }

    @Override
    public String toString() {
        return "MatriculadosAsignatura [codigoAsignatura=" + codigoAsignatura + ", alumnosMatriculados="
                + alumnosMatriculados + "]";
    }

    public MatriculadosAsignatura() {

    }

    public MatriculadosAsignatura(String codigoAsignatura, long alumnosMatriculados) {
        super();
        this.codigoAsignatura = codigoAsignatura;
        this.alumnosMatriculados = alumnosMatriculados;
    }

}