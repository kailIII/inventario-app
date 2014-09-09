/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.dao;

import com.app.inventario.daointerface.IDAO;
import com.app.inventario.entidades.Proveedor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Erick
 */
public class ProveedorDAOImpl extends HibernateDaoSupport implements IDAO<Proveedor> {

    private Session session;
    private Transaction tx;

    @Override
    public void guardar(Proveedor proveedor) {
        try {
            this.iniciaOperacion();
            session.save(proveedor);
            tx.commit();
        } catch (HibernateException he) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            this.manejaExcepcion(he);
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
    }

    @Override
    public void actualizar(Proveedor proveedor) {
        try {
            this.iniciaOperacion();
            session.update(proveedor);
            tx.commit();
        } catch (HibernateException he) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            this.manejaExcepcion(he);
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
    }

    @Override
    public void eliminar(Proveedor proveedor) {
        try {
            this.iniciaOperacion();
            session.save(proveedor);
            tx.commit();
        } catch (HibernateException he) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            this.manejaExcepcion(he);
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
    }

    @Override
    public Proveedor obtener(int id) {
        Proveedor proveedor = null;
        try {
            this.iniciaOperacion();
            proveedor = (Proveedor) session.get(Proveedor.class, id);
        } catch (HibernateException he) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            this.manejaExcepcion(he);
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
        return proveedor;
    }

    @Override
    public List<Proveedor> obtenerTodos() {
        List proveedores = null;
        try {
            this.iniciaOperacion();
            proveedores = session.createQuery("FROM Proveedor").list();
        } catch (HibernateException he) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            this.manejaExcepcion(he);
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
        return proveedores;
    }

    public List<Proveedor> obtenerTodosAGrid(int primerResultado, int numeroFilas, String ordenarPor, String ordenarAsc) {
        List proveedores = null;
        try {
            this.iniciaOperacion();
            Criteria criteria = session.createCriteria(Proveedor.class);
            criteria.setFirstResult(primerResultado);
            criteria.setMaxResults(numeroFilas);
            if(ordenarAsc.equalsIgnoreCase("asc")){
                criteria.addOrder(Order.asc(ordenarPor));
            }
            else if(ordenarAsc.equalsIgnoreCase("desc")){
                criteria.addOrder(Order.desc(ordenarPor));
            }
            
            proveedores = criteria.list();
        } catch (HibernateException he) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            this.manejaExcepcion(he);
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
        return proveedores;
    }

    public Proveedor obtenerProveedorNombre(String nombreProveedor) {
        Proveedor proveedor = null;
        try {
            this.iniciaOperacion();
            Criteria criteria = session.createCriteria(Proveedor.class).add(Restrictions.eq("nombreProveedor", nombreProveedor));
            proveedor = (Proveedor) criteria.uniqueResult();
        } catch (HibernateException he) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            manejaExcepcion(he);
            throw he;
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
        return proveedor;
    }

    // Inicia una transaccion contra la base de datos.
    private void iniciaOperacion() throws HibernateException {
        session = this.getHibernateTemplate().getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    // Encargado de manejar las excepciones si ocurre algo cuando se conecta a la base de datos
    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

}
