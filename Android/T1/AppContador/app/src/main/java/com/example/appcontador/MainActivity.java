package com.example.appcontador;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contador = 0;
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button1 = findViewById(R.id.boton1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementarContador(v);
            }
        });

        Button button2 = findViewById(R.id.boton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementarContador(v);
            }
        });

        Button button3 = findViewById(R.id.boton3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetearContador(v);
            }
        });
    }

    public void incrementarContador(View vista) {
        contador++;
        mostrarResultado();
    }

    public void decrementarContador(View vista) {
        contador--;
        mostrarResultado();
    }

    public void resetearContador(View vista) {
        contador = 0;
        mostrarResultado();
    }

    public void mostrarResultado() {

        TextView textoResultado = (TextView) findViewById(R.id.textoContador);
        textoResultado.setText("Contador: " + contador);

    }
}