package com.pberna.aad.exameneva2.data.dao;

public interface Dao <T, S> {
	void create(T model);
	T read(S id);
	void update(T model);
	void delete(S id);
}
