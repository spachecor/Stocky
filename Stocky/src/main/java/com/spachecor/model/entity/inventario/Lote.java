package com.spachecor.model.entity.inventario;

import com.spachecor.model.entity.Entidad;
import com.spachecor.model.entity.personas.Proveedor;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "lote")
public class Lote extends Entidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;
    @Column(name = "cantidad_inicial")
    private Double cantidadInicial;
    @Column(name = "cantidad_actual")
    private Double cantidadActual;
    @Column(name = "fecha_entrada")
    private LocalDate fechaEntrada;
    @Column(name = "fecha_caducidad")
    private LocalDate fechaCaducidad;
    @Column(name = "precio_compra_unitario")
    private Double precioUnitarioCompra;

    public Lote() {}


    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "id=" + id +
                ", producto=" + producto +
                ", proveedor=" + proveedor +
                ", cantidadInicial=" + cantidadInicial +
                ", cantidadActual=" + cantidadActual +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaCaducidad=" + fechaCaducidad +
                ", precioUnitarioCompra=" + precioUnitarioCompra +
                '}';
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Double getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(Double cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public Double getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(Double cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Double getPrecioUnitarioCompra() {
        return precioUnitarioCompra;
    }

    public void setPrecioUnitarioCompra(Double precioUnitarioCompra) {
        this.precioUnitarioCompra = precioUnitarioCompra;
    }
}
