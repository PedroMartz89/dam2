import java.util.Scanner;

public class Banca {
    private int dinero;

    public Banca() {
        this.dinero = 50000;
    }

    public void ingresarDinero(int cantidad) {

        dinero += cantidad;
    }

    public void restarDinero(int cantidad) {

        dinero -= cantidad;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
}

