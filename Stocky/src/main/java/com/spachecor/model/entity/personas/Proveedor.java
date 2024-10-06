package com.spachecor.model.entity.personas;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedor")
@PrimaryKeyJoinColumn(name = "id_persona")
public class Proveedor extends Persona{
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    private String tipo;

    public Proveedor() {}

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + super.getIdPersona() +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public Integer getId(){
        return super.getIdPersona();
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
