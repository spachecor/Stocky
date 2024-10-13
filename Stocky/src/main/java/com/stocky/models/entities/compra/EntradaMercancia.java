package com.stocky.models.entities.compra;

import com.stocky.models.entities.Entidad;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "entradaMercancia")
public class EntradaMercancia extends Entidad<EntradaMercancia> {
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

    @Override
    public int compareTo(EntradaMercancia o) {
        //2 entradas de mercancia son iguales si comparten el mismo instante de entrada y la misma orden de compra
        if(this.getFechaEntrada().isEqual(o.getFechaEntrada()) && this.getOrdenCompra().compareTo(o.getOrdenCompra()) == 0){
            return 0;
        }else return -1;
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
