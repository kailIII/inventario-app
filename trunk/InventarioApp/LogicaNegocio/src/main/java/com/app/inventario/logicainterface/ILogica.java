/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.logicainterface;

import java.util.List;

/**
 *
 * @author Erick
 */
public interface ILogica<T> {

    public void guardar(T objeto) throws Exception;

    public void actualizar(T objeto) throws Exception;

    public void eliminar(T objeto) throws Exception;

    public T obtener(int id) throws Exception;

    public List<T> obtenerTodos() throws Exception;
}
