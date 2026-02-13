package com.pberna.aad.exameneva2.services;

import com.pberna.aad.exameneva2.data.HibernateUtil;
import com.pberna.aad.exameneva2.data.dao.DaoDirectores;
import com.pberna.aad.exameneva2.data.pojos.Directores;
import com.pberna.aad.exameneva2.data.pojos.RentabilidadDirector;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceDirectores {
    DaoDirectores daoDirectores = new DaoDirectores(Directores.class);

    public void delete(int idDirector) {
        Directores director = daoDirectores.read(idDirector);

        if (director == null) {
            System.out.println("No existe el director.");
            return;
        }

        if (!director.getPeliculasDirigidas().isEmpty()) {
            System.out.println("No se puede eliminar al director, " +
                    "tiene peliculas dirigidas.");

            return;
        }

        daoDirectores.delete(idDirector);
    }

    public List<RentabilidadDirector> getRentabilidadDirector() {

        Session session = HibernateUtil.getSession();

        Query<RentabilidadDirector> query = session.createNamedQuery("rentabilidadDirector", RentabilidadDirector.class);

        return query.getResultList();
    }
}
