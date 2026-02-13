package model.dao;

import Hibernate.HibernateDao;
import model.pojos.House;

public class HouseDao extends HibernateDao<House, Integer> {
    public HouseDao(Class<House> entityClass) {
        super(entityClass);
    }
}
