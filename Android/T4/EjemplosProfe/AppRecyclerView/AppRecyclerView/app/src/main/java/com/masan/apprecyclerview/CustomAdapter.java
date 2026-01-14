package com.masan.apprecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private String[] localDataSet;

    private static ListItemClick myOnClickListener;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
/*
     public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }
*/

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView);

            view.setOnClickListener(this);
        }

        public TextView getTextView() {
            return textView;
        }

        @Override
        public void onClick(View v) {
            //Obtenemos el elemento clicado
            int itemClick=getAdapterPosition();
            //Le pasamos el elemento seleccionado
            myOnClickListener.onListItemClick(itemClick);
        }
    }


    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
/*
    public CustomAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }
*/
    public CustomAdapter(String[] dataSet, ListItemClick listener) {
        localDataSet = dataSet;
        //Inicializamos con el listener del constructor
        myOnClickListener=listener;

    }


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(localDataSet[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }

    //Para poder implementar el evento onClic sobre cada elemento, utilizamos una interfaz
    public interface ListItemClick{
        //Definimos un metodo que recibe como parámetro el elemento que se ha seleccionado
        void onListItemClick(int itemSel);

    }


}