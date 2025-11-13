import java.awt.desktop.SystemSleepEvent;
import java.util.concurrent.CountDownLatch;

public class ResponsableSala implements Runnable {

    private CountDownLatch cuentaAtras;

    public ResponsableSala(CountDownLatch countDownLatch) {

        this.cuentaAtras = countDownLatch;
    }

    @Override
    public void run() {

        try {
            cuentaAtras.await();
        } catch (InterruptedException e) {
            System.err.println("Se ha interrumpido el responsable de la sala.");
            return;
        }

        System.out.println("Sala medio llena.");
    }
}
