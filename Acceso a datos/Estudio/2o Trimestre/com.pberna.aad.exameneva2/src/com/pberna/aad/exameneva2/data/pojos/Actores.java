package com.pberna.aad.exameneva2.data.pojos;

import com.mongodb.client.model.geojson.LineString;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity

public class Actores {
    @Id
    @Column(name = "id_actor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActor;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column
    private int edad;

    @Column(length = 50)
    private String nacionalidad;

    @Column
    private double estatura;

    @Column(name = "fecha_nacimiento")
    @Basic
    @Temporal(TemporalType.TIME)
    private Date fechaNaciemiento;

    @OneToMany(mappedBy = "actor")
    private List<PeliculaActor> peliculasActor;

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public Date getFechaNaciemiento() {
        return fechaNaciemiento;
    }

    public void setFechaNaciemiento(Date fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
    }

    public List<PeliculaActor> getPeliculasActor() {
        return peliculasActor;
    }

    public void setPeliculasActor(List<PeliculaActor> peliculasActor) {
        this.peliculasActor = peliculasActor;
    }

    @Override
    public String toString() {
        return "Actores{" +
                "idActor=" + idActor +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", estatura=" + estatura +
                ", fechaNaciemiento=" + fechaNaciemiento +
                ", peliculasActor=" + peliculasActor +
                '}';
    }
}
