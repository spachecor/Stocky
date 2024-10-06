package com.spachecor.model.entity.ticketfactura;

import com.spachecor.model.entity.Entidad;
import com.spachecor.model.entity.personas.Cliente;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "id_factura")
public class Factura extends Entidad {
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
