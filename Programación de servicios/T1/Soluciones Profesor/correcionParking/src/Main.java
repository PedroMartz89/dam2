import java.util.Date;

public class Main {

    private static final int NUMERO_COCHES = 250;
    private static final int CAPACIDAD_PARKING = 50;

    public static void main(String[] args) {
        Parking parking = new Parking(CAPACIDAD_PARKING);

        //creamos los coches y los iniciamos
        Date fechaInicio = new Date();
        Coche[] coches = new Coche[NUMERO_COCHES];
        for(int i = 0 ; i < coches.length; i++) {
            coches[i] = new Coche(parking);
            coches[i].setName("Coche " + (i + 1));
            coches[i].start();
        }

        //esperamos a que todos los coches hayan finalizado
        for(Coche coche: coches) {
            try {
                coche.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        //mostrar el tiempo de ocupacion
        Date fechaFin = new Date();
        long tiempoMiliSegundosOcupacion = fechaFin.getTime() -
                fechaInicio.getTime();

        //mostramos el mensaje
        System.out.println("El parking ha estado ocupado durante " +
                tiempoMiliSegundosOcupacion / 1000f + " segundos");

    }

}
