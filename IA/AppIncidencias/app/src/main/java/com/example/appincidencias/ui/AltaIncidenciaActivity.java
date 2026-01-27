package com.example.appincidencias.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.appincidencias.R;
import com.example.appincidencias.model.AppDatabase;
import com.example.appincidencias.model.Incidencia;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class AltaIncidenciaActivity extends AppCompatActivity {

    private TextInputEditText etUbicacion, etDescripcion;
    private AutoCompleteTextView spPrioridad;
    private MaterialButton btnGuardar;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_incidencia);

        // Inicializar base de datos local
        db = AppDatabase.getInstance(this);

        // Vincular componentes del layout
        etUbicacion = findViewById(R.id.etUbicacion);
        etDescripcion = findViewById(R.id.etDescripcion);
        spPrioridad = findViewById(R.id.spPrioridad);
        btnGuardar = findViewById(R.id.btnGuardar);

        // Configurar el menú desplegable de Prioridad (Material 3)
        setupDropdown();

        // Listener para guardar la incidencia
        btnGuardar.setOnClickListener(v -> guardarIncidencia());
    }

    private void setupDropdown() {
        // Los valores deben coincidir con los requisitos: baja, media, alta
        String[] prioridades = new String[]{"Baja", "Media", "Alta"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item, // Layout simple para el item del dropdown
                prioridades
        );
        spPrioridad.setAdapter(adapter);
    }

    private void guardarIncidencia() {
        String ubicacion = etUbicacion.getText().toString().trim();
        String descripcion = etDescripcion.getText().toString().trim();
        String prioridad = spPrioridad.getText().toString();

        // Validación básica
        if (ubicacion.isEmpty() || descripcion.isEmpty() || prioridad.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear objeto Incidencia con campos obligatorios
        Incidencia nuevaIncidencia = new Incidencia();
        nuevaIncidencia.ubicacion = ubicacion; //
        nuevaIncidencia.prioridad = prioridad; //
        nuevaIncidencia.descripcion = descripcion; //
        nuevaIncidencia.fechaHora = System.currentTimeMillis(); // Automática
        nuevaIncidencia.estado = "Abierta"; // Estado inicial

        // Operación en hilo secundario (Room requiere no usar el hilo principal)
        new Thread(() -> {
            db.incidenciaDao().insert(nuevaIncidencia);
            runOnUiThread(() -> {
                Toast.makeText(this, "Incidencia registrada con éxito", Toast.LENGTH_SHORT).show();
                finish(); // Volver a la pantalla principal
            });
        }).start();
    }
}