/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.dao.seguridad;

import com.app.inventario.entidades.seguridad.IntentosLogin;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author eperez
 */
public class IntentosLoginDAOImpl extends HibernateDaoSupport {

    private Session session;
    private Transaction tx;

    public void actualizarIntentosFallidos(String usuario) throws HibernateException {
        try {
            this.iniciaOperacion();
            IntentosLogin intento = this.obtenerIntentoLogin(usuario);
            if (intento == null) {
                IntentosLogin intentoAux = new IntentosLogin(usuario, 1, new Date());
                session.save(intentoAux);
            } else {
                if (intento.getCantidadIntentos() < 3) {
                    Query query = session.createQuery("UPDATE IntentosLogin SET cantidadIntentos = :cantidadIntentos, ultimoAcceso = :ultimoAcceso  WHERE usuario = :username");
                    query.setInteger("cantidadIntentos", intento.getCantidadIntentos() + 1);
                    query.setDate("ultimoAcceso", new Date());
                    query.setString("username", usuario);
                    query.executeUpdate();
                }
                else if(intento.getCantidadIntentos() + 1 == 3){
                    Query query = session.createQuery("UPDATE Usuario SET noBloqueado = false WHERE username = :usuario");
                    query.setParameter("usuario", intento.getUsuario());
                    query.executeUpdate();
                }
            }
        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
        }
    }

    public void resetearIntentosFallidos(String usuario) throws HibernateException {
        try {
            this.iniciaOperacion();
            //session.save(intento);
        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
        }
    }

    public IntentosLogin obtenerIntentoLogin(String usuario) throws HibernateException {
        try {
            this.iniciaOperacion();
            Query query = session.createQuery("FROM IntentosLogin il WHERE il.usuario = :username ");
            query.setParameter("username", usuario);
            IntentosLogin intentos = (IntentosLogin) query.list().get(0);
            return intentos;
        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
        }
        return null;
    }

    private boolean usuarioExiste(String usuario) throws HibernateException {
        try {
            this.iniciaOperacion();

        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
        }
        return false;
    }

    // Inicia una transaccion contra la base de datos.
    private void iniciaOperacion() throws HibernateException {
        session = this.getHibernateTemplate().getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    // Encargado de manejar las excepciones si ocurre algo cuando se conecta a la base de datos
    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        Logger.getLogger(IntentosLoginDAOImpl.class.getName()).log(Level.SEVERE, null, he);
        throw new HibernateException(he);
    }

}
