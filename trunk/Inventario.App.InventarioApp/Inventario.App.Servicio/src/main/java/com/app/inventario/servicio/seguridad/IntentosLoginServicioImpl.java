/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.servicio.seguridad;

import com.app.inventario.entidades.seguridad.IntentosLogin;
import com.app.inventario.logica.seguridad.IntentosLoginLogicaImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author eperez
 */
public class IntentosLoginServicioImpl {
    
    private IntentosLoginLogicaImpl intentosLoginLogica = new IntentosLoginLogicaImpl();

    
    public void actualizarIntentosFallidos(String usuario) throws HibernateException {
        try{
            intentosLoginLogica.actualizarIntentosFallidos(usuario);
        }
        catch(HibernateException he){
            Logger.getLogger(IntentosLoginServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }
    
    public void resetearIntentosFallidos(String usuario) throws HibernateException {
        try{
            intentosLoginLogica.resetearIntentosFallidos(usuario);
        }
        catch(HibernateException he){
            Logger.getLogger(IntentosLoginServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }
    public IntentosLogin obtenerIntentoLogin(String usuario) throws HibernateException {
        try{
            return intentosLoginLogica.obtenerIntentoLogin(usuario);
        }
        catch(HibernateException he){
            Logger.getLogger(IntentosLoginServicioImpl.class.getName()).log(Level.SEVERE, null, he);
            throw he;
        }
    }

    public IntentosLoginLogicaImpl getIntentosLoginLogica() {
        return intentosLoginLogica;
    }

    public void setIntentosLoginLogica(IntentosLoginLogicaImpl intentosLoginLogica) {
        this.intentosLoginLogica = intentosLoginLogica;
    }
    
    
}
