package com.example.pfe.controllers;

import java.io.IOException;
import java.sql.SQLException;

import com.example.pfe.models.Modele_auteur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class AddauteurController {
    @FXML
    Button  annuler;
     @FXML
     public void annuler(){
        ((Stage) annuler.getScene().getWindow()).close();
     }
     @FXML
     TextField nom;
     @FXML
     TextField prenom;
     @FXML
     TextArea bioo;
     Button b;
     @FXML
     protected void initialize () throws SQLException{
        bioo.setStyle("-fx-control-inner-background: #222222;");
      Button b=  annuler;
    }
     @FXML
     public void valider() throws IOException, SQLException{
        Modele_auteur.insert_into_auteur(nom.getText(), prenom.getText(),  bioo.getText());
                ((Stage) annuler.getScene().getWindow()).close(); 
                
               
        
    }
 
     }
    


