
import java.util.concurrent.CountDownLatch;

public class ResponsableSala extends Thread {

    private CountDownLatch cuentaAtrasSalaMedioLlena;

    public ResponsableSala(CountDownLatch cuentaAtrasSalaMedioLlena) {
        this.cuentaAtrasSalaMedioLlena = cuentaAtrasSalaMedioLlena;
    }

    @Override
    public void run() {
        //espera a que la sala esté medio llena
        try {
            cuentaAtrasSalaMedioLlena.await();
        } catch (InterruptedException e) {
            System.err.println("El responsable sala ha sido interrumpido");
            return;
        }

        //anotamos que la sala está medio llena
        System.out.println("Sala medio llena");
    }
}
