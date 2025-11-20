import org.hibernate.Session;

import com.pberna.aad.ut3.baloncesto.data.HibernateUtil;
import com.pberna.aad.ut3.baloncesto.data.model.Equipo;
public class Main {

	public static void main(String[] args) {
		
		try(Session sesion = HibernateUtil.getSessionFactory().openSession();) {
			// Lectura por clave primaria
			Equipo equipoMurcia = sesion.get(Equipo.class, 1);
			System.out.println(equipoMurcia);
			
			// Crear un nuevo equipo
			Equipo equipoCaravaca = new Equipo();
			equipoCaravaca.setCodigoEquipo(2);
			equipoCaravaca.setNombreEquipo("Caravaca Baloncesto");
			
			sesion.beginTransaction();
			sesion.persist(equipoCaravaca);
			sesion.getTransaction().commit();
			
			//actualización 
			equipoMurcia.setNombreEquipo("Equipo Murcia 2.0");
			
			sesion.beginTransaction();
			sesion.persist(equipoMurcia);
			sesion.getTransaction().commit();		
			
			//borramos
			sesion.beginTransaction();
			sesion.remove(equipoCaravaca);
			sesion.getTransaction().commit();
		}
	}

}
