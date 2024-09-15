package com.spachecor.model.entity.inventario;

import com.spachecor.model.entity.Entidad;
import jakarta.persistence.*;

@Entity
@Table(name = "subcategoria")
public class Subcategoria extends Entidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcategoria")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    private String nombre;
    private String descripcion;

    public Subcategoria() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Subcategoria{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
