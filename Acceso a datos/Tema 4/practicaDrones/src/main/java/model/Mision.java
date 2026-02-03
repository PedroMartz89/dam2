package model;

public class Mision {
    private String tipoMision;
    private String zona;
    private long duracion;
    private boolean exito;
    private int nivelRiesgo;

    public Mision() {}

    public String getTipoMision() { return tipoMision; }
    public void setTipoMision(String tipoMision) { this.tipoMision = tipoMision; }

    public String getZona() { return zona; }
    public void setZona(String zona) { this.zona = zona; }

    public long getDuracion() { return duracion; }
    public void setDuracion(long duracion) { this.duracion = duracion; }

    public boolean isExito() { return exito; }
    public void setExito(boolean exito) { this.exito = exito; }

    public int getNivelRiesgo() { return nivelRiesgo; }
    public void setNivelRiesgo(int nivelRiesgo) { this.nivelRiesgo = nivelRiesgo; }
}