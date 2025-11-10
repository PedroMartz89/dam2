public class Chiquillo implements Runnable {

    private Cesto cesto;
    private int idChiquillo;
    private int manzanasConsumidas;

    public Chiquillo(Cesto cesto, int idChiquillo) {
        this.cesto = cesto;
        this.idChiquillo = idChiquillo;
        this.manzanasConsumidas = 0;
    }

    @Override
    public void run() {
        try {
            while (cesto.hayManzanas()) {
                cesto.consumirManzana();
                manzanasConsumidas++;
                Thread.sleep(500);
            }

            System.out.println("El chiquillo " + idChiquillo + " ha consumido " + manzanasConsumidas + " manzanas.");

        } catch (RuntimeException e) {
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getManzanasConsumidas() {
        return manzanasConsumidas;
    }
}
