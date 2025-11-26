public class Caja {

    private double facturado;
    private double tiempoComiendo;

    public double getImporte() {

        return (Math.random() * 100) + 20;

    }

    public void pagar(double importe, float tiempoComiendo) {

        facturado += importe;
        this.tiempoComiendo += tiempoComiendo;
    }

    public double calcularRentabilidad() {
        return facturado / tiempoComiendo;
    }
}
