/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.logica;

import com.app.inventario.dao.ProveedorDAOImpl;
import com.app.inventario.entidades.Proveedor;
import com.app.inventario.logicainterface.ILogica;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Erick
 */
public class ProveedorLogicaImpl implements ILogica<Proveedor> {

    private ProveedorDAOImpl proveedorDAO;

    @Transactional
    public void guardar(Proveedor proveedor) {
        try {
            proveedorDAO.guardar(proveedor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    public void actualizar(Proveedor proveedor) {
        try {
            proveedorDAO.actualizar(proveedor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    public void eliminar(Proveedor proveedor) {
        try {
            proveedorDAO.eliminar(proveedor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional(readOnly = true)
    public Proveedor obtener(int id) {
        Proveedor proveedor = null;
        try {
            proveedor = proveedorDAO.obtener(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return proveedor;
    }

    @Transactional(readOnly = true)
    public List<Proveedor> obtenerTodos() {
        List<Proveedor> proveedores = null;
        try {
            proveedores = proveedorDAO.obtenerTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return proveedores;
    }

    @Transactional(readOnly = true)
    public Map<String, Object> obtenerListaTodos(int numeroPagina, int numeroFilas, String ordenarPor, String ordenarAsc) {
        int primerResultado = numeroFilas *(numeroPagina - 1);
        int totalPaginas = 0;
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<Proveedor> proveedores = null;
        try {
            proveedores = proveedorDAO.obtenerTodosAGrid(primerResultado, numeroFilas, ordenarPor, ordenarAsc);
            if(proveedores.size() > 0){
                totalPaginas = proveedores.size() / numeroFilas;
            }
            if(numeroPagina > totalPaginas){
                numeroPagina = totalPaginas;
            }
            map.put("page", numeroPagina);
            map.put("total", totalPaginas);
            map.put("records", proveedores.size());
            map.put("rows", proveedores);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }
    
    @Transactional(readOnly = true)
    public Proveedor obtenerProveedorNombre(String nombreProveedor) {
        Proveedor proveedor = null;
        try {
            proveedor = proveedorDAO.obtenerProveedorNombre(nombreProveedor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return proveedor;
    }

    public ProveedorDAOImpl getProveedorDAO() {
        return proveedorDAO;
    }

    public void setProveedorDAO(ProveedorDAOImpl proveedorDAO) {
        this.proveedorDAO = proveedorDAO;
    }
}
