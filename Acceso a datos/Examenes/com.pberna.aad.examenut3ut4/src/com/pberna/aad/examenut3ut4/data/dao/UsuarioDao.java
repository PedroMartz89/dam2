package com.pberna.aad.examenut3ut4.data.dao;

import com.pberna.aad.examenut3ut4.data.model.Usuario;

public class UsuarioDao extends HibernateDao<Usuario, Integer> {
    public UsuarioDao(Class<Usuario> classT) {
        super(classT);
    }
}
