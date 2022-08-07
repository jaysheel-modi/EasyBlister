package P1;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SettingController {

    @FXML
    private Label aboutUs;

    @FXML
    private Label deleteAcc;

    @FXML
    private Label help;

    @FXML
    private Label history;

    @FXML
    private Button homePage;

    @FXML
    private Label notification;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void goAboutUs(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(".fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goDeleteAcc(MouseEvent event) throws IOException {
        // root = FXMLLoader.load(getClass().getResource(".fxml"));
        // stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        // scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();
    }

    @FXML
    void goHelp(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(".fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goHistory(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("History.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goNotification(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    void goSecurity(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(".fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
