/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.servicio;

import com.app.inventario.entidades.Usuario;
import com.app.inventario.logica.UsuarioLogicaImpl;
import com.app.inventario.serviciointerface.IServicio;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Erick
 */
public class UsuarioServicioImpl implements IServicio<Usuario> {

    UsuarioLogicaImpl usuarioLogica;

    public int guardar(Usuario usuario) {
        return usuarioLogica.guardar(usuario);
    }

    public int actualizar(Usuario usuario) {
        return usuarioLogica.actualizar(usuario);
    }

    public int eliminar(Usuario usuario) {
        return usuarioLogica.eliminar(usuario);
    }

    public Usuario obtener(int id) {
        return usuarioLogica.obtener(id);
    }

    public List<Usuario> obtenerTodos() {
        return usuarioLogica.obtenerTodos();
    }
    
    public List<Usuario> obtenerListaTodos(){
        return usuarioLogica.obtenerListaTodos();
    }
    
    public boolean validarUsername(String username){
        return usuarioLogica.validarUsername(username);
    }

    public Usuario obtenerUsuarioUsername(String username){
        return usuarioLogica.obtenerUsuarioUsername(username);
    }
    
    public UsuarioLogicaImpl getUsuarioLogica() {
        return usuarioLogica;
    }

    public void setUsuarioLogica(UsuarioLogicaImpl usuarioLogica) {
        this.usuarioLogica = usuarioLogica;
    }
}
