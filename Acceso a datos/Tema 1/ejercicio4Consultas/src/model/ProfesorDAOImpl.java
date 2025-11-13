package model;

import dao.ProfesorDao;
import utils.CredentialsDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAOImpl implements ProfesorDao {

    private final String SQL_OBTENER_PROFES_IMPARTEN_AULA =
            " SELECT DISTINCT p.nrp, p.dni, p.nombre, p.apellido1, p.apellido2 from profesor p "
                    +" join imparte im on p.nrp = im.nrp_profesor"
                    +" where im.num_aula = ?;";

    @Override
    public List<Profesor> obtenerProfesImpartenAula(String numAula) {

        List<Profesor> profesores = new ArrayList<>();

        try (Connection conexion = DriverManager.getConnection(
                CredentialsDB.getConnection(),
                CredentialsDB.getUser(),
                CredentialsDB.getPassword());

             PreparedStatement pstmt = conexion.prepareStatement(SQL_OBTENER_PROFES_IMPARTEN_AULA)) {

            pstmt.setString(1, numAula);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                profesores.add(new Profesor(
                        rs.getString("nrp"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2")
                ));
            }
            return profesores;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
