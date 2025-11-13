import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    private static final int NUM_COMENSALES = 100;

    static void main() {
        Caja caja = new Caja();
        Restaurante restaurante = new Restaurante();
        Comensal[] comensales = new Comensal[NUM_COMENSALES];
        CountDownLatch contador = new CountDownLatch(50);
        ResponsableSala responsableSala = new ResponsableSala(contador);
        for (int i = 0; i < NUM_COMENSALES; i++) {

            comensales[i] = new Comensal(restaurante, caja, contador);
            new Thread(comensales[i]).start();

        }

        Thread responsanleHilo = new Thread(responsableSala);
        responsanleHilo.start();



    }
}
