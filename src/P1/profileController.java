package P1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

// import javax.lang.model.util.ElementScanner14;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class profileController implements Initializable {

    @FXML
    private Label phonenumber;

    @FXML
    private Label email;

    @FXML
    private Label fname;

    @FXML
    private Button goback;

    @FXML
    private Label lname;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static String userSession;

    public void setUserSession(String text) {

        // System.out.println("This is user session: " + text);
        userSession = text;
        // setTextOfProfile();
        // System.out.println("This is user session: " + userSession);
    }

    public void setTextOfProfile() {
        File data = new File("register.dat");

        if (data.exists()) {
            try (Scanner scan = new Scanner(data)) {
                if (scan.hasNextLine()) {
                    while (scan.hasNextLine()) {
                        String userData = scan.nextLine();
                        String userField[] = userData.split(", ");
                        System.out.println(userSession);
                        if (userField[0].equals(userSession)) {
                            email.setText(userField[0]);
                            lname.setText(userField[1]);
                            fname.setText(userField[2]);
                            phonenumber.setText(userField[3]);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found");
        }

    }

    @FXML
    void gobackClicked(ActionEvent event) throws IOException {
        
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub


        setTextOfProfile();
    }

}
