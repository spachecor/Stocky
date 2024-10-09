package com.spachecor.model.entity.compra;

import com.spachecor.model.entity.Entidad;
import com.spachecor.model.entity.personas.Proveedor;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordenCompra")
public class OrdenCompra extends Entidad<OrdenCompra> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_compra")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;
    @Column(name = "fecha_orden")
    private LocalDateTime fechaOrden;
    @Column(name = "fecha_estimada_recepcion")
    private LocalDate fechaEstimadaRecepcion;
    private String estado;

    public OrdenCompra() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OrdenCompra{" +
                "id=" + id +
                ", proveedor=" + proveedor +
                ", fechaOrden=" + fechaOrden +
                ", fechaEstimadaRecepcion=" + fechaEstimadaRecepcion +
                ", estado='" + estado + '\'' +
                '}';
    }

    @Override
    public int compareTo(OrdenCompra o) {
        //2 ordenes de compra son iguales si comparten el mismo instante de creacion
        return this.getFechaOrden().compareTo(o.getFechaOrden());
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDateTime getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(LocalDateTime fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public LocalDate getFechaEstimadaRecepcion() {
        return fechaEstimadaRecepcion;
    }

    public void setFechaEstimadaRecepcion(LocalDate fechaEstimadaRecepcion) {
        this.fechaEstimadaRecepcion = fechaEstimadaRecepcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
