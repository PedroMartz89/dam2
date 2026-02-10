package com.pberna.aad.exameneva2.services;

import com.pberna.aad.exameneva2.data.HibernateUtil;
import com.pberna.aad.exameneva2.data.pojos.Pelicula;
import com.pberna.aad.exameneva2.data.pojos.PeliculaActor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.util.List;

public class ServicePeliculas {
    // Implementa el metodo getPeliculasGenero(Integer idGenero) en la clase ServicePeliculas que devuelve una lista de objetos
    //  de la clase Peliculas que son la lista de películas del género con id pasado como parámetro.

    public List<Pelicula> getPeliculasGenero(int idGenero) {
        String hql = "FROM Pelicula p WHERE p.genero = :idGenero";

        try (Session session = HibernateUtil.getSession()){
            Query<Pelicula> query = session.createQuery(hql, Pelicula.class);
            query.setParameter("idGenero", idGenero);

            List<Pelicula> peliculaList = query.getResultList();

            session.close();
            return peliculaList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
