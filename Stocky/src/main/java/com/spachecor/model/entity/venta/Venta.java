package com.spachecor.model.entity.venta;

import com.spachecor.model.entity.Entidad;
import com.spachecor.model.entity.inventario.Lote;
import com.spachecor.model.entity.personas.Cliente;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
public class Venta extends Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_lote")
    private Lote lote;
    private Double cantidad;
    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;
    @Column(name = "precio_venta_unitario")
    private Double precioVentaUnitario;
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_persona")
    private Cliente cliente;
    private String tipo;
    private String descripcion;

    public Venta() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", lote=" + lote +
                ", cantidad=" + cantidad +
                ", fechaVenta=" + fechaVenta +
                ", precioVentaUnitario=" + precioVentaUnitario +
                ", cliente=" + cliente +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
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

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getPrecioVentaUnitario() {
        return precioVentaUnitario;
    }

    public void setPrecioVentaUnitario(Double precioVentaUnitario) {
        this.precioVentaUnitario = precioVentaUnitario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
