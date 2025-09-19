public class Mammal extends Animal{

    public Mammal(String tipo) {
        super(tipo);
    }

    public Mammal() {
        super("Mamífero");
    }

    @Override
    public String toString() {
        return "Mammal{" +
                super.toString() +
                "}";
    }
}
