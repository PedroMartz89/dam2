public class Main {
    public static void main(String[] args) throws InterruptedException {

        final int MAX_TRABAJADORES = 2;
        Camion camion = new Camion();
        Conductor conductor = new Conductor(camion);
        Thread[] reponedores = new Thread[2];
        conductor.start();
        conductor.join();
        System.out.println("esperando");
        for (int i = 0; i < MAX_TRABAJADORES; i++) {
           reponedores[i] = new Reponedor(camion, i+1);
           reponedores[i].start();
        }



    }
}