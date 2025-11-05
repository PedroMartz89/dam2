import java.util.ArrayList;
import java.util.List;

public class Cinta {

    private List<Character> cinta = new ArrayList<>();
    private final int capacidad = 10;

    public synchronized void producir(char caracter) throws InterruptedException {

        if (cinta.size() == capacidad)
            wait();

        cinta.add(caracter);
        System.out.println("Se ha añadido un caracter a la cinta.");
        notify();

    }

    public synchronized  void consumir() throws InterruptedException {

        if (cinta.isEmpty())
            wait();

       char caracter = cinta.removeFirst();
        System.out.println("Elemento " + caracter +" eliminado de la cinta.");
        notify();

    }
}
