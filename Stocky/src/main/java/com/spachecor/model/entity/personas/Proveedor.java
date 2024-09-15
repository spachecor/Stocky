package com.spachecor.model.entity.personas;

import jakarta.persistence.*;

@Entity
public class Proveedor extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer id;
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    private String tipo;

    public Proveedor() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public Integer getIdPersona(){
        return super.getId();
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
