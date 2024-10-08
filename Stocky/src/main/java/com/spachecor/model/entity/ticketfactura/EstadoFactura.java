package com.spachecor.model.entity.ticketfactura;

public enum EstadoFactura {
    EMITIDA("emitida"),
    PAGADA("pagada"),
    CANCELADA("cancelada");
    private final String ESTADO_FACTURA;
    EstadoFactura(String estadoFactura) {
        this.ESTADO_FACTURA = estadoFactura;
    }
    public String getEstado() {
        return ESTADO_FACTURA;
    }
}
