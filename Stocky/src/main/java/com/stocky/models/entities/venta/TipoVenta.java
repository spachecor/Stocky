package com.stocky.models.entities.venta;

public enum TipoVenta {
    VENTA("venta"),
    SERVICIO("servicio"),
    CONSUMO("consumo");
    private final String TIPO;
    TipoVenta(String tipo){
        this.TIPO = tipo;
    }
    public String getTipo() {
        return this.TIPO;
    }
}
