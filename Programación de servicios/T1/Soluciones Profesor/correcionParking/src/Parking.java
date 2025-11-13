import java.util.concurrent.Semaphore;

public class Parking {

    private int capacidadMaxima;
    private Semaphore semaforo;

    public Parking(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.semaforo = new Semaphore(capacidadMaxima);
    }

    public void entrar() {

        // intentamos entrar en el parking
        try {
            if(semaforo.availablePermits() == 0) {
                System.out.println("El parking está lleno");
            }

            semaforo.acquire();

            // mostramos mensaje de entrar al parking
            System.out.println("Soy " + Thread.currentThread().getName() + " y entro al parking");

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void salir() {
        semaforo.release();

        // mostramos mensaje de entrar al parking
        System.out.println("Soy " + Thread.currentThread().getName() + " y salgo del parking");

        if (semaforo.availablePermits() == 1) {
            System.out.println("El parking estaba lleno pero ya está libre");
        }
    }

}
