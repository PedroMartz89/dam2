public class Consumidor extends Thread {

    private Cinta cinta;

    public Consumidor(Cinta cinta) {
        this.cinta = cinta;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                cinta.consumir();
                System.out.println("Se ha consumido un caracter");
                Thread.sleep(700);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
