
package com.app.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Erick
 */
@Entity
@Table(name = "FAMILIA")
public class Familia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDFAMILIA", unique = true, nullable = false)
    private int id;
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    public Familia(int id, String descripcion, Producto producto) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Familia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Familia{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
}
