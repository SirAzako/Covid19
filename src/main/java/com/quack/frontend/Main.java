package com.quack.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * <p>
     *     The method that will run at the start of the program
     *     from the main method and it will create the main stage,
     *     app name, set the app icon and load the fxml
     *     with the data for the GUI.
     * </p>
     * */
    @Override
    public void start(final Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Quack - Covid19");
        primaryStage.getIcons().add(new Image("/icons/quack.png"));
        primaryStage.setScene(new Scene(root, 1200, 800));
        java.net.URL url = ClassLoader.getSystemResource("/icons/editProfile"
                + ".png");
        primaryStage.show();
    }


    /**
     * The main.
     *
     * @param args arrrrrrr
     * */
    public static void main(final String[] args) {
        launch(args);
    }
}
