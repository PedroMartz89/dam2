package com.example.appincidencias.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.example.appincidencias.R;
import com.example.appincidencias.adapter.IncidenciaAdapter; // Debes crear este Adapter
import com.example.appincidencias.model.AppDatabase;
import com.example.appincidencias.model.Incidencia;
import com.example.appincidencias.worker.EmailWorker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements IncidenciaAdapter.OnIncidenciaClickListener {

    private AppDatabase db;
    private RecyclerView recyclerView;
    private IncidenciaAdapter adapter;
    private FloatingActionButton fabAdd;
    private AutoCompleteTextView spEstado, spPrioridad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Configurar Toolbar (Material 3)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 2. Inicializar base de datos y vistas
        db = AppDatabase.getInstance(this);
        recyclerView = findViewById(R.id.recyclerView);
        fabAdd = findViewById(R.id.btnAdd);
        spEstado = findViewById(R.id.spEstado);
        spPrioridad = findViewById(R.id.spPrioridad);

        // 3. Configurar RecyclerView (Sustituye al ListView anterior)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new IncidenciaAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(adapter);

        // 4. Listeners
        fabAdd.setOnClickListener(v ->
                startActivity(new Intent(this, AltaIncidenciaActivity.class)));

        // 5. Cargar datos e inicializar componentes
        configurarFiltrosM3();
        programarEnvioCorreo();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarIncidencias(); // Recargar al volver de añadir incidencia
    }

    private void cargarIncidencias() {
        // En un entorno profesional, esto se haría mediante LiveData en el ViewModel
        List<Incidencia> lista = db.incidenciaDao().getAll();
        adapter.updateList(lista);
    }

    private void configurarFiltrosM3() {
        // Configuración de Adapters para Material 3 Exposed Dropdown Menus
        String[] estados = getResources().getStringArray(R.array.estados);
        ArrayAdapter<String> adapterEst = new ArrayAdapter<>(this, R.layout.list_item, estados);
        spEstado.setAdapter(adapterEst);
        spEstado.setOnItemClickListener((parent, view, position, id) -> filtrarIncidencias());

        String[] prioridades = getResources().getStringArray(R.array.prioridades);
        ArrayAdapter<String> adapterPri = new ArrayAdapter<>(this, R.layout.list_item, prioridades);
        spPrioridad.setAdapter(adapterPri);
        spPrioridad.setOnItemClickListener((parent, view, position, id) -> filtrarIncidencias());
    }

    private void filtrarIncidencias() {
        String estadoFiltro = spEstado.getText().toString();
        String prioridadFiltro = spPrioridad.getText().toString();

        List<Incidencia> listaCompleta = db.incidenciaDao().getAll();
        List<Incidencia> filtrada = new ArrayList<>();

        for (Incidencia i : listaCompleta) {
            boolean coincideEstado = estadoFiltro.equals("Todos") || i.estado.equals(estadoFiltro);
            boolean coincidePrioridad = prioridadFiltro.equals("Todas") || i.prioridad.equals(prioridadFiltro);

            if (coincideEstado && coincidePrioridad) {
                filtrada.add(i);
            }
        }
        adapter.updateList(filtrada); // Actualizar el RecyclerView con el filtro [cite: 23, 83]
    }

    private void programarEnvioCorreo() {
        // Ejecución periódica cada hora según especificación [cite: 32, 90]
        PeriodicWorkRequest request = new PeriodicWorkRequest.Builder(
                EmailWorker.class, 1, TimeUnit.HOURS)
                .build();

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
                "envioCorreoWorker",
                ExistingPeriodicWorkPolicy.KEEP, // Mantiene la tarea si ya existe
                request);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onResolverClick(Incidencia incidencia) {
        // Cambiamos el estado localmente
        incidencia.estado = "Resuelta";

        // Actualizamos en la base de datos en un hilo secundario (Room no permite hilos principales)
        new Thread(() -> {
            db.incidenciaDao().update(incidencia);

            // Volvemos al hilo de UI para refrescar la lista
            runOnUiThread(() -> {
                cargarIncidencias(); // Recarga y aplica filtros actuales
                Toast.makeText(this, "Incidencia marcada como resuelta", Toast.LENGTH_SHORT).show();
            });
        }).start();
    }
}
