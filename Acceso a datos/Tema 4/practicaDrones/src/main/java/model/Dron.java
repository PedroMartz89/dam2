package model;

import enumerates.EstadoDron;

import java.util.ArrayList;
import java.util.List;

public class Dron {
    private int id;
    private String modelo;
    private String anoFabricacion;
    private EstadoDron estado;
    private int nivelBateria;
    List<Mision> misionesRealizadas;

    public Dron(int id, String modelo, String anoFabricacion, int nivelBateria) {
        this.id = id;
        this.modelo = modelo;
        this.anoFabricacion = anoFabricacion;
        this.nivelBateria = nivelBateria;
        this.estado = EstadoDron.disponible;
        this.misionesRealizadas = new ArrayList<>();
    }

    public Dron() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(String anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public EstadoDron getEstado() {
        return estado;
    }

    public void setEstado(EstadoDron estado) {
        this.estado = estado;
    }

    public int getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(int nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public List<Mision> getMisionesRealizadas() {
        return misionesRealizadas;
    }

    public void setMisionesRealizadas(List<Mision> misionesRealizadas) {
        this.misionesRealizadas = misionesRealizadas;
    }
}
