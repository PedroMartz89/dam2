package data;

import dao.AsignaturaDAO;
import model.Asignatura;
import utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AsignaturaDAOImpl implements AsignaturaDAO {

    @Override
    public void Create(Asignatura a) {
        Connection conn = ConnectionDB.getInstance();
        String cod_asignatura = a.getCod_asignatura();
        String cod_interno = a.getCod_interno();
        String descripcion = a.getDescripcion();
        int nHoras = a.getnHoras();
        String cod_curso = a.getCod_curso();

        try {

            String SQL_INSERT = "INSERT INTO asignatura" +
                    "(cod_asignatura, cod_interno, descripcion, nHoras, cod_curso)" +
                    "VALUES(?, ?, ?, ?, ?);";

            PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, cod_asignatura);
            pstmt.setString(2, cod_interno);
            pstmt.setString(3, descripcion);
            pstmt.setInt(4, nHoras);
            pstmt.setString(5, cod_curso);
            pstmt.executeUpdate();

            System.out.println("Se ha creado la nueva asignatura.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Read(String id) {

        Connection conn = ConnectionDB.getInstance();
        try {
            String SQL_SELECT = "SELECT * FROM asignatura WHERE cod_asignatura = ?";

            PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Update(Asignatura a) {
        Connection conn = ConnectionDB.getInstance();

        try {
            String SQL_UPDATE = "UPDATE asignatura SET " +
                    "cod_interno = ?, descripcion = ?, nHoras = ?, cod_curso = ? " +
                    "WHERE cod_asignatura = ?;";

            PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, a.getCod_asignatura());
            pstmt.setString(2, a.getDescripcion());
            pstmt.setInt(3, a.getnHoras());
            pstmt.setString(4, a.getCod_curso());
            pstmt.setString(5, a.getCod_asignatura());

            pstmt.executeUpdate();
            System.out.println("Se ha actualizado correctamente.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Delete(String id) {

        Connection conn = ConnectionDB.getInstance();
        try {
            String SQL_DELETE = "DELETE FROM asignatura WHERE cod_asignatura = ?;";

            PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            System.out.println("Eliminación correcta");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
