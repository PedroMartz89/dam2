package com.example.ejemploapp;
import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Usuario.class},version=1) // Define entidades
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoUsuario daoUsuario(); // DAO usados

}
