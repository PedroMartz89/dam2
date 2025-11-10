package data;

import dao.AsignaturaDAO;
import model.Asignatura;
import utils.ConnectionDB;

import java.sql.*;

public class AsignaturaDAOImpl implements AsignaturaDAO {

    private static final String SQL_INSERT =
            "INSERT INTO asignatura" +
            "(cod_asignatura, cod_interno, descripcion, nHoras, cod_curso)" +
            "VALUES(?,?,?,?,?)";

    private static final String SQL_UPDATE =
            "UPDATE asignatura SET " +
            "cod_interno = ?, descripcion = ?, nHoras = ?, cod_curso = ? " +
            "WHERE cod_asignatura = ?;";

    private static final String SQL_DELETE =
            "DELETE from asignatura WHERE cod_asignatura = ";

    private static final String SQL_READ =
            "SELECT cod_asignatura, cod_interno, descripcion, nHoras, cod_curso FROM asignatura " +
            "WHERE cod_asignatura = ";

    @Override
    public void read(Asignatura a) throws SQLException {

        Connection connectionDB = ConnectionDB.getInstance();
        Statement stmt = connectionDB.createStatement();
        ResultSet resultSet = stmt.executeQuery(SQL_READ+ a.getCodAsignatura());
        while (resultSet.next()) {
            System.out.println("Código: " + resultSet.getString("cod_asignatura"));
            System.out.println("Interno: " + resultSet.getString("cod_interno"));
            System.out.println("Descripción: " + resultSet.getString("descripcion"));
            System.out.println("Horas: " + resultSet.getInt("nHoras"));
            System.out.println("Curso: " + resultSet.getString("cod_curso"));
            System.out.println("-------------------------");
        }
    }

    @Override
    public void delete(int cod_departamento) throws SQLException {

        Connection conn = ConnectionDB.getInstance();
        Statement stmt = conn.createStatement();
        stmt.executeQuery(SQL_DELETE+cod_departamento);
    }

    @Override
    public void update(Asignatura a) throws SQLException {

        Connection conn = ConnectionDB.getInstance();

        PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
        pstmt.setString(1, a.getCodInterno());
        pstmt.setString(2, a.getDescripcion());
        pstmt.setInt(3, a.getnHoras());
        pstmt.setString(4, a.getCodCurso());
        pstmt.setString(5, a.getCodAsignatura());

        pstmt.executeUpdate();
    }

    @Override
    public void create(Asignatura a) throws SQLException {
        Connection conn = ConnectionDB.getInstance();

        PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
        pstmt.setString(1, a.getCodAsignatura());
        pstmt.setString(2, a.getCodInterno());
        pstmt.setString(3, a.getDescripcion());
        pstmt.setInt(4, a.getnHoras());
        pstmt.setString(5, a.getCodCurso());


    }
}
