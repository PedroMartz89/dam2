package com.pberna.aad.exameneva2.data.dao;

import com.pberna.aad.exameneva2.data.pojos.Director;

public class DirectoresDao extends HibernateDao<Director, Integer> {
    public DirectoresDao(Class<Director> classT) {
        super(classT);
    }
}
