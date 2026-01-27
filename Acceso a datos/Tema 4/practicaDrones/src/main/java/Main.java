import model.Dron;
import model.dao.DronDao;

public class Main {
    public static void main(String[] args) {
        Dron d1 = new Dron(1, "Chuli", "2024", 100);
        DronDao dronDao = new DronDao();

        dronDao.create(d1);
    }
}
