package model.dao;

import Hibernate.HibernateDao;
import Hibernate.HibernateUtil;
import model.House;
import org.hibernate.Session;

import java.util.List;

public class HouseDao extends HibernateDao<House> {
    public HouseDao() {
        super(House.class);
    }


}
