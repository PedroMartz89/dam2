public class Main {

    public static void main(String[] args) {
        Parking parking = new Parking();
        for (int i = 1; i <= 250; i++) {
            int carId = i;
            new Thread(() -> parking.entrarCoche(carId)).start();
        }
    }
}
