public class Animal {

    private int health;
    private String tipo;

    public Animal(String tipo) {
        this.tipo = tipo;
        this.health = 100;
    }

    public Animal() {
        this.health = 100;
        this.tipo = "Animal";
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "health=" + health +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public void visualiza() {
        System.out.println(toString());
    }
}
