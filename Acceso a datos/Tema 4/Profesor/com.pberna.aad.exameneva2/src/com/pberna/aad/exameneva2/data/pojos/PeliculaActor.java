package com.pberna.aad.exameneva2.data.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Pelicula_Actor")
public class PeliculaActor {
	
	@EmbeddedId
	private PeliculaActorPK peliculasActorPK;
	
	@Column(nullable = false, length = 100)
	private String personaje;
	
	@Column(nullable = false)
	private double salario;	
	
	public PeliculaActorPK getPeliculasActorPK() {
		return peliculasActorPK;
	}
	public void setPeliculasActorPK(PeliculaActorPK peliculasActorPK) {
		this.peliculasActorPK = peliculasActorPK;
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
		return "PeliculaActor [peliculasActorPK=" + peliculasActorPK + ", personaje=" + personaje + ", salario="
				+ salario + "]";
	}
	
	
}
