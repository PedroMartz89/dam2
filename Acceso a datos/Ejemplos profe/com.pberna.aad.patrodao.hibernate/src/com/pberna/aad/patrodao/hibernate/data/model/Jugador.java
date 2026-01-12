package com.pberna.aad.patrodao.hibernate.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="jugadores")
public class Jugador {

	@Id
	@Column(name="codigo_jugador", nullable = false)
	private int codigoJugador;
	
	@Column
	private int estatura;
	
	@Column(name="nombre_jugador", length = 255)
	private String nombreJugador;
	
	@Column(length= 255)
	private String puesto;
	
	//private int equipo;
	@ManyToOne
	@JoinColumn(name="equipo", referencedColumnName = "codigo_equipo")
	private Equipo equipoRelacionado;

	public int getCodigoJugador() {
		return codigoJugador;
	}

	public void setCodigoJugador(int codigoJugador) {
		this.codigoJugador = codigoJugador;
	}

	public int getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Equipo getEquipoRelacionado() {
		return equipoRelacionado;
	}

	public void setEquipoRelacionado(Equipo equipoRelacionado) {
		this.equipoRelacionado = equipoRelacionado;
	}

	@Override
	public String toString() {
		return "Jugador [codigoJugador=" + codigoJugador + ", estatura=" + estatura + ", nombreJugador=" + nombreJugador
				+ ", puesto=" + puesto + ", equipoRelacionado=" + equipoRelacionado + "]";
	}
	
}
