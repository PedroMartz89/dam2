public class Main {
    public static void main(String[] args) {
        Cesto cesto = new Cesto();
        Jardinero jardinero = new Jardinero(cesto);

        int numChiquillos = 5;
        Chiquillo[] chiquillos = new Chiquillo[numChiquillos];
        Thread[] chiquilloHilos = new Thread[numChiquillos];


        for (int i = 0; i < numChiquillos; i++) {
            chiquillos[i] = new Chiquillo(cesto, i + 1);
            chiquilloHilos[i] = new Thread(chiquillos[i]);
        }

        Thread jardineroHilo = new Thread(jardinero);

        try {

            jardineroHilo.start();

            for (Thread hiloChiquillo : chiquilloHilos) {
                hiloChiquillo.start();

            }

        } catch (RuntimeException e) {
            e.printStackTrace();
        }


    }

}
