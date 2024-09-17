package com.spachecor.model.entity.personas;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    public Cliente(){}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                '}';
    }
}
