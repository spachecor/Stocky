package com.stocky.models.entities.ticketfactura;

import com.stocky.models.entities.Entidad;
import jakarta.persistence.*;

@Entity
@Table(name = "metodoPago")
public class MetodoPago extends Entidad<MetodoPago> {
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

    @Override
    public int compareTo(MetodoPago o) {
        //2 metodos de pago son iguales si sus nombres son iguales
        return this.getNombre().compareTo(o.getNombre());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
