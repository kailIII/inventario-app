/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.logica.seguridad;

import com.app.inventario.dao.seguridad.IntentosLoginDAOImpl;
import com.app.inventario.entidades.seguridad.IntentosLogin;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author eperez
 */
public class IntentosLoginLogicaImpl {
    private IntentosLoginDAOImpl intentosLoginDAO;
    
    
    public void actualizarIntentosFallidos(String usuario) throws HibernateException {
        try{
            intentosLoginDAO.actualizarIntentosFallidos(usuario);
        }
        catch(HibernateException he){
            Logger.getLogger(IntentosLoginLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }
    
    public void resetearIntentosFallidos(String usuario) throws HibernateException {
        try{
            intentosLoginDAO.resetearIntentosFallidos(usuario);
        }
        catch(HibernateException he){
            Logger.getLogger(IntentosLoginLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }
    public IntentosLogin obtenerIntentoLogin(String usuario) throws HibernateException {
        try{
            return intentosLoginDAO.obtenerIntentoLogin(usuario);
        }
        catch(HibernateException he){
            Logger.getLogger(IntentosLoginLogicaImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public IntentosLoginDAOImpl getIntentosLoginDAO() {
        return intentosLoginDAO;
    }

    public void setIntentosLoginDAO(IntentosLoginDAOImpl intentosLoginDAO) {
        this.intentosLoginDAO = intentosLoginDAO;
    }
    
    
}
