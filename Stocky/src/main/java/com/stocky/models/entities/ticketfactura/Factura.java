package com.stocky.models.entities.ticketfactura;

import com.stocky.models.entities.Entidad;
import com.stocky.models.entities.personas.Cliente;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "id_factura")
public class Factura extends Entidad<Factura> {
    @Id
    @Column(name = "id_factura")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Cliente cliente;
    @Column(name = "fecha_factura")
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn(name = "id_impuesto")
    private Impuesto impuesto;
    @ManyToOne
    @JoinColumn(name = "id_descuento")
    private Descuento descuento;
    private String estado;

    public Factura() {}

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", fecha=" + fecha +
                ", impuesto=" + impuesto +
                ", descuento=" + descuento +
                ", estado='" + estado + '\'' +
                '}';
    }

    @Override
    public int compareTo(Factura o) {
        //2 facturas son iguales si comparten la misma fecha de factura y el mismo cliente
        if(this.getFecha().isEqual(o.getFecha()) && this.getCliente().compareTo(o.getCliente()) == 0){
            return 0;
        }else return -1;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
