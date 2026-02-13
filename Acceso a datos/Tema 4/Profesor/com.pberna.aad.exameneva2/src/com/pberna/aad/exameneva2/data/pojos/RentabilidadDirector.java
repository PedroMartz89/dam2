package com.pberna.aad.exameneva2.data.pojos;

import java.math.BigDecimal;

public class RentabilidadDirector {
	private long idDirector;
	private String nombre;
	private BigDecimal totalRecaudacion;
	private BigDecimal mediaRecaudacion;
	private BigDecimal rentabilidadMedia;	
	
	public RentabilidadDirector(long idDirector, 
			String nombre, BigDecimal totalRecaudacion, 
			BigDecimal mediaRecaudacion,
			BigDecimal rentabilidadMedia) {
		super();
		this.idDirector = idDirector;
		this.nombre = nombre;
		this.totalRecaudacion = totalRecaudacion;
		this.mediaRecaudacion = mediaRecaudacion;
		this.rentabilidadMedia = rentabilidadMedia;
	}
	public long getIdDirector() {
		return idDirector;
	}
	public void setIdDirector(long idDirector) {
		this.idDirector = idDirector;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getTotalRecaudacion() {
		return totalRecaudacion;
	}
	public void setTotalRecaudacion(BigDecimal totalRecaudacion) {
		this.totalRecaudacion = totalRecaudacion;
	}
	public BigDecimal getMediaRecaudacion() {
		return mediaRecaudacion;
	}
	public void setMediaRecaudacion(BigDecimal mediaRecaudacion) {
		this.mediaRecaudacion = mediaRecaudacion;
	}
	public BigDecimal getRentabilidadMedia() {
		return rentabilidadMedia;
	}
	public void setRentabilidadMedia(BigDecimal rentabilidadMedia) {
		this.rentabilidadMedia = rentabilidadMedia;
	}
	@Override
	public String toString() {
		return "RentabilidadDirector [idDirector=" + idDirector + ", nombre=" + nombre + ", totalRecaudacion="
				+ totalRecaudacion + ", mediaRecaudacion=" + mediaRecaudacion + ", rentabilidadMedia="
				+ rentabilidadMedia + "]";
	}
		
}
