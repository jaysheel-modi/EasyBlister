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
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        File fw = new File("register.dat");

        PrintWriter fileOut;
        fileOut = new PrintWriter(new BufferedWriter(new FileWriter(fw, true)));
        fileOut.println(emailId.getText() + ", " + lastName.getText() + ", " + firstName.getText() + ", "
                + phoneNo.getText() + ", " + password.getText() + ", " + confirm.getText());
        fileOut.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }
}
