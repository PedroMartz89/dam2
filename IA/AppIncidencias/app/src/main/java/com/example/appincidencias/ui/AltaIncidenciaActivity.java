package com.example.appincidencias.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appincidencias.R;
import com.example.appincidencias.model.AppDatabase;
import com.example.appincidencias.model.Incidencia;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class AltaIncidenciaActivity extends AppCompatActivity {

    private TextInputEditText etUbicacion, etDescripcion, etIdentificacion;
    private AutoCompleteTextView spPrioridad, spTipoDispositivo;
    private MaterialButton btnGuardar;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_incidencia);

        db = AppDatabase.getInstance(this);

        etUbicacion = findViewById(R.id.etUbicacion);
        etDescripcion = findViewById(R.id.etDescripcion);
        etIdentificacion = findViewById(R.id.etIdentificacion);
        spPrioridad = findViewById(R.id.spPrioridad);
        spTipoDispositivo = findViewById(R.id.spTipoDispositivo);
        btnGuardar = findViewById(R.id.btnGuardar);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        setupDropdowns();

        btnGuardar.setOnClickListener(v -> guardarIncidencia());
    }

    private void setupDropdowns() {
        // Usar los arrays definidos en strings.xml / arrays.xml
        String[] prioridades = getResources().getStringArray(R.array.prioridades);
        // Filtrar "Todas" de la lista de prioridades para el alta
        String[] prioridadesAlta = new String[prioridades.length - 1];
        System.arraycopy(prioridades, 1, prioridadesAlta, 0, prioridades.length - 1);
        
        ArrayAdapter<String> adapterPrioridad = new ArrayAdapter<>(this, R.layout.list_item, prioridadesAlta);
        spPrioridad.setAdapter(adapterPrioridad);

        String[] tipos = getResources().getStringArray(R.array.tipos);
        // Filtrar "Todos" de la lista de tipos para el alta
        String[] tiposAlta = new String[tipos.length - 1];
        System.arraycopy(tipos, 1, tiposAlta, 0, tipos.length - 1);

        ArrayAdapter<String> adapterTipo = new ArrayAdapter<>(this, R.layout.list_item, tiposAlta);
        spTipoDispositivo.setAdapter(adapterTipo);
    }

    private void guardarIncidencia() {
        String ubicacion = etUbicacion.getText().toString().trim();
        String descripcion = etDescripcion.getText().toString().trim();
        String identificacion = etIdentificacion.getText().toString().trim();
        String prioridad = spPrioridad.getText().toString();
        String tipo = spTipoDispositivo.getText().toString();

        if (ubicacion.isEmpty() || descripcion.isEmpty() || prioridad.isEmpty() || tipo.isEmpty() || identificacion.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Incidencia nuevaIncidencia = new Incidencia();
        nuevaIncidencia.ubicacion = ubicacion;
        nuevaIncidencia.prioridad = prioridad;
        nuevaIncidencia.tipoDispositivo = tipo;
        nuevaIncidencia.identificacion = identificacion;
        nuevaIncidencia.descripcion = descripcion;
        nuevaIncidencia.fechaHora = System.currentTimeMillis();
        nuevaIncidencia.estado = "Abierta";

        new Thread(() -> {
            db.incidenciaDao().insert(nuevaIncidencia);
            runOnUiThread(() -> {
                Toast.makeText(this, "Incidencia registrada con éxito", Toast.LENGTH_SHORT).show();
                finish();
            });
        }).start();
    }
}