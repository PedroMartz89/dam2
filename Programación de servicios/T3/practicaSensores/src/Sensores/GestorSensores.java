package Sensores;

import java.util.ArrayList;
import java.util.List;

public class GestorSensores {

    private static GestorSensores instancia;
    private final List<Sensor> listaSensores;

    private GestorSensores() {
        this.listaSensores = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            this.listaSensores.add(new Sensor(i));
        }
    }

    public static synchronized GestorSensores getInstance() {
        if (instancia == null) {
            instancia = new GestorSensores();
        }
        return instancia;
    }

    public List<Sensor> getListaSensores() {
        return listaSensores;
    }

    public Sensor buscarPorId(int id) {
        if (listaSensores == null) {
            return null;
        }

        for (Sensor s : listaSensores) {
            if (s.getIdSensor() == id) {
                return s;
            }
        }

        return null;
    }
}