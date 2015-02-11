/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.entidades.seguridad;

import com.app.inventario.entidades.Factura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Erick
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable, UserDetails {

    // <editor-fold defaultstate="collapsed" desc="Atributos">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDUSUARIO", unique = true)
    private int id;
    @Column(name = "CEDULA", unique = true, nullable = false)
    private int cedula;
    @Column(name = "USUARIO", unique = true, nullable = false)
    private String username;
    @Column(name = "CONTRASENA", nullable = false)
    private String password;
    @Transient
    private String confirmarContrasena;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "TELEFONO")
    private String telefono;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHAEXPIRACION", nullable = false)
    private Date fechaExpiracion;
    @Column(name = "ROL")
    private String rol;
    @Column(name = "HABILITADO")
    private boolean habilitado;
    @Column(name = "NOEXPIRADO")
    private boolean noExpirado;
    @Column(name = "NOBLOQUEADO")
    private boolean noBloqueado;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Factura> facturas;
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos Getter">
    public int getId() {
        return id;
    }

    public int getCedula() {
        return cedula;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
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

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }
    
    public String getRol(){
        return rol;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }
    
    public boolean isAccountNonExpired() {
        return this.noExpirado;
    }

    public boolean isAccountNonLocked() {
        return this.noBloqueado;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return this.habilitado;
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Rol> roles = new ArrayList<Rol>();
        roles.add(new Rol(this.rol));
        return roles;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos Setter">

    public void setId(int id) {
        this.id = id;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
    
    public void setRol(String rol){
        this.rol = rol;
    }

    public void setEnabled(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public void setAccountNonExpired(boolean noExpirado) {
        this.noExpirado = noExpirado;
    }

    public void setAccountNonLocked(boolean noBloqueado) {
        this.noBloqueado = noBloqueado;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
    
    //</editor-fold>
}
