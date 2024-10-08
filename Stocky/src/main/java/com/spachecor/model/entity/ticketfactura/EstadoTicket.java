package com.spachecor.model.entity.ticketfactura;

public enum EstadoTicket {
    ABIERTO("abierto"),
    CERRADO("cerrado"),
    CANCELADO("cancelado");
    private final String ESTADO_TICKET;
    EstadoTicket(String estadoTicket) {
        this.ESTADO_TICKET = estadoTicket;
    }
    public String getEstadoTicket() {
        return ESTADO_TICKET;
    }
}
