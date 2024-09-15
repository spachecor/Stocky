package com.spachecor.model.entity.personas;

public enum TipoProveedor {
    PROVEEDOR("Proveedor"),
    ACREEDOR("Acreedor");
    private final String TIPO;
    TipoProveedor(String tipo) {
        this.TIPO=tipo;
    }
    public String getTipo() {
        return this.TIPO;
    }
}
