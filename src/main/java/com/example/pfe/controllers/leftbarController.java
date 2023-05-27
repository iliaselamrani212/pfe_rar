package com.example.pfe.controllers;

import java.io.IOException;

import com.example.pfe.App;
import com.example.pfe.classes.Session;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class leftbarController {
    @FXML
    Label nom_utilisateur;
    @FXML
    Button dashboard;
    @FXML
    Button admin;
    @FXML
    Button Parametres;
    public static char  button_selected ;
    @FXML
    Button etudiants;
    @FXML
    Button livres ;

    @FXML
    protected void initialize (){
         char first_char = Session.prenom_utiliasteur.charAt(0) ;
       nom_utilisateur.setText(new String(new char[]{first_char}).toUpperCase());
       make_effect_to_selected_button();
      
    }

    void make_effect_to_selected_button(){
        if (leftbarController.button_selected=='D'){
             dashboard.setStyle("-fx-background-color:#E38B29;-fx-text-fill: #222222;");
         }
         else  if (leftbarController.button_selected=='A'){
             admin.setStyle("-fx-background-color:#E38B29;-fx-text-fill: #222222;");
         }
         else  if (leftbarController.button_selected=='E'){
             etudiants.setStyle("-fx-background-color:#E38B29;-fx-text-fill: #222222;");
         }
         else  if (leftbarController.button_selected=='B'){
           livres.setStyle("-fx-background-color:#E38B29;-fx-text-fill: #222222;");
        }

    }

    @FXML
    void gotodashboard() throws IOException{
         leftbarController.button_selected='D';
         App.setRoot(dashboard.getScene(),"dashboard");
       
    }
    /**
     * @throws IOException
     */
    @FXML
    void gotoadmin() throws IOException{
         
         leftbarController.button_selected='A';
         App.setRoot(dashboard.getScene(),"admins");

        
    }
    @FXML
    void gotoListeEtudiants() throws IOException{
       
         leftbarController.button_selected='E';
         App.setRoot(dashboard.getScene(),"NewEtudiantslist");
}
    @FXML
        void gotoLivres() throws IOException{
    try {
        leftbarController.button_selected='B';
   
        App.setRoot(dashboard.getScene(), "Livre");
    } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();    }     
    
}
@FXML
void gotoaide() throws IOException{
       
     
    App.setRoot(Parametres.getScene(),"aide");
}
@FXML 
void gotoAuteurs() throws IOException{
    
    leftbarController.button_selected='U';
    App.setRoot(dashboard.getScene(),"NewListAuteur");
}
@FXML
void decon() throws IOException{
    Session.email_utiliasteur=null;
    Session.id_utiliasteur=null;
    Session.nom_utiliasteur=null;
    Session.prenom_utiliasteur=null;
    ((Stage)  Parametres.getScene().getWindow()).close();
    Stage stage2 =new Stage();
    Scene scene2 = new Scene(App.loadFXML("login_inter"));
      stage2.setScene(scene2);
      stage2.setResizable(false);
      stage2.initStyle(StageStyle.UNDECORATED);
      stage2.show();
   
}
@FXML
void gotoparam() throws IOException{
   
 
     App.setRoot(Parametres.getScene(),"param");
}

}
