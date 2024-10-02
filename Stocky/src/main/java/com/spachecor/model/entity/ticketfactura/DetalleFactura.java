package com.spachecor.model.entity.ticketfactura;

import com.spachecor.model.entity.Entidad;
import com.spachecor.model.entity.inventario.Lote;
import jakarta.persistence.*;

@Entity
@Table(name = "detalleFactura")
public class DetalleFactura extends Entidad {
    @Id
    @Column(name = "id_detalle_factura")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;
    @ManyToOne
    @JoinColumn(name = "id_lote")
    private Lote lote;
    private Double cantidad;
    @Column(name = "precio_unitario")
    private Double precioUnitario;

    public DetalleFactura() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
