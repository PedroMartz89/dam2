package data;

import dao.GrupoDAO;
import model.Grupo;
import utils.ConnectionDB;

import java.sql.*;

public class GrupoDAOImpl implements GrupoDAO {

    private static final String SQL_INSERT =
            "INSERT INTO grupo (cod_grupo, cod_curso, nombre, cod_turno, nMaxAlumnos) VALUES (?,?,?,?,?)";

    private static final String SQL_UPDATE =
            "UPDATE grupo SET cod_curso = ?, nombre = ?, cod_turno = ?, nMaxAlumnos = ? WHERE cod_grupo = ?";

    private static final String SQL_DELETE =
            "DELETE FROM grupo WHERE cod_grupo = ";

    private static final String SQL_READ =
            "SELECT cod_grupo, cod_curso, nombre, cod_turno, nMaxAlumnos FROM grupo WHERE cod_grupo = ";

    @Override
    public void read(Grupo g) throws SQLException {
        Connection conn = ConnectionDB.getInstance();
        String key = "'" + g.getCodGrupo() + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL_READ + key);
        while (rs.next()) {
            while (rs.next()) {
                System.out.println("Código de grupo: " + rs.getString("cod_grupo"));
                System.out.println("Código de curso: " + rs.getString("cod_curso"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Código de turno: " + rs.getString("cod_turno"));
                System.out.println("Número máximo de alumnos: " + rs.getInt("nMaxAlumnos"));
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
        int rows = stmt.executeUpdate(SQL_DELETE + id);
        stmt.close();
    }

    @Override
    public void update(Grupo g) throws SQLException {
        Connection conn = ConnectionDB.getInstance();
        PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
        ps.setString(1, g.getCodCurso());
        ps.setString(2, g.getNombre());
        ps.setString(3, g.getCodTurno());
        ps.setInt(4, g.getnMaxAlumnos());
        ps.setString(5, g.getCodGrupo());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void create(Grupo g) throws SQLException {
        Connection conn = ConnectionDB.getInstance();
        PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
        ps.setString(1, g.getCodGrupo());
        ps.setString(2, g.getCodCurso());
        ps.setString(3, g.getNombre());
        ps.setString(4, g.getCodTurno());
        ps.setInt(5, g.getnMaxAlumnos());
        ps.executeUpdate();
        ps.close();
    }
}
