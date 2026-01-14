package com.masan.adaptadores;

import java.util.UUID;

public class Libro {

   private String libroId;
   private String libroTitulo;
   private String libroAutor;
   private String libroCategoria;
   private int libroImagen;

    public Libro(String titulo, String autor, String categoria, int imagen){
        //Asignamos ID aleatorio
        libroId= UUID.randomUUID().toString();
        libroTitulo=titulo;
        libroAutor=autor;
        libroCategoria=categoria;
        libroImagen=imagen;

    }

    public String getLibroId() {
        return libroId;
    }

    public void setLibroId(String libroId) {
        this.libroId = libroId;
    }

    public String getLibroTitulo() {
        return libroTitulo;
    }

    public void setLibroTitulo(String libroTitulo) {
        this.libroTitulo = libroTitulo;
    }

    public String getLibroAutor() {
        return libroAutor;
    }

    public void setLibroAutor(String libroAutor) {
        this.libroAutor = libroAutor;
    }

    public String getLibroCategoria() {
        return libroCategoria;
    }

    public void setLibroCategoria(String libroCategoria) {
        this.libroCategoria = libroCategoria;
    }

    public int getLibroImagen() {
        return libroImagen;
    }

    public void setLibroImagen(int libroImagen) {
        this.libroImagen = libroImagen;
    }

    @Override
    public String toString(){
        //return "Libro{" + "ID='" + libroId + ''' + ", Titulo='" + libroTitulo + ''' + ", Autor='"
        return "Lead{" + "ID='" + libroId + ", Compañía='" + libroTitulo + ", Nombre='" + libroAutor + ", Cargo='" + libroCategoria + '}';

    }

}
