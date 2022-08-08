package P1;

import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // open Splash Screen
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Easy Blister");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
