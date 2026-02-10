package services;

import Hibernate.HibernateUtil;
import model.dao.PersonDao;
import model.pojos.House;
import model.pojos.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ServicePerson {
    PersonDao personDao = new PersonDao(Person.class);

    public void delete(int idPerson) {
        Person person = personDao.read(idPerson);

        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            Query<Long> query = session.createNamedQuery("personIsGiver", Long.class);
            query.setParameter("idGiver", idPerson);
            Query<Long> query2 = session.createNamedQuery("personIsReceiver", Long.class);
            query.setParameter("idReceiver", idPerson);

            Long result1 = query.uniqueResult();
            Long result2 = query2.uniqueResult();

            if (result1 > 0 || result2 > 0) {
                System.out.println("No se puede eliminar a la persona, es un giver o receiver de una casa.");
                return;
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

        personDao.delete(person);
    }

    public House getHouse(Integer idPerson) {
        Person person = personDao.read(idPerson);

        return person == null ? null : person.getHouse();
    }

    public List<Person> findAllPersonInHouse(Integer idHouse) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Person> query = session.createNamedQuery("findAllPersonInHouse", Person.class);
            query.setParameter("idHouse", idHouse);

            return query.getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
