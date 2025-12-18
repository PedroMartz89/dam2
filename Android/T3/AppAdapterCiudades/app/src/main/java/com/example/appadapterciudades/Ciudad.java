package com.example.appadapterciudades;

public class Ciudad {
    private String nombre;
    private String pais;
    private String idioma;

    public Ciudad(String nombre, String pais, String idioma) {
        this.nombre = nombre;
        this.pais = pais;
        this.idioma = idioma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
