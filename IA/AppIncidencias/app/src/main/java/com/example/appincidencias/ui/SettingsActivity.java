package com.example.appincidencias.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appincidencias.R;
import com.example.appincidencias.utils.AppPreferences;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputEditText;

public class SettingsActivity extends AppCompatActivity {

    private TextInputEditText etEmail;
    private MaterialSwitch swEnvio;
    private AppPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // 1. Inicializar componentes del layout M3
        etEmail = findViewById(R.id.etEmail);
        swEnvio = findViewById(R.id.swEnvio);

        // 2. Cargar preferencias guardadas
        prefs = new AppPreferences(this);
        etEmail.setText(prefs.getEmail());
        swEnvio.setChecked(prefs.isEnvioActivo());

        // 3. Listener para el Switch de envío automático [cite: 30]
        swEnvio.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.setEnvioActivo(isChecked);
            // Aquí podrías disparar o cancelar el WorkManager según el estado
        });

        // 4. Guardar email al perder el foco (cuando el usuario termina de escribir) [cite: 29]
        etEmail.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String email = etEmail.getText().toString().trim();
                prefs.setEmail(email);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Asegurar que el email se guarde si el usuario sale de la app sin quitar el foco
        prefs.setEmail(etEmail.getText().toString().trim());
    }
}