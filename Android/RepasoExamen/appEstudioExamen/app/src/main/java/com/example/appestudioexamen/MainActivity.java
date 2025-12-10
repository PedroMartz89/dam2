package com.example.appestudioexamen;

import android.Manifest;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnTelf = findViewById(R.id.buttonTelf);
        Button btnCorreo = findViewById(R.id.buttonCorreo);
        Button btnURL = findViewById(R.id.buttonURL);

        btnTelf.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:666666666"));
            startActivity(i);
        });


        btnCorreo.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_SEND);
            String email = "mailto:pedro@gmail.com";
            Intent intent3 = new Intent(Intent.ACTION_SEND);
            intent3.setType("text/plain");
            intent3.putExtra(Intent.EXTRA_EMAIL, email);
            intent3.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo");
            intent3.putExtra(Intent.EXTRA_TEXT, "Contenido del correo");
            startActivity(intent3);
        });

        btnURL.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(i);
        });

        Button btnNotificar = findViewById(R.id.btnNotificar);
        btnNotificar.setOnClickListener(v -> {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence nombre = "Canal de notificaciones";
                String description = "Notificación de has pulsado el botón";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;

                NotificationChannel channel = new NotificationChannel("canal1", nombre, importance);
                channel.setDescription(description);

                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(channel);
                }

                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "canal1")
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Notificación de prueba")
                        .setContentText("Has pulsado el botón")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);


                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 0);
                    return;
                }
                NotificationManagerCompat.from(this).notify(0, builder.build());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (item.getItemId() == R.id.config) {
            Intent i = new Intent(this, MainActivity2.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.acercaDe) {
            Intent i = new Intent(this, MainActivity3.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.salir) {
            System.exit(0);
        }
        return super.onContextItemSelected(item);
    }

}