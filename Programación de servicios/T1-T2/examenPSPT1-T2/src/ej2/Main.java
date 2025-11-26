package ej2;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main {
   public static void main() {
        final int PRODUCCION_MAX = 50;
        final int MAX_CREADORES = 3;
        ArrayList<String> algoritmos = new ArrayList<>();
        Repositorio repositorio = new Repositorio(algoritmos);
        CountDownLatch detenerProduccion = new CountDownLatch(PRODUCCION_MAX);
        CyclicBarrier barrier = new CyclicBarrier(MAX_CREADORES);
        AdaLovelace ada = new AdaLovelace(detenerProduccion, repositorio);
        CreadorLenguaje dennis = new CreadorLenguaje(detenerProduccion,barrier, repositorio, "Dennis");
        CreadorLenguaje james = new CreadorLenguaje(detenerProduccion,barrier, repositorio, "James");
        CreadorLenguaje guido = new CreadorLenguaje(detenerProduccion,barrier, repositorio, "Guido");

        try {
          ada.start();
          dennis.start();
          james.start();
          guido.start();

          ada.join();
          dennis.join();
          james.join();
          guido.join();

      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }

       System.out.println("Ejecución terminada.");
       long tiempo = repositorio.getTiempoTotalCompilacion() / PRODUCCION_MAX;
       System.out.println("Tiempo medio de compilación: " + tiempo + "ms");

   }




}
