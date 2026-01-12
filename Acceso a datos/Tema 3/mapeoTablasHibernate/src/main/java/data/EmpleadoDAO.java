package data;

import data.hibernate.HibernateDAO;
import data.model.Empleado;

public class EmpleadoDAO extends HibernateDAO<Empleado, String> {
    public EmpleadoDAO() {
        super(Empleado.class);
    }
}
