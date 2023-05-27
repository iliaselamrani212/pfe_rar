package com.example.pfe.controllers;

import java.io.IOException;

import com.example.pfe.App;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ParamController {
    @FXML
    Button button;
    @FXML 
    Button  BackIcon;
    @FXML  
    public void gotocmpt() throws IOException{
        Stage stage2 =new Stage();
        Scene scene2 = new Scene(App.loadFXML("inform"));
          stage2.setScene(scene2);
          stage2.setResizable(false);
          stage2.initModality(Modality.APPLICATION_MODAL);
          stage2.show();
      }
      @FXML
      public void help() throws IOException{
        App.setRoot(button.getScene(),"apropos");
        }
      @FXML
      public void gotomdps() throws IOException{
          Stage stage2 =new Stage();
          Scene scene2 = new Scene(App.loadFXML("re_modpass"));
            stage2.setScene(scene2);
            stage2.setResizable(false);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.show();
        }
         //method to back to previous page ( List of books for student)
    @FXML 
    void BacktoPreviousScene(){
       
       try {
        App.setRoot(BackIcon.getScene(),"param");

       } catch (Exception e) {
        // TODO: handle exception
       } 
    }
}
    

