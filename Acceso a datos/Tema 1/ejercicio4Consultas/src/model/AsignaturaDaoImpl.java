package model;

import dao.AsignaturaDao;
import utils.CredentialsDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaDaoImpl implements AsignaturaDao {
    private static final String SQL_OBTENER_ASIGNATURA_DEPTO =
            "SELECT distinct a.cod_asignatura, a.descripcion from asignatura a " +
                    "inner join imparte i on i.cod_asig = a.cod_asignatura " +
                    "inner join profesor p on p.nrp  = i.nrp_profesor " +
                    "where p.cod_departamento = ?;";

    @Override
    public List<Asignatura> obtenerAsignaturasDepto(String cod_departamento) {
        List<Asignatura> asignaturas = new ArrayList<>();

        try (
                Connection conexion = DriverManager.getConnection(
                        CredentialsDB.getConnection(),
                        CredentialsDB.getUser(),
                        CredentialsDB.getPassword());
                PreparedStatement pstmt = conexion.prepareStatement(SQL_OBTENER_ASIGNATURA_DEPTO)) {

            pstmt.setString(1, cod_departamento);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                asignaturas.add(new Asignatura(rs.getString("cod_asignatura"), rs.getString("descripcion")));
            }

            return asignaturas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
