import java.util.LinkedList;
import java.util.Queue;

public class Camion {

    final int MAX_PALETS = 4;
    private Queue<Integer> pales;
    private Queue<Integer> descargados;
    private boolean quedanPales;
    static int paletsBajados = 0;

    public Camion() {
        this.quedanPales = true;
        pales = new LinkedList<>();
        descargados = new LinkedList<>();
        for (int i = 0; i < MAX_PALETS; i++) {
            int numProductosPalet = (int) (Math.random() * 50 ) + 51;
            pales.add(numProductosPalet);
        }

    }

    public synchronized void bajarPalet() throws InterruptedException {

        while (pales.isEmpty()) {
            System.out.println("No quedan palets en el camión.");
            wait();
        }

        Integer productos = pales.poll();
        descargados.add(productos);  // El conductor agrega un palé a la cola de palets
        System.out.println("Palé " + productos + " descargado.");
        notifyAll();
        for (Integer i : pales) {
            System.out.println(i);
        }
    }
//        try {
//            while (pales.isEmpty()) {
//                System.out.println("No quedan palets en el camión.");
//                wait();
//            }
//
//            Integer numProductosPalet = pales.poll();
//            descargados.add(numProductosPalet);
//            paletsBajados++;
//            System.out.println(paletsBajados);
//            System.out.println("El conductor ha descargado un palé con " + numProductosPalet + " productos.");
//
//            notifyAll();
//            return numProductosPalet;
//
//        } catch (InterruptedException e) {
//            System.out.println("Error al coger el palet");
//            notifyAll();
//            return 0;
//        }


    public synchronized Integer recogerPalet() throws InterruptedException {

        if (descargados.isEmpty()) {
            System.out.println("No quedan palets por colocar.");
            wait();
        }
        notifyAll();
        return descargados.poll();

    }

    public boolean estaVacio() {

        return descargados.isEmpty();
    }
}
