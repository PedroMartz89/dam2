package com.pberna.aad.examenut3ut4;

import com.pberna.aad.examenut3ut4.data.model.DetalleCompra;
import com.pberna.aad.examenut3ut4.data.model.EstadisticasValoraciones;
import com.pberna.aad.examenut3ut4.data.model.Producto;
import com.pberna.aad.examenut3ut4.mongo.VideoJuegosBD;
import com.pberna.aad.examenut3ut4.services.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductoService productoService = new ProductoService();
        DetalleCompraService detalleCompraService = new DetalleCompraService();
        UsuarioService usuarioService = new UsuarioService();
        ValoracionService valoracionService = new ValoracionService();
        CompraService compraService = new CompraService();
        VideoJuegosBD videoJuegosBD = new VideoJuegosBD();

        //HIBERNATE
        System.out.println("EJ 2.2 - Delete");
        productoService.delete(4);

        System.out.println("EJ 3.1 - detallesCompra");
        List<DetalleCompra> detalleCompraList = compraService.getDetallesCompra(1);


        System.out.println("EJ 3.2 - procutosValorados");
        List<Producto> productosValorados = usuarioService.getProductosValorados(2);

        System.out.println("EJ 3.3 - detallesCompraUmbralStock");
        List<DetalleCompra> detalleCompraUmbral = detalleCompraService.obtenerDetallesCompraUmbralStock();

        System.out.println("EJ 3.4 - estadisticasValoraciones");
        List<EstadisticasValoraciones> estadisticas = valoracionService.getEstadisticasValoraciones();

        //MONGO

        System.out.println("1.1 Crear coleccion");
        videoJuegosBD.crearColeccionConDatos();

        System.out.println("1.2 Asignar campo precio");
        videoJuegosBD.asignarCampoPrecio();

        System.out.println("1.3 Borrar juegos desarrollador");
        videoJuegosBD.borrarJuegosDesarrollador();
    }
}
