package com.example.appexament3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonSalir = findViewById(R.id.buttonSalir);
        buttonSalir.setOnClickListener(v -> finish());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_monumentos) {
            return true;
        } else if (id == R.id.menu_contacto) {
            Intent i = new Intent(this, ActivityContacto.class);
            startActivity(i);
            return true;
        } else if (id == R.id.menu_ayuda) {
            Intent i = new Intent(this, ActivityAyuda.class);
            startActivity(i);
            return true;
        } else if (id == R.id.submenu_edificios) {
            Intent i = new Intent(this, ActivityEdificios.class);
            startActivity(i);
            return true;
        } else if (id == R.id.submenu_plazas) {
            Intent i = new Intent(this, ActivityPlazas.class);
            startActivity(i);
            return true;
        }

        return super.onContextItemSelected(item);
    }

}