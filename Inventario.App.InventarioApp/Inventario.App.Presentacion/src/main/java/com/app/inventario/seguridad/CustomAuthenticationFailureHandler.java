/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.seguridad;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author eperez
 */
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        super.onAuthenticationFailure(request, response, exception);
        if (exception.getClass().isAssignableFrom(UsernameNotFoundException.class)) {
            System.out.println("Usuario no encontrado");
        } else if (exception.getClass().isAssignableFrom(DisabledException.class)) {
            System.out.println("Usuario Deshabilitado");
        } else if (exception.getClass().isAssignableFrom(LockedException.class)) {
            System.out.println("Usuario Bloqueado");
        } else if (exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
            System.out.println("Contraseña Incorrecta");
        } else if (exception.getClass().isAssignableFrom(CredentialsExpiredException.class)) {
            System.out.println("Contraseña expirada");
        }

    }
}
