package P1;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.application.Application;

public class HomePageController extends Application implements Initializable {

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
    void addNewBlister(ActionEvent event) throws IOException {
        // set user session
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddBlister.fxml"));
        Parent root = loader.load();
        AddBlisterCont addBlisterController = loader.getController();
        // System.out.println(userSession);
        addBlisterController.setUserSession(userSession);

        root = FXMLLoader.load(getClass().getResource("AddBlister.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goContactUs(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ContactUs.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goFAQ(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FAQs.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goProfile(MouseEvent event) throws IOException {

        // set user session
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
        Parent root = loader.load();
        profileController profileController = loader.getController();
        // System.out.println(userSession);
        profileController.setUserSession(userSession);

        root = FXMLLoader.load(getClass().getResource("profile.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void goSearchDoc(MouseEvent event) throws IOException {
        getHostServices().showDocument("https://doctors.cpso.on.ca/");
    }

    @FXML
    void goSearchPharmacy(MouseEvent event) throws IOException {
        getHostServices()
                .showDocument("https://cphm.ca/protecting-the-public/find-a-pharmacy-or-pharmacy-professional/");
    }

    @FXML
    void goSetting(MouseEvent event) throws IOException {
        // set user session
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Setting.fxml"));
        Parent root = loader.load();
        SettingController settingController = loader.getController();
        // System.out.println(userSession);
        settingController.setUserSession(userSession);

        root = FXMLLoader.load(getClass().getResource("Setting.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void seeBlister(ActionEvent event) throws IOException {
        // set user session
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListBlister.fxml"));
        Parent root = loader.load();
        ListBlisterController listBlisterController = loader.getController();
        // System.out.println(userSession);
        listBlisterController.setUserSession(userSession);

        root = FXMLLoader.load(getClass().getResource("ListBlister.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void userSignOut(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("signin.fxml"));
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        // System.out.println(userSession);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub

    }

}
