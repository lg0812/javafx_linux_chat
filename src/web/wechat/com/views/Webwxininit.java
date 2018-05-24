package web.wechat.com.views;

import com.sun.org.apache.bcel.internal.generic.Select;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import web.wechat.com.beans.BaseResp;
import web.wechat.com.beans.Member;
import web.wechat.com.beans.User;
import web.wechat.com.service.WxinService;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;


public class Webwxininit implements Initializable {

    @FXML
    private SplitPane mainInner;


    //    @FXML
//    private Button first;
    private Map<String, String> map;
    @FXML
    private ImageView avatarIV;
    @FXML
    private Label nickName;
    private WxinService wxinService = new WxinService();
    @FXML
    private ListView<Member> contactList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void showData(ActionEvent actionEvent) {
        System.out.println(map);
    }

    public void initPage(Map<String, String> map) {
        this.map = map;
        System.out.println(this.map);
        BaseResp baseResp = new BaseResp();
        wxinService.redictUrl(map.get("window.redirect_uri"));
        baseResp = wxinService.webwxininit();
        initSelf(baseResp.getUser());
        initChat(baseResp.getContactList());
        wxinService.webwxgetcontact();
    }

    public void initSelf(User user) {
//        dropMenu
        nickName.setText(user.getNickName());
        avatarIV.setImage(new Image(wxinService.webwxgeticon(user.getHeadImgUrl())));
    }

    public void initChat(Member[] member) {
        ObservableList<Member> ob = FXCollections.observableList(Arrays.asList(member));
        contactList.setItems(ob);
        contactList.setCellFactory(lv -> new ListCell<Member>() {

            @Override
            protected void updateItem(Member item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    GridPane gp = new GridPane();
                    ColumnConstraints c1 = new ColumnConstraints(100);
                    ColumnConstraints c2 = new ColumnConstraints(180);
                    gp.getColumnConstraints().addAll(c1, c2);
                    gp.setPrefSize(600, 100);
                    ImageView head = new ImageView();
                    head.setImage(new Image(wxinService.webwxgeticon(item.getHeadImgUrl())));
                    head.setFitWidth(80);
                    head.setFitHeight(80);
                    HBox headHbox = new HBox(head);
                    headHbox.setAlignment(Pos.CENTER);
                    gp.add(headHbox, 0, 0);


                    Label nickname = new Label();
                    nickname.setText(wxinService.textCode(item.getNickName()));
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

            @Override
            public void updateSelected(boolean selected) {
                super.updateSelected(selected);
            }
        });

        contactList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        contactList.setPrefSize(200, 200);
    }

    public void toChat(MouseEvent mouseEvent) {
        System.out.println("toChat");
    }

    public void toRead(MouseEvent mouseEvent) {
        System.out.println("toRead");
    }

    public void toContact(MouseEvent mouseEvent) {
        System.out.println("toContact");
    }
}
