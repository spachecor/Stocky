package com.stocky.models.entities.usuarios;

public enum EstadoUsuario {
    ACTIVO("Activo"),
    INACTIVO("Inactivo");
    private final String ESTADO;
    EstadoUsuario(String estado) {
        this.ESTADO = estado;
    }
    public String getEstado() {
        return this.ESTADO;
    }
}
