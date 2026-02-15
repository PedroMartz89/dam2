package com.pberna.aad.examenut3ut4.services;

import com.pberna.aad.examenut3ut4.data.HibernateUtil;
import com.pberna.aad.examenut3ut4.data.dao.CompraDao;
import com.pberna.aad.examenut3ut4.data.model.Compra;
import com.pberna.aad.examenut3ut4.data.model.DetalleCompra;
import com.pberna.aad.examenut3ut4.data.model.Producto;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CompraService {
    CompraDao compraDao = new CompraDao(Compra.class);

    public List<DetalleCompra> getDetallesCompra(int idCompra) {
        Compra compra = compraDao.read(idCompra);
        if (compra == null) {
            System.out.println("Compra no existe.");
            return new ArrayList<>();
        }
        Session session = HibernateUtil.getSession();
        Query<DetalleCompra> query = session.createNamedQuery("getDetalleCompraIdCompra", DetalleCompra.class);

        query.setParameter("idCompra", idCompra);

        return query.getResultList();
    }
}
