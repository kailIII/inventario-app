package com.app.inventario.logica;

import com.app.inventario.dao.UsuarioDAOImpl;
import com.app.inventario.entidades.Usuario;
import com.app.inventario.grid.jqGridModel;
import com.app.inventario.logicainterface.ILogica;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Erick
 */
public class UsuarioLogicaImpl implements ILogica<Usuario> {

    UsuarioDAOImpl usuarioDAO;
    private jqGridModel<Usuario> modelo;
    private MessageDigestPasswordEncoder messageDigestPasswordEncoder;
    private SaltSource saltSource;

    @Transactional
    public void guardar(Usuario usuario) throws Exception {
        try {
            User user = new User(usuario.getUsuario(), usuario.getContrasena(), true, true, true, true, new ArrayList());
            Object salt = saltSource.getSalt(user);
            usuario.setContrasena(messageDigestPasswordEncoder.encodePassword(usuario.getContrasena(), salt));
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, 3);
            usuario.setFechaExpiracion(calendar.getTime());
            usuarioDAO.guardar(usuario);
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional
    public void actualizar(Usuario usuario) throws Exception {
        try {
            User user = new User(usuario.getUsuario(), usuario.getContrasena(), true, true, true, true, new ArrayList());
            Object salt = saltSource.getSalt(user);
            usuario.setContrasena(messageDigestPasswordEncoder.encodePassword(usuario.getContrasena(), salt));
            usuarioDAO.actualizar(usuario);
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional
    public void eliminar(Usuario usuario) throws Exception {
        try {
            usuarioDAO.eliminar(usuario);
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public Usuario obtener(int id) throws Exception {
        try {
            return usuarioDAO.obtener(id);
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public List<Usuario> obtenerTodos() throws Exception {
        try {
            return usuarioDAO.obtenerTodos();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public List<Usuario> obtenerListaTodos() throws Exception {
        try {
            return usuarioDAO.obtenerTodos();
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public List<Usuario> obtenerNombresUsuario() throws HibernateException {
        try {
            List lista = usuarioDAO.obtenerNombresUsuarios();
            List<Usuario> usuarios = new ArrayList<Usuario>();
            Usuario u;
            for (Object o : lista.toArray()) {
                u = new Usuario();
                u.setId(Integer.parseInt(Array.get(o, 0).toString()));
                u.setUsuario(Array.get(o, 1).toString());
                usuarios.add(u);
            }
            return usuarios;
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public jqGridModel obtenerListaTodos(int numeroPagina, int numeroFilas, String ordenarPor, String ordenarAsc) throws Exception {
        modelo = new jqGridModel<Usuario>();
        int primerResultado = numeroFilas * (numeroPagina - 1);
        List<Usuario> usuarios = null;
        try {
            usuarios = usuarioDAO.obtenerTodosAGrid(ordenarPor, ordenarAsc);
            modelo.setPage(numeroPagina);
            modelo.setTotal((int) Math.ceil((double) usuarios.size() / (double) numeroFilas));
            modelo.setRecords(usuarios.size());
            modelo.setRows(usuarios.subList(primerResultado, numeroFilas > usuarios.size() ? usuarios.size() : numeroFilas));
            for (Usuario u : modelo.getRows()) {
                u.setFacturas(null);
            }
            return modelo;
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public boolean validarUsername(String username) throws Exception {
        boolean valido = false;
        try {
            valido = usuarioDAO.validarUsername(username);
            return valido;
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public Usuario obtenerUsuarioUsername(String username) throws Exception {
        try {
            return usuarioDAO.obtenerUsuarioUsername(username);
        } catch (HibernateException he) {
            Logger.getLogger(UsuarioLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public UsuarioDAOImpl getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAOImpl usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void setMessageDigestPasswordEncoder(MessageDigestPasswordEncoder messageDigestPasswordEncoder) {
        this.messageDigestPasswordEncoder = messageDigestPasswordEncoder;
    }

    public void setSaltSource(SaltSource saltSource) {
        this.saltSource = saltSource;
    }
}
