package com.example.pfe.controllers;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.example.pfe.App;
import com.example.pfe.classes.Livre;
import com.example.pfe.models.Model_favoris;
import com.example.pfe.models.Modele_auteur;
import com.example.pfe.models.Modele_livre;
import com.example.pfe.classes.Session;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class ListOfBooksStudentController {
  
    public static int id ;
    public static int numcarte=4 ;
    int nb_of_livre =0 ;
    @FXML
    Label page;
    @FXML
    Pane carte_etudiant;
    @FXML 
    VBox boxOfStudent ;
@FXML
TextField chercher;
public static String s;
    
   
 
    
    @FXML
    void initialize () throws SQLException, IOException {
       
   
        
        add_etudiant();
       
    }
    @FXML
    public void cherche() throws IOException{  s=chercher.getText();
        leftbarEtudiantController.isfavoris=false ;
         leftbarEtudiantController.livre_emprunte=false;
         leftbarEtudiantController.chercheLivres=true;
         App.setRoot(page.getScene(),"ListOfBooksStudent");
        

    }

    public List<Livre> chercherLivre(String texteRecherche) throws SQLException {
     
        Vector<Livre> livres=null;
        livres = Modele_livre.chercheLivres(texteRecherche);
       
        return livres;
    }
    
     void add_etudiant() throws SQLException, IOException {
        Vector<Livre> liste_of_livres=null;
     
    if (leftbarEtudiantController.isfavoris==false && leftbarEtudiantController.livre_emprunte==false &&  leftbarEtudiantController.chercheLivres==false ){
    liste_of_livres = Modele_livre.getLivres();
    page.setText("-Acceuil-");
    }
    else if (leftbarEtudiantController.chercheLivres==true){
        
        System.out.println("text"+s);
        liste_of_livres =(Vector<Livre>) chercherLivre(s);
        page.setText("-Acceuil-");
    }
    else if (leftbarEtudiantController.isfavoris==true){
        liste_of_livres = Model_favoris.getLivres_favoris(Session.id_utiliasteur);
        page.setText("-Favoris-");
    }else if (leftbarEtudiantController.livre_emprunte==true){
        liste_of_livres = Modele_livre.getLivresEmpruntee(Session.id_utiliasteur);
        page.setText("-Livres empruntees-");
    }
    Vector <Integer> id_livre_favoris = Model_favoris.allfavoris(Session.id_utiliasteur);
   
    
    
    while(nb_of_livre!=liste_of_livres.size()){ 
        
        boxOfStudent.setPrefHeight(boxOfStudent.getPrefHeight()+170);
        HBox hBox = new HBox();
       
        
        hBox .setPrefHeight(300); //440
       
        for (int j = 0; j <  5 && nb_of_livre!=liste_of_livres.size() ; j++) {
            ImageView heartimageview;
            ImageView heartimageredview;
            Label book_name = new Label(liste_of_livres.get(nb_of_livre).getTitre());

            //                 //location of label in pane
                        book_name.setLayoutX(8);
                        book_name.setLayoutY(210);
                
            //                 //add style for label
                        book_name.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                        book_name.getStyleClass().add("textofcarte");
                        book_name.setPrefWidth(120);
        
            AnchorPane carteoflivre = new AnchorPane();
            carteoflivre.setPrefWidth(165); //170 143
            Insets margins = new Insets(5,14,14,35);
            Pane imagelayout = new Pane();
            imagelayout.setPrefSize(135, 195);
            imagelayout.setStyle("-fx-background-color:#222222;");
            imagelayout.setLayoutX(25);
            imagelayout.setLayoutY(10);
            imagelayout.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
            imagelayout.getStyleClass().add("imagelayout_etudiant");
            


            carteoflivre.setId(""+liste_of_livres.get(nb_of_livre).getId_livre());
            File imageFile = new File("C:/Windows/Temp/ESTM_library/"+liste_of_livres.elementAt(nb_of_livre).getId_livre()+".jpg");
            OutputStream fos = new FileOutputStream(imageFile);
            fos.write(liste_of_livres.elementAt(nb_of_livre).getCouverture());


            System.out.println("Book image retrieved successfully.");

            System.out.println(App.class.getResource("books_cover/"+liste_of_livres.elementAt(nb_of_livre).getId_livre()));
            System.out.println(imageFile.toURI().toString());
            Image image = new Image(imageFile.toURI().toString());
            
            try {

                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(195);
                imageView.setFitWidth(135);
                imageView.setLayoutX(0);
                imageView.setLayoutY(0);
                imagelayout.setOnMouseEntered(e -> {
                    imageView.setFitHeight(201);
                    imageView.setFitWidth(139.5);
                    imagelayout.setLayoutX(23);
                    imagelayout.setLayoutY(8);
                    imagelayout.setCursor(Cursor.HAND);
                    
                });
                imagelayout.setOnMouseExited(e ->{
                imageView.setFitHeight(195);
                imageView.setFitWidth(135);
                imagelayout.setLayoutX(25);
                imagelayout.setLayoutY(9);
                imagelayout.setCursor(Cursor.DEFAULT);
                });
                imagelayout.setOnMouseClicked(e -> {
                    id=Integer.parseInt(carteoflivre.getId());
                    try {
                        App.setRoot(carteoflivre.getScene(),"BookProfile");
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    System.out.println("clicked");
                });
                
               
                

                imagelayout.getChildren().add(imageView);
            
            } catch (Exception e) {
               System.out.println("ilias");
            }
           

        
                
                        // add label for name of writer
                        Label writer = new Label(Modele_auteur.getWriterName(liste_of_livres.get(nb_of_livre).getId_auteur()));
                        //location of label in pane
                writer.setLayoutX(10);
                writer.setLayoutY(229);
                

                                        //add style for label
                writer.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                writer.getStyleClass().add("writer_name");
                
            
                   //set style to pane
                   carteoflivre.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                   carteoflivre.getStyleClass().add("carte_livre");

                //    add heart button
                   Image heartimage  = new Image(App.class.getResource("icons/love.png").toExternalForm());
                     heartimageview = new ImageView(heartimage);
                    heartimageview.setFitHeight(18);
                    heartimageview.setFitWidth(18);
                    heartimageview.setLayoutY(213);
                    heartimageview.setLayoutX(146);
                    

                    Image heartimagered  = new Image(App.class.getResource("icons/lover.png").toExternalForm());
                     heartimageredview = new ImageView(heartimagered );
                    heartimageredview.setFitHeight(18);
                    heartimageredview.setFitWidth(18);
                    heartimageredview.setLayoutY(213);
                    heartimageredview.setLayoutX(146);
                    Integer id_livre = new Integer(liste_of_livres.elementAt(nb_of_livre).getId_livre());
                    if(id_livre_favoris.indexOf(id_livre)==-1){
                        heartimageredview.setVisible(false);

                    }else{
                        heartimageview.setVisible(false);
                    }
                   int nb_like_int = Modele_livre.getlikes(liste_of_livres.elementAt(nb_of_livre).getId_livre());
                    Label nb_like = new Label(Integer.toString(nb_like_int));
                    nb_like.setLayoutY(230);
                    nb_like.setLayoutX(150);
                    nb_like.setTextFill(Color.web("#730404"));
                    nb_like.setFont(Font.font("System", FontWeight.BOLD, 11));

                    heartimageview.setOnMouseClicked(e ->{
                        heartimageview.setVisible(false);
                        
                        nb_like.setText(Integer.toString(Integer.parseInt(nb_like.getText())+1));

                        Model_favoris.setFavoris(Integer.parseInt(carteoflivre.getId()) ,Session.id_utiliasteur);
                        heartimageredview.setVisible(true);
                    });
                    heartimageredview.setOnMouseClicked(e ->{
                        heartimageview.setVisible(true);
                        nb_like.setText(Integer.toString(Integer.parseInt(nb_like.getText())-1));
                        Model_favoris.deleteFavoris(Integer.parseInt(carteoflivre.getId()), Session.id_utiliasteur);
                        heartimageredview.setVisible(false);
                        
                    });

                    

        
                    
                  
                   
                   // add compnents to livre carte
                   carteoflivre.getChildren().add(imagelayout);
                   carteoflivre.getChildren().add(book_name);
                   carteoflivre.getChildren().add(writer);
                   carteoflivre.getChildren().add(heartimageredview);
                   carteoflivre.getChildren().add(heartimageview);
                   carteoflivre.getChildren().add(nb_like);
                   

                    hBox.getChildren().add(carteoflivre);
                    
                    HBox.setMargin(carteoflivre, margins);
                    nb_of_livre++;
                }

                boxOfStudent.getChildren().add(hBox);
                
            }

    
    
    
             
     }
}


