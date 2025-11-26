package ejFicheros.model;

import java.sql.Date;

public class Escritor {
    private int cod_escritor;
    private String nombre_escritor;
    private Date fecha_nacimiento;

    public Escritor(int cod_escritor, String nombre_escritor, Date fecha_nacimiento) {
        this.cod_escritor = cod_escritor;
        this.nombre_escritor = nombre_escritor;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "Escritor{" +
                "cod_escritor=" + cod_escritor +
                ", nombre_escritor='" + nombre_escritor + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                '}';
    }

    public int getCod_escritor() {
        return cod_escritor;
    }

    public void setCod_escritor(int cod_escritor) {
        this.cod_escritor = cod_escritor;
    }

    public String getNombre_escritor() {
        return nombre_escritor;
    }

    public void setNombre_escritor(String nombre_escritor) {
        this.nombre_escritor = nombre_escritor;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
