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

public class HistoryController implements Initializable {

    @FXML
    private ListView<String> historyListview;

    @FXML
    private Label homeButton;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        File data = new File("blister.dat");
        ArrayList<String> history = new ArrayList<String>();
        if (data.exists()) {
            try (Scanner scan = new Scanner(data)) {
                if (scan.hasNextLine()) {

                    while (scan.hasNextLine()) {
                        String blisterData = scan.nextLine();
                        // history.add(blisterData);
                        String blisterField[] = blisterData.split(", ");
                        if (blisterField[0].equals(userSession)) {
                            String content = String.format(
                                    "%5s |%5s |%5s |%5s |%5s |%5s",
                                    blisterField[1], blisterField[2], blisterField[3], blisterField[4],
                                    blisterField[5], blisterField[6]);
                            history.add(content);
                        } else {
                            // history.add("Please add data first");
                        }
                    }
                } else {

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObservableList<String> obsHistory = FXCollections.observableArrayList(history);
            historyListview.setItems(obsHistory);
        }
    }
}