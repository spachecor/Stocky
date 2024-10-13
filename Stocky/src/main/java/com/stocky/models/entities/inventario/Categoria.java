package com.stocky.models.entities.inventario;

import com.stocky.models.entities.Entidad;
import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria extends Entidad<Categoria> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id;
    private String nombre;
    private String descripcion;

    public Categoria() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public int compareTo(Categoria o) {
        //2 categorias son iguales cuando ambas comparten el mismo nombre
        return this.getNombre().compareTo(o.getNombre());
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
