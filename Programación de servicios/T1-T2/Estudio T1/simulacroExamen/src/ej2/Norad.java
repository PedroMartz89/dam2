package ej2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Norad {
    static int numAcertados = 0;
    public static void main(String[] args) {

        final int MAX_MISILES = 10;
        Misil[] misiles = new Misil[MAX_MISILES];
        PipedWriter[] emisor = new PipedWriter[MAX_MISILES];
        CountDownLatch latchListos = new CountDownLatch(MAX_MISILES);
        CountDownLatch latchAtacar = new CountDownLatch(1);
        CountDownLatch latchFinAtaque = new CountDownLatch(MAX_MISILES);
        Scanner sc = new Scanner(System.in);

        try {
            for (int i = 0; i < MAX_MISILES; i++) {
                emisor[i] = new PipedWriter();
                misiles[i] = new Misil(i, latchListos, latchAtacar, latchFinAtaque, new PipedReader(emisor[i]));
            }

            for (int i = 0; i < MAX_MISILES; i++) {
                misiles[i].start();
            }

            latchListos.await();
            System.out.println("Todos los misiles armados y listos.");

            String orden;
            boolean continuar = true;
            while (continuar) {

                System.out.println("Introduce la orden de ataque: ");
                orden = sc.nextLine();

                if (orden.equals("atacar")) {
                    for (int i = 0; i < MAX_MISILES; i++) {

                       BufferedWriter bw = new BufferedWriter(emisor[i]);
                       bw.write("atacar");
                       bw.newLine();
                       bw.flush();
                       latchAtacar.countDown();
                    }
                    continuar = false;

                } else {
                    System.out.println("Introduce una opción válida.");

                }
                latchFinAtaque.await();
            }


            System.out.println("Número de misiles acertados " + getNumAcertados());
            System.out.println("Fin de la simulación");


        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static int getNumAcertados() {
        return numAcertados;
    }
}
