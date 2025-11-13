import java.util.ArrayList;
import java.util.List;

public class Cesto {

    private int numManzanasActual;
    public static int capacidad = 20;

    public synchronized int anadirManzana(int numManzanas) {
        int numManzanasPuedenPoner = capacidad - numManzanasActual;

            while (numManzanasActual == 20) {
                try {
                    wait();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            int numManzanasPuestas = Math.min(numManzanas, numManzanasPuedenPoner);
        System.out.println(numManzanasActual);
            numManzanasActual += numManzanasPuestas;

            notifyAll();
            return numManzanasPuestas;

    }

    public synchronized int consumirManzana(int manzanas) {
        if (numManzanasActual <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int numCogidasReal = Math.min(manzanas, numManzanasActual);
        numManzanasActual += numCogidasReal;
        System.out.println("notifico");
        notifyAll();
        return numCogidasReal;
    }

    public synchronized boolean hayManzanas() {
        return numManzanasActual > 0;
    }

    public int getNumManzanasActual() {
        return numManzanasActual;
    }
}
