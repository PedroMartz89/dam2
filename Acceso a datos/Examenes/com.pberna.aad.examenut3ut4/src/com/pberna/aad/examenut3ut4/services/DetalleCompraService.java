package com.pberna.aad.examenut3ut4.services;

import com.pberna.aad.examenut3ut4.data.HibernateUtil;
import com.pberna.aad.examenut3ut4.data.dao.DetalleCompraDao;
import com.pberna.aad.examenut3ut4.data.dao.HibernateDao;
import com.pberna.aad.examenut3ut4.data.model.DetalleCompra;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class DetalleCompraService {
    DetalleCompraDao detalleCompraDao = new DetalleCompraDao(DetalleCompra.class);

    public List<DetalleCompra> obtenerDetallesCompraUmbralStock() {

        try (Scanner sc = new Scanner(System.in);
             Session session = HibernateUtil.getSession()){

            System.out.println("Introduce el umbral de stock: ");
            int umbral = sc.nextInt();

            Query<DetalleCompra> query = session.createNamedQuery("getDetalleByUmbral", DetalleCompra.class);
            query.setParameter("stock", umbral);

            return query.getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
