
package com.app.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Erick
 */
@Entity
@Table(name = "LINEAFACTURA")
public class LineaFactura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDLINEAFACTURA", unique = true, nullable = false)
    private int id;
    @Column(name = "CANTIDAD", nullable = false)
    private int cantidadProductos;
    @Column(name = "TOTALLINEA", nullable = false)
    private double totalLinea;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPRODUCTO", nullable = false)
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "IDFACTURA", nullable = false)
    private Factura factura;

    public LineaFactura(int id, int cantidadProductos, double totalLinea, Producto producto, Factura factura) {
        this.id = id;
        this.cantidadProductos = cantidadProductos;
        this.totalLinea = totalLinea;
        this.producto = producto;
        this.factura = factura;
    }

    public LineaFactura() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public double getTotalLinea() {
        return totalLinea;
    }

    public void setTotalLinea(double totalLinea) {
        this.totalLinea = totalLinea;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "LineaFactura{" + "id=" + id + ", cantidadProductos=" + cantidadProductos + ", totalLinea=" + totalLinea + ", producto=" + producto + ", factura=" + factura + '}';
    }
}
