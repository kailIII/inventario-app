/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.servicio;

import com.app.inventario.entidades.Usuario;
import com.app.inventario.entidades.jqGridModel;
import com.app.inventario.logica.UsuarioLogicaImpl;
import com.app.inventario.serviciointerface.IServicio;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Erick
 */
public class UsuarioServicioImpl implements IServicio<Usuario> {

    UsuarioLogicaImpl usuarioLogica;

    public void guardar(Usuario usuario) {
        try {
            usuarioLogica.guardar(usuario);
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    public void actualizar(Usuario usuario) {
        try {
            usuarioLogica.actualizar(usuario);
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    public void eliminar(Usuario usuario) {
        try {
            usuarioLogica.eliminar(usuario);
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    public Usuario obtener(int id) {
        try {
            return usuarioLogica.obtener(id);
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    public List<Usuario> obtenerTodos() {
        try {
            return usuarioLogica.obtenerTodos();
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    public jqGridModel obtenerListaTodos(int numeroPagina, int numeroFilas, String ordenarPor, String ordenarAsc) throws Exception {
        try {
            return usuarioLogica.obtenerListaTodos(numeroPagina, numeroFilas, ordenarPor, ordenarAsc);
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    public boolean validarUsername(String username) {
        try {
            return usuarioLogica.validarUsername(username);
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    public Usuario obtenerUsuarioUsername(String username) {
        try {
            return usuarioLogica.obtenerUsuarioUsername(username);
        } catch (HibernateException he) {
            he.printStackTrace();
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
