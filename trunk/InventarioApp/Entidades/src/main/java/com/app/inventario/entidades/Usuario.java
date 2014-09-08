/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.inventario.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Erick
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDUSUARIO", unique = true)
    private int id;
    @Column(name = "CEDULA",unique = true, nullable = false)
    private int cedula;
    @Column(name = "USUARIO", unique = true, nullable = false)
    private String usuario;
    @Column(name = "CONTRASENA", nullable = false)
    private String contrasena;
    @Transient
    private String confirmarContrasena;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "ROL", nullable = false)
    private String rol;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHAEXPIRACION", nullable = false)
    private Date fechaExpiracion;
    @Column(name = "HABILITADO", nullable = false)
    private boolean habilitado;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Factura> facturas;

    public Usuario(int id, int cedula, String usuario, String contrasena, String confirmarContrasena, String correo, String telefono, String rol, Date fechaExpiracion, boolean habilitado, List<Factura> facturas) {
        this.id = id;
        this.cedula = cedula;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.confirmarContrasena = confirmarContrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.rol = rol;
        this.fechaExpiracion = fechaExpiracion;
        this.habilitado = habilitado;
        this.facturas = facturas;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmarContrasena() {
        return confirmarContrasena;
    }

    public void setConfirmarContrasena(String confirmarContrasena) {
        this.confirmarContrasena = confirmarContrasena;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", cedula=" + cedula + ", usuario=" + usuario + ", contrasena=" + contrasena + ", correo=" + correo + ", telefono=" + telefono + ", rol=" + rol + ", habilitado=" + habilitado + ", facturas=" + facturas + '}';
    }
}

