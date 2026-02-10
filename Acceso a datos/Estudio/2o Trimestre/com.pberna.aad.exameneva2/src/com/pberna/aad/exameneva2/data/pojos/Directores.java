package com.pberna.aad.exameneva2.data.pojos;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = "rentabilidadDirector",
query = "SELECT NEW com.pberna.aad.exameneva2.data.pojos.RentabilidadDirector(" +
        "d.id, d.nombre, SUM(p.recaudacion), AVG(p.recaudacion), AVG(p.recaudacion / p.presupuesto)) " +
        "FROM Peliculas p JOIN p.director d " +
        "GROUP BY d.id, d.nombre")

public class Directores {

    @Id
    @Column(name = "id_director")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDirector;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 50)
    private String nacionalidad;

    @Column(name = "fecha_nacimiento")
    @Basic
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column
    private int premios;

    @OneToMany(mappedBy = "director")
    private List<Peliculas> peliculasDirigidas;

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getPremios() {
        return premios;
    }

    public void setPremios(int premios) {
        this.premios = premios;
    }

    public List<Peliculas> getPeliculasDirigidas() {
        return peliculasDirigidas;
    }

    public void setPeliculasDirigidas(List<Peliculas> peliculasDirigidas) {
        this.peliculasDirigidas = peliculasDirigidas;
    }
}
