package com.spachecor.model.entity.compra;

public enum EstadoOrdenCompra {
    PENDIENTE("pendiente"),
    RECIBIDA("recibida"),
    CANCELADA("cancelada");
    private final String ESTADO_ORDEN_COMRA;
    EstadoOrdenCompra(String estadoOrdenCompra) {
        ESTADO_ORDEN_COMRA = estadoOrdenCompra;
    }
    public String getEstadoOrdenCompra() {
        return ESTADO_ORDEN_COMRA;
    }
}
