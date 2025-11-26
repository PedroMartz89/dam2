public class Coche implements Runnable {

    private final Parking parking;
    private final int idCoche;

    public Coche(Parking parking, int idCoche) {
        this.parking = parking;
        this.idCoche = idCoche;
    }

    @Override
    public void run() {
        try {
            int tiempoEspera = (int) (Math.random() * 101);
            Thread.sleep(tiempoEspera);
            parking.entrarCoche(idCoche);

            int parkingTime = (int) (Math.random() * 451) + 50;
            Thread.sleep(parkingTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
