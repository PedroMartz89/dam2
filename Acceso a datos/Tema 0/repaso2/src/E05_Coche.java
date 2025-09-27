public class E05_Coche {
    private E04_Motor motor;
    private E03_Rueda[] ruedas = new E03_Rueda[4];

    public E05_Coche() {
        motor = new E04_Motor();
        for (int i = 0; i < 4; i++) {
            ruedas[i] = new E03_Rueda();
        }
    }

    public E05_Coche(E04_Motor motor) {
        this.motor = motor;
        for (int i = 0; i < 4; i++) {
            ruedas[i] = new E03_Rueda();
        }
    }

    public void rodar(int km) throws Exception {
        this.motor.rodar(km);
        for (E03_Rueda rueda : ruedas) {
            rueda.rodar(km);
        }
    }

    public void print() {
        System.out.println("Estado del motor:");
        motor.print();
        System.out.println("Estado de las ruedas:");
        for (int i = 0; i < ruedas.length; i++) {
            System.out.println("Rueda " + (i + 1) + ": " + ruedas[i].getEstado());
        }
    }

    public void printConEspacio() {
        print();
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        E05_Coche coche = new E05_Coche();
        coche.rodar(50000);
        coche.printConEspacio();
    }
}