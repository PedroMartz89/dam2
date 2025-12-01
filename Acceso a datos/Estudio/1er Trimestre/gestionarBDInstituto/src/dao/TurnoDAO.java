package dao;

import model.Turno;

public interface TurnoDAO {
    void Create(Turno t);
    void Read(String id);
    void Update(Turno t);
    void Delete(String id);
}
