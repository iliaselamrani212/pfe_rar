package com.example.pfe.controllers;

import java.io.*;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Vector;

import com.example.pfe.App;

import com.example.pfe.classes.Livre;
import com.example.pfe.models.Modele_auteur;
import com.example.pfe.models.Modele_livre;


import javafx.fxml.FXML;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javafx.scene.control.ButtonType;

public class LivreController {
    public static int id ;
    public static int numcarte=4 ;
    int nb_of_livre =0 ;

    @FXML
    Pane carte_etudiant;
   
    @FXML 
    VBox boxOfStudent ;
    @FXML
    void initialize () throws SQLException, URISyntaxException {
       
        boxOfStudent.setPrefHeight(0);
       
        
        add_etudiant();
       
    }
     void add_etudiant() throws SQLException, URISyntaxException {
   
    Vector<Livre> liste_of_livres = Modele_livre.getLivres();
   
    
    
    while(nb_of_livre!=liste_of_livres.size()){ 
        
        boxOfStudent.setPrefHeight(boxOfStudent.getPrefHeight()+145);
        HBox hBox = new HBox();
       
        
        hBox .setPrefHeight(145);
       
        for (int j = 0; j < 4 && nb_of_livre!=liste_of_livres.size() ; j++) {
            
            
            AnchorPane carteoflivre = new AnchorPane();
            carteoflivre.setPrefWidth(260);
            Insets margins = new Insets(10, 1, 5, 5.5);
            Pane imagelayout = new Pane();
            imagelayout.setPrefSize(76.888, 111.1);
            imagelayout.setStyle("-fx-background-color:#222222;");
            imagelayout.setLayoutX(8);
            imagelayout.setLayoutY(10);


            
            
            try {
                System.out.println("sysout in try livrecontroller");
                System.out.println(liste_of_livres.elementAt(nb_of_livre).getId_livre());
                File imageFile = new File("C:/Windows/Temp/ESTM_library/"+liste_of_livres.elementAt(nb_of_livre).getId_livre()+".jpg");
                System.out.println(App.class.getResource(System.getProperty("user.dir")+"/src/main/resources/com/example/pfe/books_cover/"+liste_of_livres.elementAt(nb_of_livre).getId_livre()));
                try (OutputStream fos = new FileOutputStream(imageFile)) {
                    fos.write(liste_of_livres.elementAt(nb_of_livre).getCouverture());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Book image retrieved successfully.");

                System.out.println(App.class.getResource("books_cover/"+liste_of_livres.elementAt(nb_of_livre).getId_livre()));
                System.out.println(imageFile.toURI().toString());
                Image image = new Image(imageFile.toURI().toString());
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(109.1);
                imageView.setFitWidth(74.888);
                imageView.setLayoutX(1.5);
                imageView.setLayoutY(1);
                
                
                imagelayout.getChildren().add(imageView);
            
            } catch (Exception e) {
               System.out.println("ilias");
            }
           

           Label book_name = new Label(liste_of_livres.get(nb_of_livre).getTitre());

    //                 //location of label in pane
                book_name.setLayoutX(102);
                book_name.setLayoutY(17);
        
    //                 //add style for label
               
    

                
                        // add label for name of writer
                        Label writer = new Label(Modele_auteur.getWriterName(liste_of_livres.get(nb_of_livre).getId_auteur()));
                        //location of label in pane
                writer.setLayoutX(107);
                writer.setLayoutY(42);

                                        //add style for label
                writer.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                writer.getStyleClass().add("writer_name_admin");
                
                
                        // add label for Page
                        Label page = new Label("Pages : "+liste_of_livres.get(nb_of_livre).getNombre_pages());
                        //location of label in pane
                page.setLayoutX(107);
                page.setLayoutY(63);



                                        //add style for Page
                page.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                page.getStyleClass().add("page_label");

                  //add button
                  Button button_trash = new Button("Supprimer");
                  //the position if button in pane
                  button_trash.setLayoutX(87);
                  button_trash.setLayoutY(100);
  
                  // set the hight of button
                  button_trash.setPrefSize(92, 33);
                //add image trash to button
                Image trashimage  = new Image(App.class.getResource("icons/bin.png").toExternalForm());
                ImageView trashimageview = new ImageView(trashimage);
                trashimageview.setFitHeight(13);
                trashimageview.setFitWidth(13);
                button_trash.setGraphic(trashimageview);
                        //add style for button
                        button_trash.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                        button_trash.getStyleClass().add("trash");
                        button_trash.toBack();

                        // add id button trash  & voir is the id of the livre
                        button_trash.setId(liste_of_livres.get(nb_of_livre).getId_livre()+"");
                        

                        //add button voir
                  Button button_voir = new Button("Voir");
                  //the position if button in pane
                  button_voir.setLayoutX(179);
                  button_voir.setLayoutY(100);
                  
  
                  // set the hight of button
                  button_voir.setPrefSize(80, 30);
                //add image trash to button
                Image trashimage1  = new Image(App.class.getResource("icons/green_eye.png").toExternalForm());
                ImageView trashimageview1 = new ImageView(trashimage1);
                trashimageview1.setFitHeight(17);
                trashimageview1.setFitWidth(17);
                button_voir.setGraphic(trashimageview1);
                button_voir.setId(liste_of_livres.get(nb_of_livre).getId_livre()+"");

                        //add style for button
                        button_voir.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                        button_voir.getStyleClass().add("voir");
                        button_voir.toBack();
                        button_voir.setOnMouseClicked((MouseEvent event)->{
                           
                     
                                        try {
                                           
                                            id =Integer.parseInt(button_voir.getId());
            
                                                App.setRoot(carteoflivre.getScene(),"BookProfileAdmin");
                                         } catch (IOException e1) {
                                               
                                                e1.printStackTrace();
                                            }
                                            
                                         
                                    
                                });
                
            
            
                   //set style to pane
                   carteoflivre.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                   carteoflivre.getStyleClass().add("carte_livre_admin");

                   // add action to trash button 

                    button_trash.setOnMouseClicked((MouseEvent event)->{
                        try {
                            
                            Alert a = new Alert(AlertType.CONFIRMATION);
                            // set the propriety for alert
                            a.setTitle("");
                            a.setContentText("ce livre va etre supprimer definitivement");
                            a.setHeaderText("vous etes sure ?");
                            
                            
                            a.showAndWait().ifPresent(response -> {
                                if (
                                    response == ButtonType.OK) {
                                    // Action to perform when user clicks OK
                                    System.out.println("User clicked OK");
                                    try {
                                        Modele_livre.deletelivre(button_trash.getId());
                                        App.setRoot(button_trash.getScene(), "Livre");
                                    } catch (Exception e) {
                                        System.out.println("error");
                                    }
                                }
                            });
                            
                            
                        } catch (Exception e) {
                            System.out.println("ilias");
                           
                        }
                    });
                    
                  
                   
                   // add compnents to livre carte
                   carteoflivre.getChildren().add(imagelayout);
                   carteoflivre.getChildren().add(book_name);
                   carteoflivre.getChildren().add(writer);
                   carteoflivre.getChildren().add(page);
                   carteoflivre.getChildren().add(button_trash);
                   carteoflivre.getChildren().add(button_voir);


          
                
            hBox.getChildren().add(carteoflivre);
            
            HBox.setMargin(carteoflivre, margins);
            nb_of_livre++;
        }

        boxOfStudent.getChildren().add(hBox);
        
    }
          
     }
     @FXML
     void addbook () throws IOException{

        Stage stage = new Stage();
        stage.setScene(new Scene(App.loadFXML("addLivre")));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
     }
}

