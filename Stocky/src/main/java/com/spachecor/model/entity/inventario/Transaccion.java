package com.spachecor.model.entity.inventario;

import com.spachecor.model.entity.Entidad;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaccion")
public class Transaccion extends Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Integer id;
    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;
    private Double cantidad;
    @Column(name = "fecha_transaccion")
    private LocalDateTime fechaTransaccion;
    @ManyToOne
    @JoinColumn(name = "id_lote")
    private Lote lote;
    private String descripcion;

    public Transaccion() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "id=" + id +
                ", tipoTransaccion='" + tipoTransaccion + '\'' +
                ", cantidad=" + cantidad +
                ", fechaTransaccion=" + fechaTransaccion +
                ", lote=" + lote +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
