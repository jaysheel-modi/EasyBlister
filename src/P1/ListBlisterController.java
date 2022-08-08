package P1;

import java.beans.EventHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ListBlisterController implements Initializable {

    @FXML
    private Label homeButton;

    @FXML
    private Label addBlister;

    @FXML
    private ListView<String> dateList;

    @FXML
    private ListView<String> nameListView;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static String userSession;

    public void setUserSession(String text) {
        // System.out.println("This is user session: " + text);
        userSession = text;
        // System.out.println("This is user session: " + userSession);
    }

    @FXML
    void goHomePage(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goAddBlister(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddBlister.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleMouseClick(MouseEvent arg0) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Medication information");
        alert.setHeaderText("Medicine name: " + nameListView.getSelectionModel().getSelectedItem());
        File data = new File("blister.dat");
        if (data.exists()) {
            try (Scanner scan = new Scanner(data)) {
                if (scan.hasNextLine()) {
                    while (scan.hasNextLine()) {
                        String blisterData = scan.nextLine();
                        String blisterField[] = blisterData.split(", ");

                        if (blisterField[1].equals(nameListView.getSelectionModel().getSelectedItem().toString())) {
                            String content = String.format(
                                    "BREAKFAST | LUNCH    | SUPER    | DINNER   \n%16s |%16s |%16s |%16s",
                                    blisterField[3], blisterField[4],
                                    blisterField[5], blisterField[6]);
                            alert.setContentText(content);
                        }
                    }
                } else {

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        // alert.setContentText("Do you want to add another blister?");
        alert.showAndWait();
        System.out.println("clicked on " + nameListView.getSelectionModel().getSelectedItem());
    }

    public void listdata() {
        File data = new File("blister.dat");
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> date = new ArrayList<String>();
        if (data.exists()) {
            try (Scanner scan = new Scanner(data)) {
                if (scan.hasNextLine()) {
                    while (scan.hasNextLine()) {
                        String blisterData = scan.nextLine();
                        String blisterField[] = blisterData.split(", ");
                        if (blisterField[0].equals(userSession)) {
                            name.add(blisterField[1]);
                            date.add(blisterField[2]);
                        } else {
                            // name.add("Please add data first");
                            // date.add("Please add data first");       
                        }
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listdata();
        // nameListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

        // @Override
        // public void handle(MouseEvent event) {
        // System.out.println("clicked on " +
        // nameListView.getSelectionModel().getSelectedItem());
        // }
        // });
    }

}
