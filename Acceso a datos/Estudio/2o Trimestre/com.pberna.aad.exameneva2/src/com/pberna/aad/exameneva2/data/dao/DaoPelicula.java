package com.pberna.aad.exameneva2.data.dao;

import com.pberna.aad.exameneva2.data.pojos.Peliculas;

public class DaoPelicula extends HibernateDao<Peliculas, Integer> {
    public DaoPelicula(Class<Peliculas> classT) {
        super(classT);
    }
}
