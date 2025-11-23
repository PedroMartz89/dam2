import java.util.concurrent.Semaphore;

public class Restaurante {

    static final int MAX_MESAS = 10;
    private Semaphore semaforoMesas;
    private Caja caja;

    public Restaurante(Semaphore semaforoMesas, Caja caja) {
        this.semaforoMesas = semaforoMesas;
        this.caja = caja;
    }

    public boolean pedirMesa() {
        return semaforoMesas.tryAcquire();
    }

    public void liberarMesa() {
        try {
            semaforoMesas.release();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
