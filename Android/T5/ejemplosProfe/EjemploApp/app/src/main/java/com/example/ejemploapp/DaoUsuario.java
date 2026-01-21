package com.example.ejemploapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoUsuario {

    @Query("SELECT * FROM usuario")
    List<Usuario> obtenerUsuarios();

    @Query("SELECT * FROM usuario WHERE usuario= :user")
    Usuario obtenerUsuario(String user);

    @Insert
    void insertarUsuario(Usuario...usuarios);

    @Update
    void actualizarUsuario(Usuario usuario);

    @Delete
    void borrarUsuario(Usuario usuario);

    /*
    @Query("UPDATE usuario SET nombre= :nombre, correo= :correo WHERE usuario= :user")
    void actualizarUsuario(String user, String nombre, String correo);

    @Query("DELETE FROM usuario WHERE usuario= :user")
    void borrarUsuario(String user);
*/

}
