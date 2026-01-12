package data;

import data.hibernate.HibernateDAO;
import data.model.Departamento;

public class DepartamentoDAO extends HibernateDAO<Departamento, String> {
    public DepartamentoDAO() {
        super(Departamento.class);
    }
}
