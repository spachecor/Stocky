package com.stocky.models.entities.inventario;

public enum TipoProducto {
    VENTA("Venta"),
    CONSUMO("Consumo"),
    SERVICIO("Servicio");
    private final String TIPO_SERVICIO;
    TipoProducto(String tipoServicio) {
        this.TIPO_SERVICIO = tipoServicio;
    }
    public String getTipoServicio() {
        return this.TIPO_SERVICIO;
    }
}
