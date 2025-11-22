import java.util.Random;

public class Ruleta {

    private Banca banca;
    private Random random;

    public Ruleta(Random random, Banca banca) {
        this.random = random;
        this.banca = banca;
    }

    public synchronized int sacarNumeroRandom() {

        int numero = random.nextInt(37);
        if (numero == 0) {
            banca.ingresarDinero(360 * 4);
        }
        return numero;
    }

}




