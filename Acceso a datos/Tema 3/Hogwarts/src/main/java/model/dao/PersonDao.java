package model.dao;

import Hibernate.HibernateDao;
import Hibernate.HibernateUtil;
import model.House;
import model.Person;
import org.hibernate.Session;

import java.util.List;

public class PersonDao extends HibernateDao<Person> {
    public PersonDao() {
        super(Person.class);
    }

    public List<Person> findAllByHouse(int houseId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Person where house.id = :id", Person.class)
                    .setParameter("id", houseId)
                    .getResultList();
        }
    }

}
