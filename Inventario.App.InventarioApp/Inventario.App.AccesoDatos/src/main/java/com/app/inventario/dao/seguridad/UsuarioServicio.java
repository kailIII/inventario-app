/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.dao.seguridad;

import com.app.inventario.dao.UsuarioDAOImpl;
import com.app.inventario.entidades.seguridad.Usuario;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author eperez
 */
public class UsuarioServicio implements UserDetailsService {

    private UsuarioDAOImpl usuarioDAO;

    public UserDetails loadUserByUsername(String usuario) {
        try {
            Usuario usuarioAux = (Usuario) usuarioDAO.loadUserByUsername(usuario);
            return usuarioAux;
        } catch (UsernameNotFoundException unfe) {
            throw unfe;
        } catch (LockedException le) {
            throw le;
        } catch (BadCredentialsException bce) {
            throw bce;
        } catch (CredentialsExpiredException cee) {
            throw cee;
        } catch (DisabledException de) {
            throw de;
        }

    }

    public UsuarioDAOImpl getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAOImpl usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
