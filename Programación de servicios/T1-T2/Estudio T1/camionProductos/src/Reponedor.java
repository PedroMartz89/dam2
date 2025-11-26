
public class Reponedor extends Thread {

    private Camion camion;
    private int id;
    public Reponedor(Camion camion, int id) {
        this.camion = camion;
        this.id = id;
    }

    @Override
    public void run() {

        System.out.println("El reponedor " + id+ " está recogiendo un pale.");
        Integer productosColocar = null;
        try {
            productosColocar = camion.recogerPalet();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            if (productosColocar == null) {return;}
            Thread.sleep((long) (0.3 * (double) productosColocar));
            System.out.println("El reponedor " + id+ " ha colocado: " + productosColocar + " productos.");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
