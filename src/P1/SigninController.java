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
                        System.out.println("line 82: Password does not match");
                    }
                } else {
                    System.out.println("line 84: User does not exist please Register first");
                    flag = false;
                }

            }
            if (flag) {
                root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                // System.out.println("Email Id and password does not match");
            }
            scan.close();
        } else {
            System.out.println("line 101: User does not exist please Register first");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

}
