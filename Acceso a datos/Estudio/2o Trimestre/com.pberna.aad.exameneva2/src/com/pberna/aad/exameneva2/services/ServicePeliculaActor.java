package com.pberna.aad.exameneva2.services;

import com.pberna.aad.exameneva2.data.HibernateUtil;
import com.pberna.aad.exameneva2.data.dao.DaoPeliculaActor;
import com.pberna.aad.exameneva2.data.pojos.PeliculaActor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ServicePeliculaActor {
    DaoPeliculaActor daoPeliculaActor = new DaoPeliculaActor(PeliculaActor.class);

    public List<PeliculaActor> getPapelesActor(Integer idActor) {
        Session session = HibernateUtil.getSession();

        Query<PeliculaActor> query = session.createNamedQuery("papelesActor", PeliculaActor.class);
        query.setParameter("idActor", idActor);

        return query.getResultList();
    }
}
