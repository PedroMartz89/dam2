import java.util.concurrent.Semaphore;

public class Restaurante {

    private Semaphore semaphore;
    private static final int MAX_MESAS = 10;

    public Restaurante() {
        this.semaphore = new Semaphore(MAX_MESAS);
    }

    public boolean pedirMesa() {

        return semaphore.tryAcquire();

    }

    public void dejarMesa() {

        semaphore.release();
    }
}
