package model.dao;

import Hibernate.HibernateDao;
import model.pojos.HousePoints;

public class HousePointDao extends HibernateDao<HousePoints, Integer> {
    public HousePointDao(Class<HousePoints> entityClass) {
        super(entityClass);
    }
}
