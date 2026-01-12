package data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "departamentos")

public class Departamento {
    @Id
    @Column(name = "codDepto")
    private String codDepto;

    @Column(name = "nombreDpto")
    private String nombreDpto;

    @Column(name = "ciudad")
    private String ciudad;

    @OneToOne
    @JoinColumn(name = "codDirector", referencedColumnName = "nDIEmp")
    private Empleado codDirector;

    public Departamento() {
    }

    public Departamento(String codDepto, String nombreDpto, String ciudad, Empleado codDirector) {
        this.codDepto = codDepto;
        this.nombreDpto = nombreDpto;
        this.ciudad = ciudad;
        this.codDirector = codDirector;
    }

    public String getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(String codDepto) {
        this.codDepto = codDepto;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public void setNombreDpto(String nombreDpto) {
        this.nombreDpto = nombreDpto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Empleado getCodDirector() {
        return codDirector;
    }

    public void setCodDirector(Empleado codDirector) {
        this.codDirector = codDirector;
    }

    @Override
    public String toString() {
        return "Departamento{" +
               "codDepto='" + codDepto + '\'' +
               ", nombreDpto='" + nombreDpto + '\'' +
               ", ciudad='" + ciudad + '\'' +
               // Evitar recursión infinita imprimiendo solo el ID del director
               ", codDirector='" + (codDirector != null ? codDirector.getnDIEmp() : "null") + '\'' +
               '}';
    }

}
