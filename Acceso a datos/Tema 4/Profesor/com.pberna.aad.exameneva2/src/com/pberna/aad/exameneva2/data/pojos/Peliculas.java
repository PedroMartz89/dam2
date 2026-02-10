package com.pberna.aad.exameneva2.data.pojos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Peliculas {
	
	@Id
	@Column(name="id_pelicula", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPelicula;
	
	@Column(length = 150, nullable = false)
	private String titulo;
	
	@Column(name="anio", nullable = false)
	private int año;
	
	@Column
	private double presupuesto;
	
	@Column(length = 10)
	private String clasificacion;	
	
	@ManyToOne
	@JoinColumn(name="id_genero", nullable = false)
	private Genero genero;
	
	@ManyToOne
	@JoinColumn(name="id_director", nullable = false)
	private Directores director;	
	
	@Column(nullable = false)
	private double recaudacion;
	
	@OneToMany	
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
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
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
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Directores getDirector() {
		return director;
	}
	public void setDirector(Directores director) {
		this.director = director;
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
		return "Peliculas [idPelicula=" + idPelicula + ", titulo=" + titulo + ", año=" + año + ", presupuesto="
				+ presupuesto + ", clasificacion=" + clasificacion + ", genero=" + genero + ", director=" + director
				+ ", recaudacion=" + recaudacion + "]";
	}	
	
}
