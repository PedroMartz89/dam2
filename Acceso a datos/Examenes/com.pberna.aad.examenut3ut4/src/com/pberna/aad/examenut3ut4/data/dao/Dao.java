package com.pberna.aad.examenut3ut4.data.dao;

public interface Dao <T, S> {
	public void create(T model);
	public T read(S id);
	public void update(T model);
	public void delete(S id);
}
