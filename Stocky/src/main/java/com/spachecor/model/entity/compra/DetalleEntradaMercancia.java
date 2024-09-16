package com.spachecor.model.entity.compra;

import com.spachecor.model.entity.Entidad;
import com.spachecor.model.entity.inventario.Lote;
import com.spachecor.model.entity.inventario.Transaccion;
import jakarta.persistence.*;

@Entity
@Table(name = "detalleEntradaMercancia")
public class DetalleEntradaMercancia extends Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_entrada_mercancia")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_entrada_mercancia")
    private EntradaMercancia entradaMercancia;
    @ManyToOne
    @JoinColumn(name = "id_transaccion")
    private Transaccion transaccion;

    public DetalleEntradaMercancia() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DetalleEntradaMercancia{" +
                "id=" + id +
                ", entradaMercancia=" + entradaMercancia +
                ", transaccion=" + transaccion +
                '}';
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public EntradaMercancia getEntradaMercancia() {
        return entradaMercancia;
    }

    public void setEntradaMercancia(EntradaMercancia entradaMercancia) {
        this.entradaMercancia = entradaMercancia;
    }
}
