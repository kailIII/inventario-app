/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.controlador;

import com.app.inventario.entidades.*;
import com.app.inventario.servicio.ProveedorServicioImpl;
import com.app.inventario.servicio.UsuarioServicioImpl;
import java.security.Principal;
import java.util.*;
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
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

/**
 *
 * @author Erick
 */
@Controller
public class Controlador {

    UsuarioServicioImpl usuarioServicio;
    ProveedorServicioImpl proveedorServicio;

    private org.springframework.web.servlet.view.json.MappingJacksonJsonView jsonView = new MappingJacksonJsonView();

    // Generales
    @RequestMapping(value = "/login")
    public ModelAndView devolverPantallaLogin(ModelMap model, HttpServletRequest request) {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/logout")
    public ModelAndView devolverPantallaLogout(ModelMap model, HttpServletRequest request) {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/principal")
    public String devolverPantallaPrincipal(ModelMap model, Principal principal, HttpServletRequest request) {
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", principal.getName().toUpperCase());
        return "paginas/principal";
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
    public @ResponseBody
    Map agregarUsuario(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap();
        try {
            this.usuarioServicio.guardar(usuario);
            response.setStatus(HttpServletResponse.SC_OK);
            map.put("Status", "OK");
            map.put("Message", "Agregado Correctamente");
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            map.put("Status", "FAIL");
            map.put("Message", ex.getCause().getCause().getCause().getMessage());
        }
        return map;
    }

    @RequestMapping(value = "/actualizar-usuario", method = RequestMethod.POST)
    public String actualizarUsuario(@ModelAttribute("usuario-modificar") Usuario usuario) {
        usuarioServicio.actualizar(usuario);
        return "redirect:mantenimiento-usuario";
    }

    @RequestMapping(value = "/listar-usuarios", method = {RequestMethod.POST})
    public @ResponseBody
    jqGridModel obtenerTodosUsuarios(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int numeroPagina = Integer.parseInt(request.getParameter("page"));
        int numeroColumnas = Integer.parseInt(request.getParameter("rows"));
        String ordenarPor = request.getParameter("sidx");
        String ordenarAsc = request.getParameter("sord");
        jqGridModel result = usuarioServicio.obtenerListaTodos(numeroPagina, numeroColumnas, ordenarPor, ordenarAsc);
        return result;
    }

    @RequestMapping(value = "/cargar-usuarios", method = RequestMethod.GET)
    public @ResponseBody
    List<String> cargarUsuarios(HttpServletRequest request, HttpServletResponse response) {
        List<Usuario> usuarios = usuarioServicio.obtenerTodos();
        List<String> usernames = new ArrayList<String>();
        for (Usuario u : usuarios) {
            usernames.add(u.getUsuario());
        }
        return usernames;
    }

    @RequestMapping(value = "/buscar-usuario-username", method = RequestMethod.GET)
    public @ResponseBody
    Usuario obtenerUsuarioUsername(@RequestParam("nombreUsuario") String username) {
        Usuario usuario = usuarioServicio.obtenerUsuarioUsername(username);
        return usuario;
    }

    @RequestMapping(value = "/validar-username", method = RequestMethod.GET)
    public @ResponseBody
    boolean validarUsername(HttpServletRequest request) {
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

    @RequestMapping(value = "/agregar-proveedor", method = RequestMethod.POST)
    public @ResponseBody
    Map agregarProveedor(@ModelAttribute("proveedor") Proveedor proveedor, HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap();
        try {
            proveedorServicio.guardar(proveedor);
            response.setStatus(HttpServletResponse.SC_OK);
            map.put("Status", "OK");
            map.put("Message", "Agregado Correctamente");
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            map.put("Status", "FAIL");
            map.put("Message", ex.getCause().getCause().getCause().getMessage());
        }
        return map;
    }

    @RequestMapping(value = "/buscar-proveedor-nombre", method = RequestMethod.GET)
    public @ResponseBody
    Proveedor obtenerProveedorNombre(@RequestParam("nombreProveedor") String nombreProveedor) throws Exception {
        Proveedor proveedor = proveedorServicio.obtenerProveedorNombre(nombreProveedor);
        return proveedor;
    }

    @RequestMapping(value = "/actualizar-proveedor", method = RequestMethod.POST)
    public String actualizarProveedor(@ModelAttribute("proveedor-modificar") Proveedor proveedor) throws Exception {
        proveedorServicio.actualizar(proveedor);
        return "redirect:mantenimiento-proveedor";
    }

    @RequestMapping(value = "/listar-proveedores", method = {RequestMethod.POST})
    public @ResponseBody
    jqGridModel obtenerTodosProveedores(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int numeroPagina = Integer.parseInt(request.getParameter("page"));
        int numeroColumnas = Integer.parseInt(request.getParameter("rows"));
        String ordenarPor = request.getParameter("sidx");
        String ordenarAsc = request.getParameter("sord");
        //Map map = new HashMap();
        //jqGridModel proveedores = this.proveedorServicio.obtenerListaTodos(numeroPagina, numeroColumnas, ordenarPor, ordenarAsc);
        //map.put("rows", this.proveedorServicio.obtenerTodos());
        return this.proveedorServicio.obtenerListaTodos(numeroPagina, numeroColumnas, ordenarPor, ordenarAsc);
    }

    @RequestMapping(value = "/cargar-proveedores", method = RequestMethod.GET)
    public @ResponseBody
    String cargarProveedores(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Proveedor> proveedores = proveedorServicio.obtenerTodos();
        //return proveedores;
        String sb = "";
        for (Proveedor p : proveedores) {
            sb += "<option value=" + p.getId() + ">" + p.getNombreProveedor() + "</option>";
        }
        return sb;
    }

    public UsuarioServicioImpl getUsuarioServicio() {
        return usuarioServicio;
    }

    public void setUsuarioServicio(UsuarioServicioImpl usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    public ProveedorServicioImpl getProveedorServicio() {
        return proveedorServicio;
    }

    public void setProveedorServicio(ProveedorServicioImpl proveedorServicio) {
        this.proveedorServicio = proveedorServicio;
    }
}
