/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.daointerface;

import java.util.List;

/**
 *
 * @author Erick
 */
public interface IDAO<T> {

    public void guardar(T objeto);

    public void actualizar(T objeto);

    public void eliminar(T objeto);

    public T obtener(int id);

    public List<T> obtenerTodos();
}
