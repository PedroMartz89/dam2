package com.example.ejemploadaptadores;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String[] urls = {"https://mail.google.com/", "https://notebooklm.google.com/", "https://github.com/", "https://gemini.google.com/", "https://www.youtube.com/", "https://www.google.com/"};

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

        ListView lista = findViewById(R.id.lvLista);
        ArrayAdapter<String> my_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, urls);
        
        lista.setAdapter(my_adapter);

        TextView textoTitulo = new TextView(this);
        textoTitulo.setText("URLs de sitios web");
        lista.addHeaderView(textoTitulo);
        /*Position -> Objeto seleccionado
        * Id -> Id del elemento seleccionado en el array
        * */
        lista.setOnItemClickListener((parent, view, position, id) -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(urls[position-1]));
            startActivity(i);

        });

    }
}