public class Productor extends Thread {

    private Cinta cinta;

    public Productor(Cinta cinta) {
        this.cinta = cinta;
    }

    @Override
    public void run() {
        try {
          for (char c = 'A'; c < 'J' ; c++) {

              cinta.producir(c);
              System.out.println("Se ha añadido el caracter " + c + " a la cinta.");
              Thread.sleep(500);
          }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
