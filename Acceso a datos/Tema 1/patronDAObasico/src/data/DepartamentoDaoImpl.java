package data;

import java.sql.*;

import dao.DepartamentoDao;
import model.Departamento;
import utils.CredentialsDB;

public class DepartamentoDaoImpl implements DepartamentoDao {

	private static final String SQL_INSERT = 
			"INSERT INTO departamentos" +
			"(codDepto, nombreDpto, ciudad, codDirector)" + 
			"VALUES(?, ?, ?, ?);";

    private static final String SQL_UPDATE =
            "UPDATE departamentos SET " +
            "nombreDPTO = ?, ciudad = ?, codDirector = ? " +
            "WHERE codDepto = ?;";

    private static final String SQL_DELETE =
            "DELETE FROM departamentos WHERE ID = ";

	@Override
	public void create(Departamento departamento) {
		
		try (Connection conexion = CredentialsDB.getInstance();

             PreparedStatement sentencia = conexion.prepareStatement(SQL_INSERT);) {
        	
			sentencia.setString(1, departamento.getCodDepto());
			sentencia.setString(2, departamento.getNombreDpto());
			sentencia.setString(3, departamento.getCiudad());
			sentencia.setString(4, departamento.getCodDirector());
			
			sentencia.executeUpdate();

        } catch (SQLException cn) {
            cn.printStackTrace();
        }
		
	}
	
	@Override
	public Departamento read(String codDepartamento) throws SQLException {

        String sql = "Select codDepto, nombreDpto, ciudad, codDirector from departamentos where codDepto =  "+ codDepartamento;

        Connection connection = CredentialsDB.getInstance();

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {

            System.out.println(rs);
        }

        return null;
	}
	
	@Override
	public void update(Departamento departamento) throws SQLException {

        Connection conn = CredentialsDB.getInstance();
        PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
        pstmt.setString(1, departamento.getNombreDpto());
        pstmt.setString(2, departamento.getCiudad());
        pstmt.setString(3, departamento.getCodDirector());
        pstmt.setString(4, departamento.getCodDepto());

        pstmt.executeUpdate();

	}

	@Override
	public void delete(String codDepartamento) throws SQLException {

        Connection conn = CredentialsDB.getInstance();

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(SQL_DELETE+codDepartamento);
		
	}	

}
