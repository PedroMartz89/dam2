package com.example.appexament3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnCorreo = findViewById(R.id.buttonCorreo);
        btnCorreo.setOnClickListener(v -> mandarCorreo());
        Button btnTelefono = findViewById(R.id.btnTelefono);
        btnTelefono.setOnClickListener(v -> realizarLlamada());

    }

    public void realizarLlamada() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:666666666"));
        startActivity(intent);


    }

    public void mandarCorreo() {
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:examenAndroid@T3.com"));
        i.putExtra(Intent.EXTRA_SUBJECT, "Asunto");
        i.putExtra(Intent.EXTRA_TEXT, "Mensaje");
        startActivity(i);

    }
}