package data;

import dao.TurnoDAO;
import model.Turno;
import utils.ConnectionDB;

import java.sql.*;

public class TurnoDAOImpl implements TurnoDAO {

    private static final String SQL_INSERT =
            "INSERT INTO turno (cod_turno, horario) VALUES (?,?)";

    private static final String SQL_UPDATE =
            "UPDATE turno SET horario = ? WHERE cod_turno = ?";

    private static final String SQL_DELETE =
            "DELETE FROM turno WHERE cod_turno = ";

    private static final String SQL_READ =
            "SELECT cod_turno, horario FROM turno WHERE cod_turno = ";

    @Override
    public void read(Turno t) throws SQLException {
        Connection conn = ConnectionDB.getInstance();
        String codigoTurno = "'" + t.getCodTurno() + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL_READ + codigoTurno);
        while (rs.next()) {
            System.out.println("Código de turno: " + rs.getString("cod_turno"));
            System.out.println("Horario: " + rs.getString("horario"));
            System.out.println("---------------------------------");
        }
        rs.close();
        stmt.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection conn = ConnectionDB.getInstance();
        Statement stmt = conn.createStatement();
        int rows = stmt.executeUpdate(SQL_DELETE + id);
        System.out.println("Se han eliminado : " + rows + " filas.");
        stmt.close();
    }

    @Override
    public void update(Turno t) throws SQLException {
        Connection conn = ConnectionDB.getInstance();
        PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
        ps.setString(1, t.getHorario());
        ps.setString(2, t.getCodTurno());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void create(Turno t) throws SQLException {
        Connection conn = ConnectionDB.getInstance();
        PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
        ps.setString(1, t.getCodTurno());
        ps.setString(2, t.getHorario());
        ps.executeUpdate();
        ps.close();
    }
}
