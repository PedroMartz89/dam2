public class E03_Rueda {

    private String marca;
    private int diametroPulgadas;
    private int anchuraNominalMm;
    private int ratioAspectoPc;
    private boolean pinchada;
    private int rodaduraKm;
    private final int rodaduraMaxKm = 60000;


    public E03_Rueda() {
        this.marca = "Genérica";
        this.diametroPulgadas = 15;
        this.anchuraNominalMm = 195;
        this.ratioAspectoPc = 65;
        this.pinchada = false;
        this.rodaduraKm = 0;
    }

    public E03_Rueda(String marca, int diametroPulgadas, int anchuraNominalMm, int ratioAspectoPc) {
        this.marca = marca;
        this.diametroPulgadas = diametroPulgadas;
        this.anchuraNominalMm = anchuraNominalMm;
        this.ratioAspectoPc = ratioAspectoPc;
        this.pinchada = false;
        this.rodaduraKm = 0;
    }


    public void pinchar() {
        this.pinchada = true;
    }

    public void reparar() {
        this.rodaduraKm = 0;
        this.pinchada = false;
        System.out.println("Rueda cambiada.");
    }

    public String getEstado() {
        return "Rodadura de rueda: " + rodaduraKm + " km";
    }

    public void rodar(int km) {
        this.rodaduraKm += km;
        if (this.rodaduraKm > this.rodaduraMaxKm) {
            this.pinchada = true;
        }
    }

    public void print() {
        System.out.println("Marca: " + marca);
        System.out.println("Diámetro (pulgadas): " + diametroPulgadas);
        System.out.println("Anchura nominal (mm): " + anchuraNominalMm);
        System.out.println("Ratio de aspecto (%): " + ratioAspectoPc);
        System.out.println("¿Pinchada?: " + (pinchada ? "Sí" : "No"));
        System.out.println("Rodadura actual (km): " + rodaduraKm);
        if (rodaduraKm <= rodaduraMaxKm) {
            System.out.println("Kilómetros restantes: " + (rodaduraMaxKm - rodaduraKm));
        } else {
            System.out.println("Excedido por: " + (rodaduraKm - rodaduraMaxKm) + " km");
        }
    }

    public void println() {
        print();
        System.out.println();
    }
    public static void main(String[] args) {
        E03_Rueda rueda1 = new E03_Rueda();
        E03_Rueda rueda2 = new E03_Rueda("Michelin", 17, 205, 55);

        rueda1.print();
        rueda2.rodar(30000);
        rueda2.pinchar();
        rueda2.print();
        rueda2.reparar();
        rueda2.rodar(31000);
        rueda2.println();

    }
}
