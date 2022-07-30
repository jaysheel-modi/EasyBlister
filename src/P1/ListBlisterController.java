package P1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ListBlisterController implements Initializable{

    @FXML
    private Label homeButton;

    @FXML
    private ListView<String> dateList;

    @FXML
    private ListView<String> nameListView;


    private Stage  stage;
    private Scene scene;
    private Parent root;

    

    @FXML
    void goHomePage(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage)((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String name[] = { "Jack", "Jacob", "Leo", "Max", "Daniel", "Mason", "Noh" };
        String date[] = { "28-09-2022", "22-08-2022", "08-01-2022", "07-07-2022", "28-09-2022", "28-09-2022", "28-09-2022" };
        ObservableList<String> obsName = FXCollections.observableArrayList(name);
        ObservableList<String> obsDate = FXCollections.observableArrayList(date);
        nameListView.setItems(obsName);
        dateList.setItems(obsDate);
        
    }

}
