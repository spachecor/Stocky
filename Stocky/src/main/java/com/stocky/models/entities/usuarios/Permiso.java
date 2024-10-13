package com.stocky.models.entities.usuarios;

import com.stocky.models.entities.Entidad;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permiso")
public class Permiso extends Entidad<Permiso> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso")
    private Integer id;
    @Column(name = "nombre_permiso")
    private String permiso;
    private String descripcion;
    @ManyToMany(mappedBy = "permisos")
    private Set<Rol> roles;
    {
        roles = new HashSet<Rol>();
    }

    public Permiso() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Permiso{" +
                "id=" + id +
                ", permiso='" + permiso + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public int compareTo(Permiso o) {
        //2 permisos son iguales si comparten el nombre del permiso
        return this.getPermiso().compareTo(o.getPermiso());
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
