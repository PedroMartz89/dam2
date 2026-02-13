package com.pberna.aad.exameneva2.data.dao;

import com.pberna.aad.exameneva2.data.pojos.Actores;

public class DaoActores extends HibernateDao<Actores, Integer> {
    public DaoActores(Class<Actores> classT) {
        super(classT);
    }
}
