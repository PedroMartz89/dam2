package com.pberna.aad.exameneva2.data.dao;

import com.pberna.aad.exameneva2.data.pojos.Genero;

public class GeneroDao extends HibernateDao<Genero, Integer> {
    public GeneroDao(Class<Genero> classT) {
        super(classT);
    }
}
