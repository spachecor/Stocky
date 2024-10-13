package com.stocky.models.entities.personas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

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

    @Override
    public int compareTo(Persona o) {
        return super.compareTo(o);
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
