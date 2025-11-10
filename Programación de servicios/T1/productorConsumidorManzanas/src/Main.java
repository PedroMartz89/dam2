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
            jardineroHilo.join();
            for (Thread hiloChiquillo : chiquilloHilos) {
                hiloChiquillo.start();
            }



            for (Thread hiloChiquillo : chiquilloHilos) {
                hiloChiquillo.join();
            }

            int totalConsumidas = 0;
            for (Chiquillo chiquillo : chiquillos) {
                totalConsumidas += chiquillo.getManzanasConsumidas();
            }

            System.out.println("Los chiquillos han consumido " + totalConsumidas + " manzanas.");

        } catch (RuntimeException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Simulación terminada.");
    }
}
