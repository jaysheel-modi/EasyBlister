package P1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddBlisterCont implements Initializable {

    @FXML
    private Button saveButton;

    @FXML
    private Label b2;

    @FXML
    private TextField t1;

    @FXML
    private TextField t2;

    @FXML
    private TextField t3;

    @FXML
    private TextField t4;

    @FXML
    private TextField t5;

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
    void goHomePage(MouseEvent event) throws IOException {
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
    void goViewBlister(MouseEvent event) throws IOException {
        // set user session
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListBlister.fxml"));
        Parent root = loader.load();
        ListBlisterController listBlisterController = loader.getController();
        // System.out.println(userSession);
        listBlisterController.setUserSession(userSession);

        root = FXMLLoader.load(getClass().getResource("ListBlister.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saveBlister(ActionEvent event) throws IOException {

        if (t1.getText().trim().length() == 0 || t2.getText().trim().length() == 0
                || t3.getText().trim().length() == 0 || t4.getText().trim().length() == 0
                || t5.getText().trim().length() == 0) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill all the fields");
            alert.showAndWait();

        }

        else {
            File fw = new File("blister.dat");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDateTime now = LocalDateTime.now();
            String today = dtf.format(now);
            PrintWriter fileOut;

            fileOut = new PrintWriter(new BufferedWriter(new FileWriter(fw, true)));
            fileOut.print(
                    "\n" + userSession + ", " + t1.getText() + ", " + today + ", " + t2.getText() + ", " + t3.getText()
                            + ", "
                            + t4.getText() + ", " + t5.getText());
            fileOut.close();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Conformation Message");
            alert.setHeaderText("BLISTER SAVED SUCCESSFULLY");
            alert.setContentText("Do you want to add another blister?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                alert.close();
                t1.clear();
                t2.clear();
                t3.clear();
                t4.clear();
                t5.clear();
                t1.requestFocus();
            } else if (result.get() == ButtonType.CANCEL) {
                // set user session
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

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

}
