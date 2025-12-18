package com.example.appadapterciudades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositorioCiudades {
    private static RepositorioCiudades repository = new RepositorioCiudades();
    private HashMap<String, Ciudad> ciudades = new HashMap<>();

    public static RepositorioCiudades getInstance() {
        return repository;
    }

    private RepositorioCiudades() {
        saveLead(new Ciudad("Murcia", "España", "Español"));
        saveLead(new Ciudad("Madrid", "España", "Español"));
        saveLead(new Ciudad("Paris", "Francia", "Francés"));
        saveLead(new Ciudad("Roma", "Italia", "Italiano"));
        saveLead(new Ciudad("Londres", "Reino Unido", "Inglés"));

    }

    private void saveLead(Ciudad lib) {
        ciudades.put(lib.getNombre(), lib);
    }

    public List<Ciudad> getLeads() {
        return new ArrayList<>(ciudades.values());
    }

}
