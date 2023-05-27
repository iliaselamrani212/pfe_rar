package com.example.pfe.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
public class apropscontroller {
    @FXML
    Pane root;
    @FXML
    protected void initialize () throws Exception{
        Accordion accordion = new Accordion();
TitledPane titledPane1 = new TitledPane("Title 1", new Label("Content 1"));
TitledPane titledPane2 = new TitledPane("Title 2", new Label("Content 2"));
accordion.getPanes().addAll(titledPane1, titledPane2);

// Listen for changes in the expanded state of the accordion
accordion.cacheProperty().addListener((observable, oldValue, newValue) -> {
    if (newValue) {
        System.out.println("Accordion is expanded");
    } else {
        System.out.println("Accordion is collapsed");
    }
});
        root.getChildren().add(accordion);
    }
}
