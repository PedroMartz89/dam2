package services;

import Hibernate.HibernateUtil;
import model.dao.HousePointDao;
import model.pojos.HousePoints;
import model.pojos.Person;
import model.pojos.PuntosCasa;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceHousePoints {
    HousePointDao housePointDao = new HousePointDao(HousePoints.class);

    public List<Person> findReceiverOf(String apellido) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            Query<Person> query = session.createNamedQuery("findReceiverOfByLastname", Person.class);
            query.setParameter("apellido", apellido);

            return query.getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> findMorePoints() {
         try (Session session = HibernateUtil.getSessionFactory().openSession()){

            Query<Person> query = session.createNamedQuery("findMorePointsPerson", Person.class);
            return query.getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PuntosCasa> getPuntosCasas() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            Query<PuntosCasa> query = session.createNamedQuery("getHousesTotalPoints", PuntosCasa.class);
            return query.getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
