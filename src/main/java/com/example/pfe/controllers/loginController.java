package com.example.pfe.controllers;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;



import com.example.pfe.App;
import com.example.pfe.models.Modele_admin;
import com.example.pfe.models.Modele_etudiant;
import com.example.pfe.classes.Session;
import com.example.pfe.classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController  {
    private static boolean visible = false ;
    protected static boolean isadmin=false;
   
        public static boolean isIsadmin() {
        return isadmin;
    }

        @FXML
        private Button closeButton;
        @FXML
        private PasswordField password_password_field;
        @FXML
        private TextField password_text_field ;
        @FXML
        private Button eye_button_passwordfield ;
        @FXML
        private Button admin ;
        @FXML
        private Button etudiant ;
        @FXML 
        private TextField email ;
        @FXML 
        private Label incorrect_mdps;
        @FXML
        private Button seConnecter;
        
        

       
    @FXML
    protected void initialize (){
        password_text_field.setVisible(false);
        etudiant.setStyle("-fx-border-style: hidden solid solid hidden;-fx-border-color : #FF5F00 ;-fx-border-radius: 3;-fx-background-color:#292929 ;-fx-border-width :1.5px ;");
        incorrect_mdps.setVisible(false);

            String directoryPath = "C:/Windows/Temp/ESTM_library";

            // Create a File object with the desired directory path
            File directory = new File(directoryPath);

            // Create the directory
            if (directory.mkdir()) {
                System.out.println("Directory created successfully!");
            } else {
                System.out.println("Failed to create the directory.");

        }
    }
        
    
        @FXML
        void closeButtonClicked(ActionEvent event) throws IOException {
            
            ((Stage) closeButton.getScene().getWindow()).close();
            
           
        }
        @FXML
        void switchtoadmin(ActionEvent event) throws IOException {
            
            admin.setStyle("-fx-border-style: hidden hidden solid solid ;-fx-border-color : #FF5F00 ;-fx-border-radius: 3;-fx-background-color:#292929 ;-fx-border-width :1.5px ;");
            etudiant.setStyle(null);
            isadmin=true;

           
        }
        @FXML
        void switchtoetudiant(ActionEvent event) throws IOException {
            
            etudiant.setStyle("-fx-border-style: hidden solid solid hidden;-fx-border-color : #FF5F00 ;-fx-border-radius: 3;-fx-background-color:#292929 ;-fx-border-width :1.5px ;");
            admin.setStyle(null);
            isadmin=false;
           
        }

        
        @FXML
        void eye_button(ActionEvent event )throws IOException{
            if (visible==false){
                
                password_text_field.setText(password_password_field.getText());
                password_password_field.setText("");
                password_password_field.setVisible(false);
                password_text_field.setVisible(true);
                visible=true;
                
                return ;
            }
            if(visible==true){
                password_password_field.setText(password_text_field.getText());
                password_text_field.setText("");
                password_text_field.setVisible(false);
                password_password_field.setVisible(true);
                visible=false;
                return;
               
            }
           
        }

   
       User  verifierEtulisateur() throws SQLException{
        User utilisateur = null ; 
        if (isadmin==true){
             
            if (!password_password_field.getText().isEmpty())
            utilisateur =Modele_admin.checkadmin(email.getText(),password_password_field.getText());
           
             if (!password_text_field.getText().isEmpty())
             utilisateur=Modele_admin.checkadmin(email.getText(),password_text_field.getText());
        }else {
            if (!password_password_field.getText().isEmpty())
            utilisateur =Modele_etudiant.checkEtudiant(email.getText(),password_password_field.getText());
           
             if (!password_text_field.getText().isEmpty())
             utilisateur=Modele_etudiant.checkEtudiant(email.getText(),password_text_field.getText());
        }
        
        return utilisateur ;

   }
   @FXML
   void seconnecter (ActionEvent event) throws Exception {
    if (verifierEtulisateur()==null){
        incorrect_mdps.setVisible(true);
    }
    else if(isadmin==true) {
        User user=this.verifierEtulisateur();
        Session.nom_utiliasteur=user.getNom_user();
        Session.prenom_utiliasteur=user.getPrenom_user();
        Session.email_utiliasteur=user.getEmail_user();
        leftbarController.button_selected='D';
        
        ((Stage) closeButton.getScene().getWindow()).close();
      Stage stage2 =new Stage();
      Scene scene2 = new Scene(App.loadFXML("dashboard"));
       
     
        stage2.setScene(scene2);
        stage2.setResizable(false);
        
        stage2.show();
    }
    else {
        User user=this.verifierEtulisateur();
        Session.id_utiliasteur=Modele_etudiant.getcneetudiant(user.getEmail_user(), user.getNom_user(), user.getPrenom_user());
        Session.nom_utiliasteur=user.getNom_user();
        Session.prenom_utiliasteur=user.getPrenom_user();
        Session.email_utiliasteur=user.getEmail_user();
      
        
        ((Stage) closeButton.getScene().getWindow()).close();
      Stage stage2 =new Stage();
      Scene scene2 = new Scene(App.loadFXML("ListOfBooksStudent"));
        stage2.setScene(scene2);
        stage2.setResizable(false);
        
        stage2.show();
    }
   }



  
    
}

