package com.pberna.aad.exameneva2.services;

import com.pberna.aad.exameneva2.data.HibernateUtil;
import com.pberna.aad.exameneva2.data.dao.DirectoresDao;
import com.pberna.aad.exameneva2.data.pojos.Director;
import com.pberna.aad.exameneva2.data.pojos.RentabilidadDirector;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceDirectores {

    DirectoresDao directoresDao = new DirectoresDao(Director.class);

    // Debes crear el metodo delete en ServiceDirectores para que,
    //  si se intenta borrar un director que ha dirigido alguna película, muestre un mensaje indicando que no es posible

    public String delete(Integer idDirector) {

        Director director = directoresDao.read(idDirector);

        if (director == null) {
            return "El director con ID " + idDirector + " no existe.";
        }

        if (director.getPeliculas() != null && !director.getPeliculas().isEmpty()) {
            return "No es posible eliminar al director: " + director.getNombre() +
                    " porque tiene películas registradas en CineDB.";
        }

        try {
            directoresDao.delete(idDirector);
            return "Director eliminado correctamente.";
        } catch (Exception e) {
            return "Error al intentar eliminar: " + e.getMessage();
        }
    }

    public List<RentabilidadDirector> getRentabilidadDirector() {

        try (Session session = HibernateUtil.getSession()){
           String hql = "SELECT new com.pberna.aad.exameneva2.data.pojos.RentabilidadDirector(" +
                     "d.id, " +
                     "d.nombre, " +
                     "SUM(p.recaudacion), " +
                     "AVG(p.recaudacion), " +
                     "AVG(p.recaudacion / p.presupuesto)) " +
                     "FROM Director d " +
                     "JOIN d.peliculas p " +
                     "JOIN p.director " +
                     "WHERE p.presupuesto > 0 " +
                     "GROUP BY d.id_director, d.nombre";

           Query<RentabilidadDirector> query = session.createQuery(hql, RentabilidadDirector.class);
           List<RentabilidadDirector> rentabilidadDirectores = query.getResultList();

           session.close();
           return rentabilidadDirectores;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
