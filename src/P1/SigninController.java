import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class SigninController {

    @FXML
    private TextField Password;

    @FXML
    private TextField emailAddress;

    @FXML
    private Label gotoRegister;

    @FXML
    private Button signinbtn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void registerClicked(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void signinClicked(MouseEvent event) {
        // root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        // stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        // scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();
    }

}