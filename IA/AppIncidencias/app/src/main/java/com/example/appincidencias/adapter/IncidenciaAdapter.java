package com.example.appincidencias.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appincidencias.R;
import com.example.appincidencias.model.Incidencia;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import java.util.List;

public class IncidenciaAdapter extends RecyclerView.Adapter<IncidenciaAdapter.IncidenciaViewHolder> {

    private List<Incidencia> listaIncidencias;
    private OnIncidenciaClickListener listener;

    public interface OnIncidenciaClickListener {
        void onResolverClick(Incidencia incidencia);
    }

    public IncidenciaAdapter(List<Incidencia> listaIncidencias, OnIncidenciaClickListener listener) {
        this.listaIncidencias = listaIncidencias;
        this.listener = listener;
    }

    public IncidenciaAdapter(List<Incidencia> listaIncidencias) {
        this.listaIncidencias = listaIncidencias;
    }

    public void updateList(List<Incidencia> nuevaLista) {
        this.listaIncidencias = nuevaLista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public IncidenciaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.incidencia_item, parent, false);
        return new IncidenciaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IncidenciaViewHolder holder, int position) {
        Incidencia incidencia = listaIncidencias.get(position);

        holder.tvUbicacion.setText(incidencia.ubicacion);
        holder.tvTipo.setText(incidencia.tipoDispositivo + " - " + incidencia.identificacion);
        holder.tvDescripcion.setText(incidencia.descripcion);
        holder.chipEstado.setText(incidencia.estado);

        // Lógica de colores según prioridad
        int color;
        if (incidencia.prioridad != null) {
            switch (incidencia.prioridad.toLowerCase()) {
                case "alta":
                    color = Color.parseColor("#E57373"); // Rojo Material
                    break;
                case "media":
                    color = Color.parseColor("#FFB74D"); // Naranja Material
                    break;
                default:
                    color = Color.parseColor("#81C784"); // Verde Material
                    break;
            }
        } else {
            color = Color.GRAY;
        }

        holder.viewPrioridad.setBackgroundColor(color);

        // Mostrar/ocultar botón de resolver
        if ("Resuelta".equalsIgnoreCase(incidencia.estado)) {
            holder.btnResolver.setVisibility(View.GONE);
            holder.chipEstado.setChipBackgroundColorResource(android.R.color.darker_gray);
        } else {
            holder.btnResolver.setVisibility(View.VISIBLE);
            holder.btnResolver.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onResolverClick(incidencia);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaIncidencias.size();
    }

    static class IncidenciaViewHolder extends RecyclerView.ViewHolder {
        TextView tvUbicacion, tvTipo, tvDescripcion;
        Chip chipEstado;
        View viewPrioridad;
        MaterialButton btnResolver;

        public IncidenciaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUbicacion = itemView.findViewById(R.id.tvUbicacion);
            tvTipo = itemView.findViewById(R.id.tvTipo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            chipEstado = itemView.findViewById(R.id.chipEstado);
            viewPrioridad = itemView.findViewById(R.id.viewPrioridad);
            btnResolver = itemView.findViewById(R.id.btnResolver);
        }
    }

}
