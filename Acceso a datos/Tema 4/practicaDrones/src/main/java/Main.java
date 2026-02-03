import model.Dron;
import model.Mision;
import model.dao.DronDao;
import enumerates.EstadoDron;
import utils.DBConection;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static DronDao dao = new DronDao();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== CONTROL DE DRONES ===");
            System.out.println("1. Registrar nuevo dron");
            System.out.println("2. Listar drons");
            System.out.println("3. Actualizar estado o batería de un dron");
            System.out.println("4. Eliminar dron");
            System.out.println("5. Registrar misión a un dron");
            System.out.println("6. Consultas operativas");
            System.out.println("0. Salir");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> registrarDron();
                case 2 -> listarDrones();
                case 3 -> actualizarDron();
                case 4 -> eliminarDron();
                case 5 -> registrarMision();
                case 6 -> consultasOperativas();
            }
        } while (opcion != 0);
        DBConection.closeConnection();
    }

    private static void registrarDron() {
        System.out.print("ID Único: "); int id = leerEntero();
        System.out.print("Modelo: "); String mod = sc.nextLine();
        System.out.print("Año: "); String anio = sc.nextLine();
        System.out.print("Batería (0-100): "); int bat = leerEntero();
        dao.create(new Dron(id, mod, anio, bat));
        System.out.println("Dron registrado.");
    }

    private static void listarDrones() {
        dao.findAll().forEach(d -> System.out.printf("Modelo: %s | Estado: %s | Batería: %d%% | Misiones: %d%n",
                d.getModelo(), d.getEstado(), d.getNivelBateria(), d.getMisionesRealizadas().size()));
    }

    private static void actualizarDron() {
        System.out.print("ID del dron: "); int id = leerEntero();
        Dron d = dao.read(id);
        if (d != null) {
            System.out.println("1. Cambiar estado | 2. Actualizar batería");
            int sub = leerEntero();
            if (sub == 1) {
                System.out.println("1. Disponible | 2. En misión | 3. Fuera de servicio");
                int est = leerEntero();
                d.setEstado(est == 1 ? EstadoDron.disponible : est == 2 ? EstadoDron.en_mision : EstadoDron.fuera_de_servicio);
            } else {
                System.out.print("Nueva batería: "); d.setNivelBateria(leerEntero());
            }
            dao.update(d);
            System.out.println("Dron actualizado.");
        }
    }

    private static void eliminarDron() {
        System.out.print("ID del dron a eliminar: "); int id = leerEntero();
        Dron d = new Dron(); d.setId(id);
        dao.delete(d);
        System.out.println("Dron eliminado.");
    }

    private static void registrarMision() {
        System.out.print("ID del dron: "); int id = leerEntero();
        Mision m = new Mision();
        System.out.print("Tipo misión: "); m.setTipoMision(sc.nextLine());
        System.out.print("Zona: "); m.setZona(sc.nextLine());
        System.out.print("Duración (min): "); m.setDuracion(Long.parseLong(sc.nextLine()));
        System.out.print("Éxito (si/no): "); m.setExito(sc.nextLine().equalsIgnoreCase("si"));
        System.out.print("Riesgo (1-5): "); m.setNivelRiesgo(leerEntero());

        dao.registrarMision(id, m);
        System.out.println("Misión registrada.");
    }

    private static void consultasOperativas() {
        System.out.println("\nCONSULTAS OPERATIVAS");
        System.out.println("1. Drons con batería baja");
        System.out.println("2. Drons con misiones de alto riesgo");
        System.out.println("0. Volver");
        int sub = leerEntero();
        if (sub == 1) {
            System.out.print("Mostrar batería inferior a: ");
            dao.findBateriaBaja(leerEntero()).forEach(d ->
                System.out.println("Modelo: " + d.getModelo() + " | Batería: " + d.getNivelBateria() + "%"));
        } else if (sub == 2) {
            dao.findMisionesAltoRiesgo().forEach(d ->
                System.out.println("Dron con riesgo >=4: " + d.getModelo()));
        }
    }

    private static int leerEntero() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
}