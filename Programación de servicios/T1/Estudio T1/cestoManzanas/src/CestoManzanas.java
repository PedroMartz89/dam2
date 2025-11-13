public class CestoManzanas{

    private int maxManzanas;
    private int manzanasActual;

    public CestoManzanas(int maxManzanas) {
        this.maxManzanas = maxManzanas;
        this.manzanasActual = 0;
    }

    public synchronized int meterManzanas(int manzanasPoner) {

        int manzanasSePuedenPoner = maxManzanas - manzanasActual;
        System.out.println("hola");
        while (manzanasActual >= maxManzanas) {
            try {

                System.out.println("Soy el hilo " + Thread.currentThread().getName() + " y no caben más manzanas.");
                wait();

            } catch (RuntimeException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int numManzanasPuestasReal = Math.min(manzanasPoner, manzanasSePuedenPoner);
        manzanasActual += numManzanasPuestasReal;
        notifyAll();
        System.out.println("Se ha añadido " + numManzanasPuestasReal+ " manzana.");

        return numManzanasPuestasReal;

    }

    public synchronized int sacarManzanas(int manzanasSacar) {

        try {
            while (manzanasActual == 0) {
                wait();
            }

            int manzanasSePuedenSacar = Math.min(manzanasActual, manzanasSacar);

            manzanasActual -= manzanasSePuedenSacar;
            notifyAll();

            return manzanasSePuedenSacar;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
