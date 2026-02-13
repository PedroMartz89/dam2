package com.pberna.aad.exameneva2.data.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Genero {
    @Id
    @Column(name = "id_genero")
    private int idGenero;

    private String nombre;

    public Genero() {
    }

    public int getId_genero() {
        return idGenero;
    }

    public void setId_genero(int id_genero) {
        this.idGenero = id_genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
