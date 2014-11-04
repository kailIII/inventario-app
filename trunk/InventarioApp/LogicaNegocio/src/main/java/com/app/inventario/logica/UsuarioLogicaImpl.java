package com.app.inventario.logica;

import com.app.inventario.dao.UsuarioDAOImpl;
import com.app.inventario.entidades.Proveedor;
import com.app.inventario.entidades.Usuario;
import com.app.inventario.entidades.jqGridModel;
import com.app.inventario.logicainterface.ILogica;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Erick
 */
public class UsuarioLogicaImpl implements ILogica<Usuario> {

    UsuarioDAOImpl usuarioDAO;
    private jqGridModel<Usuario> modelo;

    @Transactional
    public void guardar(Usuario usuario) {
        try {
            usuarioDAO.guardar(usuario);
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    @Transactional
    public void actualizar(Usuario usuario) {
        try {
            usuarioDAO.actualizar(usuario);
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    @Transactional
    public void eliminar(Usuario usuario) {
        try {
            usuarioDAO.eliminar(usuario);
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public Usuario obtener(int id) {
        try {
            return usuarioDAO.obtener(id);
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public List<Usuario> obtenerTodos() {
        try {
            return usuarioDAO.obtenerTodos();
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public List<Usuario> obtenerListaTodos() {
        Map<String, Object> datos = new HashMap<String, Object>();
        List<Usuario> usuarios = null;
        try {
            return usuarioDAO.obtenerTodos();
        } catch (HibernateException he) {
            he.printStackTrace();
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
            for(Usuario u : modelo.getRows()){
                u.setFacturas(null);
            }
            return modelo;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
    
    @Transactional(readOnly = true)
    public boolean validarUsername(String username) {
        boolean valido = false;
        try {
            valido = usuarioDAO.validarUsername(username);
            return valido;
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    @Transactional(readOnly = true)
    public Usuario obtenerUsuarioUsername(String username) {
        try {
            return usuarioDAO.obtenerUsuarioUsername(username);
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    public UsuarioDAOImpl getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAOImpl usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
