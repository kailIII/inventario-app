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

    // <editor-fold defaultstate="collapsed" desc="Atributos">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDUSUARIO", unique = true)
    private int id;
    @Column(name = "CEDULA", unique = true, nullable = false)
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
    @Column(name = "BLOQUEADO", nullable = false)
    private boolean bloqueado;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Factura> facturas;
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Usuario(int id, int cedula, String usuario, String contrasena, String confirmarContrasena, String correo, String telefono, String rol, Date fechaExpiracion, boolean habilitado, boolean bloqueado, List<Factura> facturas) {
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
        this.bloqueado = bloqueado;
        this.facturas = facturas;
    }

    public Usuario() {
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos Getter">
    public int getId() {
        return id;
    }

    public int getCedula() {
        return cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getConfirmarContrasena() {
        return confirmarContrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRol() {
        return rol;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }
    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos Setter">

    public void setId(int id) {
        this.id = id;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setConfirmarContrasena(String confirmarContrasena) {
        this.confirmarContrasena = confirmarContrasena;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
    
    
    
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos sobre escritos">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.cedula;
        hash = 97 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cedula != other.cedula) {
            return false;
        }
        if ((this.usuario == null) ? (other.usuario != null) : !this.usuario.equals(other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", cedula=" + cedula + ", usuario=" + usuario + ", contrasena=" + contrasena + ", confirmarContrasena=" + confirmarContrasena + ", correo=" + correo + ", telefono=" + telefono + ", rol=" + rol + ", fechaExpiracion=" + fechaExpiracion + ", habilitado=" + habilitado + ", bloqueado=" + bloqueado + ", facturas=" + facturas + '}';
    }
    // </editor-fold>

}
