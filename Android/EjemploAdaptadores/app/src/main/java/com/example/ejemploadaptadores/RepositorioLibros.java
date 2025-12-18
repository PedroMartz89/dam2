package com.example.ejemploadaptadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositorioLibros {
    private static RepositorioLibros repository = new RepositorioLibros();
    private HashMap<String, Libro> mylibro = new HashMap<>();

    public static RepositorioLibros getInstance() {
        return repository;
    }

    private RepositorioLibros() {
        saveLead(new Libro("Las Mil y una noches", "Anónimo", "Novela", R.drawable.mil_noches));
        saveLead(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "Novela", R.drawable.quijote));
        saveLead(new Libro("Orgullo y prejuicio", "Jane Austin", "Novela", R.drawable.orgullo_prejuicio));
        saveLead(new Libro("Moby Dick", "Herman Melville", "Infantil", R.drawable.moby_dick));
        saveLead(new Libro("Los tres cerditos", "Angelika Scudamore", "Infantil", R.drawable.tres_cerditos));
    }

    private void saveLead(Libro lib) {
        mylibro.put(lib.getLibro_id(), lib);
    }

    public List<Libro> getLeads() {
        return new ArrayList<>(mylibro.values());
    }

}
