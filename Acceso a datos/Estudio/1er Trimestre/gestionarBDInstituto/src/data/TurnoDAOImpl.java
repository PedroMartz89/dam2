package data;

import dao.TurnoDAO;
import model.Turno;

public class TurnoDAOImpl implements TurnoDAO {

    private final String SQL_INSERT = "INSERT INTO asignatura" +
            "(cod_asignatura, cod_interno, descripcion, nHoras, cod_curso)" +
            "VALUES(?, ?, ?, ?, ?);";

    private final String SQL_UPDATE = "UPDATE asignatura SET " +
            "cod_interno = ?, descripcion = ?, nHoras = ?, cod_curso = ? " +
            "WHERE cod_asignatura = ?;";

    private final String SQL_DELETE = "DELETE FROM asignatura WHERE cod_asignatura = ?;";

    private final String SQL_SELECT = "SELECT * FROM asignatura WHERE cod_asignatura = ?";

    @Override
    public void Create(Turno t) {

    }

    @Override
    public void Read(String id) {

    }

    @Override
    public void Update(Turno t) {

    }

    @Override
    public void Delete(String id) {

    }
}
