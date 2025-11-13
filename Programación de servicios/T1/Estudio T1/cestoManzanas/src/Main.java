public class Main {

    public static void main() {
        final int NUM_MANZANAS_MAX = 25;
        final int NUM_CHIQUILLOS = 1;
        CestoManzanas cestoManzanas = new CestoManzanas(NUM_MANZANAS_MAX);
        Thread jardinero = new Thread(new Jardinero(cestoManzanas));
        Thread[] chiquillos = new Thread[NUM_CHIQUILLOS];

        for (int i = 0; i < NUM_CHIQUILLOS; i++) {

            chiquillos[i] = new Thread(new Chiquillos(cestoManzanas));
            System.out.println("Chiquillo arrancado");
            chiquillos[i].setName("Chiquillo " + i);
            chiquillos[i].start();
        }

        jardinero.start();

        try {
            jardinero.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Thread t : chiquillos) {
            t.interrupt();
        }

    }
}
