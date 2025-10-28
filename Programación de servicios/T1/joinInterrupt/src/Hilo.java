public class Hilo extends Thread {

    String nombre;

    public Hilo(int num) {
        this.nombre = "Hilo" + " "+ num;
    }

    @Override
    public void run() {
        int sleep = (int) (Math.random()* 1001) + 1000;
        try {
            Thread.sleep(sleep);
            System.out.println("El " + nombre + " va a dormir " + sleep + " segundos.");
            System.out.println("El " + nombre + " ha finalizado.");
        } catch (InterruptedException e) {
            System.out.println("El " + nombre + " se ha interrumpido.");
        }
    }
}
