package com.pberna.aad.exameneva2.data.pojos;

import java.math.BigDecimal;

public class RentabilidadDirector {
    private long idDirector;
	private String nombre;
	private double totalRecaudacion;
	private double mediaRecaudacion;
	private double rentabilidadMedia;

    public RentabilidadDirector(long idDirector, String nombre, double totalRecaudacion, double mediaRecaudacion, double rentabilidadMedia) {
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

    public double getTotalRecaudacion() {
        return totalRecaudacion;
    }

    public void setTotalRecaudacion(double totalRecaudacion) {
        this.totalRecaudacion = totalRecaudacion;
    }

    public double getMediaRecaudacion() {
        return mediaRecaudacion;
    }

    public void setMediaRecaudacion(double mediaRecaudacion) {
        this.mediaRecaudacion = mediaRecaudacion;
    }

    public double getRentabilidadMedia() {
        return rentabilidadMedia;
    }

    public void setRentabilidadMedia(double rentabilidadMedia) {
        this.rentabilidadMedia = rentabilidadMedia;
    }

    @Override
	public String toString() {
		return "RentabilidadDirector [idDirector=" + idDirector + ", nombre=" + nombre + ", totalRecaudacion="
				+ totalRecaudacion + ", mediaRecaudacion=" + mediaRecaudacion + ", rentabilidadMedia="
				+ rentabilidadMedia + "]";
	}
}
