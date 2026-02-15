package com.pberna.aad.examenut3ut4.data.dao;

import com.pberna.aad.examenut3ut4.data.model.Compra;

public class CompraDao extends HibernateDao<Compra, Integer> {
    public CompraDao(Class<Compra> classT) {
        super(classT);
    }
}
