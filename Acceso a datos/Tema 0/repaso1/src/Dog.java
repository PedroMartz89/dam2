public class Dog extends Mammal {

    public String talla;


    public Dog(String tipo) {
        super(tipo);
        this.talla = null;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "talla='" + talla + '\'' +
                super.toString() +
                '}';
    }
}
