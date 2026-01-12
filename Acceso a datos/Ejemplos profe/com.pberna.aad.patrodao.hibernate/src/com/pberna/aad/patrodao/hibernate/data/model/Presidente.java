package com.pberna.aad.patrodao.hibernate.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="presidente")
public class Presidente {

	@Id
	@Column(name="id_presidente", nullable= false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPresidente;
	
	@Column(length = 100, nullable = false)
	private String nombre;	
	
	@OneToOne
	@JoinColumn(name="equipo", referencedColumnName = "codigo_equipo")
	private Equipo equipoPresidido;

	public int getIdPresidente() {
		return idPresidente;
	}


	public void setIdPresidente(int idPresidente) {
		this.idPresidente = idPresidente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Equipo getEquipoPresidido() {
		return equipoPresidido;
	}


	public void setEquipoPresidido(Equipo equipoPresidido) {
		this.equipoPresidido = equipoPresidido;
	}
	
}
