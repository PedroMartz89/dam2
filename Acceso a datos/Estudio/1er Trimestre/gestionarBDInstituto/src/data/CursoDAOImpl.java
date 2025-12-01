package data;

import dao.CursoDAO;
import model.Curso;
import utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CursoDAOImpl implements CursoDAO {


    @Override
    public void Create(Curso c) {
       String cod_curso = c.getCod_curso();
       String nombre = c.getNombre();
       String descripcion = c.getDescripcion();

       try {
           String SQL_INSERT = "INSERT INTO curso" +
                   "(cod_curso, nombre, descripcion)" +
                   "VALUES(?, ?, ?);";

           Connection conn = ConnectionDB.getInstance();
           PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
           pstmt.setString(1, cod_curso);
           pstmt.setString(2, nombre);
           pstmt.setString(3, descripcion);
           pstmt.executeUpdate();
           System.out.println("Se ha creado correctamente.");

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public void Read(String id) {
        try {
            String SQL_SELECT = "SELECT * FROM curso WHERE cod_curso = ?";

            Connection conn = ConnectionDB.getInstance();
            PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Update(Curso c) {
        try {
            String SQL_UPDATE = "UPDATE curso SET " +
                    "nombre = ?, descripcion = ? " +
                    "WHERE cod_curso = ?;";

            Connection conn = ConnectionDB.getInstance();
            PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);

            pstmt.setString(1, c.getNombre());
            pstmt.setString(2, c.getDescripcion());
            pstmt.setString(3, c.getCod_curso());

            pstmt.executeUpdate();
            System.out.println("Actualización correcta");

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Delete(String id) {

        try {
            String SQL_DELETE = "DELETE FROM curso WHERE cod_curso = ?;";
            Connection conn = ConnectionDB.getInstance();
            PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE);

            pstmt.setString(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
