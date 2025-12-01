package dao;

import model.Grupo;

public interface GrupoDAO {
    void Create(Grupo g);
    void Read(String id);
    void Update(Grupo g);
    void Delete(String id);
}
