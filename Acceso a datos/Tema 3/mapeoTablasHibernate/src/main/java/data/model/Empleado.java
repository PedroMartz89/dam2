package data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @Column(name = "nDIEmp")
    private String nDIEmp;

    @Column(name = "nomEmp")
    private String nomEmp;

    @Column(name = "sexEmp")
    private String sexEmp;

    @Column(name = "fecNac")
    private String fecNac;

    @Column(name = "fecIncorporacion")
    private String fecIncorporacion;

    @Column(name = "salEmp")
    private float salEmp;

    @Column(name = "comisionE")
    private float comisionE;

    @Column(name = "cargoE")
    private String cargoE;

    @OneToOne
    @JoinColumn(name = "jefeID", referencedColumnName = "nDIEmp")
    private Empleado jefeID;

    @OneToOne
    @JoinColumn(name = "codDepto", referencedColumnName = "codDepto")
    private Departamento codDepto;

    public Empleado() {
    }

    public Empleado(String nDIEmp, String nomEmp, String sexEmp, String fecNac, String fecIncorporacion, float salEmp, float comisionE, String cargoE, Empleado jefeID, Departamento codDepto) {
        this.nDIEmp = nDIEmp;
        this.nomEmp = nomEmp;
        this.sexEmp = sexEmp;
        this.fecNac = fecNac;
        this.fecIncorporacion = fecIncorporacion;
        this.salEmp = salEmp;
        this.comisionE = comisionE;
        this.cargoE = cargoE;
        this.jefeID = jefeID;
        this.codDepto = codDepto;
    }

    public String getnDIEmp() {
        return nDIEmp;
    }

    public void setnDIEmp(String nDIEmp) {
        this.nDIEmp = nDIEmp;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nDIEmp='" + nDIEmp + '\'' +
                ", nomEmp='" + nomEmp + '\'' +
                ", sexEmp='" + sexEmp + '\'' +
                ", fecNac='" + fecNac + '\'' +
                ", fecIncorporacion='" + fecIncorporacion + '\'' +
                ", salEmp=" + salEmp +
                ", comisionE=" + comisionE +
                ", cargoE='" + cargoE + '\'' +
                // Esto es para evitar recursión infinita imprimiendo solo el ID dle jefe y el departamento (antes daba error porque se llamaba al toString de departamento
                // y del jefe todo el rato)
                ", jefeID=" + (jefeID != null ? jefeID.getnDIEmp() : "null") +
                ", codDepto=" + (codDepto != null ? codDepto.getCodDepto() : "null") +
                '}';
    }
}
