package web.wechat.com.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Mac implements Initializable {
    //ListView的自定义
    @FXML
    public AnchorPane root;

    public void init() {
        ObservableList<Tuser> strList = FXCollections.observableArrayList(
                new Tuser("https://www.baidu.com/img/baidu_jgylogo3.gif", "aaaa"),
                new Tuser("https://www.baidu.com/img/baidu_jgylogo3.gif", "aaaa"),
                new Tuser("https://www.baidu.com/img/baidu_jgylogo3.gif", "aaaa"),
                new Tuser("https://www.baidu.com/img/baidu_jgylogo3.gif", "aaaa"),
                new Tuser("https://www.baidu.com/img/baidu_jgylogo3.gif", "aaaa"),
                new Tuser("https://www.baidu.com/img/baidu_jgylogo3.gif", "aaaa"),
                new Tuser("https://www.baidu.com/img/baidu_jgylogo3.gif", "aaaa"));
        ListView<Tuser> listView = new ListView<>();
        listView.setItems(strList);
        listView.setPrefSize(380, 540);
        listView.setCellFactory((ListView<Tuser> l) -> new ListCell<Tuser>() {
            @Override
            protected void updateItem(Tuser item, boolean empty) {
                super.updateItem(item, empty);

                if (item != null) {
                    GridPane gp = new GridPane();
                    ColumnConstraints c1 = new ColumnConstraints(100);
                    ColumnConstraints c2 = new ColumnConstraints(180);
                    gp.getColumnConstraints().addAll(c1, c2);
                    gp.setPrefSize(600, 100);
                    ImageView head = new ImageView();
                    head.setImage(new Image(item.getUrl()));
                    head.setFitWidth(80);
                    head.setFitHeight(80);
                    HBox headHbox = new HBox(head);
                    headHbox.setAlignment(Pos.CENTER);


                    Label count = new Label();
                    count.setText("10");
                    count.setTextFill(Color.ORANGERED);
                    count.setLayoutX(80);
                    count.setLayoutY(0);
                    Pane pane = new Pane(count);
                    pane.setPrefHeight(100);
                    pane.setPrefWidth(100);
//                    pane.setBackground(new Background(new BackgroundFill(Color.ORANGERED, new CornerRadii(2), new Insets(2))));
                    gp.add(headHbox, 0, 0);
                    gp.add(pane, 0, 0);


                    Label nickname = new Label();
                    nickname.setText("none");
                    nickname.setPrefHeight(50);

                    Label msg = new Label();
                    msg.setText("none");
                    msg.setPrefHeight(50);
                    VBox info = new VBox(nickname, msg);

                    gp.add(info, 1, 0);
                    setGraphic(gp);
                } else {
                    setGraphic(null);
                }
            }
        });
        listView.setEditable(true);
        root.getChildren().add(listView);

//        Label label = new Label("...");
//        label.textProperty().bind(listView.getSelectionModel().selectedItemProperty());
//        label.setLayoutY(200);
//        root.getChildren().add(label);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }
}

class ColorCell extends ListCell<String> {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        Rectangle rect = new Rectangle(100, 20);
        if (item != null) {
            rect.setFill(Color.web(item));
            setGraphic(rect);
        } else {
            setGraphic(null);
        }
    }
}

class Tuser {
    private String url;
    private String name;

    public Tuser(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}