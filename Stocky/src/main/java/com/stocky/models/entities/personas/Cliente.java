package com.stocky.models.entities.personas;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "id_persona")
public class Cliente extends Persona {

    public Cliente(){}

    @Override
    public Integer getId() {
        return super.getIdPersona();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + super.getIdPersona() +
                '}';
    }
}
