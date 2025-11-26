import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int MAX_MESAS = 10;
        final int MAX_COMENSALES = 100;
        Comensal[] comensales = new Comensal[MAX_COMENSALES];
        CountDownLatch contadorMedioLleno = new CountDownLatch(50);
        Semaphore semaphore = new Semaphore(MAX_MESAS);
        Caja caja = new Caja();
        Restaurante restaurante = new Restaurante(semaphore, caja);
        ResponsableSala responsableSala = new ResponsableSala(contadorMedioLleno);

        responsableSala.start();
        for (int i = 0; i < MAX_COMENSALES; i++) {
            comensales[i] = new Comensal(i, restaurante, caja, contadorMedioLleno);
            comensales[i].start();
            comensales[i].join();
        }


        double rentabilidad = caja.calcularRentabilidad();
        System.out.println("La rentabilidad total del restaurante es: " + rentabilidad + "€");
    }
}
