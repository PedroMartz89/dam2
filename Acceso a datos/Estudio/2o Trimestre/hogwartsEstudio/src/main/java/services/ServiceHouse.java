package services;

import Hibernate.HibernateUtil;
import model.dao.HouseDao;
import model.dao.PersonDao;
import model.pojos.House;
import model.pojos.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceHouse {
    HouseDao houseDao = new HouseDao(House.class);
    PersonDao personDao = new PersonDao(Person.class);

    public void delete(int houseID) {

        House house = houseDao.read(houseID);
        if (house == null) {
            System.out.println("El ID de la casa no corresponde a ninguna casa.");
            return;
        }

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query<Person> query = session.createNamedQuery("findAllByHouse", Person.class);
        query.setParameter("houseId", houseID);

        List<Person> personList = query.getResultList();

        if (!personList.isEmpty()) {
            System.out.println("No se puede eliminar la casa, contiene estudiantes.");
        }

        houseDao.delete(house);
    }

    public Person getHeadTeacher(Integer idHouse) {

        House house = houseDao.read(idHouse);

        if (house == null ) {
            System.out.println("La casa no existe.");
            return null;
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Person> query = session.createNamedQuery("getHeadTeacher", Person.class);
            query.setParameter("idHouse", idHouse);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
