package ej2;

import java.util.concurrent.CountDownLatch;

public class AdaLovelace extends Thread {
    private CountDownLatch detenerProduccion;
    private Repositorio repo;
    public AdaLovelace(CountDownLatch detenerProduccion, Repositorio rep) {
        this.detenerProduccion = detenerProduccion;
        this.repo = rep;
    }

    @Override
    public void run() {
        while (detenerProduccion.getCount() != 0) {

            System.out.println("Ada va a generar un lote de algoritmos.");
            try {
                sleep(1);
                repo.colocarAlgoritmo("Algoritmo", "Algoritmo");
                detenerProduccion.countDown();
                detenerProduccion.countDown();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Ada ha terminado su trabajo.");
    }


}
