package com.pberna.aad.exameneva2.data.dao;

import com.pberna.aad.exameneva2.data.pojos.PeliculaActor;

public class DaoPeliculaActor extends HibernateDao<PeliculaActor, Integer> {
    public DaoPeliculaActor(Class<PeliculaActor> classT) {
        super(classT);
    }
}
