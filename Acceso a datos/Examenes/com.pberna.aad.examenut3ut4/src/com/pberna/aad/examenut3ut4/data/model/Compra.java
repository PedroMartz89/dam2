package com.pberna.aad.examenut3ut4.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @Column(name = "id_compra")
    private int idCompra;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "fecha_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaCompra;

    @Column(name = "total")
    private double total;

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Timestamp getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Timestamp fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
