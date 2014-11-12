/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.servicio;

import com.app.inventario.entidades.Usuario;
import com.app.inventario.grid.jqGridModel;
import com.app.inventario.logica.UsuarioLogicaImpl;
import com.app.inventario.serviciointerface.IServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Erick
 */
public class UsuarioServicioImpl implements IServicio<Usuario> {

    UsuarioLogicaImpl usuarioLogica;

    public void guardar(Usuario usuario) throws Exception {
        try {
            usuarioLogica.guardar(usuario);
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public void actualizar(Usuario usuario) throws Exception {
        try {
            usuarioLogica.actualizar(usuario);
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public void eliminar(Usuario usuario) throws Exception {
        try {
            usuarioLogica.eliminar(usuario);
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public Usuario obtener(int id) throws Exception {
        try {
            return usuarioLogica.obtener(id);
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public List<Usuario> obtenerTodos() throws Exception {
        try {
            return usuarioLogica.obtenerTodos();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public jqGridModel obtenerListaTodos(int numeroPagina, int numeroFilas, String ordenarPor, String ordenarAsc) throws Exception {
        try {
            return usuarioLogica.obtenerListaTodos(numeroPagina, numeroFilas, ordenarPor, ordenarAsc);
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public boolean validarUsername(String username) throws Exception {
        try {
            return usuarioLogica.validarUsername(username);
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public String obtenerNombresUsuario() throws Exception {
        try {
            return usuarioLogica.obtenerNombresUsuario();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public Usuario obtenerUsuarioUsername(String username) throws Exception {
        try {
            return usuarioLogica.obtenerUsuarioUsername(username);
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public UsuarioLogicaImpl getUsuarioLogica() {
        return usuarioLogica;
    }

    public void setUsuarioLogica(UsuarioLogicaImpl usuarioLogica) {
        this.usuarioLogica = usuarioLogica;
    }
}
