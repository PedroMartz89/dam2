import java.util.Date;

public class Jardinero implements Runnable {

    private CestoManzanas cestoManzanas;

    public Jardinero(CestoManzanas cestoManzanas) {
        this.cestoManzanas = cestoManzanas;
    }


    @Override
    public void run() {

        Date tiempoInicio = new Date();
        long milis = 0;
        int manzanasPuestasTotal = 0;
        long TIEMPO_FUNCIONANDO = 20000;

        while (milis < TIEMPO_FUNCIONANDO) {

            int numManzanasPoner = (int) (Math.random() * 10) + 1;
            int manzanasPuestas = cestoManzanas.meterManzanas(numManzanasPoner);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Date horaActual = new Date();
            milis = horaActual.getTime() - tiempoInicio.getTime();
            manzanasPuestasTotal += Math.min(numManzanasPoner, manzanasPuestas);
        }

        System.out.println("El jardinero ha puesto " + manzanasPuestasTotal);
    }
}
