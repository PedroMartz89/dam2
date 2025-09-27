public class E04_Motor {

    private int cubicajeCC;
    private int potenciaCV;
    private final int limiteKm = 300000;
    private int rodaduraKm = 0;

    public E04_Motor() {
        this.cubicajeCC = 1600;
        this.potenciaCV = 100;
    }

    public E04_Motor(int cubicajeCC, int potenciaCV) {
        this.cubicajeCC = cubicajeCC;
        this.potenciaCV = potenciaCV;
    }

    public void rodar(int km) throws Exception {
        rodaduraKm += km;
        if (rodaduraKm > limiteKm) {
            throw new Exception("Límite excedido! Rodadura actual: " + rodaduraKm);
        }
    }

    public void print() {
        System.out.println("Cubicaje: " + cubicajeCC + " cc");
        System.out.println("Potencia: " + potenciaCV + " CV");
        System.out.println("Rodadura actual: " + rodaduraKm + " km");
        int kmRestantes = limiteKm - rodaduraKm;
        if (kmRestantes >= 0) {
            System.out.println("Kilómetros restantes: " + kmRestantes);
        } else {
            System.out.println("Exceso de kilómetros: " + Math.abs(kmRestantes));
        }
    }

    public void printConEspacio() {
        print();
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            E04_Motor motor1 = new E04_Motor();
            E04_Motor motor2 = new E04_Motor(2000, 150);

            motor1.rodar(100000);
            motor2.rodar(310000);

            motor1.printConEspacio();
            motor2.printConEspacio();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

