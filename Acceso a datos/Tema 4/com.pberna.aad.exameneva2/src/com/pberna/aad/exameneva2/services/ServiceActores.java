package com.pberna.aad.exameneva2.services;

import com.pberna.aad.exameneva2.data.HibernateUtil;
import com.pberna.aad.exameneva2.data.pojos.Actor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceActores {
    // Implementa el metodo getActoresPelicula(Integer idPelicula) en la clase ServiceActores
    // que devuelve una lista de objetos de la clase Actores que es la lista de actores que han
    // participado en la película con id pasado como parámetro. Para hacer la consulta necesaria usa una NamedQuery.

    public List<Actor> getActoresPelicula(int idPelicula) {
        try (Session session = HibernateUtil.getSession()){

            Query<Actor> query = session.createNamedQuery("PeliculaActor.findActorPelicula", Actor.class);
            query.setParameter("idPelicula", idPelicula);

            List<Actor> actores = query.getResultList();
            session.close();

            return actores;

        }
    }
}
