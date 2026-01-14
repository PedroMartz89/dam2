package com.masan.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.time.Instant;
import java.util.List;

public class LibroAdapter extends ArrayAdapter<Libro> {

    //Luego crea un constructor que reciba el contexto y la lista Libro. Llama al constructor padre que usamos anteriormente con super()
    // y agrega los dos parámetros entrantes. Debido a que el segundo parámetro es el layout pasa 0, ya que usaremos uno propio.
    public LibroAdapter(@NonNull Context context, List<Libro> objects) {
        super(context, 0, objects);
    }

    //El método getView() es el que infla los ítems y liga los datos de los objetos Lead, así que el objetivo es sobrescribir este método.


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.list_item_libro,
                    parent,
                    false);
        }

        // Referencias UI.
        ImageView avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
        TextView name = (TextView) convertView.findViewById(R.id.libTitulo);
        TextView title = (TextView) convertView.findViewById(R.id.libAutor);
        TextView company = (TextView) convertView.findViewById(R.id.libCategoria);

        // Libro actual.
        Libro libro = getItem(position);

        // Setup.

        //Glide.with(getContext()).load(libro.getLibroImagen()).into(avatar);
        name.setText(libro.getLibroTitulo());
        title.setText(libro.getLibroAutor());
        company.setText(libro.getLibroCategoria());

        return convertView;
    }


}
