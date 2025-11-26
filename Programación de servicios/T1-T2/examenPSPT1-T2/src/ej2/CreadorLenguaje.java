package ej2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CreadorLenguaje extends Thread {

    private CountDownLatch contadorComenzar;
    private CyclicBarrier barrera;
    private Repositorio repo;
    private String nombre;
    public CreadorLenguaje(CountDownLatch contadorComenzar, CyclicBarrier barrera, Repositorio repo, String nombre) {
        this.contadorComenzar = contadorComenzar;
        this.barrera = barrera;
        this.repo = repo;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            contadorComenzar.await();
            System.out.println("Conectándose al servidor...");
            sleep(4);
            barrera.await();

            System.out.println("Conectado.");

            while (repo.algoritmosRestantes() != 0) {
                repo.recogerAlgoritmo();
                System.out.println(nombre + " ha recogido un algoritmo.");
                System.out.println(nombre + " está compilando algoritmos...");
                long tiempoCompilacion = 2;
                sleep(tiempoCompilacion);
                repo.sumarTiempo(tiempoCompilacion);

                System.out.println("Compilación terminada.");
            }

            System.out.println("El repositorio está vacio, " + nombre + " ha terminado.");
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }
}
