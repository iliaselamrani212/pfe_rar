package com.example.pfe.controllers;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.example.pfe.classes.Etudiant;
import com.example.pfe.models.Modele_etudiant;
import com.example.pfe.models.Modele_reserve;
import com.example.pfe.classes.Session;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class EtudiantProfilController {

    @FXML
    Label filiere ;
    @FXML
    Label email ;
    @FXML
    Label telephone ;
    @FXML
    Label TitreLivreEmpt;
    @FXML
    Button closeButton ;
    @FXML 
    Button closeButton1;
    @FXML
    Label nomprenometudiant ;
    @FXML
    Label cne ;
    int i , j ;
     @FXML
    public  TableView<Map<String, Object>> listeLivres;
    @FXML
    TableColumn<Map<String, Object>,String> titreLivre;
    @FXML
    TableColumn<Map<String, Object>,String> date_debut;
    @FXML
    TableColumn<Map<String, Object>,String> date_fin;
    final Etudiant etu=Modele_etudiant.getProfileEtudiant(NewEtudiantsController.s);
    public void loadData2() throws SQLException {

        List<Map<String, Object>> reservedBooksList = Modele_reserve.getReservedBooks(NewEtudiantsController.s);
        ObservableList<Map<String, Object>> reservedBooks = FXCollections.observableArrayList(reservedBooksList);
         i++ ;
        listeLivres.setItems(reservedBooks);
    }
  
    @FXML
   void initialize() throws SQLException { 
    // List<Map<String, Object>> reservedBooksList33 = Modele_reserve.getReservedBooks(EtudiantsController.s);
    if(closeButton.getText().compareTo("X")==0){
      //  final Etudiant etu=Modele_etudiant.getProfileEtudiant(EtudiantsController.s);
       cne.setText(etu.getCne());
       filiere.setText(etu.getFiliere().toUpperCase());
       email.setText(etu.getEmail_user());
       telephone.setText(etu.getTelephone());
       nomprenometudiant.setText((etu.getNom_user()+" "+etu.getPrenom_user()).toUpperCase());
       TitreLivreEmpt.setText(""+Modele_reserve.getTitle(etu.getCne()));
          }
       else{
        Etudiant etu=Modele_etudiant.getetuparemail(Session.email_utiliasteur);
        cne.setText(etu.getCne());
       filiere.setText(etu.getFiliere().toUpperCase());
       email.setText(etu.getEmail_user());
       telephone.setText(etu.getTelephone());
       nomprenometudiant.setText((etu.getNom_user()+" "+etu.getPrenom_user()).toUpperCase());
       TitreLivreEmpt.setText(""+Modele_reserve.getTitle(etu.getCne()));
     }
      
       titreLivre.setCellValueFactory(cellData -> {
        try {
          return new SimpleStringProperty(Modele_reserve.getTitre(cellData.getValue().get("titre")));
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        return null;
      });
date_debut.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("startDate").toString()));
date_fin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("endDate").toString()));
       j++;
       this.loadData2();       
       
       }
       // TitreLivreEmpt.setText("");
    
      
    

    @FXML
    void closeButtonClicked(ActionEvent event) throws IOException {
        System.out.println(closeButton.getScene().getWindow());
        ((Stage) closeButton.getScene().getWindow()).close();
        
       
    }

//  static Etudiant etu=Modele_etudiant.getProfileEtudiant(EtudiantsController.s);

 @FXML 
 public void confirmerLivreRendu() throws SQLException {
    Modele_reserve.ConfirmerLivreRendu(etu.getCne()) ; 
    System.out.println("Confirmer rendu livre :  "+etu.getCne());
 }



}