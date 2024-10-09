package com.spachecor.model.entity.ticketfactura;

import com.spachecor.model.entity.Entidad;
import com.spachecor.model.entity.personas.Cliente;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
public class Ticket extends Entidad<Ticket> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @Column(name = "fecha_ticket")
    private LocalDateTime fechaTicket;
    @ManyToOne
    @JoinColumn(name = "id_impuesto")
    private Impuesto impuesto;
    @ManyToOne
    @JoinColumn(name = "id_descuento")
    private Descuento descuento;
    @ManyToOne
    @JoinColumn(name = "id_metodo_pago")
    private MetodoPago metodoPago;
    private String estado;

    public Ticket() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", fechaTicket=" + fechaTicket +
                ", impuesto=" + impuesto +
                ", descuento=" + descuento +
                ", metodoPago=" + metodoPago +
                ", estado='" + estado + '\'' +
                '}';
    }

    @Override
    public int compareTo(Ticket o) {
        //2 tickets son iguales si comparten instante de compra y cliente
        if(this.getCliente().compareTo(o.getCliente()) == 0 && this.getFechaTicket().isEqual(o.getFechaTicket())){
            return 0;
        }else return -1;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaTicket() {
        return fechaTicket;
    }

    public void setFechaTicket(LocalDateTime fechaTicket) {
        this.fechaTicket = fechaTicket;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
