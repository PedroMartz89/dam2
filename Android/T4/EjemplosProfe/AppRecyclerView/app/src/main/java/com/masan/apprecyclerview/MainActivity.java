package com.masan.apprecyclerview;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity  implements CustomAdapter.ListItemClick {

    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;

    private static final String[] mDataSet = {
            "El Principito", "Harry Potter y la piedra filosofal", "Matilda"
            , "Charlie y la fábrica de chocolate", "Donde viven los monstruos"
            , "Alicia en el País de las Maravillas", "Pippi Calzaslargas"
            , "La telaraña de Carlota", "El viento en los sauces", "El mago de Oz"
            , "Peter Pan", "Cuentos de la abuela Amelia", "La pequeña oruga glotona"
            , "Las aventuras de Tom Sawyer", "La casa en Mango Street", "El jardín secreto"
            , "Los tres cerditos", "Caperucita Roja", "La liebre y la tortuga"
            , "Los viajes de Gulliver", "El león, la bruja y el armario"
            , "El soldadito de plomo", "La isla del tesoro", "El diario de Greg"
            , "La máquina del tiempo", "Momo", "El pequeño Nicolás", "La brújula dorada"
            , "Los libros de la selva", "La historia interminable", "El bosque de los árboles muertos"
            , "Coraline", "La princesa y el guisante", "El fantasma de Canterville", "El mago de la luna"
            , "Winnie the Pooh", "Holes", "La tierra de las sombras", "El castillo ambulante"
            , "El gran gigante bonachón", "La señora Frisby y las ratas de NIMH"
            , "El viento entre los sauce", "La casa de los espíritus", "El secreto del espejo"
            , "El príncipe feliz", "La última bruja", "Fantasía", "Las crónicas de Narnia"
            , "Bajo el león de San Marcos", "El jardín de las hadas"
            , "La familia Robinson", "El pequeño príncipe", "La llamada de lo salvaje" };

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

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //También podemos definir desde aquí el layoutManager a utilizar, que aquí indicamos un LinearLayoutManager
        /*
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        */

        //Vinculamos el adaptador
        //mAdapter = new CustomAdapter(mDataSet);
        mAdapter = new CustomAdapter(mDataSet,this);
        recyclerView.setAdapter(mAdapter);


    }

    @Override
    public void onListItemClick(int itemSel) {
        //La interfaz es la que le está pasando la posición del elemento sobre el que se hizo clic, que es itemSel

        String texto = "Elemento seleccionado: " + mDataSet[itemSel];
         //Aquí queremos mostrar el elemento en un Toast
        Toast mToast = Toast.makeText(this, texto, Toast.LENGTH_SHORT);
        mToast.show();

    }
}