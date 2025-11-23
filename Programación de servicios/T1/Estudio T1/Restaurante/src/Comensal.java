import java.util.concurrent.CountDownLatch;

public class Comensal extends Thread {

    private Restaurante restaurante;
    private Caja caja;
    private CountDownLatch contadorMedioLleno;
    private int id;
    public Comensal(int id, Restaurante restaurante, Caja caja, CountDownLatch contadorMedioLleno) {
        this.id = id;
        this.restaurante = restaurante;
        this.caja = caja;
        this.contadorMedioLleno = contadorMedioLleno;
    }

    @Override
    public void run() {
        while (true) {
            //Comensal pide mesa
            if (restaurante.pedirMesa()) {
                try {
                    long tiempoComer = (long) ((Math.random() * 4) + 1);
                    System.out.println("Comensal " + id + " ha cogido mesa.");
                    contadorMedioLleno.countDown();
                    //comensal come entre 1 a 4 sg
                    System.out.println("Comensal " + id + " está comiendo.");
                    sleep(tiempoComer);
                    //pagar
                    double importe = caja.getImporte();
                    System.out.println("Comensal " + id + " está pagando.");
                    caja.pagar(importe, tiempoComer);
                    //libera la mesa
                    System.out.println("Comensal " + id + " se fue y ha liberado la mesa.");
                    restaurante.liberarMesa();
                    break;

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
