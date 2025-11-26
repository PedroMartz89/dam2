
public class Main {
    public static void main(String[] args) {

        Cinta cinta = new Cinta();
        Productor productor = new Productor(cinta);
        Consumidor consumidor = new Consumidor(cinta);

        productor.start();
        consumidor.start();

    }
}