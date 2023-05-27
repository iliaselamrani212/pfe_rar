package com.example.pfe.controllers;
import com.example.pfe.classes.Auteur;
import com.example.pfe.models.Model_livreAvoirTag;
import com.example.pfe.models.Modele_auteur;
import com.example.pfe.models.Modele_livre;
import com.example.pfe.models.Modele_tag;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

public class AddLivreController {
    public static int id_couverture;
    @FXML
    Button annuler;
    @FXML
    TextField titre;
    @FXML
    Label incorrect_champs;
    @FXML
    TextField pages;
    @FXML
    TextArea description;
    @FXML
    TextField exemplaire;
    @FXML
    TextArea tags;
    @FXML
    Button upload;
    File selectedfile = null;
    @FXML
    ComboBox<String> comboBox;
    @FXML
    Label selected_cover;

    @FXML
    void initialize() throws SQLException {
        id_couverture = Modele_livre.selectMaxId();

        Vector<Auteur> listofauteur = Modele_auteur.getAuteur();
        for (Auteur object : listofauteur) {
            comboBox.getItems().add(object.getId_auteur() + "-" + " " + object.getNom_auteur() + " " + object.getPrenom_auteur());
            incorrect_champs.setVisible(false);
        }
    }

    @FXML
    void upload() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selectez la couverture du livre");
        selectedfile = fileChooser.showOpenDialog(upload.getScene().getWindow());
        if (selectedfile != null) {
            // Set the name of the image in the interface
            selected_cover.setText(selectedfile.getName() + " ✔");
        }
    }

    @FXML
    void add() throws NumberFormatException, SQLException, IOException {
        if (!titre.getText().isEmpty() && !description.getText().isEmpty() && !pages.getText().isEmpty() && selectedfile != null && comboBox.getSelectionModel().getSelectedItem() != null) {
            // Get the extension of the image
//            int dotIndex = selectedfile.getName().lastIndexOf(".");
//            String extension = selectedfile.getName().substring(dotIndex + 1);

            // Generate a unique filename
//            String fileName = id_couverture + "." + extension;
//            String s = System.getProperty("user.dir");
//            String path = s.toString()+"/src/main/resources/com/example/pfe/books_cover/"+titre+"."+extension;
//            System.out.println(path);
//            File f = new File(path);
//            //rename the image and replace it
//            selectedfile.renameTo(f);

//            // Set the directory to save the file
//            String uploadDir = "upload/";
//            String filePath = uploadDir + fileName;
//            String filepath2 = fileName;
//            File f = new File(filepath2);
//            System.out.println(fileName);
//            selectedfile.renameTo(f);
//            System.out.println(selectedfile.getAbsolutePath());





            // Add the book to the database
            Vector<Integer> list_of_ids = Modele_tag.addtags(tags.getText().toUpperCase());
            String title_spaced = titre.getText().replace("'", "''");
            String description_spaced = description.getText().replace("'", "''");
            if (description_spaced.length() >= 801) {
                description_spaced = description_spaced.substring(0, 800);
            }

            int id_livre = Modele_livre.addLivre(1, title_spaced, description_spaced,selectedfile , Integer.parseInt(comboBox.getSelectionModel().getSelectedItem().split("-")[0]), Integer.parseInt(pages.getText()), Integer.parseInt(exemplaire.getText()));

            for (Integer id_tag : list_of_ids) {
                if (Model_livreAvoirTag.insertIntoAvoir(id_livre, id_tag)) ;
            }

            id_couverture++;
            ((Stage) annuler.getScene().getWindow()).close();
        } else {
            incorrect_champs.setVisible(true);
        }
    }

    @FXML
    public void annuler() {
        ((Stage) annuler.getScene().getWindow()).close();
    }
}