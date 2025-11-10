import java.util.concurrent.Semaphore;

public class Parking {

    private final Semaphore espacioParking;
    private long tiempoEjecutado;
    private boolean parkingCompleto;

    public Parking() {
        this.espacioParking = new Semaphore(50);
        this.tiempoEjecutado = 0;
        this.parkingCompleto = false;
    }

    public void entrarCoche(int idCoche) {
        try {
            espacioParking.acquire();
            long tiempoEntra = System.currentTimeMillis();
            System.out.println("El coche " + idCoche + " ha entrado al parking.");
            checkParking();
            int parkingTime = (int) (Math.random() * 451) + 50;
            Thread.sleep(parkingTime);
            long tiempoSale = System.currentTimeMillis();
            System.out.println("El coche " + idCoche + " ha salido del parking.");
            long tiempoEnParking = tiempoSale - tiempoEntra;
            tiempoEjecutado += tiempoEnParking;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            espacioParking.release();
            checkParking();
        }
    }

    private synchronized void checkParking() {
        if (espacioParking.availablePermits() == 0 && !parkingCompleto) {
            System.out.println("Parking completo.");
            parkingCompleto = true;
        }
        if (espacioParking.availablePermits() > 0 && parkingCompleto) {
            System.out.println("Parking libre.");
            parkingCompleto = false;
        }
    }

    public synchronized long getTiempoEjecutado() {
        return tiempoEjecutado;
    }

}
