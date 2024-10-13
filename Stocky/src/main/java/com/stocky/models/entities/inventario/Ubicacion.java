package com.stocky.models.entities.inventario;

import com.stocky.models.entities.Entidad;
import jakarta.persistence.*;

@Entity
@Table(name = "ubicacion")
public class Ubicacion extends Entidad<Ubicacion> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion")
    private Integer id;
    private String nombre;
    private String descripcion;

    public Ubicacion() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public int compareTo(Ubicacion o) {
        //2 ubicaciones son iguales si comparten el mismo nombre
        return this.nombre.compareTo(o.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
