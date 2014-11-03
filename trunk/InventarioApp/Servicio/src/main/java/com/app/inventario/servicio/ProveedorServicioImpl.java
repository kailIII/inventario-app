/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.servicio;

import com.app.inventario.entidades.Proveedor;
import com.app.inventario.entidades.jqGridModel;
import com.app.inventario.logica.ProveedorLogicaImpl;
import com.app.inventario.serviciointerface.IServicio;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Erick
 */
public class ProveedorServicioImpl implements IServicio<Proveedor> {

    ProveedorLogicaImpl proveedorLogica;

    public void guardar(Proveedor proveedor) throws Exception {
        try {
            proveedorLogica.guardar(proveedor);
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    public void actualizar(Proveedor proveedor) throws Exception {
        try {
            proveedorLogica.actualizar(proveedor);
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    public void eliminar(Proveedor proveedor) throws Exception {
        try {
            proveedorLogica.eliminar(proveedor);
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    public Proveedor obtener(int id) throws Exception {
        try {
            return proveedorLogica.obtener(id);
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    public List<Proveedor> obtenerTodos() throws Exception {
        try {
            return proveedorLogica.obtenerTodos();
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    public String obtenerListaTodosXML(int numeroPagina, int numeroFilas, String ordenarPor, String ordenarAsc) throws Exception {
        try {
            String datos = proveedorLogica.obtenerListaTodosXML(numeroPagina, numeroFilas, ordenarPor, ordenarAsc);
            return datos;
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    public jqGridModel obtenerListaTodos(int numeroPagina, int numeroFilas, String ordenarPor, String ordenarAsc) throws Exception {
        try {
            return proveedorLogica.obtenerListaTodos(numeroPagina, numeroFilas, ordenarPor, ordenarAsc);
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    public Proveedor obtenerProveedorNombre(String nombreProveedor) throws Exception {
        try {
            return proveedorLogica.obtenerProveedorNombre(nombreProveedor);
        } catch (HibernateException ex) {
            throw ex;
        }
    }

    public ProveedorLogicaImpl getProveedorLogica() {
        return proveedorLogica;
    }

    public void setProveedorLogica(ProveedorLogicaImpl proveedorLogica) {
        this.proveedorLogica = proveedorLogica;
    }
}
