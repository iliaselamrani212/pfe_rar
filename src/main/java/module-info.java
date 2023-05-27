module com.example.pfe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.pfe to javafx.fxml;
    exports com.example.pfe;

    opens com.example.pfe.controllers to javafx.fxml;
    exports com.example.pfe.models;
    opens com.example.pfe.models to javafx.fxml;
    exports com.example.pfe.classes;
    opens com.example.pfe.classes to javafx.fxml;


    exports com.example.pfe.database;
    opens com.example.pfe.database to javafx.fxml;
    exports com.example.pfe.controllers;
}