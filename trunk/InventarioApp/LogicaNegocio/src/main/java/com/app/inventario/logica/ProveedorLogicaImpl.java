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
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Erick
 */
public class ProveedorLogicaImpl implements ILogica<Proveedor> {

    private ProveedorDAOImpl proveedorDAO;
    private jqGridModel<Proveedor> modelo;

    @Transactional
    public void guardar(Proveedor proveedor) throws Exception {
        try {
            proveedorDAO.guardar(proveedor);
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    @Transactional
    public void actualizar(Proveedor proveedor) throws Exception {
        try {
            proveedorDAO.actualizar(proveedor);
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    @Transactional
    public void eliminar(Proveedor proveedor) throws Exception {
        try {
            proveedorDAO.eliminar(proveedor);
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    @Transactional(readOnly = true)
    public Proveedor obtener(int id) throws Exception {
        try {
            Proveedor proveedor = proveedorDAO.obtener(id);
            return proveedor;
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    @Transactional(readOnly = true)
    public List<Proveedor> obtenerTodos() throws Exception {
        try {
            List<Proveedor> proveedores = null;
            proveedores = proveedorDAO.obtenerTodos();
            return proveedores;
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    @Transactional(readOnly = true)
    public Proveedor obtenerProveedorNombre(String nombreProveedor) {
        try {
            Proveedor proveedor = null;
            proveedor = proveedorDAO.obtenerProveedorNombre(nombreProveedor);
            return proveedor;
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    @Transactional(readOnly = true)
    public String obtenerListaTodosXML(int numeroPagina, int numeroFilas, String ordenarPor, String ordenarAsc) throws Exception {
        XStream xstream = new XStream();
        xstream.alias("root", jqGridModel.class);
        xstream.alias("proveedor", Proveedor.class);
        modelo = new jqGridModel<Proveedor>();
        int primerResultado = numeroFilas * (numeroPagina - 1);
        List<Proveedor> proveedores = null;
        try {
            proveedores = proveedorDAO.obtenerTodosAGrid(ordenarPor, ordenarAsc);
            modelo.setPage(numeroPagina);
            modelo.setTotal((int) Math.ceil((double) proveedores.size() / (double) numeroFilas));
            modelo.setRecords(proveedores.size());
            modelo.setRows(proveedores.subList(primerResultado, numeroFilas > proveedores.size() ? proveedores.size() : numeroFilas));
            return xstream.toXML(modelo);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        //return map;
    }

    @Transactional(readOnly = true)
    public jqGridModel obtenerListaTodos(int numeroPagina, int numeroFilas, String ordenarPor, String ordenarAsc) throws Exception {
        modelo = new jqGridModel<Proveedor>();
        int primerResultado = numeroFilas * (numeroPagina - 1);
        List<Proveedor> proveedores = null;
        try {
            proveedores = proveedorDAO.obtenerTodosAGrid(ordenarPor, ordenarAsc);
            modelo.setPage(numeroPagina);
            modelo.setTotal((int) Math.ceil((double) proveedores.size() / (double) numeroFilas));
            modelo.setRecords(proveedores.size());
            modelo.setRows(proveedores.subList(primerResultado, numeroFilas > proveedores.size() ? proveedores.size() : numeroFilas));
            return modelo;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public ProveedorDAOImpl getProveedorDAO() {
        return proveedorDAO;
    }

    public void setProveedorDAO(ProveedorDAOImpl proveedorDAO) {
        this.proveedorDAO = proveedorDAO;
    }
}
