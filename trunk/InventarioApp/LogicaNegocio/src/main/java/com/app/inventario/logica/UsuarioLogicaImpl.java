/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.logica;

import com.app.inventario.dao.UsuarioDAOImpl;
import com.app.inventario.entidades.Usuario;
import com.app.inventario.logicainterface.ILogica;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Erick
 */
public class UsuarioLogicaImpl implements ILogica<Usuario> {

    UsuarioDAOImpl usuarioDAO;

    @Transactional
    public void guardar(Usuario usuario) {
        try {
            usuarioDAO.guardar(usuario);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    public void actualizar(Usuario usuario) {
        try {
            usuarioDAO.actualizar(usuario);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    public void eliminar(Usuario usuario) {
        try {
            usuarioDAO.eliminar(usuario);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional(readOnly = true)
    public Usuario obtener(int id) {
        Usuario usuario = null;
        try {
            usuario = usuarioDAO.obtener(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuario;
    }

    @Transactional(readOnly = true)
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = null;
        try {
            usuarios = usuarioDAO.obtenerTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }
    
    @Transactional(readOnly = true)
    public boolean validarUsername(String username){
        boolean valido = false;
        try{
            valido = usuarioDAO.validarUsername(username);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return valido;
    }

    @Transactional(readOnly = true)
    public Usuario obtenerUsuarioUsername(String username){
        Usuario usuario = null;
        try{
            usuario = usuarioDAO.obtenerUsuarioUsername(username);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
    }
    
    public UsuarioDAOImpl getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAOImpl usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
