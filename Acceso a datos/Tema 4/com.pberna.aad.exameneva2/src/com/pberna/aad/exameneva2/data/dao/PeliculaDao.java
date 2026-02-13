package com.pberna.aad.exameneva2.data.dao;

import com.pberna.aad.exameneva2.data.pojos.Pelicula;

public class PeliculaDao extends HibernateDao<Pelicula, Integer> {

    public PeliculaDao(Class classT) {
        super(classT);
    }
}
