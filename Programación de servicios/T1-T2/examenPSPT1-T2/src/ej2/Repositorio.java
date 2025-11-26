package ej2;

import java.util.ArrayList;

public class Repositorio {

    private ArrayList<String> algoritmos;
    long tiempoTotalCompilacion;

    public Repositorio(ArrayList<String> algoritmos) {
        this.algoritmos = algoritmos;
        this.tiempoTotalCompilacion = 0;
    }

    public synchronized void recogerAlgoritmo() {
       try {
           if (algoritmos.isEmpty()) {
               wait();
           }

           algoritmos.removeFirst();
           System.out.println("Se ha recogido un algoritmo.");
           int restantes = algoritmosRestantes();
           System.out.println("Quedan " + restantes + " algoritmos por recoger.");
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }


    }

    public synchronized void colocarAlgoritmo(String algoritmo1, String algoritmo2) {

        algoritmos.add("Algoritmo");
        System.out.println("Se ha agregado un algoritmo.");
    }

    public synchronized void sumarTiempo(long tiempo) {
        tiempoTotalCompilacion += tiempo;
    }

    public synchronized int algoritmosRestantes() {
        return algoritmos.size();
    }

    public synchronized long getTiempoTotalCompilacion() {
        return tiempoTotalCompilacion;
    }
}
