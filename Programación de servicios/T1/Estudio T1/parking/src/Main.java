import java.util.Date;

public class Main {

    public static void main(String[] args) {

        final int MAX_PARKING = 50;
        final int MAX_COCHES = 250;
        Parking parking = new Parking(MAX_PARKING);
        Thread[] coches = new Thread[MAX_COCHES];

        Date horaInicio = new Date();

        for (int i = 0; i < MAX_COCHES; i++) {
            coches[i] = new Thread(new Coche(parking));
            coches[i].setName("Coche " + i);
            coches[i].start();
        }

        try {
            for (int i = 0 ; i < MAX_COCHES ; i++) {
                coches[i].join();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Date horaFin = new Date();

        long tiempoTotal = horaFin.getTime() - horaInicio.getTime();
        System.out.println("Tiempo de parking total : " + tiempoTotal + " ms");

    }
}
