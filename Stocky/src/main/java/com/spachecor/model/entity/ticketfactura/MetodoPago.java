package com.spachecor.model.entity.ticketfactura;

import com.spachecor.model.entity.Entidad;
import jakarta.persistence.*;

@Entity
@Table(name = "metodoPago")
public class MetodoPago extends Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo_pago")
    private Integer id;
    @Column(name = "nombre_metodo_pago")
    private String nombre;

    public MetodoPago() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MetodoPago{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
