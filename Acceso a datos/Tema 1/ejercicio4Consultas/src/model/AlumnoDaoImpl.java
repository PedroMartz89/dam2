package model;
import dao.*;
import model.calculados.MatriculadosAsignatura;
import utils.CredentialsDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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

    //EJERCICIO 4 - 1
    private static final String SQL_ALUMNOS_MATRICULADOS_ASIGNATURA_SOLICITADA =
            "SELECT DISTINCT a.nre, a.dni, a.nombre, a.apellido1, a.apellido2 "
                    + "from matricula m "
                    + "inner join alumno a on a.nre = m.nre "
                    + "where m.cod_asig = ?;";



    @Override
    public List<Alumno> alumnosMatriculadosAsignatura(Scanner sc) {
        List<Alumno> alumnos = new ArrayList<>();

        System.out.println("Introduce el id de la asignatura: ");
        String id = sc.nextLine();
        try (Connection conexion = DriverManager.getConnection(
                CredentialsDB.getConnection(),
                CredentialsDB.getUser(),
                CredentialsDB.getPassword());

                PreparedStatement pstmt = conexion.prepareStatement(SQL_ALUMNOS_MATRICULADOS_ASIGNATURA_SOLICITADA)) {

                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {

                    alumnos.add(new Alumno(
                            rs.getString("nre"),
                            rs.getString("dni"),
                            rs.getString("nombre"),
                            rs.getString("apellido1"),
                            rs.getString("apellido2")
                    ));
                }
                return alumnos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
