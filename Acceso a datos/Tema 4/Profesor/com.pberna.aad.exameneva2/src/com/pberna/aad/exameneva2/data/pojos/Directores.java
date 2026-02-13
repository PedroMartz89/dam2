package com.pberna.aad.exameneva2.data.pojos;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Directores")
public class Directores {
	
	@Id
	@Column(name="id_director", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDirector;
	
	@Column(name="nombre", length = 100, nullable = false)
	private String nombre;
	
	@Column(length = 50, nullable = false)
	private String nacionalidad;
	
	@Column(name="fecha_nacimiento")
	@Basic
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column
	private int premios;
	
	@Column(length = 100)
	private String email;	
	
	@OneToMany(mappedBy="director")
	private List<Peliculas> peliculasDirigidas;
	
	
	public int getIdDirector() {
		return idDirector;
	}
	public void setIdDirector(int idDirector) {
		this.idDirector = idDirector;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getPremios() {
		return premios;
	}
	public void setPremios(int premios) {
		this.premios = premios;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Peliculas> getPeliculasDirigidas() {
		return peliculasDirigidas;
	}
	public void setPeliculasDirigidas(List<Peliculas> peliculasDirigidas) {
		this.peliculasDirigidas = peliculasDirigidas;
	}
	
	@Override
	public String toString() {
		return "Directores [idDirector=" + idDirector + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad
				+ ", fechaNacimiento=" + fechaNacimiento + ", premios=" + premios + ", email=" + email + "]";
	}	
	
}
