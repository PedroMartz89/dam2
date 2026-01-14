package com.masan.adaptadores;

import static android.app.PendingIntent.getActivity;

import android.os.Bundle;
//Importamos las librerías necesarias para utilizar el tipo de Adapter y la ListView
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

//Si declaramos los valores como un ArrayList:


public class MainActivity extends AppCompatActivity {

    ListView mLeadsList;
    LibroAdapter mLeadsAdapter;

    Spinner mSpinner;
    Button mBoton;

    //Declaramos e inicializamos la lista con los elementos
    String[] libros={"Narrativa", "Poesía", "Ensayo", "Artístico","Texto","Técnico","Infantil"};

    //También se podría declarar así:
    //ArrayList<String> libros2=new ArrayList<String>(
    //        Arrays.asList("Narrativa", "Poesía", "Ensayo", "Artístico","Texto","Técnico","Infantil"));

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

        //miLibroList=(ListView)findViewById(R.id.li)
        mLeadsList = (ListView) findViewById(R.id.myList2);

        // Inicializar el adaptador con la fuente de datos.
        mLeadsAdapter = new LibroAdapter(this,LibroRepositorio.getInstance().getLeads());

        //Relacionando la lista con el adaptador
        mLeadsList.setAdapter(mLeadsAdapter);


        //Utilizamos un adaptador de tipo ArrayAdapter
        ArrayAdapter my_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,libros);
        //ArrayAdapter my_adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,libros);
        ListView lista = (ListView) findViewById(R.id.myList);
        lista.setAdapter(my_adapter);

        //Añadimos título a la lista
        TextView texto = new TextView(getApplicationContext());
        texto.setText("Temática de libros");
        lista.addHeaderView(texto);


        //Ponemos la lista a la escucha de la selección de un elemento
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //i --> Posición de la vista en el adaptador. Comienza en 1
                //l --> Fila del elemento que se ha seleccionado. Comienza en 0

                //Vamos a comprobar qué parámetros llegan
                Toast toast= Toast.makeText(MainActivity.this, "Valor de i: " + i,Toast.LENGTH_SHORT);
                //Toast toast= Toast.makeText(MainActivity.this, "Valor de l: " + l,Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();

                //String elemento=datosArray.get(i);
                //String elemento=libros[i-1].toString();
                //Obtenemos el texto del elemento por la posición i
                String elemento=adapterView.getItemAtPosition(i).toString();

                //Mostramos en un textView el elemento de la listView que se ha seleccionado:
                TextView texto=(TextView)findViewById(R.id.itemSel);
                //texto.setText(texto + " " + elemento);
                texto.setText("Elemento seleccionado: " + elemento);

            }
        });

        // Obtenemos el Spinner
        mSpinner = findViewById(R.id.spinner);
        // Botón que llenará el Spinner
        mBoton = findViewById(R.id.button);

        //Ponemos el botón a la escucha de su evento onClick
        mBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llenarSpinner();
            }
        });


        //Ponemos el Spinner a la escucha de la selección de un elemento
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //Equipo equipoSel= (Equipo)mSpinner.getSelectedItem();
                String elemento=adapterView.getItemAtPosition(i).toString();

                //Mostramos en un textView el elemento de la listView que se ha seleccionado:
                TextView texto=(TextView)findViewById(R.id.itemSel);
                //texto.setText(texto + " " + elemento);
                texto.setText("Elemento seleccionado: " + elemento);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void llenarSpinner(){

        //Vamos a cargar los equipos desde un ArrayList de objetos "Equipo"
        ArrayList<Equipo> equipos = new ArrayList<Equipo>();

        //Llenamos la lista de equipos ficticios
        equipos.add(new Equipo(1, "Primer Equipo", "Alevín","Femenino"));
        equipos.add(new Equipo(2, "Segundo Equipo", "Alevín","Masculino"));
        equipos.add(new Equipo(3, "Tercer Equipo", "Infantil","Femenino"));
        equipos.add(new Equipo(4, "Cuarto Equipo", "Infantil","Masculino"));

        //Enviamos los datos al Spinner a través de un adaptador:
        ArrayAdapter<Equipo> mAdapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,equipos);

        //Mandamos el adaptador al Spinner
        mSpinner.setAdapter(mAdapter);

        //Para añadir título/sugerencia a la lista:
        //mSpinner.setPrompt(getString(R.string.seleccion_equipo));

    }



}