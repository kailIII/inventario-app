/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.dao;

import com.app.inventario.daointerface.IDAO;
import com.app.inventario.entidades.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Erick
 */
public class UsuarioDAOImpl extends HibernateDaoSupport implements IDAO<Usuario>, UserDetailsService {

    private Session session;
    private Transaction tx;
    private MessageDigestPasswordEncoder messageDigestPasswordEncoder;
    private SaltSource saltSource;

    @Override
    public void guardar(Usuario usuario) {
        int id = 0;
        try {
            this.iniciaOperacion();
            //String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities
            User user = new User(usuario.getUsuario(), usuario.getContrasena(), true, true, true, true, new ArrayList());
            Object salt = saltSource.getSalt(user);
            usuario.setContrasena(messageDigestPasswordEncoder.encodePassword(usuario.getContrasena(), salt));
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, 3);
            usuario.setFechaExpiracion(calendar.getTime());
            session.save(usuario);
            id = 1;
            tx.commit();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            he.printStackTrace();
            id = -1;
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
    }

    @Override
    public void actualizar(Usuario usuario) {
        int id = 0;
        try {
            this.iniciaOperacion();
            User user = new User(usuario.getUsuario(), usuario.getContrasena(), true, true, true, true, new ArrayList());
            Object salt = saltSource.getSalt(user);
            usuario.setContrasena(messageDigestPasswordEncoder.encodePassword(usuario.getContrasena(), salt));
            session.update(usuario);
            id = 1;
            tx.commit();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            he.printStackTrace();
            id = -1;
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
    }

    @Override
    public void eliminar(Usuario usuario) {
        int id = 0;
        try {
            this.iniciaOperacion();
            session.delete(usuario);
            id = 1;
            tx.commit();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            he.printStackTrace();
            id = -1;
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
    }

    @Override
    public Usuario obtener(int id) {
        Usuario usuario = null;
        try {
            this.iniciaOperacion();
            usuario = (Usuario) session.get(Usuario.class, id);
        } catch (HibernateException he) {
            
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
        return usuario;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = null;
        try {
            this.iniciaOperacion();
            usuarios = session.createQuery("FROM Usuario").list();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            this.manejaExcepcion(he);
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
        return usuarios;
    }

    public boolean validarUsername(String username) {
        Usuario usuario = null;
        try {
            this.iniciaOperacion();
            Criteria criteria = session.createCriteria(Usuario.class).add(Restrictions.eq("usuario", username));
            usuario = (Usuario) criteria.uniqueResult();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            manejaExcepcion(he);
            throw he;
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
        return usuario == null;
    }

    public Usuario obtenerUsuarioUsername(String username) {
        Usuario usuario = null;
        try {
            this.iniciaOperacion();
            Criteria criteria = session.createCriteria(Usuario.class).add(Restrictions.eq("usuario", username));
            usuario = (Usuario) criteria.uniqueResult();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            manejaExcepcion(he);
            throw he;
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
        usuario.setContrasena("");
        usuario.setConfirmarContrasena("");
        usuario.setFacturas(null);
        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = null;
        UserDetails user = null;
        boolean expirado = true;
        try {
            this.iniciaOperacion();
            Criteria criteria = session.createCriteria(Usuario.class).add(Restrictions.eq("usuario", username));
            usuario = (Usuario) criteria.uniqueResult();
            Date fechaActual = Calendar.getInstance().getTime();
            expirado = !fechaActual.equals(usuario.getFechaExpiracion());
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(usuario.getRol()));
            user = new User(usuario.getUsuario(), usuario.getContrasena(), usuario.isHabilitado(), true, expirado, true, authorities);
            if (usuario == null) {
                throw new UsernameNotFoundException("Usuario no encontrado");
            }
            if (!user.isEnabled()) {
                throw new DisabledException("Usuario deshabilitado");
            }
            if (user.isCredentialsNonExpired() == false) {
                throw new CredentialsExpiredException("Contraseña expirada");
            }
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            manejaExcepcion(he);
            throw he;
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                manejaExcepcion(he);
                throw he;
            }
        }
        return user;
    }

    // Inicia una transaccion contra la base de datos.
    private void iniciaOperacion() throws HibernateException {
        session = this.getHibernateTemplate().getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    // Encargado de manejar las excepciones si ocurre algo cuando se conecta a la base de datos
    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("OcurriÃ³ un error en la capa de acceso a datos", he);
    }

    public void setMessageDigestPasswordEncoder(MessageDigestPasswordEncoder messageDigestPasswordEncoder) {
        this.messageDigestPasswordEncoder = messageDigestPasswordEncoder;
    }

    public void setSaltSource(SaltSource saltSource) {
        this.saltSource = saltSource;
    }


}
