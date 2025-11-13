import java.util.Date;
import java.util.Random;

public class Jardinero  implements Runnable {

    //Recurso compartido
    private Cesto cesto;
    private final long TIEMPO_FUNCIONANDO = 200000;
    public Jardinero(Cesto cesto) {
        this.cesto = cesto;
    }

    @Override
    public void run() {
        Date fechaInicio = new Date();
        long milis = 0;
        while (milis <= TIEMPO_FUNCIONANDO) {
            Date fechaActual = new Date();
            milis = fechaInicio.getTime() - fechaActual.getTime();
          try {
                Thread.sleep(1000);
                int manzanasPuestas = cesto.anadirManzana((int) (Math.random() * 10) + 1);

            System.out.println("El jardinero ha intentado poner " + manzanasPuestas + " manzanas");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
   }

