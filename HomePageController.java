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
import javafx.stage.Stage;

public class HomePageController implements Initializable{

    @FXML
    private Button addButton;

    @FXML
    private Label contactUs;

    @FXML
    private Label faq;

    @FXML
    private Label profile;

    @FXML
    private Label searchDoctor;

    @FXML
    private Label searchPharmacy;

    @FXML
    private Button seeButton;

    @FXML
    private Label setting;

    @FXML
    private Label signOut;

    @FXML
    void addNewBlister(ActionEvent event) {

    }

    private Stage  stage;
    private Scene scene;
    private Parent root;

    @FXML
    void seeBlister(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ListBlister.fxml"));
        stage = (Stage)((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }

   

}
