package P1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Optional;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SettingController {

    // private static final String ButtonBar = null;

    @FXML
    private Label aboutUs;

    // @FXML
    // private Label deleteAcc;

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

    private static String userSession;

    public void setUserSession(String text) {
        // System.out.println("This is user session: " + text);
        userSession = text;
        // System.out.println("This is user session: " + userSession);
    }

    @FXML
    void goAboutUs(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AboutUs.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goHelp(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PriceCalculation.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goHistory(MouseEvent event) throws IOException {
        // set user session
        FXMLLoader loader = new FXMLLoader(getClass().getResource("History.fxml"));
        Parent root = loader.load();
        HistoryController historyController = loader.getController();
        // System.out.println(userSession);
        historyController.setUserSession(userSession);

        root = FXMLLoader.load(getClass().getResource("History.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goHomePage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = loader.load();
        HomePageController homeController = loader.getController();
        homeController.setUserSession(userSession);

        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goNotification(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Notification.fxml"));
        Parent root = loader.load();
        notificationController notificationController = loader.getController();
        notificationController.setUserSession(userSession);

        root = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void goSecurity(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PrivacyPolicy.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
