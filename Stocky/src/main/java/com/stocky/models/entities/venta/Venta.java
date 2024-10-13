package com.stocky.models.entities.venta;

import com.stocky.models.entities.Entidad;
import com.stocky.models.entities.inventario.Lote;
import com.stocky.models.entities.personas.Cliente;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
public class Venta extends Entidad<Venta> {
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

    @Override
    public int compareTo(Venta o) {
        //2 ventas son iguales si comparten el mismo lote, instante de venta y cliente(existe el cliente generic, no cliente)
        if(this.getLote().compareTo(o.getLote()) == 0 && this.getFechaVenta().isEqual(o.getFechaVenta())
        && this.getCliente().compareTo(o.getCliente()) == 0){
            return 0;
        }else return -1;
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
