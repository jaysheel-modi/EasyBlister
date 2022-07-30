package P1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    @FXML
    void goHomePage(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saveBlister(ActionEvent event) throws IOException {
        File fw = new File("blister.dat");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        String today = dtf.format(now);
        PrintWriter fileOut;
        
        fileOut = new PrintWriter(new BufferedWriter(new FileWriter(fw, true)));
        fileOut.println(t1.getText() + ", " + today + ", " + t2.getText() + ", " + t3.getText() + ", "
                + t4.getText() + ", " + t5.getText());
        fileOut.close();

        t1.clear();
        t2.clear();
        t3.clear();
        t4.clear();
        t5.clear();
        t1.requestFocus();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

}
