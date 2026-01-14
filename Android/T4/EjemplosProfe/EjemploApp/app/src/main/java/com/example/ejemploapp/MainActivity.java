package com.example.ejemploapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase appDatabase;

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

        //Instanciar BBDD
        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "dbPruebas"
        ).allowMainThreadQueries().build();

        //insertarElementos();

        Button boton = findViewById(R.id.botonMostrar);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CASOS DE USO

                //mostrarUsuarios();
                //modificarUsuario("masanchez","Antonia Saez", "asaez@pruebas.es");
                suprimirUsuario("masanchez");
            }
        });

        Button boton2 = findViewById(R.id.botonInsertar);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarUsuario();
            }
        });

    }

    private void insertarElementos() {

        //Vamos a incluir datos ficticios para probar las consultas
        appDatabase.daoUsuario().insertarUsuario(new Usuario("masanchez", "Maria Angeles Sánchez", "masanchez@prueba.com"));
        appDatabase.daoUsuario().insertarUsuario(new Usuario("iandreu", "Inés Andreu", "iandreu@prueba.com"));
        appDatabase.daoUsuario().insertarUsuario(new Usuario("jcarrillo", "Juan Carrillo", "jcarrillo@prueba.com"));

    }

    public void mostrarUsuarios() {
        // Muestra todos los usuarios de la tabla Usuario

        //Creamos una lista de usuarios
        List<Usuario> listaUsuarios;
        //Llamamos al metodo obtenerUsuarios() del DAO
        listaUsuarios = appDatabase.daoUsuario().obtenerUsuarios();
        String texto = "";
        for (int i = 0; i < listaUsuarios.size(); i++) {
            texto = texto + "\nUsuario: " + i + " = " + listaUsuarios.get(i).usuario + ", " + listaUsuarios.get(i).nombre + ", " + listaUsuarios.get(i).correo;
        }

        //Mostramos los elementos recuperados de la base de datos, en el TextView
        TextView vistaUsuarios=findViewById(R.id.usuarios);
        vistaUsuarios.setText(texto);

    }

    public void modificarUsuario(String codUsuario, String nuevoNombre, String nuevoCorreo){

        Usuario usuario1=appDatabase.daoUsuario().obtenerUsuario(codUsuario);
        usuario1.nombre=nuevoNombre;
        usuario1.correo=nuevoCorreo;
        appDatabase.daoUsuario().actualizarUsuario(usuario1);

        mostrarUsuarios();

    }

    public void suprimirUsuario(String codUsuario){
        Usuario usuario1=appDatabase.daoUsuario().obtenerUsuario(codUsuario);
        appDatabase.daoUsuario().borrarUsuario(usuario1);
        // Para comprobarlo, mostramos la información de todos los usuarios
        mostrarUsuarios();
    }


    public void insertarUsuario(){

        EditText vCodigo=findViewById(R.id.editTextCodigo);
        EditText vNombre=findViewById(R.id.editTextNombre);
        EditText vCorreo=findViewById(R.id.editTextCorreo);

        Usuario usuario1=new Usuario(vCodigo.getText().toString(),vNombre.getText().toString(),vCorreo.getText().toString());
        appDatabase.daoUsuario().insertarUsuario(usuario1);

        //Mostrar los usuarios:
        mostrarUsuarios();


    }

}