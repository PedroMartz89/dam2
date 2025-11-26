package ej2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Norad {

    public static int aciertos = 0;

    public static void main(String[] args) throws InterruptedException {
        final int MAX_MISILES = 20;
        CountDownLatch latchArmado = new CountDownLatch(MAX_MISILES);
        CountDownLatch latchLanzado = new CountDownLatch(1);
        CountDownLatch latchAtaque = new CountDownLatch(MAX_MISILES);

        Misil[] misiles = new Misil[MAX_MISILES];
        PipedWriter[] emisores = new PipedWriter[MAX_MISILES];
        try {
            for (int i = 0; i < MAX_MISILES; i++) {

                PipedWriter emisor = new PipedWriter();
                PipedReader receptor = new PipedReader(emisor);

                emisores[i] = emisor;
                misiles[i] = new Misil(i, latchArmado, latchLanzado, latchAtaque, receptor);

                misiles[i].start();
            }

            latchArmado.await();

            System.out.println("Todos los misiles armados y listos.");

            Scanner sc = new Scanner(System.in);
            String linea = "";

            while (!"atacar".equalsIgnoreCase(linea)) {
                System.out.println("Introduce una orden de ataque: ");

                if (!sc.hasNextLine()) {
                    System.out.println("No se ha atacado.");
                    return;
                }

                linea = sc.nextLine();
            }

            System.out.println("Orden de ataque confirmada.");

            latchLanzado.countDown();

            for (int i = 0; i < MAX_MISILES; i++) {
                BufferedWriter bw = new BufferedWriter(emisores[i]);
                bw.write("ataca");
                bw.newLine();
                bw.flush();
            }

            latchAtaque.await();

            aciertos = Misil.getAciertos();
            System.out.println("\nSe ha terminado el ataque.");
            System.out.println("Misiles lanzados: " + MAX_MISILES);
            System.out.println("Misiles acertados: " + aciertos);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
