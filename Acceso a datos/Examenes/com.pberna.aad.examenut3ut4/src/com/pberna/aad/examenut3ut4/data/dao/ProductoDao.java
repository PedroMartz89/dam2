package com.pberna.aad.examenut3ut4.data.dao;

import com.pberna.aad.examenut3ut4.data.model.Producto;

public class ProductoDao extends HibernateDao<Producto, Integer>{
    public ProductoDao(Class<Producto> classT) {
        super(classT);
    }
}
