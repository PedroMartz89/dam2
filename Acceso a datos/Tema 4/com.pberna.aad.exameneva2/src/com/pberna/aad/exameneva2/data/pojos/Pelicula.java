package com.pberna.aad.exameneva2.data.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "Peliculas")
public class Pelicula {
    @Id
    @Column(name = "id_pelicula")
    private int idPelicula;

    private String titulo;
    private int anio;
    private double presupuesto;
    private String clasificacion;
    private double recaudacion;

    @ManyToOne
    @JoinColumn(name = "id_director")
    private Director director;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    public Pelicula() {
    }

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

    public double getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
