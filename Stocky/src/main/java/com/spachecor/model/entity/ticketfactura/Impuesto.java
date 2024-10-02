package com.spachecor.model.entity.ticketfactura;

import com.spachecor.model.entity.Entidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "impuesto")
public class Impuesto extends Entidad {
    @Id
    @Column(name = "id_impuesto")
    private Integer id;
    private Integer porcentaje;
    private String descripcion;

    public Impuesto() {}

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
