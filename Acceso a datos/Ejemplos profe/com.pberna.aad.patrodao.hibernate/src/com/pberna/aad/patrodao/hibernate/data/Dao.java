package com.pberna.aad.patrodao.hibernate.data;

public interface Dao <T, P> {
	 void create(T model);
	 T read(P identifier);
	 void update(T model);
	 void delete(P identifier);
}
