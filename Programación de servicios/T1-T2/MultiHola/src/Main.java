//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


    class Hilo1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1500);
                System.out.println("Hola Mundo");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class Hilo2 extends Thread {
        @Override
        public void run() {

            try {
                Thread.sleep(50000);
                System.out.println("Hola Mundo");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class Hilo3 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("Hola Mundo");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
public class Main {
    public static void main(String[] args) {

        Hilo1 hilo1 = new Hilo1();
        Hilo2 hilo2 = new Hilo2();
        Hilo3 hilo3 = new Hilo3();

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}