package com.stocky.models.entities.inventario;

import com.stocky.models.entities.Entidad;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventario")
public class Inventario extends Entidad<Inventario> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_lote")
    private Lote lote;
    @ManyToOne
    @JoinColumn(name = "id_ubicacion")
    private Ubicacion ubicacion;
    @Column(name = "cantidad_disponible")
    private Double cantidadDisponible;
    @Column(name = "fecha_entrada")
    private LocalDate fechaEntrada;
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public Inventario() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "id=" + id +
                ", lote=" + lote +
                ", ubicacion=" + ubicacion +
                ", cantidadDisponible=" + cantidadDisponible +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaActualizacion=" + fechaActualizacion +
                '}';
    }

    @Override
    public int compareTo(Inventario o) {
        //2 inventarios son iguales si comparten ubicacion y lote. Si se intentase meter productos del mismo lote donde
        //ya hay otros productos, se fusionarian los inventarios para tener uno solo del mismo producto
        if(this.getUbicacion().compareTo(o.getUbicacion()) == 0 && this.getLote().compareTo(o.getLote()) == 0){
            return 0;
        }else return -1;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
