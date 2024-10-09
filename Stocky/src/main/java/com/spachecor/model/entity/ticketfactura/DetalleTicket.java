package com.spachecor.model.entity.ticketfactura;

import com.spachecor.model.entity.Entidad;
import com.spachecor.model.entity.inventario.Lote;
import jakarta.persistence.*;

@Entity
@Table(name = "detalleTicket")
public class DetalleTicket extends Entidad<DetalleTicket> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_ticket")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_ticket")
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(name = "id_lote")
    private Lote lote;
    private Double cantidad;
    @Column(name = "precio_unitario")
    private Double precioUnitario;

    public DetalleTicket() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DetalleTicket{" +
                "id=" + id +
                ", ticket=" + ticket +
                ", lote=" + lote +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }

    @Override
    public int compareTo(DetalleTicket o) {
        //2 detalles de ticket son iguales si comparten el mismo ticket y el mismo lote
        if(this.getTicket().compareTo(o.getTicket()) == 0 && this.getLote().compareTo(o.getLote()) == 0){
            return 0;
        }else return -1;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
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
