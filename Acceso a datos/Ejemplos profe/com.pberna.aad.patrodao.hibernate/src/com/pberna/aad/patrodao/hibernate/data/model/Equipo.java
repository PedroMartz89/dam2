package com.pberna.aad.patrodao.hibernate.data.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipo {
	
	@Id
	@Column(name="codigo_equipo")
	private int codigoEquipo;
	
	@Column(name="nombre_equipo", nullable = false, length = 40)
	private String nombreEquipo;
	
	@OneToMany(mappedBy = "equipoRelacionado", fetch = FetchType.LAZY)	
	private List<Jugador> jugadores;	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="equipo_patrocinador",
			joinColumns = { 
					@JoinColumn(name="equipo", 
							referencedColumnName = "codigo_equipo") 
					},
			inverseJoinColumns = { @JoinColumn(name="patrocinador",
							referencedColumnName = "id_patrocinador"),
						})
	private List<Patrocinador> patrocinadores;
	
	@OneToOne(mappedBy = "equipoPresidido")
	private Presidente presidente;
	
	public List<Patrocinador> getPatrocinadores() {
		return patrocinadores;
	}
	public void setPatrocinadores(List<Patrocinador> patrocinadores) {
		this.patrocinadores = patrocinadores;
	}
	public int getCodigoEquipo() {
		return codigoEquipo;
	}
	public void setCodigoEquipo(int codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	
	@Override
	public String toString() {
		return "Equipo [codigoEquipo=" + codigoEquipo + ", nombreEquipo=" + nombreEquipo + "]";
	}
	
	public Presidente getPresidente() {
		return presidente;
	}
	
	public void setPresidente(Presidente presidente) {
		this.presidente = presidente;
	}	
	
}
