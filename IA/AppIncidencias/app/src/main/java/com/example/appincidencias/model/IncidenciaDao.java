package com.example.appincidencias.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IncidenciaDao {

    @Insert
    void insert(Incidencia incidencia);

    @Query("SELECT * FROM incidencias ORDER BY fechaHora DESC")
    List<Incidencia> getAll();

    @Query("SELECT * FROM incidencias WHERE estado != 'Resuelta'")
    List<Incidencia> getPendientes();

    @Update
    void update(Incidencia incidencia);
}
