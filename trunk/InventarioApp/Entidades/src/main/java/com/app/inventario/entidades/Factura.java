
package com.app.inventario.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Erick
 */
@Entity
@Table(name = "FACTURA")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDFACTURA", unique = true, nullable = false)
    private int id;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    private Date fecha;
    @Column(name = "NOMBRECLIENTE")
    private String nombreCliente;
    @Column(name = "TOTAL", nullable = false)
    private double total;
    @ManyToOne
    @JoinColumn(name = "IDUSUARIO", nullable = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "factura")
    private List<LineaFactura> lineasFactura;

    public Factura(int id, Date fecha, String nombreCliente, double total, Usuario usuario, List<LineaFactura> lineasFactura) {
        this.id = id;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.total = total;
        this.usuario = usuario;
        this.lineasFactura = lineasFactura;
    }

    public Factura() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<LineaFactura> getLineasFactura() {
        return lineasFactura;
    }

    public void setLineasFactura(List<LineaFactura> lineasFactura) {
        this.lineasFactura = lineasFactura;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", fecha=" + fecha + ", nombreCliente=" + nombreCliente + ", total=" + total + ", usuario=" + usuario + ", lineasFactura=" + lineasFactura + '}';
    }
}
