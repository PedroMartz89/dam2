package com.example.ejemploadaptadores;

import androidx.annotation.NonNull;

public class Libro {
    private String libro_id;
    private String titulo;
    private String autor;
    private String categoria;
    private int imagen;

    public Libro(String libro_id, String titulo, String autor, String categoria, int imagen) {
        this.libro_id = libro_id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.imagen = imagen;
    }

    public String getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(String libro_id) {
        this.libro_id = libro_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "libro_id='" + libro_id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", categoria='" + categoria + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
