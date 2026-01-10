import model.Person;
import services.HouseService;
import services.PersonService;
import services.HousePointsService;
import Hibernate.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("=== INICIANDO TEST DE HOGWARTS ===\n");

            // 1. Instanciar Servicios
            HouseService houseService = new HouseService();
            PersonService personService = new PersonService();
            HousePointsService pointsService = new HousePointsService();

            // 2. TEST: Obtener Director de una Casa
            System.out.println("1. Test getHeadTeacher:");
            Person director = houseService.getHeadTeacher(1); // Gryffindor suele ser ID 1
            if (director != null) {
                System.out.println("El director de Gryffindor es: " + director.getFirstName() + " " + director.getLastName());
            }
            System.out.println("----------------------------------\n");

            // 3. TEST: Listar Personas de una Casa
            System.out.println("2. Test findAllPersoninHouse (ID 2):");
            List<Person> alumnosCasa2 = personService.findAllPersonInHouse(2);
            alumnosCasa2.forEach(p -> System.out.println("- " + p.getFirstName() + " " + p.getLastName()));
            System.out.println("----------------------------------\n");

            // 4. TEST: Borrado de Casa con Alumnos (Debe fallar)
            System.out.println("3. Test borrado casa con alumnos (Debe mostrar error):");
            houseService.delete(1);
            System.out.println("----------------------------------\n");

            // 5. TEST: Borrado de Persona con historial de puntos (Debe fallar)
            System.out.println("4. Test borrado persona con puntos (Debe mostrar error):");
            // Harry Potter es el ID 19 o similar que seguro tiene puntos
            personService.delete(19);
            System.out.println("----------------------------------\n");

            // 6. TEST: Puntos totales por Casa
            System.out.println("5. Test getPuntosCasas:");
            pointsService.getPuntosCasas();
            System.out.println("----------------------------------\n");

        } catch (Exception e) {
            System.err.println("Error durante el testeo: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerramos la factoría al terminar
            HibernateUtil.shutdown();
            System.out.println("\n=== TEST FINALIZADO ===");
        }
    }
}