/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author Erick
 */
@Entity
@Table(name = "PROVEEDOR")
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDPROVEEDOR", unique = true, nullable = false)
    private int id;
    @Column(name = "NOMBREPROVEEDOR", nullable = false)
    private String nombreProveedor;
    @Column(name = "CEDULAJURIDICA", unique=true, nullable = false)
    private String cedulaJuridica;
    @Column(name = "TELEFONO", nullable = false)
    private String telefono;
    @Column(name = "DIRECCION", nullable = false)
    private String direccion;

    public Proveedor(int id, String nombreProveedor, String cedulaJuridica, String telefono, String direccion) {
        this.id = id;
        this.nombreProveedor = nombreProveedor;
        this.cedulaJuridica = cedulaJuridica;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Proveedor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", nombreProveedor=" + nombreProveedor + ", cedulaJuridica=" + cedulaJuridica + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
}
