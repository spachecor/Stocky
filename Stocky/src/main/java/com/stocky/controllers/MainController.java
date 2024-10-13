package com.stocky.controllers;

import com.stocky.models.entities.venta.Venta;
import com.stocky.models.services.repository.GenericRepositoryServiceImpl;
import com.stocky.models.util.JpaUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Venta.class).listar().toString());
    }
}