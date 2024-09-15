package com.spachecor.model.entity.usuarios;

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
