package services;
import model.Alumno;
import model.AlumnoDaoImpl;

public interface Servicio <T, P> {
    void crear(T modelo) throws ServiceException;
    T obtener(P id);
    void actualizar(T modelo);
    void borrarPorId(P id);
}
