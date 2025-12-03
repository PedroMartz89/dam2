package ra1;

public class Pelicula {
    private int anyo_estreno;
    private float recaudacion;
    private String titulo;

    public Pelicula(int anyo_estreno, float recaudacion, String titulo) {
        this.anyo_estreno = anyo_estreno;
        this.recaudacion = recaudacion;
        this.titulo = titulo;
    }

    public int getAnyo_estreno() {
        return anyo_estreno;
    }

    public void setAnyo_estreno(int anyo_estreno) {
        this.anyo_estreno = anyo_estreno;
    }

    public float getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(float recaudacion) {
        this.recaudacion = recaudacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
