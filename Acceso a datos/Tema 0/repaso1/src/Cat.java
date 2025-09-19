public class Cat extends Mammal {

    public int lifes;

    public Cat(String tipo) {
        super(tipo);
        this.lifes = 7;
    }

    public Cat() {
        super("Gato");
        this.lifes = 7;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "lifes=" + lifes + " " +
                super.toString() +
                '}';
    }


}
