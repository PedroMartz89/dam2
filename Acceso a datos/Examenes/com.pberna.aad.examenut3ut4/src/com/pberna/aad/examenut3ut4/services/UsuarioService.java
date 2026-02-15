package com.pberna.aad.examenut3ut4.services;

import com.pberna.aad.examenut3ut4.data.HibernateUtil;
import com.pberna.aad.examenut3ut4.data.dao.UsuarioDao;
import com.pberna.aad.examenut3ut4.data.model.Producto;
import com.pberna.aad.examenut3ut4.data.model.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UsuarioService {
    UsuarioDao usuarioDao = new UsuarioDao(Usuario.class);

    public List<Producto> getProductosValorados(int idUsuario) {

        Session session = HibernateUtil.getSession();
        Query<Producto> query = session.createNamedQuery("getProductosValorados", Producto.class);
        query.setParameter("idUsuario", idUsuario);

        return query.getResultList();
    }
}
