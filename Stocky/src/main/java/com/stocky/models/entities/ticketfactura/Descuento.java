package com.stocky.models.entities.ticketfactura;

import com.stocky.models.entities.Entidad;
import jakarta.persistence.*;

@Entity
@Table(name = "descuento")
public class Descuento extends Entidad<Descuento> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_descuento")
    private Integer id;
    private Integer porcentaje;
    private String descripcion;

    public Descuento() {}

    @Override
    public String toString() {
        return "Descuento{" +
                "id=" + id +
                ", porcentaje=" + porcentaje +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public int compareTo(Descuento o) {
        //2 descuentos son iguales cuando comparten el porcentaje
        return this.porcentaje.compareTo(o.getPorcentaje());
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
