package com.pberna.aad.examenut3ut4.services;

import com.pberna.aad.examenut3ut4.data.HibernateUtil;
import com.pberna.aad.examenut3ut4.data.model.EstadisticasValoraciones;
import com.pberna.aad.examenut3ut4.data.model.Producto;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ValoracionService {

    public List<EstadisticasValoraciones> getEstadisticasValoraciones() {
        Session session = HibernateUtil.getSession();
        Query<EstadisticasValoraciones> query = session.createNamedQuery("getEstadisticasValoraciones", EstadisticasValoraciones.class);

        return query.getResultList();
    }

}
