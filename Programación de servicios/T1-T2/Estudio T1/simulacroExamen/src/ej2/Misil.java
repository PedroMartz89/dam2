package ej2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Misil extends Thread {
    private int id;
    private CountDownLatch latchListos;
    private CountDownLatch latchAtacar;
    private CountDownLatch latchFinAtaque;
    private PipedReader pipedReader;
    private Semaphore semaphore;

    public Misil(int id, CountDownLatch latchListos, CountDownLatch latchAtacar, CountDownLatch latchFinAtaque, PipedReader pipedReader) {
        this.id = id;
        this.latchListos = latchListos;
        this.latchAtacar = latchAtacar;
        this.latchFinAtaque = latchFinAtaque;
        this.pipedReader = pipedReader;
        this.semaphore = new Semaphore(1);
    }

    @Override
    public void run() {

        try {
            System.out.println("Misil" + currentThread() + " listo.");
            latchListos.countDown();
            sleep(1000);

            latchAtacar.await();

            BufferedReader br = new BufferedReader(pipedReader);

            if (br.readLine().equals("atacar")) {
                int random;
                Random random1 = new Random();
                random = random1.nextInt();
                System.out.println("El misil " + threadId() + " disparado.");

                if (!(semaphore.availablePermits() == 0)) {
                    if (random < 0.5) {
                        semaphore.acquire();
                        Norad.numAcertados++;
                        System.out.println("El misil " + threadId() + " ha acertado.");
                        latchFinAtaque.countDown();
                        semaphore.release();

                        sleep(1000);

                    } else {
                        semaphore.acquire();
                        System.out.println("El misil " + threadId() + " ha fallado.");
                        latchFinAtaque.countDown();
                        semaphore.release();
                    }

                }
            }
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
