package com.example.appincidencias.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "incidencias")
public class Incidencia {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String ubicacion;
    public String prioridad;
    public String tipoDispositivo;
    public String identificacion;
    public String descripcion;
    public String estado;
    public long fechaHora;
}
