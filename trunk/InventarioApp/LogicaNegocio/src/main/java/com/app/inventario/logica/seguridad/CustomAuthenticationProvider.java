/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.logica.seguridad;

import com.app.inventario.dao.seguridad.UsuarioServicio;
import com.app.inventario.entidades.seguridad.Usuario;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 *
 * @author eperez
 */

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private UsuarioServicio usuarioServicioAuth;

    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String nombreUsuario = auth.getName();
        String contrasena = auth.getCredentials().toString();
        Usuario usuario = (Usuario) usuarioServicioAuth.loadUserByUsername(nombreUsuario);
        if (usuario == null) {
            throw new BadCredentialsException("Usuario y/o contraseña incorrecta");
        }
        return new UsernamePasswordAuthenticationToken(nombreUsuario, contrasena, usuario.getAuthorities());
    }

    public boolean supports(Class<?> type) {
        return true;
    }

    public UsuarioServicio getUsuarioServicioAuth() {
        return usuarioServicioAuth;
    }

    public void setUsuarioServicioAuth(UsuarioServicio usuarioServicioAuth) {
        this.usuarioServicioAuth = usuarioServicioAuth;
    }
}
