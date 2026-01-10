package services;

import model.House;
import model.Person;
import model.dao.HousePointsDao;
import model.dao.PersonDao;

import java.util.List;

public class PersonService {
    private PersonDao daoPerson = new PersonDao();
    private HousePointsDao daoHousePoints = new HousePointsDao();

    //3.2
    public void delete(int personId) {
        Person person = daoPerson.read(personId);

        if (person != null) {

            boolean esGiver = daoHousePoints.existsAsGiver(personId);
            boolean esReceiver = daoHousePoints.existsAsReceiver(personId);

            if (esGiver || esReceiver) {
                System.out.println("No se puede borrar la persona " + person.getFirstName() + " porque está involucrada en registros de puntos de casa.");
            } else {
                Person p = daoPerson.read(personId);
                if (p != null) {
                    daoPerson.delete(p);
                    System.out.println("Persona borrada correctamente.");
                }
            }
        } else {
            System.out.println("No se encontró ninguna persona con el ID: " + personId);
        }
    }

    //4.2
    public House getHouse(int personId) {
        Person person = daoPerson.read(personId);

        if (person != null) {
            return person.getHouse();
        } else {
            return null;
        }
    }

    //5
    public List<Person> findAllPersonInHouse(int idHouse) {
        return daoPerson.findAllByHouse(idHouse);
    }
}
