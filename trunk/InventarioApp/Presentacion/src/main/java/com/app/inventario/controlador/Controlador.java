/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.inventario.controlador;

import com.app.inventario.entidades.*;
import com.app.inventario.servicio.UsuarioServicioImpl;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Erick
 */

@Controller
public class Controlador {
    
    UsuarioServicioImpl usuarioServicio;

    // Generales
   @RequestMapping(value = "/login")
    public ModelAndView devolverPantallaLogin(ModelMap model, HttpServletRequest request){
        return new ModelAndView("login");
    }
    
    @RequestMapping(value = "/logout")
    public ModelAndView devolverPantallaLogout(ModelMap model, HttpServletRequest request){
        return new ModelAndView("login");
    }
    
    @RequestMapping(value = "/principal")
    public ModelAndView devolverPantallaPrincipal(ModelMap model, HttpServletRequest request){
        return new ModelAndView("paginas/principal");
    }
    
    // Mantenimiento Usuario
    
    @RequestMapping(value = "/mantenimiento-usuario", method = RequestMethod.GET)
    public ModelAndView mantenimientoUsuarios(ModelMap model, HttpServletRequest request) {   
        ModelAndView mvc = new ModelAndView("paginas/mantenimiento-usuarios");
        mvc.addObject("usuario", new Usuario());
        mvc.addObject("usuario-modificar", new Usuario());
        return mvc;
    }
    
    @RequestMapping(value = "/agregar-usuario", method = RequestMethod.POST)
    public String agregarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioServicio.guardar(usuario);
        return "redirect:mantenimiento-usuario";
    }
    
    @RequestMapping(value = "/actualizar-usuario", method = RequestMethod.POST)
    public String actualizarUsuario(@ModelAttribute("usuario-modificar") Usuario usuario) {
        usuarioServicio.actualizar(usuario);
        return "redirect:mantenimiento-usuario";
    }
    
    @RequestMapping(value = "/cargar-usuarios", method = RequestMethod.GET)
    public @ResponseBody List<String> cargarUsuarios(HttpServletRequest request, HttpServletResponse response){
        List<Usuario> usuarios = usuarioServicio.obtenerTodos();
        List<String> usernames= new ArrayList<String>();
        for(Usuario u: usuarios){
            usernames.add(u.getUsuario());
        }
        return usernames;
    }
    
    @RequestMapping(value = "/buscar-usuario-username", method = RequestMethod.GET)
    public @ResponseBody Usuario obtenerUsuarioUsername(@RequestParam("nombreUsuario") String username){
        Usuario usuario = usuarioServicio.obtenerUsuarioUsername(username);
        return usuario;
    }
    
    @RequestMapping(value = "/validar-username", method = RequestMethod.POST)
    public @ResponseBody boolean validarUsername(HttpServletRequest request){
        String username = request.getParameter("usuario");
        return usuarioServicio.validarUsername(username);
    }
    
    // Mantenimiento Familias
    @RequestMapping(value = "/mantenimiento-familias", method = RequestMethod.GET)
    public ModelAndView mantenimientoFamilias(ModelMap model, HttpServletRequest request) {        
        return new ModelAndView("paginas/mantenimiento-familias", "familia", new Familia());
    }
    
    
    //Mantenimiento Proveedores
    @RequestMapping(value = "/mantenimiento-proveedor", method = RequestMethod.GET)
    public ModelAndView mantenimientoProveedores(ModelMap model, HttpServletRequest request) {
        ModelAndView mvc = new ModelAndView("paginas/mantenimiento-proveedor");
        mvc.addObject("proveedor", new Proveedor());
        mvc.addObject("proveedor-modificar", new Proveedor());
        return mvc;//();
    }
    
    public UsuarioServicioImpl getUsuarioServicio() {
        return usuarioServicio;
    }

    public void setUsuarioServicio(UsuarioServicioImpl usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }
    
}