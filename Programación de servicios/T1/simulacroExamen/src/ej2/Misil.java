package ej2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Misil extends Thread {

    private int id;
    private CountDownLatch latchArmado;
    private CountDownLatch latchLanzado;
    private CountDownLatch latchAtaque;
    private static final Semaphore semaforoAciertos = new Semaphore(1);
    private PipedReader reader;
    private static int aciertos = 0;

    public Misil(int id, CountDownLatch latchArmado, CountDownLatch latchLanzado, CountDownLatch latchAtaque, PipedReader reader) {
        this.id = id;
        this.latchArmado = latchArmado;
        this.latchLanzado = latchLanzado;
        this.latchAtaque = latchAtaque;
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            System.out.println("Misil " + id + " armado.");
            latchArmado.countDown();
            sleep(1000);  // Simula el tiempo de armado

            latchLanzado.await();  // Espera la orden de lanzamiento

            // Lee la orden de ataque del lector
            BufferedReader bufferedReader = new BufferedReader(reader);
            String linea = bufferedReader.readLine();

            // Si la orden es "ataca", disparar el misil
            if ("ataca".equalsIgnoreCase(linea)) {
                System.out.println("MISIL " + id + " DISPARADO.");
                int pausaRandom = (int) (Math.random() * 100) + 1;  // Pausa aleatoria
                sleep(pausaRandom);  // Simula el tiempo de vuelo del misil

                // Determina si el misil ha acertado
                boolean acertado = Math.random() < 0.5;
                if (acertado) {
                    semaforoAciertos.acquire();  // Asegura que solo un hilo modifique aciertos
                    aciertos++;  // Incrementa el número de aciertos
                    System.out.println("El misil " + id + " ha acertado");
                    latchAtaque.countDown();  // Reduce el contador del latch
                    semaforoAciertos.release();  // Libera el semáforo
                } else {
                    System.out.println("El misil " + id + " ha fallado");
                    latchAtaque.countDown();
                }
            }
            System.out.println("Aciertos actuales: " + aciertos);
            System.out.println("latch ataque: " +latchAtaque.getCount());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método estático para obtener el número de aciertos
    public static int getAciertos() {
        return aciertos;
    }
}
