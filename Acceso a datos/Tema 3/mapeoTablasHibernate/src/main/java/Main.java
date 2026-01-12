import data.DepartamentoDAO;
import data.EmpleadoDAO;
import data.model.Departamento;
import data.model.Empleado;

public class Main {
    static void main() {
        try {

            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            DepartamentoDAO departamentoDAO = new DepartamentoDAO();

            Empleado e1 = empleadoDAO.read("1.130.222");
            System.out.println(e1.toString());

            Departamento d1 = departamentoDAO.read("1000");
            System.out.println(d1.toString());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
