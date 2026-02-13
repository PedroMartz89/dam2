package com.pberna.aad.exameneva2.data.dao;

import com.pberna.aad.exameneva2.data.pojos.Directores;

public class DaoDirectores extends HibernateDao<Directores, Integer> {
    public DaoDirectores(Class<Directores> classT) {
        super(classT);
    }

}
