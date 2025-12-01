package dao;

import model.Curso;

public interface CursoDAO {
    void Create(Curso c);
    void Read(String id);
    void Update(Curso c);
    void Delete(String id);
}
