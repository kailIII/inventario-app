/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.inventario.serviciointerface;

import java.util.List;

/**
 *
 * @author Erick
 */
public interface IServicio <T> {
    public int guardar(T objeto);

    public int actualizar(T objeto);

    public int eliminar(T objeto);

    public T obtener(int id);

    public List<T> obtenerTodos();
}
