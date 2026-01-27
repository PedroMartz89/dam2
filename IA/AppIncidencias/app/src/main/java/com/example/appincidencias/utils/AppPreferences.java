package com.example.appincidencias.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {

    private static final String PREFS_NAME = "IncidenciasPrefs";
    private static final String PREF_EMAIL = "email";
    private static final String PREF_ENVIO_ACTIVO = "envioActivo";

    private SharedPreferences sharedPreferences;

    public AppPreferences(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    // Obtener el correo configurado
    public String getEmail() {
        return sharedPreferences.getString(PREF_EMAIL, "");
    }

    // Guardar el correo configurado
    public void setEmail(String email) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREF_EMAIL, email);
        editor.apply();
    }

    // Verificar si el envío automático está activado
    public boolean isEnvioActivo() {
        return sharedPreferences.getBoolean(PREF_ENVIO_ACTIVO, false);
    }

    // Guardar si el envío automático está activado
    public void setEnvioActivo(boolean activo) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(PREF_ENVIO_ACTIVO, activo);
        editor.apply();
    }
}

