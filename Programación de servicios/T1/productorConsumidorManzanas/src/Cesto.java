import java.util.ArrayList;
import java.util.List;

public class Cesto {

    private List<Character> cesto = new ArrayList<>();
    public static int capacidad = 20;

    public synchronized void anadirManzana() {
        try {
            while (cesto.size() >= capacidad) {
                wait();
            }
            cesto.add('ó');
            System.out.println("Se ha añadido una manzana.");
            notifyAll();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void consumirManzana() {
        int cantidad = (int) (Math.random() * 5) + 1;
        try {
            while (cesto.isEmpty()) {
                wait();
            }

            for (int i = 0; i < cantidad; i++) {
                if (!cesto.isEmpty()) {
                    cesto.remove(0);
                    System.out.println("Manzana consumida.");
                }
            }
            notifyAll();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean hayManzanas() {
        return !cesto.isEmpty();
    }

    public synchronized boolean cestoLleno() {
        return cesto.size() >= capacidad;
    }
}
