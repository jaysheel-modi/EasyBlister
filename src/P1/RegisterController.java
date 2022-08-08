package P1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegisterController implements Initializable {

    @FXML
    private Button Registerbtn;

    @FXML
    private TextField confirm;

    @FXML
    private TextField emailId;

    @FXML
    private TextField firstName;

    @FXML
    private Label gotoSignin;

    @FXML
    private TextField lastName;

    @FXML
    private TextField password;

    @FXML
    private TextField phoneNo;

    private Stage stage;
    private Scene scene;
    private Parent root;

    Boolean flag = false;

    // @FXML
    // void registerClick(MouseEvent event) {

    // }

    @FXML
    void signinClicked(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("signin.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void registerClick(MouseEvent event) throws IOException {

        if (emailId.getText().trim().length() == 0 || lastName.getText().trim().length() == 0
                || firstName.getText().trim().length() == 0 || phoneNo.getText().trim().length() == 0
                || password.getText().trim().length() == 0 || confirm.getText().trim().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill all the fields");
            alert.showAndWait();
            flag = false;
        } else if (!password.getText().equals(confirm.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Password does not match with confirm password");
            alert.showAndWait();
            flag = false;
        } else {
            flag = true;
        }

        if (flag) {
            File fw = new File("register.dat");

            PrintWriter fileOut;
            fileOut = new PrintWriter(new BufferedWriter(new FileWriter(fw, true)));
            fileOut.println(emailId.getText() + ", " + lastName.getText() + ", " +
                    firstName.getText() + ", "
                    + phoneNo.getText() + ", " + password.getText() + ", " + confirm.getText());
            fileOut.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent root = loader.load();
            HomePageController homeController = loader.getController();
            homeController.setUserSession(emailId.getText());

            root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }
}
