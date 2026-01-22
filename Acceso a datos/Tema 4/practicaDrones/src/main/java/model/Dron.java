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
}
