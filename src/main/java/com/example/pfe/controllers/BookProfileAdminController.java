package com.example.pfe.controllers;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Vector;

import com.example.pfe.App;
import com.example.pfe.classes.Commentaire;
import com.example.pfe.classes.Livre;

import com.example.pfe.models.Modele_auteur;
import com.example.pfe.models.Modele_cmnt;
import com.example.pfe.models.Modele_livre;


import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Cursor;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class BookProfileAdminController {
    @FXML ImageView couverture ;
    @FXML Label  title ;
    @FXML Label nb_comnt;
    @FXML Text description ;
    @FXML Label nom_auteur ;
    @FXML Label  nb_pages;
    @FXML  Button  BackIcon;
    @FXML Label exemplaire;
   
   
   @FXML ImageView image ;
   @FXML TextField comnt;

   @FXML VBox commentBox;
   
     
   @FXML
   void initialize ()  throws SQLException {

       int id_livre;

       Livre L = Modele_livre.getBook(LivreController.id);
       title.setText(L.getTitre());
       id_livre = L.getId_livre();
       description.setText(L.getDescription());
       nom_auteur.setText(Modele_auteur.getWriterName(L.getId_auteur()));
       nom_auteur.toFront();
       nb_pages.setText(L.getNombre_pages() + " " + "pages");
       try {


           File imageFile = new File( "C:/Windows/Temp/ESTM_library/" + L.getId_livre() + ".jpg");

           try (OutputStream fos = new FileOutputStream(imageFile)) {
               fos.write(L.getCouverture());
           } catch (FileNotFoundException e) {
               throw new RuntimeException(e);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }

           Image image = new Image(imageFile.toURI().toString());

           couverture.setImage(image);
           couverture.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0, 0, 0, 0.84), 7, 0, 0, 0);");
           couverture.toFront();
           exemplaire.setText(L.getExemplaire() + "");


           Vector<Commentaire> listeofcmnts = Modele_cmnt.getcmnts(L.getId_livre());
           //hhdhdhdhdhdh
           nb_comnt.setText(listeofcmnts.size() + "  Commentaires");
           if (listeofcmnts != null) {
               if (listeofcmnts.size() > 0) {


                   commentBox.setSpacing(10);


// Itérer sur la liste des commentaires pour créer un HBox pour chaque commentaire
                   for (Commentaire commentaire : listeofcmnts) {
                       Label commentairelabel = new Label(Modele_cmnt.selectaut(commentaire.getId_commentaire()));

                       // VBox v=new VBox();


                       // Créer un Label pour afficher le texte du commentaire


                       // crere un pane pour un commentaire
                       AnchorPane carteofcomment = new AnchorPane();

                       carteofcomment.setPrefHeight(70);
                       carteofcomment.setPrefWidth(360);
                       Insets margins = new Insets(0.01, 0, 0, 7);
                       carteofcomment.setStyle("-fx-border-width: 0.5px 0.5px 0.5px 0.5px;-fx-border-color: #D7D7D7; -fx-border-style: solid;-fx-border-radius: 10px;");
                       commentBox.setMargin(carteofcomment, margins);

                       // add name of commentaire auteur

                       String auteur = Modele_cmnt.selectaut(commentaire.getId_commentaire());
                       Label commentaire_auteur = new Label(auteur);


                       commentaire_auteur.setLayoutX(20);
                       commentaire_auteur.setLayoutY(10);
                       commentaire_auteur.setFont(Font.font("System", FontWeight.BOLD, 12));
                       carteofcomment.getChildren().add(commentaire_auteur);

                       // add content of commentaire
                       Text commentaire_content = new Text(commentaire.getContenu() + "\n");
                       commentaire_content.setLayoutX(23);
                       commentaire_content.setLayoutY(45);
                       commentaire_content.setWrappingWidth(550.40008544921864);

                       carteofcomment.getChildren().add(commentaire_content);

                       Label datecomment;
                       Label texteLabel1 = new Label("jdk");
                       LocalDate currentDate = LocalDate.now();
                       long daysBetween = ChronoUnit.DAYS.between(commentaire.getCommentDate(), currentDate);
                       Insets margin_comment = new Insets(0.01, 0, 0, 7);


                       if (daysBetween == 0) {
                           texteLabel1 = new Label("  aujourd'hui     ");
                       } else {
                           texteLabel1 = new Label("   " + daysBetween + " j     ");
                       }


                       texteLabel1.setLayoutY(12);
                       texteLabel1.setLayoutX(commentaire_auteur.getText().length() * 7 + 10);
                       texteLabel1.setFont(Font.font("System", FontWeight.NORMAL, 10));

                       carteofcomment.getChildren().add(texteLabel1);


                       // create botton delete
                       Label delete = new Label("Supprimer");
                       delete.setLayoutY(10);
                       delete.setLayoutX(520);
                       delete.setCursor(Cursor.HAND);
                       delete.setStyle("-fx-text-fill:#780B0B;");
                       delete.setOnMouseClicked(e -> {
                           try {
                               Modele_cmnt.deletecmnt(commentaire.getId_commentaire());
                               App.setRoot(delete.getScene(), "BookProfileAdmin");

                           } catch (SQLException e1) {
                               System.out.println(e1.getSQLState());
                           } catch (IOException e1) {
                               // TODO Auto-generated catch block
                               e1.printStackTrace();
                           }

                       });
                       carteofcomment.getChildren().add(delete);


                       // Créer un HBox pour contenir les deux Labels


                       // Ajouter le HBox du commentaire à la VBox de tous les commentaires

                       commentBox.getChildren().add(carteofcomment);
                       commentBox.setPrefHeight(commentBox.getPrefHeight() + 77);


                   }
                   commentBox.setPrefWidth(600);

// Ajouter la VBox de tous les commentaires au ScrollPane
               }
           }


       }catch (Exception e){

       }
   }
}


