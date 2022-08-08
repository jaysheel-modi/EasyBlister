package P1;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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

public class SigninController implements Initializable {

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

    boolean flag = false;

    @FXML
    void registerClicked(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void signinClicked(MouseEvent event) throws IOException {
        File data = new File("register.dat");

        if (data.exists()) {
            Scanner scan = new Scanner(data);
            if (scan.hasNextLine()) {
                while (scan.hasNextLine()) {
                    String userData = scan.nextLine();
                    String userField[] = userData.split(", ");

                    // database data
                    String emailId = userField[0];
                    String password = userField[4];

                    // user entered data
                    String userEmail = emailAddress.getText();
                    String userPassword = Password.getText();

                    // sign in logic
                    if (userEmail.equals(emailId)) {
                        if (userPassword.equals(password)) {
                            flag = true;
                            break;
                        } else {

                            flag = false;

                            // System.out.println("line 82: Password does not match");
                            // Alert alert = new Alert(Alert.AlertType.ERROR);
                            // alert.setTitle("Alert");
                            // alert.setHeaderText("Password does not match");
                            // alert.showAndWait();
                        }
                    } else {
                        if (!scan.hasNextLine()) {
                            // Alert alert = new Alert(Alert.AlertType.ERROR);
                            // alert.setTitle("Alert");
                            // alert.setHeaderText("User does not exist please Register first");
                            // alert.showAndWait();
                            flag = false;
                        }
                    }
                }
            } else {
                System.out.println("NO data");
            }
            if (flag) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
                Parent root = loader.load();
                HomePageController homeController = loader.getController();
                homeController.setUserSession(emailAddress.getText());

                root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {

                // Alert alert = new Alert(Alert.AlertType.ERROR);
                // alert.setTitle("Alert");
                // alert.setHeaderText("Incorrect Password! Please try again");
                // alert.showAndWait();
                // Password.requestFocus();

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setHeaderText("User does not exist please Register first");
                alert.showAndWait();
                emailAddress.requestFocus();

            }
            scan.close();
        } else {
            System.out.println("line 101: User does not exist please Register first");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setHeaderText("User does not exist please Register first");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

}
