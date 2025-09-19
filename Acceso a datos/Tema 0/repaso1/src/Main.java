//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Animal c3;
        Animal c = new Cat();
        Animal elefante = new Animal("Elefante");

        c.visualiza();

        Dog d = new Dog("Grande");
        d.visualiza();

        Cat c2 = new Cat();
        c2.visualiza();

        Mammal m = c2;

        c3 = m;

        m.visualiza();
        c3.visualiza();

        c2.setHealth(60);
        c2.visualiza();

        elefante.visualiza();
    }
}