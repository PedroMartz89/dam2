package com.pberna.aad.exameneva2.services;

import com.pberna.aad.exameneva2.data.HibernateUtil;
import com.pberna.aad.exameneva2.data.pojos.Actores;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceActores {

    public List<Actores> getActoresPelicula(Integer idPelicula) {

        Session session = HibernateUtil.getSession();

        Query<Actores> query = session.createNamedQuery("buscarActoresPelicula", Actores.class);
        query.setParameter("idPelicula", idPelicula);

        return query.getResultList();
    }
}
