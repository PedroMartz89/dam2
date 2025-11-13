import java.util.concurrent.CountDownLatch;

public class Comensal implements Runnable {

    private Restaurante restaurante;
    private Caja caja;
    private CountDownLatch contadorSala;

    public Comensal(Restaurante restaurante, Caja caja, CountDownLatch contadorSala) {
        this.restaurante = restaurante;
        this.caja = caja;
        this.contadorSala = contadorSala;
    }

    @Override
    public void run() {
//comensal pide mesa
        boolean hayMesaDisponible = restaurante.pedirMesa();

        while(!hayMesaDisponible) {
            int tiempoEspera = ((int)(400 * Math.random())) + 100;
            try {
                //System.out.println("Soy un comensal y espero porque no hay mesa libre");
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                System.out.println("Un comensal se ha interrumpido");
                break;
            }

            hayMesaDisponible = restaurante.pedirMesa();
        }

        //simulamos el tiempo de comer
        contadorSala.countDown();
        int tiempoComiendo = ((int)(3000 * Math.random())) + 1000;
        try {
            System.out.println("Soy un comensal y estoy comiendo");
            Thread.sleep(tiempoComiendo);
        } catch (InterruptedException e) {
            System.out.println("Un comensal se ha interrumpido mientras estaba comiendo");
        }

        //pagar la cuenta
        float importeCuenta = (float) ((81 * Math.random())) + 20f;
        caja.pagar(importeCuenta, tiempoComiendo);

        //liberar la mesa
        System.out.println("Soy un comensal he pagado y dejo la mesa");
        restaurante.dejarMesa();

    }
}
