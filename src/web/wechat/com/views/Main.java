package web.wechat.com.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scan.fxml"));
        primaryStage.setTitle("Scan to login");
        Scene scene = new Scene(root, 380, 540);
        scene.getStylesheets().add(Scan.class.getResource("Scan.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);


    }


}
