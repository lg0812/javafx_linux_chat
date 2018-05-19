package web.wechat.com.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;



public class Index {
    @FXML
    public Label toLogin;

    @FXML
    public void resetText(ActionEvent actionEvent) {
        toLogin.setText("index label");

    }

    @FXML
    public void toLogin(ActionEvent actionEvent) {

        try {
            Stage stage = new Stage();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("login.fxml")));
            stage.setTitle("login");
            stage.setScene(scene);
            stage.show();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
