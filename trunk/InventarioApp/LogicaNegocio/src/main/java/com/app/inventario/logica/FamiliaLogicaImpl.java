/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.logica;

import com.app.inventario.dao.FamiliaDAOImpl;
import com.app.inventario.entidades.Familia;
import com.app.inventario.grid.jqGridModel;
import com.app.inventario.logicainterface.ILogica;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eperez
 */
public class FamiliaLogicaImpl implements ILogica<Familia> {

    private FamiliaDAOImpl familiaDAO;
    private jqGridModel<Familia> modelo;

    @Transactional
    public void guardar(Familia familia) throws Exception {
        try {
            familiaDAO.guardar(familia);
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional
    public void actualizar(Familia familia) throws Exception {
        try {
            familiaDAO.actualizar(familia);
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional
    public void eliminar(Familia familia) throws Exception {
        try {
            familiaDAO.eliminar(familia);
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public Familia obtener(int id) throws Exception {
        try {
            Familia familia = familiaDAO.obtener(id);
            return familia;
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public List<Familia> obtenerTodos() throws Exception {
        try {
            List<Familia> familias = null;
            familias = familiaDAO.obtenerTodos();
            return familias;
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public jqGridModel obtenerListaTodos(int numeroPagina, int numeroFilas, String ordenarPor, String ordenarAsc) throws Exception {
        modelo = new jqGridModel<Familia>();
        int primerResultado = numeroFilas * (numeroPagina - 1);
        List<Familia> familias = null;
        try {
            familias = familiaDAO.obtenerTodosAGrid(ordenarPor, ordenarAsc);
            modelo.setPage(numeroPagina);
            modelo.setTotal((int) Math.ceil((double) familias.size() / (double) numeroFilas));
            modelo.setRecords(familias.size());
            modelo.setRows(familias.subList(primerResultado, numeroFilas > familias.size() ? familias.size() : numeroFilas));
            return modelo;
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public FamiliaDAOImpl getFamiliaDAO() {
        return familiaDAO;
    }

    public void setFamiliaDAO(FamiliaDAOImpl familiaDAO) {
        this.familiaDAO = familiaDAO;
    }
}
