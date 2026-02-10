package com.pberna.aad.exameneva2.data.pojos;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="ListarPorIdPelicula", 
			query = "SELECT a.* from Actores a " + 
					" INNER JOIN Pelicula_Actor pa ON pa.id_actor = a.id_actor "+ 
					" WHERE pa.id_pelicula = ?", resultClass = Actores.class)
})
public class Actores {
	
	@Id
	@Column(name="id_actor", nullable=false)
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
	
	@Column(name="fecha_nacimiento")
	@Basic
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@OneToMany
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<PeliculaActor> getPeliculasActor() {
		return peliculasActor;
	}

	public void setPeliculasActor(List<PeliculaActor> peliculasActor) {
		this.peliculasActor = peliculasActor;
	}

	@Override
	public String toString() {
		return "Actores [idActor=" + idActor + ", nombre=" + nombre + ", edad=" + edad + ", nacionalidad="
				+ nacionalidad + ", estatura=" + estatura + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	
}
