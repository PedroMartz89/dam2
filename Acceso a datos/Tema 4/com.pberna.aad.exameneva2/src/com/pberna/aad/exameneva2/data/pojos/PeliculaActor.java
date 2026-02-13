package com.pberna.aad.exameneva2.data.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "Pelicula_Actor")
@NamedQuery(
        name = "PeliculaActor.findActorPelicula",
        query = "select pa.actor FROM PeliculaActor pa WHERE pa.pelicula.idPelicula = :idPelicula"
)
public class PeliculaActor {
    @EmbeddedId
    private PeliculaActorId id;

    @ManyToOne
    @MapsId("id_pelicula")
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

    @ManyToOne
    @MapsId("id_actor")
    @JoinColumn(name="id_actor")
    private Actor actor;

    private String personaje;
    private double salario;

    public PeliculaActorId getId() {
        return id;
    }

    public void setId(PeliculaActorId id) {
        this.id = id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
