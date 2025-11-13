public class Coche implements Runnable {

    private Parking parking;

    public Coche(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {

        try {

            Thread.sleep((int) (Math.random() * 101));
            parking.entrarParking();

            Thread.sleep((int) (Math.random() * 500) + 51);
            parking.salirParking();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
