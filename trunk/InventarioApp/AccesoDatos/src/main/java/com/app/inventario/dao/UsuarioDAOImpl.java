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
import org.hibernate.criterion.Order;
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
        try {
            this.iniciaOperacion();
            //String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities
            User user = new User(usuario.getUsuario(), usuario.getContrasena(), true, true, true, true, new ArrayList());
            Object salt = saltSource.getSalt(user);
            usuario.setContrasena(messageDigestPasswordEncoder.encodePassword(usuario.getContrasena(), salt));
            session.save(usuario);
            tx.commit();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            he.printStackTrace();
            throw he;
        } finally {
            try {
                //session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                throw he;
            }
        }
    }

    @Override
    public void actualizar(Usuario usuario) {
        try {
            this.iniciaOperacion();
            User user = new User(usuario.getUsuario(), usuario.getContrasena(), true, true, true, true, new ArrayList());
            Object salt = saltSource.getSalt(user);
            usuario.setContrasena(messageDigestPasswordEncoder.encodePassword(usuario.getContrasena(), salt));
            session.update(usuario);
            tx.commit();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            he.printStackTrace();
            throw he;
        } finally {
            try {
                //session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                throw he;
            }
        }
    }

    @Override
    public void eliminar(Usuario usuario) {
        try {
            this.iniciaOperacion();
            session.delete(usuario);
            tx.commit();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            he.printStackTrace();
            throw he;
        } finally {
            try {
                //session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                throw he;
            }
        }
    }

    @Override
    public Usuario obtener(int id) {
        Usuario result = null;
        try {
            this.iniciaOperacion();
            result = (Usuario) session.get(Usuario.class, id);
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            he.printStackTrace();
            throw he;
        } finally {
            try {
                //session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                throw he;
            }
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
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            he.printStackTrace();
            throw he;
        } finally {
            try {
                //session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                throw he;
            }
        }
        return result;
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
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            tx.rollback();
            throw he;
        } finally {
            try {
                //session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                throw he;
            }
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
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            tx.rollback();
            throw he;
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
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        } finally {
            try {
                //session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                throw he;
            }
        }
        return result == null;
    }

    public Usuario obtenerUsuarioUsername(String username) {
        Usuario result = null;
        try {
            this.iniciaOperacion();
            Criteria criteria = session.createCriteria(Usuario.class).add(Restrictions.eq("usuario", username));
            result = (Usuario) criteria.uniqueResult();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        } finally {
            try {
                //session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
                throw he;
            }
        }
        result.setContrasena("");
        result.setConfirmarContrasena("");
        result.setFacturas(null);
        return result;
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
            throw he;
        } finally {
            try {
                //session.close();
            } catch (HibernateException he) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, he);
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
