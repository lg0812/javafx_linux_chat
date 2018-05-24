package web.wechat.com.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import web.wechat.com.beans.BaseResp;
import web.wechat.com.beans.Member;
import web.wechat.com.beans.User;
import web.wechat.com.service.WxinService;

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
