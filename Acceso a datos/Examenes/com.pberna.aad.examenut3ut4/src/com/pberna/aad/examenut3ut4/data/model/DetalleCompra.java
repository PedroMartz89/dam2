package com.pberna.aad.examenut3ut4.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_compra")
@NamedQueries({
        @NamedQuery(
                name = "getProductosInDetalle",
                query = "select dc.producto from DetalleCompra dc WHERE dc.producto.idProducto = :idProducto"
        ),
        @NamedQuery(
                name = "getDetalleCompraIdCompra",
                query = "FROM DetalleCompra dc WHERE dc.compra.idCompra = :idCompra"
        ),
        @NamedQuery(
                name = "getDetalleByUmbral",
                query = "FROM DetalleCompra dc WHERE dc.producto.stock < :stock ORDER BY dp.cantidad DESC"
        )
})
public class DetalleCompra {

    @Id
    @Column(name = "id_detalle")
    private int idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_compra")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    public int getIdDetalle() {
        return idDetalle;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }
}
