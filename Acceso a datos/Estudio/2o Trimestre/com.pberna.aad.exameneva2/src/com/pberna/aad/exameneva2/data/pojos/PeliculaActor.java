package com.pberna.aad.exameneva2.data.pojos;

import jakarta.persistence.*;

@Entity
@Table(name="Pelicula_Actor")
@NamedQuery(name = "papelesActor",
        query = "from PeliculaActor pa where pa.actor.idActor = :idActor")

@NamedQuery(
        name = "buscarActoresPelicula",
        query = "SELECT pa.actor FROM PeliculaActor pa WHERE pa.pelicula.idPelicula = :idPelicula"
)
public class PeliculaActor {

    @EmbeddedId
    private PeliculaActorPK peliculaActorPK;

    @ManyToOne
    @MapsId("id_pelicula")
    @JoinColumn(name = "id_pelicula")
    private Peliculas pelicula;

    @ManyToOne
    @MapsId("id_actor")
    @JoinColumn(name = "id_actor")
    private Actores actor;

    @Column(length = 100, nullable = false)
    private String personaje;

    @Column
    private double salario;

    public PeliculaActorPK getPeliculaActorPK() {
        return peliculaActorPK;
    }

    public void setPeliculaActorPK(PeliculaActorPK peliculaActorPK) {
        this.peliculaActorPK = peliculaActorPK;
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

    @Override
    public String toString() {
        return "PeliculaActor{" +
                "peliculaActorPK=" + peliculaActorPK +
                ", personaje='" + personaje + '\'' +
                ", salario=" + salario +
                '}';
    }
}
