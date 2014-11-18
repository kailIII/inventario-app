/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.entidades.seguridad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author eperez
 */
@Entity
@Table(name = "INTENTOS")
public class IntentosLogin implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDINTENTO", nullable = false, unique = true)
    private int id;
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "CANTIDADINTENTOS")
    private int cantidadIntentos;
    @Column(name = "ULTIMOACCESO")
    private Date ultimoAcceso;
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public IntentosLogin(int id, String usuario, int cantidadIntentos, Date ultimoAcceso) {
        this.id = id;
        this.usuario = usuario;
        this.cantidadIntentos = cantidadIntentos;
        this.ultimoAcceso = ultimoAcceso;
    }

    public IntentosLogin() {
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos Getter">

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getCantidadIntentos() {
        return cantidadIntentos;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos Setter">

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setCantidadIntentos(int cantidadIntentos) {
        this.cantidadIntentos = cantidadIntentos;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }
    
    // </editor-fold>
}
