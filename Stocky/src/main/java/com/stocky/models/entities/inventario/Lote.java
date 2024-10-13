package com.stocky.models.entities.inventario;

import com.stocky.models.entities.Entidad;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "lote")
public class Lote extends Entidad<Lote> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
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
                ", cantidadInicial=" + cantidadInicial +
                ", cantidadActual=" + cantidadActual +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaCaducidad=" + fechaCaducidad +
                ", precioUnitarioCompra=" + precioUnitarioCompra +
                '}';
    }

    @Override
    public int compareTo(Lote o) {
        //2 lotes son iguales si comparten instante de creacion y producto
        if(this.fechaEntrada.isEqual(o.fechaEntrada)&&this.getProducto().compareTo(o.getProducto())==0){
            return 0;
        }else return -1;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
