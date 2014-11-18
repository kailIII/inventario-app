/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.dao.seguridad;

import com.app.inventario.dao.UsuarioDAOImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


/**
 *
 * @author eperez
 */

public class UsuarioServicio implements UserDetailsService{

    private UsuarioDAOImpl usuarioDAO;

    public UsuarioDAOImpl getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAOImpl usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        return usuarioDAO.loadUserByUsername(usuario);
    }
    
}
