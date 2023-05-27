package com.example.pfe.controllers;
import java.io.IOException;
import com.example.pfe.models.Modele_etudiant;
import com.example.pfe.classes.Session;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
public class re_motdepass {
    @FXML
    private PasswordField password_password_field;
    @FXML
    private PasswordField password_password_field1;
    @FXML
    private PasswordField password_password_field11;
    @FXML
    private TextField password_text_field ;
    @FXML
    private TextField password_text_field1 ;
    @FXML
    private TextField password_text_field11 ;
    @FXML
    private Button eye_button_passwordfield ;
    @FXML
    private Button seConnecter;
    private static boolean visible = false;
    private static boolean visible1 = false;
   
    String pass_cry;
    @FXML 
        private Label incorrect_mdps;
    @FXML
    protected void initialize (){
        password_text_field.setVisible(false);
         password_text_field1.setVisible(false);
         password_text_field11.setVisible(false);
        incorrect_mdps.setVisible(false);
      
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
    @FXML
    void eye_button1(ActionEvent event )throws IOException{
        if (visible1==false){
            
            password_text_field1.setText(password_password_field1.getText());
            password_password_field1.setText("");
            password_password_field1.setVisible(false);
            password_text_field1.setVisible(true);
              password_text_field11.setText(password_password_field11.getText());
            password_password_field11.setText("");
            password_password_field11.setVisible(false);
            password_text_field11.setVisible(true);
           
            visible1=true;
            
            return ;
        }
        if(visible1==true){
            password_password_field1.setText(password_text_field1.getText());
            password_text_field1.setText("");
            password_text_field1.setVisible(false);
            password_password_field1.setVisible(true);
              password_password_field11.setText(password_text_field11.getText());
            password_text_field11.setText("");
            password_text_field11.setVisible(false);
            password_password_field11.setVisible(true);
           
            visible1=false;
            return;
           
        }
       
    }
  public boolean checkancien(){
    String mdps=Modele_etudiant.getoldpass(Session.email_utiliasteur, Session.nom_utiliasteur, Session.prenom_utiliasteur);
    System.out.println(mdps);
    boolean check;
    System.out.println(password_password_field.getText());
    if (visible==true){
       check=PasswordCrypter.checkPassword(password_text_field.getText(),mdps);        
    }
    else{
        check=PasswordCrypter.checkPassword(password_password_field.getText(),mdps);    
    }
    
    return check;
  }
  @FXML
  public void rempdpass(){
    System.out.println(this.checkancien());
    if(this.checkancien()==false){
incorrect_mdps.setText("le ancien mot de passe est incorrect");
incorrect_mdps.setVisible(true);
return;
    }else{ incorrect_mdps.setVisible(false);
        if(visible1==false){if(password_password_field1.getText().isEmpty()==true) {
            incorrect_mdps.setText("les mots de passe non valide");
                incorrect_mdps.setVisible(true);
                return;
        }
            if(password_password_field1.getText().compareTo(password_password_field11.getText())==0){
                Modele_etudiant.changemotdepass(PasswordCrypter.cryptPassword(password_password_field1.getText()));
                System.out.println(111);
                Alert a=new Alert(AlertType.INFORMATION);
                a.setTitle("Success");
                a.setHeaderText(null);
                a.setContentText("Operation successful!");
                a.showAndWait();
                ((Stage) seConnecter.getScene().getWindow()).close();
            }
            else{
                incorrect_mdps.setText("les mots de passe ne sont pas valide");
                incorrect_mdps.setVisible(true);
                return;
            }
        }else{
            if(password_text_field1.getText().isEmpty()==true) {
                incorrect_mdps.setText("les mots de passe non valide");
                    incorrect_mdps.setVisible(true);return;}
            System.out.println(2222);
            if(password_text_field1.getText().compareTo(password_text_field11.getText())==0){
                Modele_etudiant.changemotdepass(PasswordCrypter.cryptPassword(password_text_field1.getText()));
                ((Stage) seConnecter.getScene().getWindow()).close();
            }
            else{
                incorrect_mdps.setText("les mots de passe ne sont pas valid");
                incorrect_mdps.setVisible(true);
                return;
            }
        }
    }
  }
}
