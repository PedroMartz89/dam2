package com.pberna.aad.examenut3ut4.data.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaRegistro;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
