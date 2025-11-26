import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Banca banca = new Banca();
        Ruleta ruleta = new Ruleta(random, banca);

        Jugador[] jugadores = new Jugador[4];

        // Creamos los jugadores con diferentes estrategias
        for (int i = 0; i < jugadores.length; i++) {
            if (i % 3 == 0) {
                jugadores[i] = new Jugador("número", ruleta, banca);
            } else if (i % 3 == 1) {
                jugadores[i] = new Jugador("par-impar", ruleta, banca);
            } else {
                jugadores[i] = new Jugador("martingala", ruleta, banca);
            }
            jugadores[i].start(); // Iniciamos los hilos de los jugadores
        }



    }
}
