import javax.persistence.*;
import java.util.List;
import java.util.Scanner;
public class GestionTienda {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/mascotas.odb");
        EntityManager em = emf.createEntityManager();

        try {
            // --- 5 mascotas --- (están hechas con IA)
            em.getTransaction().begin();
            em.persist(new Mascota("Rex", "Perro", 5, new Chapita("Soy el rey", "600111222", "Rojo")));
            em.persist(new Mascota("Misi", "Gato", 3, new Chapita("No me toques", "600333444", "Azul")));
            em.persist(new Mascota("Burbuja", "Pez", 1, new Chapita("Glub glub", "N/A", "Dorado")));
            em.persist(new Mascota("Smaug", "Dragón", 150, new Chapita("Cuidado: Fuego", "900000001", "Negro")));
            em.persist(new Mascota("Hammy", "Hámster", 2, new Chapita("Corro mucho", "611222333", "Verde")));
            em.getTransaction().commit();

            // Recuperar y mostrar todas las mascotas
            System.out.println("\n--- LISTADO DE MASCOTAS ESTRELLA ---");
            TypedQuery<Mascota> queryTodas = em.createQuery("SELECT m FROM Mascota m", Mascota.class);
            List<Mascota> resultados = queryTodas.getResultList();
            for (Mascota m : resultados) System.out.println(m);

            // Buscar por nombre
            Scanner sc = new Scanner(System.in);
            System.out.print("\nIntroduce el nombre de la mascota a buscar: ");
            String nombreBusqueda = sc.nextLine();

            TypedQuery<Mascota> queryNombre = em.createQuery(
                    "SELECT m FROM Mascota m WHERE m.nombre = :nom", Mascota.class);
            queryNombre.setParameter("nom", nombreBusqueda);

            List<Mascota> encontrados = queryNombre.getResultList();
            if (encontrados.isEmpty()) {
                System.out.println("No se encontró ninguna mascota con ese nombre.");
            } else {
                System.out.println("Resultados encontrados:");
                for (Mascota m : encontrados) System.out.println(m);
            }

        } finally {
            // Cerrar conexiones
            if (em.isOpen()) em.close();
            if (emf.isOpen()) emf.close();
        }
    }
}