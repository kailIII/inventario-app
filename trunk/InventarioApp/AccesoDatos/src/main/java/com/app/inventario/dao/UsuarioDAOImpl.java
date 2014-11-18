/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.dao;

import com.app.inventario.daointerface.IDAO;
import com.app.inventario.entidades.seguridad.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.core.userdetails.UserDetails;


/**
 *
 * @author Erick
 */

public class UsuarioDAOImpl extends HibernateDaoSupport implements IDAO<Usuario> {

    private Session session;
    private Transaction tx;

    @Override
    public void guardar(Usuario usuario) {
        try {
            this.iniciaOperacion();
            //String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities
            session.save(usuario);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
            // Cerrar la session
        }
    }

    @Override
    public void actualizar(Usuario usuario) {
        try {
            this.iniciaOperacion();
            session.update(usuario);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
            // Cerrar la session
        }
    }

    @Override
    public void eliminar(Usuario usuario) {
        try {
            this.iniciaOperacion();
            session.delete(usuario);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
            // Cerrar la session
        }
    }

    @Override
    public Usuario obtener(int id) {
        Usuario result = null;
        try {
            this.iniciaOperacion();
            result = (Usuario) session.get(Usuario.class, id);
        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
            // Cerrar la session
        }
        return result;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> result = null;
        try {
            this.iniciaOperacion();
            result = session.createQuery("FROM Usuario").list();
        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
            // Cerrar la session
        }
        return result;
    }
    
    public List<Usuario> obtenerNombresUsuarios() throws HibernateException {
        List<Usuario> lista = null;
        try{
            this.iniciaOperacion();
            Query consulta = session.createQuery("SELECT u.id, u.usuario FROM Usuario u");
            lista = consulta.list();
        }
        catch(HibernateException he){
            this.manejaExcepcion(he);
        }
        finally{
            // Cerrar la session
        }
        return lista;
    }
    
    public List<Usuario> obtenerTodosAGrid(String ordenarPor, String ordenarAsc) {
        List<Usuario> result = null;
        try {
            this.iniciaOperacion();
            Criteria criteria = session.createCriteria(Usuario.class);
            if (ordenarAsc.equalsIgnoreCase("asc")) {
                criteria.addOrder(Order.asc(ordenarPor));
            } else if (ordenarAsc.equalsIgnoreCase("desc")) {
                criteria.addOrder(Order.desc(ordenarPor));
            }
            result = criteria.list();
        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
            // Cerrar la session
        }
        return result;
    }
    
    /*public List<Proveedor> obtenerTodosAGrid(String ordenarPor, String ordenarAsc) {
        try {
            this.iniciaOperacion();
            Criteria criteria = session.createCriteria(Proveedor.class);
            if (ordenarAsc.equalsIgnoreCase("asc")) {
                criteria.addOrder(Order.asc(ordenarPor));
            } else if (ordenarAsc.equalsIgnoreCase("desc")) {
                criteria.addOrder(Order.desc(ordenarPor));
            }
            return criteria.list();
        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                throw he;
            }
        }
    }*/
    
    

    public boolean validarUsername(String username) {
        Usuario result = null;
        try {
            this.iniciaOperacion();
            Criteria criteria = session.createCriteria(Usuario.class).add(Restrictions.eq("usuario", username));
            result = (Usuario) criteria.uniqueResult();
        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
            // Cerrar la session
        }
        return result == null;
    }

    public Usuario obtenerUsuarioUsername(String username) {
        Usuario usuario = null;
        try {
            this.iniciaOperacion();
            Criteria criteria = session.createCriteria(Usuario.class).add(Restrictions.eq("usuario", username));
            usuario = (Usuario) criteria.uniqueResult();
        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
            // Cerrar la session
        }
        usuario.setContrasena("");
        usuario.setConfirmarContrasena("");
        usuario.setFacturas(null);
        return usuario;
    }

    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = null;
        try {
            this.iniciaOperacion();
            Criteria criteria = session.createCriteria(Usuario.class).add(Restrictions.eq("usuario", username));
            usuario = (Usuario) criteria.uniqueResult();
        } catch (HibernateException he) {
            this.manejaExcepcion(he);
        } finally {
        }
        return usuario;
    }

    // Inicia una transaccion contra la base de datos.
    private void iniciaOperacion() throws HibernateException {
        session = this.getHibernateTemplate().getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    // Encargado de manejar las excepciones si ocurre algo cuando se conecta a la base de datos
    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
        throw new HibernateException(he);
    }

}
