package com.pberna.aad.ut1.instituto.services;

public interface Servicio <T, P> {
	 void crear(T modelo) throws ServiceException;
	 T obtener(P id);
	 void actualizar(T modelo);
	 void borrarPorId(P id);
}
