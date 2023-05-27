package com.example.pfe.controllers;

import java.sql.SQLException;

import com.example.pfe.models.Modele_auteur;
import com.example.pfe.models.Modele_etudiant;
import com.example.pfe.models.Modele_livre;
import com.example.pfe.models.Modele_tag;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
 

public class DashboardController {
    @FXML
    Pane pane_1;
    @FXML
    Label nb_etu;
    @FXML
    Label nb_livre;
    @FXML
    Label nb_auteur;
    @FXML 
    Label nb_tag;
    @FXML 
    Label label;
    @FXML
    protected void initialize () throws SQLException{
        
        label.getStyleClass().add("outline");
       leftbarController.button_selected='D';
       nb_etu.setText(""+Modele_etudiant.countetu());
       nb_livre.setText(""+Modele_livre.countlivre());
       nb_auteur.setText(""+Modele_auteur.countauteur());
       nb_tag.setText(""+Modele_tag.counttag());
       Pane pane = new Pane();
LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
        new Stop(0, Color.BLUE), new Stop(1, Color.GREEN));
pane.setBackground(new Background(new BackgroundFill(gradient, null, null)));
       
    }
}
