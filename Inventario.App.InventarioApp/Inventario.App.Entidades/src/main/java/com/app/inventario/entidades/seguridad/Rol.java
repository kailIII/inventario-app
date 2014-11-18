/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.entidades.seguridad;

import java.io.Serializable;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author eperez
 */

public class Rol implements Serializable, GrantedAuthority {

    
    private String descripcion;

    public Rol(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rol() {
    }
    
    public String getAuthority() {
        return this.descripcion;
    }
    
    public void setAuthority(String descripcion){
        this.descripcion = descripcion;
    }
}
