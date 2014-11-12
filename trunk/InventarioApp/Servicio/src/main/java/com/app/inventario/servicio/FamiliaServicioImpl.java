/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.servicio;

import com.app.inventario.entidades.Familia;
import com.app.inventario.grid.jqGridModel;
import com.app.inventario.logica.FamiliaLogicaImpl;
import com.app.inventario.serviciointerface.IServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author eperez
 */
public class FamiliaServicioImpl implements IServicio<Familia> {
    
    FamiliaLogicaImpl familiaLogica;

    public void guardar(Familia familia) throws Exception {
        try {
            familiaLogica.guardar(familia);
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public void actualizar(Familia familia) throws Exception {
        try {
            familiaLogica.actualizar(familia);
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public void eliminar(Familia familia) throws Exception {
        try {
            familiaLogica.eliminar(familia);
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public Familia obtener(int id) throws Exception {
        try {
            return familiaLogica.obtener(id);
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public List<Familia> obtenerTodos() throws Exception {
        try {
            return familiaLogica.obtenerTodos();
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }
    
    public jqGridModel obtenerListaTodos(int numeroPagina, int numeroFilas, String ordenarPor, String ordenarAsc) throws Exception {
        try {
            return familiaLogica.obtenerListaTodos(numeroPagina, numeroFilas, ordenarPor, ordenarAsc);
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }
    
    public FamiliaLogicaImpl getFamiliaLogica() {
        return familiaLogica;
    }

    public void setFamiliaLogica(FamiliaLogicaImpl familiaLogica) {
        this.familiaLogica = familiaLogica;
    }
}
