package com.pberna.aad.examenut3ut4.data.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "valoraciones")
@NamedQueries({
        @NamedQuery(
                name = "getProductosValorados",
                query = "SELECT v.producto FROM Valoracion WHERE v.usuario.idUsuario = :idUsuario"
        ),
        @NamedQuery(
                name = "getEstadisticasValoraciones",
                query = "SELECT v.producto.idProducto, " +
                        "v.producto.nombre, " +
                        "COUNT(v.idValoracion) as num_valoraciones, " +
                        "AVG(v.puntuacion) as valoracion_media, " +
                        "MIN(v.puntuacion) as valoracion_minima, " +
                        "MAX(v.puntuacion) as valoracion_maxima, " +
                        "FROM Valoracion v " +
                        "GROUP BY v.producto.idProducto, v.producto.nombre, " +
                        "ORDER BY valoracion_media DESC"
        )
})
public class Valoracion {
    @Id
    @Column(name = "id_valoracion")
    private int idValoracion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(name = "puntuacion")
    private int puntuacion;

    @Column(name = "comentario", length = 400)
    private String comentario;

    @Column(name = "fecha_valoracion")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaValoracion;

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Timestamp getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(Timestamp fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }
}
