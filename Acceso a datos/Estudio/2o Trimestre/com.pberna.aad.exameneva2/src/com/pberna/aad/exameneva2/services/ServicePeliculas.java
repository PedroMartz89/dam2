package com.pberna.aad.exameneva2.services;

import com.pberna.aad.exameneva2.data.dao.DaoGenero;
import com.pberna.aad.exameneva2.data.dao.DaoPelicula;
import com.pberna.aad.exameneva2.data.pojos.Genero;
import com.pberna.aad.exameneva2.data.pojos.Peliculas;

import java.util.ArrayList;
import java.util.List;

public class ServicePeliculas {
    DaoPelicula daoPelicula = new DaoPelicula(Peliculas.class);
    DaoGenero daoGenero = new DaoGenero(Genero.class);

    public List<Peliculas> getPeliculasGenero(Integer idGenero) {

        Genero genero = daoGenero.read(idGenero);

        if (genero == null) {
            return new ArrayList<Peliculas>();
        }

        return genero.getPeliculas();
    }

}
