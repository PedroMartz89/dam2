package com.pberna.aad.examenut3ut4.data.dao;

import com.pberna.aad.examenut3ut4.data.model.Valoracion;

public class ValoracionDao extends HibernateDao<Valoracion, Integer> {
    public ValoracionDao(Class<Valoracion> classT) {
        super(classT);
    }
}
