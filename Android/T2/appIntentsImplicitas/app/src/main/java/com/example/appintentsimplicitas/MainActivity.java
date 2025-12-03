package com.example.appintentsimplicitas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);



        Button btnWeb = findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(v -> {
                    String url = textView.getText().toString();
                    Uri webpage = Uri.parse(url);
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(intent);
        });


        Button btnTelf = findViewById(R.id.btnTelf);
        btnTelf.setOnClickListener(v -> {
                    String numero = "tel:" + textView2.getText().toString();
                    Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse(numero));
                    startActivity(intent2);

        });
        Button btnEmail = findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(v -> {
                    String email = "mailto:" + textView3.getText().toString();
                    Intent intent3 = new Intent(Intent.ACTION_SEND);
                    intent3.setType("text/plain");
                    intent3.putExtra(Intent.EXTRA_EMAIL, email);
                    intent3.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo");
                    intent3.putExtra(Intent.EXTRA_TEXT, "Contenido del correo");
                    startActivity(intent3);

        });

    }
}