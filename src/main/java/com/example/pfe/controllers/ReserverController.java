package com.example.pfe.controllers;

import java.sql.SQLException;
import java.time.LocalDate;

import com.example.pfe.classes.Livre;
import com.example.pfe.models.Modele_livre;
import com.example.pfe.models.Modele_reserve;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ReserverController {
    @FXML
    DatePicker date_fin;
    @FXML
    Button annuler;
    @FXML
    Label title;
    @FXML
    void initialize ()  throws SQLException{
        Livre livre =Modele_livre.getBook(ListOfBooksStudentController.id);
        title.setText(title.getText()+" "+livre.getTitre());
    }
    @FXML
    public void annuler(){
        ((Stage) annuler.getScene().getWindow()).close();
    }
    @FXML
    public void submit() throws SQLException{
        LocalDate selectedDate = date_fin.getValue();
        LocalDate date = LocalDate.now();
       
        if( selectedDate.getDayOfMonth()>=date.getDayOfMonth() && selectedDate.getYear()>=date.getYear() && selectedDate.getMonthValue()>= date.getMonthValue()){
        Modele_reserve.addLivre(selectedDate);
        ((Stage) annuler.getScene().getWindow()).close();}
        else{
            if(selectedDate.getMonthValue()> date.getMonthValue() && selectedDate.getYear()>=date.getYear()){
                Modele_reserve.addLivre(selectedDate);((Stage) annuler.getScene().getWindow()).close();
            }
            else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error date");
            alert.setHeaderText("An error in date!");
            alert.setContentText("select une date valide");
            
            alert.showAndWait();}
        }
       
        
    }
}
