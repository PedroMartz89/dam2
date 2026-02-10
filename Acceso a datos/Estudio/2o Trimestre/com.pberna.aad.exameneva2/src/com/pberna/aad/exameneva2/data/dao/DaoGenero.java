package com.pberna.aad.exameneva2.data.dao;

import com.pberna.aad.exameneva2.data.pojos.Genero;

public class DaoGenero extends HibernateDao<Genero, Integer> {
    public DaoGenero(Class<Genero> classT) {
        super(classT);
    }
}
