package services;

import model.House;
import model.Person;
import model.dao.HouseDao;
import model.dao.PersonDao;

import java.util.List;

public class HouseService {
    private HouseDao daoHouse = new HouseDao();
    private PersonDao daoPerson = new PersonDao();

    //3.1
    public void delete(int houseId) {
        House house = daoHouse.read(houseId);

        if (house != null) {

            // Verificar si hay personas en la casa
            List<Person> personasEnCasa = daoPerson.findAllByHouse(houseId);

            if (!personasEnCasa.isEmpty()) {
                System.out.println("No es posible borrar la casa" + house.getName() + " porque tiene "
                        + personasEnCasa.size() + " personas en ella.");
            } else {
                daoHouse.delete(house);
                System.out.println("Casa borrada correctamente.");
            }
        }
    }

    //4.1
    public Person getHeadTeacher(int idHouse) {

        House house = daoHouse.read(idHouse);

        if (house != null) {
            return house.getHeadTeacher();
        } else {
            return null;
        }
    }
}
