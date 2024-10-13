module com.stocky {
    requires javafx.controls;
    requires mysql.connector.j;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens com.stocky;
    opens com.stocky.controllers;
    opens com.stocky.models.entities;
    opens com.stocky.models.entities.inventario;
    opens com.stocky.models.entities.ticketfactura;
    opens com.stocky.models.entities.compra;
    opens com.stocky.models.entities.personas;
    opens com.stocky.models.entities.venta;
    opens com.stocky.models.entities.usuarios;
}
