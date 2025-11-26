public class Caja {

    private float totalImporte;
    private int totalTiempoComiendo;

    public Caja() {
        this.totalImporte = 0;
        this.totalTiempoComiendo = 0;
    }


    public void pagar(float importe, int tiempoComiendo) {

        totalImporte += importe;
        totalTiempoComiendo += tiempoComiendo;
    }

    public float getImporte() {

        return totalImporte;
    }

    public float rentabilidad() {

        return totalImporte / (totalTiempoComiendo / 1000f);
    }
}
