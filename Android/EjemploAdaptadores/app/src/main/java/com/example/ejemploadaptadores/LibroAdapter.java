package com.example.ejemploadaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class LibroAdapter extends ArrayAdapter<Libro> {
    public LibroAdapter(@NonNull Context context, @NonNull List<Libro> objects) {
        super(context, 0, objects);
    }

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
        ImageView avatar = (ImageView) convertView.findViewById(R.id.imagen);
        TextView name = (TextView) convertView.findViewById(R.id.lblTitulo);
        TextView title = (TextView) convertView.findViewById(R.id.lblAutor);
        TextView company = (TextView) convertView.findViewById(R.id.lblCategoria);

        // Libro actual.
        Libro libro = getItem(position);

        // Setup.

        //Glide.with(getContext()).load(libro.getLibroImagen()).into(avatar);
        name.setText(libro.getTitulo());
        title.setText(libro.getAutor());
        company.setText(libro.getCategoria());

        return convertView;
    }
}

