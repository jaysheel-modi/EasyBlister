package P1;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.NumberBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PriceCalculationCont implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button homePage;

    @FXML
    private TextField noOfTab;

    @FXML
    private TextField priceOfOne;

    @FXML
    private Label totalPrice;

    private Stage stage;
    private Scene scene;
    private Parent root;

    // private Medicine med = new Medicine();

    @FXML
    private Label showTotal;

    @FXML
    void calculatePrice(ActionEvent event) {
        if (noOfTab.getText().trim().length() != 0) {
            int n = Integer.parseInt(noOfTab.getText());
            int total = n * 5;
            showTotal.setText("Price of the whole pack : $ " + total);
        }
    }

    @FXML
    void goBack(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Setting.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void goToHomePage(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // noOfTab.textProperty().addListener(new InvalidationListener() {

        // @Override
        // public void invalidated(javafx.beans.Observable observable) {
        // if (!noOfTab.getText().isEmpty())
        // med.setNoOfTab(Integer.parseInt(noOfTab.getText()));

        // }
        // });

        // priceOfOne.textProperty().addListener(new InvalidationListener() {

        // @Override
        // public void invalidated(javafx.beans.Observable observable) {
        // if (!priceOfOne.getText().isEmpty())
        // med.setPriceOfOne(Double.parseDouble(noOfTab.getText()));

        // }
        // });
        // TODO Auto-generated method stub

        // NumberBinding total =
        // med.noOfTabProperty().multiply(med.priceOfOneProperty());
        // totalPrice.textProperty().bind(total.asString());

    }

}
