package com.pberna.aad.exameneva2.data.pojos;

public class RentabilidadDirector {
    private int idRentDirector;
    private String nombreRentDirector;
    private double totalRecaudacion;
    private double mediaRecaudacion;
    private double rentabilidadMedia;

    public RentabilidadDirector() {
    }

    public int getIdRentDirector() {
        return idRentDirector;
    }

    public RentabilidadDirector(int idRentDirector, String nombreRentDirector, double totalRecaudacion, double mediaRecaudacion, double rentabilidadMedia) {
        this.idRentDirector = idRentDirector;
        this.nombreRentDirector = nombreRentDirector;
        this.totalRecaudacion = totalRecaudacion;
        this.mediaRecaudacion = mediaRecaudacion;
        this.rentabilidadMedia = rentabilidadMedia;
    }

    public void setIdRentDirector(int idRentDirector) {
        this.idRentDirector = idRentDirector;
    }

    public String getNombreRentDirector() {
        return nombreRentDirector;
    }

    public void setNombreRentDirector(String nombreRentDirector) {
        this.nombreRentDirector = nombreRentDirector;
    }

    public double getTotalRecaudacion() {
        return totalRecaudacion;
    }

    public void setTotalRecaudacion(double totalRecaudacion) {
        this.totalRecaudacion = totalRecaudacion;
    }

    public double getRentabilidadMedia() {
        return rentabilidadMedia;
    }

    public void setRentabilidadMedia(double rentabilidadMedia) {
        this.rentabilidadMedia = rentabilidadMedia;
    }

    public double getMediaRecaudacion() {
        return mediaRecaudacion;
    }

    public void setMediaRecaudacion(double mediaRecaudacion) {
        this.mediaRecaudacion = mediaRecaudacion;
    }
}
