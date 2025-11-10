package data;

import dao.CursoDAO;
import model.Curso;
import utils.ConnectionDB;

import java.sql.*;


public class CursoDAOImpl implements CursoDAO {

    private static final String SQL_INSERT =
            "INSERT INTO curso (cod_curso, nombre, descripcion) VALUES (?,?,?)";

    private static final String SQL_UPDATE =
            "UPDATE curso SET nombre = ?, descripcion = ? WHERE cod_curso = ?";

    private static final String SQL_DELETE =
            "DELETE FROM curso WHERE cod_curso = ";

    private static final String SQL_READ =
            "SELECT cod_curso, nombre, descripcion FROM curso WHERE cod_curso = ";

    @Override
    public void read(Curso c) throws SQLException {
        Connection conn = ConnectionDB.getInstance();

        String codCurso = "'" + c.getCodCurso() + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL_READ + codCurso);
        while (rs.next()) {
            while (rs.next()) {
                System.out.println("Código de curso: " + rs.getString("cod_curso"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Descripción: " + rs.getString("descripcion"));
                System.out.println("---------------------------------");
            }
        }
        rs.close();
        stmt.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection conn = ConnectionDB.getInstance();
        Statement stmt = conn.createStatement();
        System.out.println("Eliminado correctamente-");
        stmt.close();
    }

    @Override
    public void update(Curso c) throws SQLException {
        Connection conn = ConnectionDB.getInstance();
        PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getDescripcion());
        ps.setString(3, c.getCodCurso());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void create(Curso c) throws SQLException {
        Connection conn = ConnectionDB.getInstance();
        PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
        ps.setString(1, c.getCodCurso());
        ps.setString(2, c.getNombre());
        ps.setString(3, c.getDescripcion());
        ps.executeUpdate();
        ps.close();
    }
}