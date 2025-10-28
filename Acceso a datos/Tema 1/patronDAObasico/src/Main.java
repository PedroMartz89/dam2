import com.pberna.aad.patrondao.simple.dao.DepartamentoDao;
import com.pberna.aad.patrondao.simple.dao.DepartamentoDaoImpl;
import com.pberna.aad.patrondao.simple.model.Departamento;

public class Main {
	public static void main(String args[]) {
		DepartamentoDao departamentoDao = new DepartamentoDaoImpl();
		
		Departamento departamento = new Departamento();
		departamento.setNombreDpto("Clase 2DAM");
		departamento.setCodDepto("2DAM");
		departamento.setCodDirector("31.840.269");
		departamento.setCiudad("Murcia");
		
		departamentoDao.create(departamento);
		
		System.out.println("Se ha creado el departamento " + departamento);
	}
}
