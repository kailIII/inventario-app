
package com.app.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Erick
 */
@Entity
@Table(name = "PRODUCTO")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDPRODUCTO", unique = true, nullable = false)
    private int id;
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;
    @Column(name = "PRECIO", nullable = false)
    private double precio;
    @Column(name = "CANTIDADSTOCK", nullable = false)
    private int cantidadStock;
    // Revisar cuando se ejecute si es necesario el CASCADE.
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "producto", cascade = CascadeType.PERSIST)
    private LineaFactura lineaFactura;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDFAMILIA")
    private Familia familia;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "IDPROVEEDOR")
    private Proveedor proveedor;
    
    public Producto(int id, String descripcion, double precio, int cantidadStock, LineaFactura lineaFactura, Familia familia, Proveedor proveedor) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.lineaFactura = lineaFactura;
        this.familia = familia;
        this.proveedor = proveedor;
    }
    
    public Producto(){}

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public LineaFactura getLineaFactura() {
        return lineaFactura;
    }

    public void setLineaFactura(LineaFactura lineaFactura) {
        this.lineaFactura = lineaFactura;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidadStock=" + cantidadStock + ", lineaFactura=" + lineaFactura + ", familia=" + familia + ", provedor=" + proveedor + '}';
    }
    
    
}
