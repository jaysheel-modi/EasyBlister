package P1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

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

public class ListBlisterController implements Initializable {

    @FXML
    private Label homeButton;

    @FXML
    private ListView<String> dateList;

    @FXML
    private ListView<String> nameListView;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File data = new File("blister.dat");
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> date = new ArrayList<String>();
        if (data.exists()) {
            try (Scanner scan = new Scanner(data)) {
                if (scan.hasNextLine()) {
                    while (scan.hasNextLine()) {
                        String blisterData = scan.nextLine();
                        String blisterField[] = blisterData.split(", ");
                        name.add(blisterField[0]);
                        date.add(blisterField[1]);
                    }
                } else {
                    name.add("Please add data first");
                    date.add("Please add data first");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObservableList<String> obsName = FXCollections.observableArrayList(name);
            ObservableList<String> obsDate = FXCollections.observableArrayList(date);
            nameListView.setItems(obsName);
            dateList.setItems(obsDate);
        }
    }

}
