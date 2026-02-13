package com.pberna.aad.exameneva2.data.dao;

import com.pberna.aad.exameneva2.data.pojos.Actor;

public class ActorDao extends HibernateDao<Actor, Integer> {
    public ActorDao(Class<Actor> classT) {
        super(classT);
    }
}
