package com.stocky.models.entities.inventario;

public enum TipoTransaccion {
    ENTRADA("entrada"),
    SALIDA("salida");
    private final String TIPO_TRANSACCION;
    TipoTransaccion(String tipoTransaccion) {
        TIPO_TRANSACCION = tipoTransaccion;
    }
    public String getTipoTransaccion() {
        return TIPO_TRANSACCION;
    }
}
