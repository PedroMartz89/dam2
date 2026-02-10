package model.dao;

import Hibernate.HibernateDao;
import model.pojos.Person;

public class PersonDao extends HibernateDao<Person, Integer> {
    public PersonDao(Class<Person> entityClass) {
        super(entityClass);
    }
}
