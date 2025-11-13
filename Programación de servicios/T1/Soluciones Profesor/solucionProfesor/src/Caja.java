
public class Caja {

    private float totalImporteCaja;
    private int totalTiempoComiendo;

    public Caja() {
        totalImporteCaja = 0;
        totalTiempoComiendo = 0;
    }

    public float getImporte() {
        return totalImporteCaja;
    }

    public void pagar(float importe, int tiempoComiendoMs) {
        totalImporteCaja += importe;
        totalTiempoComiendo += tiempoComiendoMs;
    }

    public float rentabilidad() {
        return totalImporteCaja / (totalTiempoComiendo / 1000f);
    }
}
