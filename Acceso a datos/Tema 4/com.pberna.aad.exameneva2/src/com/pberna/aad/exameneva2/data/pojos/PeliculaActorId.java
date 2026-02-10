package com.pberna.aad.exameneva2.data.pojos;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PeliculaActorId implements Serializable {
    private int id_pelicula;
    private int id_actor;

    public PeliculaActorId() {}

    public PeliculaActorId(int id_pelicula, int id_actor) {
        this.id_pelicula = id_pelicula;
        this.id_actor = id_actor;
    }

    // Getters y Setters
    public int getId_pelicula() { return id_pelicula; }
    public void setId_pelicula(int id_pelicula) { this.id_pelicula = id_pelicula; }

    public int getId_actor() { return id_actor; }
    public void setId_actor(int id_actor) { this.id_actor = id_actor; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeliculaActorId that = (PeliculaActorId) o;
        return id_pelicula == that.id_pelicula && id_actor == that.id_actor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pelicula, id_actor);
    }
}