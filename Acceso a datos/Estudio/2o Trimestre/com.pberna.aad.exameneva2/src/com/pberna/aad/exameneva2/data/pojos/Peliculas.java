package com.pberna.aad.exameneva2.data.pojos;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Peliculas {

    @Id
    @Column(name = "id_pelicula")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPelicula;

    @Column(length = 150, nullable = false)
    private String titulo;

    @Column
    private int anio;

    @Column
    private double presupuesto;

    @Column(length = 10, nullable = false)
    private String clasificacion;

    @ManyToOne
    @JoinColumn(name = "id_director")
    private Directores director;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    @Column
    private double recaudacion;

    @OneToMany(mappedBy = "pelicula")
    private List<PeliculaActor> peliculasActor;

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Directores getDirector() {
        return director;
    }

    public void setDirector(Directores director) {
        this.director = director;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public List<PeliculaActor> getPeliculasActor() {
        return peliculasActor;
    }

    public void setPeliculasActor(List<PeliculaActor> peliculasActor) {
        this.peliculasActor = peliculasActor;
    }

    @Override
    public String toString() {
        return "Peliculas{" +
                "idPelicula=" + idPelicula +
                ", titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", presupuesto=" + presupuesto +
                ", clasificacion='" + clasificacion + '\'' +
                ", director=" + director +
                ", genero=" + genero +
                ", recaudacion=" + recaudacion +
                ", peliculasActor=" + peliculasActor +
                '}';
    }
}
