package dao;

import model.Asignatura;

public interface AsignaturaDAO {

    void Create(Asignatura a);
    void Read(String id);
    void Update(Asignatura a);
    void Delete(String id);
}
