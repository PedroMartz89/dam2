package com.pberna.aad.examenut3ut4.data.model;

public class EstadisticasValoraciones {
    private int id; // idProducto
    private String nombre; //nombreProducto
    private long numValoraciones; // sum(valoraciones)
    private double valoracionMedia; // avg()
    private double valoracionMinima; // min(puntuacion)
    private double valoracionMaxima; // max(puntuacion)

    public EstadisticasValoraciones(int id, String nombre, long numValoraciones, double valoracionMedia, double valoracionMinima, double valoracionMaxima) {
        this.id = id;
        this.nombre = nombre;
        this.numValoraciones = numValoraciones;
        this.valoracionMedia = valoracionMedia;
        this.valoracionMinima = valoracionMinima;
        this.valoracionMaxima = valoracionMaxima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNumValoraciones() {
        return numValoraciones;
    }

    public void setNumValoraciones(long numValoraciones) {
        this.numValoraciones = numValoraciones;
    }

    public double getValoracionMedia() {
        return valoracionMedia;
    }

    public void setValoracionMedia(double valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }

    public double getValoracionMinima() {
        return valoracionMinima;
    }

    public void setValoracionMinima(double valoracionMinima) {
        this.valoracionMinima = valoracionMinima;
    }

    public double getValoracionMaxima() {
        return valoracionMaxima;
    }

    public void setValoracionMaxima(double valoracionMaxima) {
        this.valoracionMaxima = valoracionMaxima;
    }
}
