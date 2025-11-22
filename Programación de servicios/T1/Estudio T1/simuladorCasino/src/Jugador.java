import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Jugador extends Thread {

    private int dinero;
    private Ruleta ruleta;
    private Banca banca;
    private int numRandom;
    private String estrategia;

    public Jugador(String estrategia, Ruleta ruleta, Banca banca) {
        this.ruleta = ruleta;

        this.dinero = 1000;
        this.banca = banca;
        this.estrategia = estrategia.toLowerCase();
    }

    @Override
    public void run() {
        while (banca.getDinero() > 0 && dinero > 0) {

            try {
                Thread.sleep(3000);
                jugar();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public int getNumRandom() {
        return numRandom;
    }

    public void setNumRandom(int numRandom) {
        this.numRandom = numRandom;
    }

    public boolean puedeJugar(int cantidadApostar) {

        return cantidadApostar > dinero;
    }

    public void jugar() {
        Random random = new Random();
        boolean esPar = random.nextBoolean();
        switch (estrategia) {
            case "numero concreto" -> numeroConcreto();
            case "par-impar" -> parImpar(esPar);
            case "martingala" -> martingala();
        }
    }

    public void numeroConcreto() {

        Random random = new Random();
        int numRuleta = ruleta.sacarNumeroRandom();
        int numApostado = random.nextInt(37);
        try {
            if (numApostado == numRuleta) {
                System.out.println("El jugador " + Thread.currentThread().threadId() + " ha ganado con numero concreto.");
                banca.restarDinero(360);
                ingresarDinero(360);
            } else {
                System.out.println("El jugador" + Thread.currentThread().threadId() + "ha perdido con numero concreto.");
                banca.ingresarDinero(360);
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    public void parImpar(boolean esPar) {

        int numRuleta = ruleta.sacarNumeroRandom();
        int numApostado = sacarNumRandom();
        try {

            if (esPar & (numApostado % 2 == 0) & (numRuleta % 2 == 0)) {
                System.out.println("El jugador " + Thread.currentThread().threadId() + " ha ganado con par-impar.");
                ingresarDinero(20);

            } else if (!esPar & (numApostado % 2 != 0) & (numRuleta % 2 != 0)) {
                System.out.println("El jugador " + Thread.currentThread().threadId() + " ha ganado con par-impar.");
                ingresarDinero(20);
            } else {
                System.out.println("El jugador" + Thread.currentThread().threadId() + "ha perdido con par-impar.");
                retirarDinero(10);
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void martingala() {

        int apuestaActual = 10;

        while (dinero >= apuestaActual) {
            int numRuleta = ruleta.sacarNumeroRandom();
            int numApostado = sacarNumRandom();

            retirarDinero(apuestaActual);
            if (numRuleta == numApostado) {
                System.out.println("El jugador ha ganado con martingala.");
                ingresarDinero(360);
                return;
            } else {
                System.out.println("El jugador ha perdido con martingala.");
                retirarDinero(apuestaActual);
                apuestaActual *= 2;
            }

        }

        System.out.println("El jugador " + currentThread().threadId() + " se ha quedado sin dinero.");
    }

    public void retirarDinero(int cantidad) {
        dinero -= cantidad;
    }

    public void ingresarDinero(int cantidad) {
        dinero += cantidad;
    }

    public int sacarNumRandom() {
        Random random = new Random();
        return random.nextInt(36) + 1;
    }
}
