package com.masan.adaptadores;

public class Equipo {

    private Integer id;
    private String nombre;
    private String categoria;
    private String genero;
    private String equipoFormato;

    public Equipo() {
    }

    public Equipo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Equipo(Integer id, String nombre, String categoria, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        this.equipoFormato=this.nombre + ": " + this.categoria + " " + this.genero;
        return equipoFormato;
    }


}
