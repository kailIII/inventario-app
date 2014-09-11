/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.logica;

import com.app.inventario.dao.ProveedorDAOImpl;
import com.app.inventario.entidades.Proveedor;
import com.app.inventario.entidades.jqGridModel;
import com.app.inventario.logicainterface.ILogica;
import com.thoughtworks.xstream.XStream;
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
    private jqGridModel<Proveedor> modelo;

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
    public String obtenerListaTodos(int numeroPagina, int numeroFilas, String ordenarPor, String ordenarAsc) {
        XStream xstream = new XStream();
        xstream.alias("root", jqGridModel.class);
        xstream.alias("proveedor", Proveedor.class);
        modelo = new jqGridModel<Proveedor>();
        int primerResultado = numeroFilas *(numeroPagina - 1);
        int totalPaginas = 0;
        List<Proveedor> proveedores = null;
        try {
            proveedores = proveedorDAO.obtenerTodosAGrid(primerResultado, numeroFilas, ordenarPor, ordenarAsc);
            if(proveedores.size() > 0){
                totalPaginas = Math.round(proveedores.size() / numeroFilas);
            }
            if(numeroPagina > totalPaginas){
                numeroPagina = totalPaginas;
            }
            modelo.setPage(1);
            modelo.setTotal(1);
            modelo.setRecords(proveedores.size());
            modelo.setRows(proveedores);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return xstream.toXML(modelo);
        //return map;
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
