package com.pberna.aad.examenut3ut4.services;

import com.pberna.aad.examenut3ut4.data.HibernateUtil;
import com.pberna.aad.examenut3ut4.data.dao.ProductoDao;
import com.pberna.aad.examenut3ut4.data.model.Producto;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductoService {
    ProductoDao productoDao = new ProductoDao(Producto.class);
    public void delete(Integer idProducto) {
        Producto producto = productoDao.read(idProducto);

        Session session = HibernateUtil.getSession();
        Query<Producto> productoQuery = session.createNamedQuery("getProductosInDetalle", Producto.class);

        productoQuery.setParameter("idProducto", idProducto);

        List<Producto> productoList = productoQuery.getResultList();

        if (!productoList.isEmpty()) {
            System.out.println("No es posible borrar el producto, hay un detalle con el.");
            return;
        }

        productoDao.delete(idProducto);
    }
}
