package com.spachecor.model.entity.compra;

import com.spachecor.model.entity.Entidad;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "entradaMercancia")
public class EntradaMercancia extends Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada_mercancia")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_orden_compra")
    private OrdenCompra ordenCompra;
    @Column(name = "fecha_entrada")
    private LocalDateTime fechaEntrada;

    public EntradaMercancia() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "EntradaMercancia{" +
                "id=" + id +
                ", ordenCompra=" + ordenCompra +
                ", fechaEntrada=" + fechaEntrada +
                '}';
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
}
