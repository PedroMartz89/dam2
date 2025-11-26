package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        contador = 0;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button botonI = findViewById(R.id.button2);
        botonI.setOnClickListener(this::incrementaContador);

        Button botonD = findViewById(R.id.button);
        botonD.setOnClickListener(this::decrementaContador);

        Button botonR = findViewById(R.id.button3);
        botonR.setOnClickListener(this::reseteaContador);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void incrementaContador(View vista){
        contador++;
        mostrarResultado();
    }
    public void decrementaContador(View vista){
        contador--;
        mostrarResultado();
    }
    public void reseteaContador(View vista){
        contador=0;
        mostrarResultado();
    }

    public void mostrarResultado(){
        TextView textoResultado = findViewById(R.id.textView2);
        textoResultado.setText(String.valueOf(contador));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_en_activity, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId(); // Optimization: Call method once

        if (id == R.id.configuracion) {
            // Correct way: Start a new Activity
            Intent intent = new Intent(this, ConfiguracionActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.acercaDe) {
            // Correct way: Start a new Activity
            Intent intent = new Intent(this, AcercaDe.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.salir) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}