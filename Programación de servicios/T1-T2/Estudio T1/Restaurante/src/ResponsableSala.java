import java.util.concurrent.CountDownLatch;

public class ResponsableSala extends Thread {

    private CountDownLatch contadorMedioLleno;

    public ResponsableSala(CountDownLatch contadorMedioLleno) {
        this.contadorMedioLleno = contadorMedioLleno;
    }

    @Override
    public void run() {
        try {
            contadorMedioLleno.await();
            System.out.println("La sala está medio llena.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
