import java.util.concurrent.Semaphore;

public class Parking {

    private Semaphore semaphore;

    public Parking(int capacidadMax) {
        this.semaphore = new Semaphore(capacidadMax);
    }

    public void entrarParking() {
        try {

            if (semaphore.availablePermits() == 0) {

                System.out.println("El parking está lleno.");
            }

            semaphore.acquire();
            System.out.println("El " + Thread.currentThread().getName() + " ha entrado al parking");

            if (semaphore.availablePermits() == 1) {
                System.out.println("El parking está libre.");
            }

        } catch (RuntimeException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void salirParking() {

        semaphore.release();
        System.out.println("El " + Thread.currentThread().getName() + " ha salido del parking.");
    }
}
