package com.example.pfe.controllers;

import java.io.IOException;
import com.example.pfe.App;
import com.example.pfe.classes.Session;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class leftbarEtudiantController {
    public static boolean isfavoris=false ;
    public static boolean livre_emprunte = false;
    public static boolean chercheLivres = false;
    @FXML
    Button Parametres;
    @FXML
    Button Acceuil;
    @FXML
    void gotoparam() throws IOException{
       
     
         App.setRoot(Parametres.getScene(),"param");
}

@FXML
void gotolivre() throws IOException{
    
    App.setRoot(Parametres.getScene(),"ListOfBooksStudent");
}

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
void gotoaide() throws IOException{
       
     
    App.setRoot(Parametres.getScene(),"aide");
}
@FXML
void gotoAcceuil() throws IOException{
    leftbarEtudiantController.chercheLivres=false;
     leftbarEtudiantController.isfavoris=false;
     leftbarEtudiantController.livre_emprunte=false;
    App.setRoot(Acceuil.getScene(),"ListOfBooksStudent");
}
@FXML 
void gotofavoris () throws IOException{
    leftbarEtudiantController.chercheLivres=false;
    leftbarEtudiantController.isfavoris=true;
    leftbarEtudiantController.livre_emprunte=false;
    App.setRoot(Acceuil.getScene(),"ListOfBooksStudent");
}
@FXML
void gotolivresEnpruntes () throws IOException{
    leftbarEtudiantController.chercheLivres=false;
    leftbarEtudiantController.isfavoris=false;
    leftbarEtudiantController.livre_emprunte=true;
    App.setRoot(Acceuil.getScene(),"ListOfBooksStudent");
}

}


