/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.inventario.dao;

/**
 *
 * @author Erick
 */
import com.app.inventario.daointerface.IDAO;
import com.app.inventario.entidades.Familia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class FamiliaDAOImpl extends HibernateDaoSupport implements IDAO<Familia> {

    private Session session;
    private Transaction tx;

    @Override
    public void guardar(Familia familia) {
        try {
            this.iniciaOperacion();
            session.save(familia);
            tx.commit();
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            this.manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    @Override
    public void actualizar(Familia familia) {
        try {
            this.iniciaOperacion();
            session.saveOrUpdate(familia);
            tx.commit();
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            this.manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    @Override
    public void eliminar(Familia familia) {
        try {
            this.iniciaOperacion();
            session.delete(familia);
            tx.commit();
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            this.manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    @Override
    public Familia obtener(int id) {
        Familia familia = null;
        try {
            this.iniciaOperacion();
            familia = (Familia) session.get(Familia.class, id);
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            this.manejaExcepcion(he);
        } finally {
            session.close();
        }
        return familia;
    }

    @Override
    public List<Familia> obtenerTodos() {
        List<Familia> familias = null;
        try {
            this.iniciaOperacion();
            familias = session.createQuery("from familia").list();
        } catch (HibernateException he) {
            Logger.getLogger(FamiliaDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            this.manejaExcepcion(he);
        } finally {
            session.close();
        }
        return familias;
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
