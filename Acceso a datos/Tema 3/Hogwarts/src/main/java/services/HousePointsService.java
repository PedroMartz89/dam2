package services;

import model.HousePoints;
import model.Person;
import model.dao.HouseDao;
import model.dao.HousePointsDao;
import model.dao.PersonDao;

import java.util.ArrayList;
import java.util.List;

public class HousePointsService {
    PersonDao personDao = new PersonDao();
    HouseDao  houseDao = new HouseDao();
    HousePointsDao housePointsDao = new HousePointsDao();

    //4.3
    public List<Person> findReceiverOf(String name2) {
        List<HousePoints> housePoints = housePointsDao.findAll();
        List<Person> persons = new ArrayList<>();
        for (HousePoints hp : housePoints) {
            if (hp.getGiver().getLastName().equals(name2)) {
                persons.add(hp.getReceiver());
            }
        }

        System.out.println("Personas a las que " + name2 + " les ha dado puntos.");
        for (Person p : persons) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
        }
        return persons;
    }

    //4.4
    public List<Person> findMorePoints() {
        List<HousePoints> housePoints = housePointsDao.findAll();
        int max = 0;
        List<Person> persons = new ArrayList<>();

        for (HousePoints hp : housePoints) {
            if (hp.getPoints() > max ) {
                max = hp.getPoints();
                persons.clear();
                persons.add(hp.getReceiver());
            } else if (hp.getPoints() == max) {
                persons.add(hp.getReceiver());
            }
        }
        for (Person p : persons) {
            System.out.println(p.getFirstName() + " " + p.getLastName() + " con " + max + " puntos.");
        }
        return persons;
    }

    //6
    public List<Object[]> getPuntosCasas() {
        List<Object[]> resultados = housePointsDao.getPuntosTotalesPorCasa();
        System.out.println();
        System.out.println("--- PUNTUACIÓN TOTAL POR CASA ---");
        for (Object[] fila : resultados) {
            String nombreCasa = (String) fila[0];
            Long totalPuntos = (Long) fila[1];
            System.out.println(nombreCasa + ": " + totalPuntos + " puntos.");
        }
        return resultados;
    }
}
