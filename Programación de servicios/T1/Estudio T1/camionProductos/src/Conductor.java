
public class Conductor extends Thread {

    private Camion camion;

    public Conductor(Camion camion) {
        this.camion = camion;

    }

    @Override
    public void run() {

        try {
            System.out.println("El conductor está bajando un pale.");
            Thread.sleep(10 + (int)(Math.random() * 6) * 1000);
            camion.bajarPalet();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
