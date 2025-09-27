public class E06_Camion extends E05_Coche {
    private int cargaMaximaKg;
    private E03_Rueda[] ruedasAdicionales;

    public E06_Camion(int cargaMaximaKg, int numRuedasAdicionales) {
        super();
        this.cargaMaximaKg = cargaMaximaKg;
        ruedasAdicionales = new E03_Rueda[numRuedasAdicionales];
        for (int i = 0; i < numRuedasAdicionales; i++) {
            ruedasAdicionales[i] = new E03_Rueda();
        }
    }

    @Override
    public void rodar(int km) throws Exception {
        super.rodar(km);
        for (E03_Rueda rueda : ruedasAdicionales) {
            rueda.rodar(km);
        }
    }

    @Override
    public void print() {
        System.out.println("Estado del camión:");
        super.print();
        System.out.println("Carga máxima permitida: " + cargaMaximaKg + " kg");
        System.out.println("Ruedas adicionales:");
        for (int i = 0; i < ruedasAdicionales.length; i++) {
            System.out.println("Rueda adicional " + (i + 1) + ": " + ruedasAdicionales[i].getEstado());
        }
    }

    @Override
    public void printConEspacio() {
        print();
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        E06_Camion camion = new E06_Camion(12000, 2);
        camion.rodar(100000);
        camion.printConEspacio();
    }
}