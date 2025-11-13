package com.pberna.aad.ut1.instituto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.pberna.aad.ut1.instituto.model.Alumno;
import com.pberna.aad.ut1.instituto.model.calculados.MatriculadosAsignatura;

public class AlumnoDaoImpl implements AlumnoDao {

	@Override
	public void create(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alumno read(String nre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String alumno) {
		// TODO Auto-generated method stub
		
	}

	private static final String SQL_BUSCAR_POR_CURSO =
			"SELECT DISTINCT a.* "
			+ "FROM matricula m "
			+ "	INNER JOIN alumno a ON a.nre = m.nre "
			+ "WHERE cod_curso = ? "
			+ "ORDER BY a.apellido1, a. apellido2, a.nombre ";
	
	@Override
	public List<Alumno> buscarPorCurso(String codCurso) {
		List<Alumno> alumnos = new LinkedList<Alumno>();
		
		try (Connection conexion = DriverManager.getConnection(
				CredentialsDB.getConnection(), 
				CredentialsDB.getUser(),
				CredentialsDB.getPassword()); 
                PreparedStatement sentencia = conexion.prepareStatement(SQL_BUSCAR_POR_CURSO); ){
        	
            sentencia.setString(1, codCurso);
            
            try (ResultSet result = sentencia.executeQuery()) {
            	
            	while(result.next()) {
            		Alumno alumno = new Alumno();
                    alumno.setNre(result.getString("nre"));
                    alumno.setDni(result.getString("dni"));
                    alumno.setNombre(result.getString("nombre"));
                    alumno.setApellido1(result.getString("apellido1"));
                    alumno.setApellido2(result.getString("apellido2"));
                    
                    alumnos.add(alumno);
            	}                
            }

        } catch (SQLException cn) {
            cn.printStackTrace();
        }
		
		return alumnos;
	}

	private static final String SQL_BUSCAR_NOMBRE = 
			"SELECT * "
			+ "FROM alumno "
			+ "WHERE nombre like ?";
	
	@Override
	public List<Alumno> buscarPorNombre(String nombre) {
		List<Alumno> alumnos = new LinkedList<Alumno>();
		
		try (Connection conexion = DriverManager.getConnection(
				CredentialsDB.getConnection(), 
				CredentialsDB.getUser(),
				CredentialsDB.getPassword()); 
                PreparedStatement sentencia = conexion.prepareStatement(SQL_BUSCAR_NOMBRE); ){
        	
            sentencia.setString(1, "%" + nombre + "%");
            
            try (ResultSet result = sentencia.executeQuery()) {
            	
            	while(result.next()) {
            		Alumno alumno = new Alumno();
                    alumno.setNre(result.getString("nre"));
                    alumno.setDni(result.getString("dni"));
                    alumno.setNombre(result.getString("nombre"));
                    alumno.setApellido1(result.getString("apellido1"));
                    alumno.setApellido2(result.getString("apellido2"));
                    
                    alumnos.add(alumno);
            	}                
            }

        } catch (SQLException cn) {
            cn.printStackTrace();
        }
		
		return alumnos;
	}

	private static final String SQL_RECUENTO_MATRICULADOS = 
			"SELECT cod_asig, COUNT(nre) as alumnos_matriculados "
			+ "  FROM matricula m "
			+ "GROUP BY cod_asig "
			+ "ORDER BY COUNT(nre) desc ";
	
	@Override
	public List<MatriculadosAsignatura> obtenerRecuentoMatriculadosAsignatura() {
		List<MatriculadosAsignatura> listado = new LinkedList<MatriculadosAsignatura>();
		
		try (
	        	Connection conexion = DriverManager.getConnection(
	        			CredentialsDB.getConnection(), 
	    				CredentialsDB.getUser(),
	    				CredentialsDB.getPassword()); 
	                Statement sentencia = conexion.createStatement(); 
	                ResultSet result = sentencia.executeQuery(SQL_RECUENTO_MATRICULADOS)){

	            while (result.next()) {
	            	MatriculadosAsignatura matriculadosAsignatura = new MatriculadosAsignatura();
	            	matriculadosAsignatura.setCodigoAsignatura(
	            			result.getString("cod_asig"));
	            	matriculadosAsignatura.setAlumnosMatriculados(
	            			result.getLong("alumnos_matriculados")
	            			);	            	
	            	
	            	listado.add(matriculadosAsignatura);
	            }

	        } catch (SQLException cn) {
	            cn.printStackTrace();
	        }
		
		return listado;
	}


	
}
