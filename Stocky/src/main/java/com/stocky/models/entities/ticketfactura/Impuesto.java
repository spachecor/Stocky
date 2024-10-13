package com.stocky.models.entities.ticketfactura;

import com.stocky.models.entities.Entidad;
import jakarta.persistence.*;

@Entity
@Table(name = "impuesto")
public class Impuesto extends Entidad<Impuesto> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_impuesto")
    private Integer id;
    private Integer porcentaje;
    private String descripcion;

    public Impuesto() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Impuesto{" +
                "id=" + id +
                ", porcentaje=" + porcentaje +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public int compareTo(Impuesto o) {
        //2 impuestos son iguales si comparten el porcentaje
        return this.getPorcentaje().compareTo(o.getPorcentaje());
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
