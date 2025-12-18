package com.example.appadapterciudades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CiudadAdapter extends ArrayAdapter<Ciudad> {
   //Constructor del adapter
    public CiudadAdapter(Context context, List<Ciudad> ciudades) {
        super(context, 0, ciudades);
    }

    //Obtener la vista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Existe?
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_layout_ciudades, parent, false);

        }
        //Referenciar UI
        ImageView imagen = convertView.findViewById(R.id.imagen);
        TextView lblNombre = convertView.findViewById(R.id.lblNombre);
        TextView lblPais = convertView.findViewById(R.id.lblPais);
        TextView lblIdioma = convertView.findViewById(R.id.lblIdioma);

        imagen.setImageResource(R.drawable.ic_launcher_foreground);
        //Ciudad actual
        Ciudad ciudad = getItem(position);
        lblNombre.setText(ciudad.getNombre());
        lblPais.setText(ciudad.getPais());
        lblIdioma.setText(ciudad.getIdioma());

        return convertView;
    }
}
