import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FirstPageController {

    @FXML
    private Label register;

    @FXML
    private Label signIn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void userSignIn(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("signin.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void userSignup(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
