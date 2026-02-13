package com.pberna.aad.exameneva2.data.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Genero {

    @Id
    @Column(name = "id_genero", nullable = false)
    private int idGenero;

    @Column(length = 45, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "genero")
    private List<Peliculas> peliculas;

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Peliculas> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Peliculas> peliculas) {
        this.peliculas = peliculas;
    }
}
