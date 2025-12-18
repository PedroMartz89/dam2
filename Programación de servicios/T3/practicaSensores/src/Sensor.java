public class Sensor {
    private int idSensor;
    private boolean estado;
    private Double umbral;

    public Sensor(int idSensor, Double umbral) {
        this.idSensor = idSensor;
        this.estado = false;
        this.umbral = umbral;
    }

    public Sensor(int idSensor) {
        this.idSensor = idSensor;
        this.estado = false;
        this.umbral = null;
    }

    public void encenderSensor() {
        this.estado = true;
    }

    public void apagarSensor() {
        this.estado = false;
    }

    public void establecerUmbral(Double umbralEstablecer) {
        this.umbral = umbralEstablecer;
    }

    public int getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Double getUmbral() {
        return umbral;
    }

    public void setUmbral(Double umbral) {
        this.umbral = umbral;
    }
}
