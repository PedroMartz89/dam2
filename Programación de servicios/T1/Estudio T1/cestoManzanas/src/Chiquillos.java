public class Chiquillos implements Runnable {

    private CestoManzanas cestoManzanas;

    public Chiquillos(CestoManzanas cestoManzanas) {
        this.cestoManzanas = cestoManzanas;
    }

    @Override
    public void run() {

        int manzanasComidas = 0;
        int manzanasComer = (int) (Math.random() * 4) + 1;
        while (true) {
            try {
               int manzanasSacadas = cestoManzanas.sacarManzanas(manzanasComer);

               manzanasComidas += manzanasSacadas;
                System.out.println("Me he comido " + manzanasSacadas + " manzanas.");

            } catch (RuntimeException e) {
                break;
            }

            if (Thread.interrupted()) {
                break;
            }
        }
            System.out.println("Soy el chiquillo " + Thread.currentThread().getName()
                    + " y he comido " + manzanasComidas + " manzanas.");
    }
}
