package com.pberna.aad.patrodao.hibernate.data.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="patrocinador")
public class Patrocinador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_patrocinador")
	private int idPatrocinador;
	
	@Column(name="nombre_patrocinador", nullable = false, length = 30)
	private String nombrePatrocinador;	
	
	@ManyToMany(mappedBy="patrocinadores")
	private List<Equipo> equipos;
	
	public int getIdPatrocinador() {
		return idPatrocinador;
	}
	public void setIdPatrocinador(int idPatrocinador) {
		this.idPatrocinador = idPatrocinador;
	}
	public String getNombrePatrocinador() {
		return nombrePatrocinador;
	}
	public void setNombrePatrocinador(String nombrePatrocinador) {
		this.nombrePatrocinador = nombrePatrocinador;
	}
	
	@Override
	public String toString() {
		return "Patrocinador [idPatrocinador=" + idPatrocinador + ", nombrePatrocinador=" + nombrePatrocinador + "]";
	}
	public List<Equipo> getEquipos() {
		return equipos;
	}
	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	
}
