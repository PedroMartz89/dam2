public class Coche extends Thread {

    private Parking parking;

    public Coche(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        int tiempoEsperaInicial = (int)(Math.random() * 1000);

        try {
            sleep(tiempoEsperaInicial);

            //entramos en el parking
            parking.entrar();

            //esperamos en el parking
            int tiempoEsperaParking = ((int)(Math.random() * 450)) + 50;
            sleep(tiempoEsperaParking);

            //salimos
            parking.salir();


        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
