package com.stocky.models.entities.ticketfactura;

import com.stocky.models.entities.Entidad;
import com.stocky.models.entities.inventario.Lote;
import jakarta.persistence.*;

@Entity
@Table(name = "detalleFactura")
public class DetalleFactura extends Entidad<DetalleFactura> {
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
    public String toString() {
        return "DetalleFactura{" +
                "id=" + id +
                ", factura=" + factura +
                ", lote=" + lote +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }

    @Override
    public int compareTo(DetalleFactura o) {
        //2 detalles de factura son iguales si comparten la misma factura y el mismo lote
        if(this.getFactura().compareTo(o.getFactura()) == 0 && this.getLote().compareTo(o.getLote()) == 0){
            return 0;
        }else return -1;
    }

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
