package com.spachecor.model.entity.personas;

import jakarta.persistence.*;

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
