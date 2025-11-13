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
            System.out.println("consumo manzana");
            int totalManzanas = (int) (Math.random() * 5) + 1;
            manzanasConsumidas += cesto.consumirManzana(totalManzanas);
            if (Thread.interrupted()) {
                break;
            }
            System.out.println("El chiquillo " + idChiquillo + " ha consumido " + manzanasConsumidas + " manzanas.");
        }

        } catch (RuntimeException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getManzanasConsumidas() {
        return manzanasConsumidas;
    }
}
