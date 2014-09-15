/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.inventario.servicio;

import com.app.inventario.entidades.Proveedor;
import com.app.inventario.logica.ProveedorLogicaImpl;
import com.app.inventario.serviciointerface.IServicio;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Erick
 */
public class ProveedorServicioImpl implements IServicio<Proveedor> {

    ProveedorLogicaImpl proveedorLogica;

    public int guardar(Proveedor proveedor) {
        return proveedorLogica.guardar(proveedor);
    }

    public int actualizar(Proveedor proveedor) {
        return proveedorLogica.actualizar(proveedor);
    }

    public int eliminar(Proveedor proveedor) {
        return proveedorLogica.eliminar(proveedor);
    }

    public Proveedor obtener(int id) {
        return proveedorLogica.obtener(id);
    }

    public List<Proveedor> obtenerTodos() {
        return proveedorLogica.obtenerTodos();
    }
    
    public String obtenerListaTodos(int numeroPagina, int numeroFilas, String ordenarPor, String ordenarAsc){
        String datos = proveedorLogica.obtenerListaTodos(numeroPagina, numeroFilas, ordenarPor, ordenarAsc);
        return datos;
    }
    
    /*public jqGridModel obtenerListaTodos(int numeroPagina, int numeroFilas, String ordenarPor, String ordenarAsc){
        return proveedorLogica.obtenerListaTodos(numeroPagina, numeroFilas, ordenarPor, ordenarAsc);
    }*/
    
    public Proveedor obtenerProveedorNombre(String nombreProveedor){
        return proveedorLogica.obtenerProveedorNombre(nombreProveedor);
    }
    
    public ProveedorLogicaImpl getProveedorLogica() {
        return proveedorLogica;
    }

    public void setProveedorLogica(ProveedorLogicaImpl proveedorLogica) {
        this.proveedorLogica = proveedorLogica;
    }
}
