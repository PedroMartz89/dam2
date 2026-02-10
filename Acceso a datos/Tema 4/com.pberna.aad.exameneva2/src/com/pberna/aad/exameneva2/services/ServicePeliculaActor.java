package com.pberna.aad.exameneva2.services;

import com.pberna.aad.exameneva2.data.HibernateUtil;
import com.pberna.aad.exameneva2.data.pojos.PeliculaActor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ServicePeliculaActor {
    // Implementa el metodo getPapelesActor(Integer idActor) en la clase ServicePeliculaActor
    //  que devuelve una lista de objetos de tipo PeliculaActor asociadas con el idActor pasado como parámetro
    //  y ordenados de mayor a menor según salario. Para hacer la consulta necesaria puedes usar SQL o HQL, como prefieras.

    public List<PeliculaActor> getPapelesActor(int idActor) {
        String hql = "FROM PeliculaActor pa WHERE pa.actor.id = :idActor order by pa.salario desc";

        try (Session session = HibernateUtil.getSession()){

            Query<PeliculaActor> query = session.createQuery(hql, PeliculaActor.class);
            query.setParameter("idActor", idActor);
            List<PeliculaActor> peliculaActores = query.getResultList();

            session.close();
            return peliculaActores;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
