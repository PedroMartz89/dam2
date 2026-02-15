package com.pberna.aad.examenut3ut4.data.dao;

import com.pberna.aad.examenut3ut4.data.model.DetalleCompra;
public class DetalleCompraDao extends HibernateDao<DetalleCompra, Integer> {
    public DetalleCompraDao(Class<DetalleCompra> classT) {
        super(classT);
    }
}
