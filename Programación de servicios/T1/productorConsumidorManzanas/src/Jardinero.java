import java.util.Random;

public class Jardinero  implements Runnable {

    private Cesto cesto;

    public Jardinero(Cesto cesto) {
        this.cesto = cesto;
    }

    @Override
    public void run() {
        try {
            while (!cesto.cestoLleno()) {
                cesto.anadirManzana();
                Thread.sleep(500);
            }
            System.out.println("El jardinero ha terminado de añadir manzanas.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
