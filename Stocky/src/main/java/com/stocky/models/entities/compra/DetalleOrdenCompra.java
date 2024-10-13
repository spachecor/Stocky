package com.stocky.models.entities.compra;

import com.stocky.models.entities.Entidad;
import com.stocky.models.entities.inventario.Producto;
import jakarta.persistence.*;

@Entity
@Table(name = "detalleOrdenCompra")
public class DetalleOrdenCompra extends Entidad<DetalleOrdenCompra> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_orden_compra")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_orden_compra")
    private OrdenCompra ordenCompra;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    private Double cantidad;

    public DetalleOrdenCompra() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DetalleOrdenCompra{" +
                "id=" + id +
                ", ordenCompra=" + ordenCompra +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public int compareTo(DetalleOrdenCompra o) {
        //2 detalles de ordenes de compra son iguales si comparten la misma orden de compra y el mismo producto.
        //no puede haber 2 productos repetidos en una misma orden de compra
        if(this.getOrdenCompra().compareTo(o.getOrdenCompra()) == 0 && this.getProducto().compareTo(o.getProducto()) == 0){
            return 0;
        }else return -1;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
