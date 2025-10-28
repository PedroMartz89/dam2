
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Hilo[] hilos = new Hilo[10];

        for (int i = 0; i < hilos.length; i++) {

            hilos[i] = new Hilo(i);
            hilos[i].start();
        }

        Thread.sleep(1000);

        for (int i = 0 ; i < hilos.length/2 ; i++) {

            System.out.println("Interrumpiendo " + hilos[i].nombre);
            hilos[i].interrupt();
        }

        for (int i = hilos.length/2; i < hilos.length; i++) {
            System.out.println("Esperando con join el " + hilos[i].nombre);
        }

        System.out.println("El programa ha finalizado");
    }
}