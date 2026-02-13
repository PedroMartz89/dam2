package com.pberna.aad.exameneva2.data.dao;

import com.pberna.aad.exameneva2.data.pojos.PeliculaActor;

public class PeliculaActorDao extends HibernateDao<PeliculaActor, Integer> {
    public PeliculaActorDao(Class<PeliculaActor> classT) {
        super(classT);
    }
}
