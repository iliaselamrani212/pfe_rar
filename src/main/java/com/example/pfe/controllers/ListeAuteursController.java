package com.example.pfe.controllers;

import java.sql.SQLException;
import java.util.Vector;

import com.example.pfe.App;
import com.example.pfe.classes.Auteur;
import com.example.pfe.models.Modele_auteur;



import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;


public class ListeAuteursController {
    @FXML
    ImageView add_aut ;
   @FXML 
   VBox vbox ;
    @FXML
    Button addaut;
    @FXML
    Button refresh;
   
    // int i=0 ;
   
    // Etudiant Etudiant = null ;
  
    @FXML
    protected void initialize () throws SQLException{
             
        add_aut.setOnMouseClicked((MouseEvent event) -> {
           
            Stage stage =new Stage();
        Scene scene4=null ;
        try {
            scene4 = new Scene(App.loadFXML("addauteur"));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
       
          stage.setScene(scene4);
          stage.setResizable(false);
         stage.initStyle(StageStyle.UNDECORATED);
         stage.initModality(Modality.APPLICATION_MODAL);
          stage.show();
        
        });
       
loadList(Modele_auteur.getAuteur());






            
}

public void loadList( Vector<Auteur> auteurs ) {
for(int i=0 ; i < auteurs.size() ; i++) {
    Pane pane = new Pane() ;
    Label id = new Label() ;
    Label nom = new Label() ;
    Label prenom = new Label() ;
    Label bio = new Label() ;
    Image image  = new Image(App.class.getResource("icons/delete-asfar.png").toExternalForm());
    ImageView deleteicon = new ImageView(image);
    deleteicon.setId(""+auteurs.get(i).getId_auteur());
    deleteicon.setFitWidth(19);
    deleteicon.setFitHeight(19);
                  


    id.setText("id"+auteurs.get(i).getId_auteur());
    nom.setText(auteurs.get(i).getNom_auteur());
    prenom.setText(auteurs.get(i).getPrenom_auteur());
    bio.setText(auteurs.get(i).getBio_auteur());
   
   
   

    id.setLayoutX(20);
    id.setLayoutY(10);
    nom.setLayoutX(200);
    nom.setLayoutY(10);
    prenom.setLayoutX(410);
    prenom.setLayoutY(10);
    bio.setLayoutX(620);
    bio.setLayoutY(10);
    deleteicon.setLayoutX(1000);
    deleteicon.setLayoutY(10);
    
    id.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
    id.getStyleClass().add("textofcarte_admin");
    nom.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
    nom.getStyleClass().add("textofcarte_admin");
    prenom.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
    prenom.getStyleClass().add("textofcarte_admin");
    bio.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
    bio.getStyleClass().add("textofcarte_admin");





   
            // viewIcon.setId();
    pane.getChildren().add(id);
    pane.getChildren().add(nom);
    pane.getChildren().add(prenom);
    pane.getChildren().add(bio);
    pane.getChildren().add(deleteicon);    

    pane.setPrefHeight(45);
    // pane.setPrefWidth(200) ;
    pane.setStyle("-fx-background-color:white;") ;
    Insets margins = new Insets(5,10,4,10);
    vbox.setPrefHeight(vbox.getPrefHeight()+100);
   pane.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
   pane.getStyleClass().add("carte_livre_admin");
    vbox.getChildren().add(pane);
    vbox.setMargin(pane, margins);

    deleteicon.setOnMouseClicked((MouseEvent event) -> {
           
        int  id_auteur= Integer.parseInt(deleteicon.getId());
         System.out.println(id_auteur);
      
        
        try {
            
            Modele_auteur.DELETE_FROM_auteur(id_auteur);
            App.setRoot(deleteicon.getScene(), "NewListAuteur");
        } catch (SQLException e) {
            System.out.println("error in database ");
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    });
}






} 
    
      
   
    @FXML
    public void addaut(){

        Stage stage =new Stage();
        Scene scene4=null ;
        try {
            scene4 = new Scene(App.loadFXML("addauteur"));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
       
          stage.setScene(scene4);
          stage.setResizable(false);
         stage.initStyle(StageStyle.UNDECORATED);
         stage.initModality(Modality.APPLICATION_MODAL);
          stage.show();
        
    }
 
    
}



    

