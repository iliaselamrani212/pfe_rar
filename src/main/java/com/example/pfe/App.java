package com.example.pfe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    // private static boolean netIsAvailable() {
    //     try {
    //         final URL url = new URL("http://www.google.com");
    //         final URLConnection conn = url.openConnection();
    //         conn.connect();
    //         conn.getInputStream().close();
    //         return true;
    //     } catch (MalformedURLException e) {
    //         throw new RuntimeException(e);
    //     } catch (IOException e) {
    //         return false;
    //     }
    // }

    @Override
    public void start(Stage stage) throws IOException {
        // if(netIsAvailable()==true){





        scene = new Scene(loadFXML("login_inter")); //, 1300, 700
        stage.setScene(scene);


        stage.initStyle(StageStyle.UNDECORATED);

        stage.show();
        // }

    }

    public static void setRoot(Scene scene1 ,String fxml) throws IOException {
        scene1.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }



}